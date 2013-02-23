package org.domainworkbench.parts;

import java.util.Collection;
import java.util.EventObject;
import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.classmaker.ClassMaker;
import org.classmaker.ModelWorkspace;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.e4.ui.workbench.swt.modeling.EMenuService;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class NavigationView implements IEditingDomainProvider {

	private TreeViewer viewer;

	@Named(IServiceConstants.ACTIVE_SHELL)
	protected Shell shell;

	protected AdapterFactoryEditingDomain editingDomain;

	protected ComposedAdapterFactory adapterFactory;

	@Inject
	protected ESelectionService selectionService;

	@Inject
	EMenuService menuService;

	public NavigationView() {
		initializeEditingDomain();
	}

	@PostConstruct
	public void createControls(Composite parent, final IEclipseContext context) {
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));
		viewer = new TreeViewer(parent, SWT.BORDER);
		ModelWorkspace input = ClassMaker.getInstance().getWorkspace();

		AdapterFactoryContentProvider contentProvider = new AdapterFactoryContentProvider(
				adapterFactory);
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(
				adapterFactory);
		viewer.setContentProvider(contentProvider);
		viewer.setLabelProvider(new DecoratingLabelProvider(labelProvider,
				(ILabelDecorator) new BundleStateDecorator()));
		viewer.setInput(input);
		ClassMaker.getInstance().getWorkspace()
				.addRefreshListener(new AdapterImpl() {

					@Override
					public void notifyChanged(Notification msg) {
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
				if (selection instanceof IStructuredSelection
						&& ((IStructuredSelection) selection).size() == 1) {
					Object selectedObject = ((IStructuredSelection) selection)
							.getFirstElement();
					selectionService.setSelection(selectedObject);
					context.set(IEditingDomainItemProvider.class,
							(IEditingDomainItemProvider) adapterFactory.adapt(
									selectedObject,
									IEditingDomainItemProvider.class));
				}
			}

		});
		context.set(IEditingDomainProvider.class, this);
		menuService.registerContextMenu(viewer.getControl(),
				"org.domainworkbench.popupmenu.navigator");
	}

	public void setSelectionToViewer(Collection<?> collection) {
		final Collection<?> theSelection = collection;
		if (theSelection != null && !theSelection.isEmpty()) {
			Runnable runnable = new Runnable() {
				public void run() {
					if (viewer != null) {
						viewer.setSelection(new StructuredSelection(
								theSelection.toArray()), true);
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

	protected void initializeEditingDomain() {
		adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		BasicCommandStack commandStack = new BasicCommandStack();

		commandStack.addCommandStackListener(new CommandStackListener() {
			public void commandStackChanged(final EventObject event) {
				shell.getDisplay().asyncExec(new Runnable() {
					public void run() {
						Command mostRecentCommand = ((CommandStack) event
								.getSource()).getMostRecentCommand();
						if (mostRecentCommand != null) {
							setSelectionToViewer(mostRecentCommand
									.getAffectedObjects());
						}
					}
				});
			}
		});

		editingDomain = new AdapterFactoryEditingDomain(adapterFactory,
				commandStack, new HashMap<Resource, Boolean>());
	}

	@Override
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

}