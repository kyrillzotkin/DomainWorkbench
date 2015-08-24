package org.domainworkbench.renderer;

import org.eclipse.e4.ui.internal.workbench.swt.AbstractPartRenderer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;

/**
 * Workaround until Mars SR1
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=469581
 *
 * @author mbiggs
 *
 */
public class WorkbenchRendererFactory extends org.eclipse.e4.ui.workbench.renderers.swt.WorkbenchRendererFactory {

	private MenuManagerRenderer menuRenderer;

	@Override
	public AbstractPartRenderer getRenderer(final MUIElement uiElement, final Object parent) {
		if (uiElement instanceof MMenu) {
			if (menuRenderer == null) {
				menuRenderer = new MenuManagerRenderer();
				initRenderer(menuRenderer);
			}
			return menuRenderer;
		}
		return super.getRenderer(uiElement, parent);
	}

}
