package org.domainworkbench.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.classupplier.ClassSupplier;
import org.classupplier.ClassSupplierPackage;
import org.classupplier.State;
import org.classupplier.provider.ClassSupplierItemProviderAdapterFactory;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.services.EMenuService;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;

public class NavigationView implements IEditingDomainProvider, IAdapterFactory {

	public static final String ID = "org.domainworkbench.part.navigationView";

	private TreeViewer viewer;

	@Named(IServiceConstants.ACTIVE_SHELL)
	protected Shell shell;

	protected AdapterFactoryEditingDomain editingDomain;

	protected ComposedAdapterFactory adapterFactory;

	@Inject
	protected ESelectionService selectionService;

	@Inject
	protected ClassSupplier classupplier;

	@Inject
	protected EMenuService menuService;

	protected List<PropertySheetPage> propertySheetPages = new ArrayList<PropertySheetPage>();

	public NavigationView() {
		initializeEditingDomain();
	}

	private EContentAdapter labelAdapter = new EContentAdapter() {

		@Override
		public void notifyChanged(Notification msg) {
			switch (msg.getFeatureID(State.class)) {
			case ClassSupplierPackage.STATE__STAGE:
				if (labelProvider != null)
					Display.getDefault().asyncExec(new Runnable() {

						@Override
						public void run() {
							labelProvider.fireLabelProviderChanged();
						}
					});
				break;
			default:
				;
			}
		}
	};

	private AdapterFactoryLabelProvider labelProvider;

	public Adapter getLabelAdapter() {
		return labelAdapter;
	}

	@PostConstruct
	public void createControls(Composite parent, final IEclipseContext context, final EPartService partService,
			final EModelService modelService) {
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));
		viewer = new TreeViewer(parent, SWT.BORDER);
		viewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
		viewer.setLabelProvider(
				new DecoratingLabelProvider(labelProvider, (ILabelDecorator) new ContributionStageDecorator()));
		viewer.setInput(classupplier.getWorkspace());

		classupplier.getWorkspace().eAdapters().add(new AdapterImpl() {

			@Override
			public void notifyChanged(final Notification msg) {
				Display.getCurrent().asyncExec(new Runnable() {

					@Override
					public void run() {
						viewer.refresh();
					}
				});
			}

		});
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
					Object selectedObject = ((IStructuredSelection) selection).getFirstElement();
					selectionService.setSelection(selectedObject);
					context.set(IEditingDomainItemProvider.class, (IEditingDomainItemProvider) adapterFactory
							.adapt(selectedObject, IEditingDomainItemProvider.class));
				}
			}

		});
		viewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				ISelection selection = event.getSelection();
				if (selection == null || selection.isEmpty())
					return;
				if (selection instanceof IStructuredSelection
						&& ((IStructuredSelection) event.getSelection()).size() == 1) {
					Object selected = ((IStructuredSelection) selection).getFirstElement();
					if (!(selected instanceof EObject))
						return;
					MPart part = partService.createPart("org.domainworkbench.part.eObjectView");
					part.getTransientData().put("org.domainworkbench.input.eObject", selected);
					part.setLabel(((EObject) selected).eClass().getName());
					MPartStack stack = (MPartStack) modelService.find("org.domainworkbench.partstack.editors",
							context.get(MApplication.class));
					stack.getChildren().add(part);
					partService.showPart(part, PartState.ACTIVATE);
				}
			}
		});
		context.set(IEditingDomainProvider.class, this);
		menuService.registerContextMenu(viewer.getControl(), "org.domainworkbench.popupmenu.navigator");
		context.set(ISelectionProvider.class, viewer);
	}

	public void setSelectionToViewer(Collection<?> collection) {
		final Collection<?> theSelection = collection;
		if (theSelection != null && !theSelection.isEmpty()) {
			Runnable runnable = new Runnable() {
				public void run() {
					if (viewer != null) {
						viewer.setSelection(new StructuredSelection(theSelection.toArray()), true);
					}
				}
			};
			shell.getDisplay().asyncExec(runnable);
		}
	}

	@Focus
	public void onFocus() {
		if (viewer != null)
			viewer.getControl().setFocus();
	}

	public IPropertySheetPage getPropertySheetPage() {
		PropertySheetPage propertySheetPage = new ExtendedPropertySheetPage(editingDomain) {
			@Override
			public void setSelectionToViewer(List<?> selection) {
				NavigationView.this.setSelectionToViewer(selection);
			}

		};
		propertySheetPage.setPropertySourceProvider(new AdapterFactoryContentProvider(adapterFactory));
		propertySheetPages.add(propertySheetPage);

		return propertySheetPage;
	}

	protected void initializeEditingDomain() {
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ClassSupplierItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		BasicCommandStack commandStack = new BasicCommandStack();

		commandStack.addCommandStackListener(new CommandStackListener() {
			public void commandStackChanged(final EventObject event) {
				shell.getDisplay().asyncExec(new Runnable() {
					public void run() {
						Command mostRecentCommand = ((CommandStack) event.getSource()).getMostRecentCommand();
						if (mostRecentCommand != null) {
							setSelectionToViewer(mostRecentCommand.getAffectedObjects());
						}
					}
				});
			}
		});

		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
	}

	@Override
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
		if (adapterType.equals(IPropertySheetPage.class)) {
			return ((T) getPropertySheetPage());
		}
		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return new Class<?>[] { IPropertySheetPage.class };
	}

}