/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart;
import org.eclipse.emf.ecore.parts.EcoreViewsRepository;

import org.eclipse.emf.ecore.providers.EcoreMessages;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * 
 * 
 */
public class EClassPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EClassPropertiesEditionPart {

	protected Text name;
	protected Text instanceClassName;
	protected Text instanceTypeName;
	protected EObjectFlatComboViewer ePackage;
	protected Button abstract_;
	protected Button interface_;
	protected ReferencesTable eSuperTypes;
	protected List<ViewerFilter> eSuperTypesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> eSuperTypesFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable eGenericSuperTypes;
	protected List<ViewerFilter> eGenericSuperTypesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> eGenericSuperTypesFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EClassPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
		CompositionSequence eClassStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = eClassStep.addStep(EcoreViewsRepository.EClass.Properties.class);
		propertiesStep.addStep(EcoreViewsRepository.EClass.Properties.name);
		propertiesStep.addStep(EcoreViewsRepository.EClass.Properties.instanceClassName);
		propertiesStep.addStep(EcoreViewsRepository.EClass.Properties.instanceTypeName);
		propertiesStep.addStep(EcoreViewsRepository.EClass.Properties.ePackage);
		propertiesStep.addStep(EcoreViewsRepository.EClass.Properties.abstract_);
		propertiesStep.addStep(EcoreViewsRepository.EClass.Properties.interface_);
		propertiesStep.addStep(EcoreViewsRepository.EClass.Properties.eSuperTypes);
		propertiesStep.addStep(EcoreViewsRepository.EClass.Properties.eGenericSuperTypes);
		
		
		composer = new PartComposer(eClassStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EcoreViewsRepository.EClass.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EcoreViewsRepository.EClass.Properties.name) {
					return createNameText(parent);
				}
				if (key == EcoreViewsRepository.EClass.Properties.instanceClassName) {
					return createInstanceClassNameText(parent);
				}
				if (key == EcoreViewsRepository.EClass.Properties.instanceTypeName) {
					return createInstanceTypeNameText(parent);
				}
				if (key == EcoreViewsRepository.EClass.Properties.ePackage) {
					return createEPackageFlatComboViewer(parent);
				}
				if (key == EcoreViewsRepository.EClass.Properties.abstract_) {
					return createAbstract_Checkbox(parent);
				}
				if (key == EcoreViewsRepository.EClass.Properties.interface_) {
					return createInterface_Checkbox(parent);
				}
				if (key == EcoreViewsRepository.EClass.Properties.eSuperTypes) {
					return createESuperTypesAdvancedReferencesTable(parent);
				}
				if (key == EcoreViewsRepository.EClass.Properties.eGenericSuperTypes) {
					return createEGenericSuperTypesAdvancedTableComposition(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EcoreMessages.EClassPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EClass.Properties.name, EcoreMessages.EClassPropertiesEditionPart_NameLabel);
		name = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EClassPropertiesEditionPartImpl.this, EcoreViewsRepository.EClass.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});
		name.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EClassPropertiesEditionPartImpl.this, EcoreViewsRepository.EClass.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, EcoreViewsRepository.EClass.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EClass.Properties.name, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createInstanceClassNameText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EClass.Properties.instanceClassName, EcoreMessages.EClassPropertiesEditionPart_InstanceClassNameLabel);
		instanceClassName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData instanceClassNameData = new GridData(GridData.FILL_HORIZONTAL);
		instanceClassName.setLayoutData(instanceClassNameData);
		instanceClassName.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EClassPropertiesEditionPartImpl.this, EcoreViewsRepository.EClass.Properties.instanceClassName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, instanceClassName.getText()));
			}

		});
		instanceClassName.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EClassPropertiesEditionPartImpl.this, EcoreViewsRepository.EClass.Properties.instanceClassName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, instanceClassName.getText()));
				}
			}

		});
		EditingUtils.setID(instanceClassName, EcoreViewsRepository.EClass.Properties.instanceClassName);
		EditingUtils.setEEFtype(instanceClassName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EClass.Properties.instanceClassName, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createInstanceTypeNameText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EClass.Properties.instanceTypeName, EcoreMessages.EClassPropertiesEditionPart_InstanceTypeNameLabel);
		instanceTypeName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData instanceTypeNameData = new GridData(GridData.FILL_HORIZONTAL);
		instanceTypeName.setLayoutData(instanceTypeNameData);
		instanceTypeName.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EClassPropertiesEditionPartImpl.this, EcoreViewsRepository.EClass.Properties.instanceTypeName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, instanceTypeName.getText()));
			}

		});
		instanceTypeName.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EClassPropertiesEditionPartImpl.this, EcoreViewsRepository.EClass.Properties.instanceTypeName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, instanceTypeName.getText()));
				}
			}

		});
		EditingUtils.setID(instanceTypeName, EcoreViewsRepository.EClass.Properties.instanceTypeName);
		EditingUtils.setEEFtype(instanceTypeName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EClass.Properties.instanceTypeName, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createEPackageFlatComboViewer(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EClass.Properties.ePackage, EcoreMessages.EClassPropertiesEditionPart_EPackageLabel);
		ePackage = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EClass.Properties.ePackage, EcoreViewsRepository.SWT_KIND));
		ePackage.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		ePackage.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EClassPropertiesEditionPartImpl.this, EcoreViewsRepository.EClass.Properties.ePackage, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getEPackage()));
			}

		});
		GridData ePackageData = new GridData(GridData.FILL_HORIZONTAL);
		ePackage.setLayoutData(ePackageData);
		ePackage.setID(EcoreViewsRepository.EClass.Properties.ePackage);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EClass.Properties.ePackage, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createAbstract_Checkbox(Composite parent) {
		abstract_ = new Button(parent, SWT.CHECK);
		abstract_.setText(getDescription(EcoreViewsRepository.EClass.Properties.abstract_, EcoreMessages.EClassPropertiesEditionPart_Abstract_Label));
		abstract_.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EClassPropertiesEditionPartImpl.this, EcoreViewsRepository.EClass.Properties.abstract_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(abstract_.getSelection())));
			}

		});
		GridData abstract_Data = new GridData(GridData.FILL_HORIZONTAL);
		abstract_Data.horizontalSpan = 2;
		abstract_.setLayoutData(abstract_Data);
		EditingUtils.setID(abstract_, EcoreViewsRepository.EClass.Properties.abstract_);
		EditingUtils.setEEFtype(abstract_, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EClass.Properties.abstract_, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createInterface_Checkbox(Composite parent) {
		interface_ = new Button(parent, SWT.CHECK);
		interface_.setText(getDescription(EcoreViewsRepository.EClass.Properties.interface_, EcoreMessages.EClassPropertiesEditionPart_Interface_Label));
		interface_.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EClassPropertiesEditionPartImpl.this, EcoreViewsRepository.EClass.Properties.interface_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(interface_.getSelection())));
			}

		});
		GridData interface_Data = new GridData(GridData.FILL_HORIZONTAL);
		interface_Data.horizontalSpan = 2;
		interface_.setLayoutData(interface_Data);
		EditingUtils.setID(interface_, EcoreViewsRepository.EClass.Properties.interface_);
		EditingUtils.setEEFtype(interface_, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EClass.Properties.interface_, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createESuperTypesAdvancedReferencesTable(Composite parent) {
		String label = getDescription(EcoreViewsRepository.EClass.Properties.eSuperTypes, EcoreMessages.EClassPropertiesEditionPart_ESuperTypesLabel);		 
		this.eSuperTypes = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addESuperTypes(); }
			public void handleEdit(EObject element) { editESuperTypes(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveESuperTypes(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromESuperTypes(element); }
			public void navigateTo(EObject element) { }
		});
		this.eSuperTypes.setHelpText(propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EClass.Properties.eSuperTypes, EcoreViewsRepository.SWT_KIND));
		this.eSuperTypes.createControls(parent);
		this.eSuperTypes.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EClassPropertiesEditionPartImpl.this, EcoreViewsRepository.EClass.Properties.eSuperTypes, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData eSuperTypesData = new GridData(GridData.FILL_HORIZONTAL);
		eSuperTypesData.horizontalSpan = 3;
		this.eSuperTypes.setLayoutData(eSuperTypesData);
		this.eSuperTypes.disableMove();
		eSuperTypes.setID(EcoreViewsRepository.EClass.Properties.eSuperTypes);
		eSuperTypes.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addESuperTypes() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(eSuperTypes.getInput(), eSuperTypesFilters, eSuperTypesBusinessFilters,
		"eSuperTypes", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EClassPropertiesEditionPartImpl.this, EcoreViewsRepository.EClass.Properties.eSuperTypes,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				eSuperTypes.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveESuperTypes(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EClassPropertiesEditionPartImpl.this, EcoreViewsRepository.EClass.Properties.eSuperTypes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		eSuperTypes.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromESuperTypes(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EClassPropertiesEditionPartImpl.this, EcoreViewsRepository.EClass.Properties.eSuperTypes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		eSuperTypes.refresh();
	}

	/**
	 * 
	 */
	protected void editESuperTypes(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				eSuperTypes.refresh();
			}
		}
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createEGenericSuperTypesAdvancedTableComposition(Composite parent) {
		this.eGenericSuperTypes = new ReferencesTable(getDescription(EcoreViewsRepository.EClass.Properties.eGenericSuperTypes, EcoreMessages.EClassPropertiesEditionPart_EGenericSuperTypesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EClassPropertiesEditionPartImpl.this, EcoreViewsRepository.EClass.Properties.eGenericSuperTypes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				eGenericSuperTypes.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EClassPropertiesEditionPartImpl.this, EcoreViewsRepository.EClass.Properties.eGenericSuperTypes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				eGenericSuperTypes.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EClassPropertiesEditionPartImpl.this, EcoreViewsRepository.EClass.Properties.eGenericSuperTypes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				eGenericSuperTypes.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EClassPropertiesEditionPartImpl.this, EcoreViewsRepository.EClass.Properties.eGenericSuperTypes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				eGenericSuperTypes.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.eGenericSuperTypesFilters) {
			this.eGenericSuperTypes.addFilter(filter);
		}
		this.eGenericSuperTypes.setHelpText(propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EClass.Properties.eGenericSuperTypes, EcoreViewsRepository.SWT_KIND));
		this.eGenericSuperTypes.createControls(parent);
		this.eGenericSuperTypes.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EClassPropertiesEditionPartImpl.this, EcoreViewsRepository.EClass.Properties.eGenericSuperTypes, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData eGenericSuperTypesData = new GridData(GridData.FILL_HORIZONTAL);
		eGenericSuperTypesData.horizontalSpan = 3;
		this.eGenericSuperTypes.setLayoutData(eGenericSuperTypesData);
		this.eGenericSuperTypes.setLowerBound(0);
		this.eGenericSuperTypes.setUpperBound(-1);
		eGenericSuperTypes.setID(EcoreViewsRepository.EClass.Properties.eGenericSuperTypes);
		eGenericSuperTypes.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#getInstanceClassName()
	 * 
	 */
	public String getInstanceClassName() {
		return instanceClassName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#setInstanceClassName(String newValue)
	 * 
	 */
	public void setInstanceClassName(String newValue) {
		if (newValue != null) {
			instanceClassName.setText(newValue);
		} else {
			instanceClassName.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#getInstanceTypeName()
	 * 
	 */
	public String getInstanceTypeName() {
		return instanceTypeName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#setInstanceTypeName(String newValue)
	 * 
	 */
	public void setInstanceTypeName(String newValue) {
		if (newValue != null) {
			instanceTypeName.setText(newValue);
		} else {
			instanceTypeName.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#getEPackage()
	 * 
	 */
	public EObject getEPackage() {
		if (ePackage.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) ePackage.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#initEPackage(EObjectFlatComboSettings)
	 */
	public void initEPackage(EObjectFlatComboSettings settings) {
		ePackage.setInput(settings);
		if (current != null) {
			ePackage.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#setEPackage(EObject newValue)
	 * 
	 */
	public void setEPackage(EObject newValue) {
		if (newValue != null) {
			ePackage.setSelection(new StructuredSelection(newValue));
		} else {
			ePackage.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#setEPackageButtonMode(ButtonsModeEnum newValue)
	 */
	public void setEPackageButtonMode(ButtonsModeEnum newValue) {
		ePackage.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#addFilterEPackage(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEPackage(ViewerFilter filter) {
		ePackage.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#addBusinessFilterEPackage(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEPackage(ViewerFilter filter) {
		ePackage.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#getAbstract_()
	 * 
	 */
	public Boolean getAbstract_() {
		return Boolean.valueOf(abstract_.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#setAbstract_(Boolean newValue)
	 * 
	 */
	public void setAbstract_(Boolean newValue) {
		if (newValue != null) {
			abstract_.setSelection(newValue.booleanValue());
		} else {
			abstract_.setSelection(false);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#getInterface_()
	 * 
	 */
	public Boolean getInterface_() {
		return Boolean.valueOf(interface_.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#setInterface_(Boolean newValue)
	 * 
	 */
	public void setInterface_(Boolean newValue) {
		if (newValue != null) {
			interface_.setSelection(newValue.booleanValue());
		} else {
			interface_.setSelection(false);
		}
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#initESuperTypes(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initESuperTypes(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		eSuperTypes.setContentProvider(contentProvider);
		eSuperTypes.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#updateESuperTypes()
	 * 
	 */
	public void updateESuperTypes() {
	eSuperTypes.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#addFilterESuperTypes(ViewerFilter filter)
	 * 
	 */
	public void addFilterToESuperTypes(ViewerFilter filter) {
		eSuperTypesFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#addBusinessFilterESuperTypes(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToESuperTypes(ViewerFilter filter) {
		eSuperTypesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#isContainedInESuperTypesTable(EObject element)
	 * 
	 */
	public boolean isContainedInESuperTypesTable(EObject element) {
		return ((ReferencesTableSettings)eSuperTypes.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#initEGenericSuperTypes(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initEGenericSuperTypes(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		eGenericSuperTypes.setContentProvider(contentProvider);
		eGenericSuperTypes.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#updateEGenericSuperTypes()
	 * 
	 */
	public void updateEGenericSuperTypes() {
	eGenericSuperTypes.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#addFilterEGenericSuperTypes(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEGenericSuperTypes(ViewerFilter filter) {
		eGenericSuperTypesFilters.add(filter);
		if (this.eGenericSuperTypes != null) {
			this.eGenericSuperTypes.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#addBusinessFilterEGenericSuperTypes(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEGenericSuperTypes(ViewerFilter filter) {
		eGenericSuperTypesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart#isContainedInEGenericSuperTypesTable(EObject element)
	 * 
	 */
	public boolean isContainedInEGenericSuperTypesTable(EObject element) {
		return ((ReferencesTableSettings)eGenericSuperTypes.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EcoreMessages.EClass_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
