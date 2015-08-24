package org.domainworkbench.renderer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.AboutToHide;
import org.eclipse.e4.ui.model.application.ui.menu.MDynamicMenuContribution;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MPopupMenu;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.renderers.swt.MenuManagerRenderer;
import org.eclipse.e4.ui.workbench.renderers.swt.MenuManagerShowProcessor;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Menu;

public class MenuManagerHideProcessor extends org.eclipse.e4.ui.workbench.renderers.swt.MenuManagerHideProcessor {

	@Inject
	private MenuManagerRenderer renderer;

	@Inject
	private EModelService modelService;

	static final String TMP_ORIGINAL_CONTEXT = "MenuServiceFilter.original.context"; //$NON-NLS-1$

	static final String DYNAMIC_ELEMENT_STORAGE_KEY = MenuManagerShowProcessor.class.getSimpleName() + ".dynamicElements"; //$NON-NLS-1$

	@Override
	public void menuAboutToShow(final IMenuManager manager) {
		if (!(manager instanceof MenuManager)) {
			return;
		}
		final MenuManager menuManager = (MenuManager) manager;
		final MMenu menuModel = renderer.getMenuModel(menuManager);
		final Menu menu = menuManager.getMenu();
		if (menuModel instanceof MPopupMenu) {
			hidePopup(menu, (MPopupMenu) menuModel, menuManager);
		}
		if ((menuModel != null) && (menu != null)) {
			processDynamicElements((MenuManager) manager, menu, menuModel);
		}
	}

	private void processDynamicElements(final MenuManager menuManager, final Menu menu, final MMenu menuModel) {

		if (!menu.isDisposed()) {
			menu.getDisplay().asyncExec(new Runnable() {
				@Override
				public void run() {
					// We need to make a copy of the dynamic items which need to be removed
					// because the actual remove happens asynchronously.
					final Map<MDynamicMenuContribution, ArrayList<MMenuElement>> toBeHidden = new HashMap<MDynamicMenuContribution, ArrayList<MMenuElement>>();

					for (final MMenuElement currentMenuElement : menuModel.getChildren()) {
						if (currentMenuElement instanceof MDynamicMenuContribution) {

							final Map<String, Object> storageMap = currentMenuElement.getTransientData();
							@SuppressWarnings("unchecked")
							final
							ArrayList<MMenuElement> mel = (ArrayList<MMenuElement>) storageMap
									.get(DYNAMIC_ELEMENT_STORAGE_KEY);

							toBeHidden.put((MDynamicMenuContribution) currentMenuElement, mel);
						}
					}

					for (final Entry<MDynamicMenuContribution, ArrayList<MMenuElement>> entry : toBeHidden.entrySet()) {
						final MDynamicMenuContribution currentMenuElement = entry.getKey();
						final Object contribution = currentMenuElement.getObject();
						final IEclipseContext dynamicMenuContext = EclipseContextFactory.create();

						final ArrayList<MMenuElement> mel = entry.getValue();

						dynamicMenuContext.set(List.class, mel);
						final IEclipseContext parentContext = modelService.getContainingContext(currentMenuElement);
						ContextInjectionFactory.invoke(contribution, AboutToHide.class, parentContext,
								dynamicMenuContext, null);
						dynamicMenuContext.dispose();
						// remove existing entries for this dynamic
						// contribution item if there are any
						if ((mel != null) && (mel.size() > 0)) {
							renderer.removeDynamicMenuContributions(menuManager, menuModel, mel);
						}

						// make existing entries for this dynamic contribution item
						// invisible if there are any
						if ((mel != null) && (mel.size() > 0)) {
							for (final MMenuElement item : mel) {
								item.setVisible(false);
							}
						}
						currentMenuElement.getTransientData().remove(DYNAMIC_ELEMENT_STORAGE_KEY);
					}
				}
			});
		}
	}

	private void hidePopup(final Menu menu, final MPopupMenu menuModel,
			final MenuManager menuManager) {
		final IEclipseContext popupContext = menuModel.getContext();
		final IEclipseContext originalChild = (IEclipseContext) popupContext
				.get(TMP_ORIGINAL_CONTEXT);
		popupContext.remove(TMP_ORIGINAL_CONTEXT);
		if (!menu.isDisposed()) {
			menu.getDisplay().asyncExec(new Runnable() {
				@Override
				public void run() {
					if (originalChild == null) {
						popupContext.deactivate();
					} else {
						originalChild.activate();
					}
				}
			});
		}
	}
}
