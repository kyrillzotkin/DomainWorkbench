/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart;
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
public class EOperationPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EOperationPropertiesEditionPart {

	protected Text name;
	protected Button ordered;
	protected Button unique;
	protected Text lowerBound;
	protected Text upperBound;
	protected EObjectFlatComboViewer eType;
	protected EObjectFlatComboViewer eContainingClass;
	protected ReferencesTable eExceptions;
	protected List<ViewerFilter> eExceptionsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> eExceptionsFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable eGenericExceptions;
	protected List<ViewerFilter> eGenericExceptionsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> eGenericExceptionsFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EOperationPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence eOperationStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = eOperationStep.addStep(EcoreViewsRepository.EOperation.Properties.class);
		propertiesStep.addStep(EcoreViewsRepository.EOperation.Properties.name);
		propertiesStep.addStep(EcoreViewsRepository.EOperation.Properties.ordered);
		propertiesStep.addStep(EcoreViewsRepository.EOperation.Properties.unique);
		propertiesStep.addStep(EcoreViewsRepository.EOperation.Properties.lowerBound);
		propertiesStep.addStep(EcoreViewsRepository.EOperation.Properties.upperBound);
		propertiesStep.addStep(EcoreViewsRepository.EOperation.Properties.eType);
		propertiesStep.addStep(EcoreViewsRepository.EOperation.Properties.eContainingClass);
		propertiesStep.addStep(EcoreViewsRepository.EOperation.Properties.eExceptions);
		propertiesStep.addStep(EcoreViewsRepository.EOperation.Properties.eGenericExceptions);
		
		
		composer = new PartComposer(eOperationStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EcoreViewsRepository.EOperation.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EcoreViewsRepository.EOperation.Properties.name) {
					return createNameText(parent);
				}
				if (key == EcoreViewsRepository.EOperation.Properties.ordered) {
					return createOrderedCheckbox(parent);
				}
				if (key == EcoreViewsRepository.EOperation.Properties.unique) {
					return createUniqueCheckbox(parent);
				}
				if (key == EcoreViewsRepository.EOperation.Properties.lowerBound) {
					return createLowerBoundText(parent);
				}
				if (key == EcoreViewsRepository.EOperation.Properties.upperBound) {
					return createUpperBoundText(parent);
				}
				if (key == EcoreViewsRepository.EOperation.Properties.eType) {
					return createETypeFlatComboViewer(parent);
				}
				if (key == EcoreViewsRepository.EOperation.Properties.eContainingClass) {
					return createEContainingClassFlatComboViewer(parent);
				}
				if (key == EcoreViewsRepository.EOperation.Properties.eExceptions) {
					return createEExceptionsAdvancedReferencesTable(parent);
				}
				if (key == EcoreViewsRepository.EOperation.Properties.eGenericExceptions) {
					return createEGenericExceptionsAdvancedTableComposition(parent);
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
		propertiesGroup.setText(EcoreMessages.EOperationPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EOperation.Properties.name, EcoreMessages.EOperationPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EOperationPropertiesEditionPartImpl.this, EcoreViewsRepository.EOperation.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EOperationPropertiesEditionPartImpl.this, EcoreViewsRepository.EOperation.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, EcoreViewsRepository.EOperation.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EOperation.Properties.name, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createOrderedCheckbox(Composite parent) {
		ordered = new Button(parent, SWT.CHECK);
		ordered.setText(getDescription(EcoreViewsRepository.EOperation.Properties.ordered, EcoreMessages.EOperationPropertiesEditionPart_OrderedLabel));
		ordered.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EOperationPropertiesEditionPartImpl.this, EcoreViewsRepository.EOperation.Properties.ordered, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(ordered.getSelection())));
			}

		});
		GridData orderedData = new GridData(GridData.FILL_HORIZONTAL);
		orderedData.horizontalSpan = 2;
		ordered.setLayoutData(orderedData);
		EditingUtils.setID(ordered, EcoreViewsRepository.EOperation.Properties.ordered);
		EditingUtils.setEEFtype(ordered, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EOperation.Properties.ordered, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createUniqueCheckbox(Composite parent) {
		unique = new Button(parent, SWT.CHECK);
		unique.setText(getDescription(EcoreViewsRepository.EOperation.Properties.unique, EcoreMessages.EOperationPropertiesEditionPart_UniqueLabel));
		unique.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EOperationPropertiesEditionPartImpl.this, EcoreViewsRepository.EOperation.Properties.unique, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(unique.getSelection())));
			}

		});
		GridData uniqueData = new GridData(GridData.FILL_HORIZONTAL);
		uniqueData.horizontalSpan = 2;
		unique.setLayoutData(uniqueData);
		EditingUtils.setID(unique, EcoreViewsRepository.EOperation.Properties.unique);
		EditingUtils.setEEFtype(unique, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EOperation.Properties.unique, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createLowerBoundText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EOperation.Properties.lowerBound, EcoreMessages.EOperationPropertiesEditionPart_LowerBoundLabel);
		lowerBound = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData lowerBoundData = new GridData(GridData.FILL_HORIZONTAL);
		lowerBound.setLayoutData(lowerBoundData);
		lowerBound.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EOperationPropertiesEditionPartImpl.this, EcoreViewsRepository.EOperation.Properties.lowerBound, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, lowerBound.getText()));
			}

		});
		lowerBound.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EOperationPropertiesEditionPartImpl.this, EcoreViewsRepository.EOperation.Properties.lowerBound, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, lowerBound.getText()));
				}
			}

		});
		EditingUtils.setID(lowerBound, EcoreViewsRepository.EOperation.Properties.lowerBound);
		EditingUtils.setEEFtype(lowerBound, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EOperation.Properties.lowerBound, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createUpperBoundText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EOperation.Properties.upperBound, EcoreMessages.EOperationPropertiesEditionPart_UpperBoundLabel);
		upperBound = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData upperBoundData = new GridData(GridData.FILL_HORIZONTAL);
		upperBound.setLayoutData(upperBoundData);
		upperBound.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EOperationPropertiesEditionPartImpl.this, EcoreViewsRepository.EOperation.Properties.upperBound, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, upperBound.getText()));
			}

		});
		upperBound.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EOperationPropertiesEditionPartImpl.this, EcoreViewsRepository.EOperation.Properties.upperBound, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, upperBound.getText()));
				}
			}

		});
		EditingUtils.setID(upperBound, EcoreViewsRepository.EOperation.Properties.upperBound);
		EditingUtils.setEEFtype(upperBound, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EOperation.Properties.upperBound, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createETypeFlatComboViewer(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EOperation.Properties.eType, EcoreMessages.EOperationPropertiesEditionPart_ETypeLabel);
		eType = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EOperation.Properties.eType, EcoreViewsRepository.SWT_KIND));
		eType.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		eType.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EOperationPropertiesEditionPartImpl.this, EcoreViewsRepository.EOperation.Properties.eType, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getEType()));
			}

		});
		GridData eTypeData = new GridData(GridData.FILL_HORIZONTAL);
		eType.setLayoutData(eTypeData);
		eType.setID(EcoreViewsRepository.EOperation.Properties.eType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EOperation.Properties.eType, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createEContainingClassFlatComboViewer(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EOperation.Properties.eContainingClass, EcoreMessages.EOperationPropertiesEditionPart_EContainingClassLabel);
		eContainingClass = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EOperation.Properties.eContainingClass, EcoreViewsRepository.SWT_KIND));
		eContainingClass.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		eContainingClass.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EOperationPropertiesEditionPartImpl.this, EcoreViewsRepository.EOperation.Properties.eContainingClass, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getEContainingClass()));
			}

		});
		GridData eContainingClassData = new GridData(GridData.FILL_HORIZONTAL);
		eContainingClass.setLayoutData(eContainingClassData);
		eContainingClass.setID(EcoreViewsRepository.EOperation.Properties.eContainingClass);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EOperation.Properties.eContainingClass, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createEExceptionsAdvancedReferencesTable(Composite parent) {
		String label = getDescription(EcoreViewsRepository.EOperation.Properties.eExceptions, EcoreMessages.EOperationPropertiesEditionPart_EExceptionsLabel);		 
		this.eExceptions = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addEExceptions(); }
			public void handleEdit(EObject element) { editEExceptions(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveEExceptions(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromEExceptions(element); }
			public void navigateTo(EObject element) { }
		});
		this.eExceptions.setHelpText(propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EOperation.Properties.eExceptions, EcoreViewsRepository.SWT_KIND));
		this.eExceptions.createControls(parent);
		this.eExceptions.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EOperationPropertiesEditionPartImpl.this, EcoreViewsRepository.EOperation.Properties.eExceptions, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData eExceptionsData = new GridData(GridData.FILL_HORIZONTAL);
		eExceptionsData.horizontalSpan = 3;
		this.eExceptions.setLayoutData(eExceptionsData);
		this.eExceptions.disableMove();
		eExceptions.setID(EcoreViewsRepository.EOperation.Properties.eExceptions);
		eExceptions.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addEExceptions() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(eExceptions.getInput(), eExceptionsFilters, eExceptionsBusinessFilters,
		"eExceptions", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EOperationPropertiesEditionPartImpl.this, EcoreViewsRepository.EOperation.Properties.eExceptions,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				eExceptions.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveEExceptions(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EOperationPropertiesEditionPartImpl.this, EcoreViewsRepository.EOperation.Properties.eExceptions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		eExceptions.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromEExceptions(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EOperationPropertiesEditionPartImpl.this, EcoreViewsRepository.EOperation.Properties.eExceptions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		eExceptions.refresh();
	}

	/**
	 * 
	 */
	protected void editEExceptions(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				eExceptions.refresh();
			}
		}
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createEGenericExceptionsAdvancedTableComposition(Composite parent) {
		this.eGenericExceptions = new ReferencesTable(getDescription(EcoreViewsRepository.EOperation.Properties.eGenericExceptions, EcoreMessages.EOperationPropertiesEditionPart_EGenericExceptionsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EOperationPropertiesEditionPartImpl.this, EcoreViewsRepository.EOperation.Properties.eGenericExceptions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				eGenericExceptions.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EOperationPropertiesEditionPartImpl.this, EcoreViewsRepository.EOperation.Properties.eGenericExceptions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				eGenericExceptions.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EOperationPropertiesEditionPartImpl.this, EcoreViewsRepository.EOperation.Properties.eGenericExceptions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				eGenericExceptions.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EOperationPropertiesEditionPartImpl.this, EcoreViewsRepository.EOperation.Properties.eGenericExceptions, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				eGenericExceptions.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.eGenericExceptionsFilters) {
			this.eGenericExceptions.addFilter(filter);
		}
		this.eGenericExceptions.setHelpText(propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EOperation.Properties.eGenericExceptions, EcoreViewsRepository.SWT_KIND));
		this.eGenericExceptions.createControls(parent);
		this.eGenericExceptions.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EOperationPropertiesEditionPartImpl.this, EcoreViewsRepository.EOperation.Properties.eGenericExceptions, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData eGenericExceptionsData = new GridData(GridData.FILL_HORIZONTAL);
		eGenericExceptionsData.horizontalSpan = 3;
		this.eGenericExceptions.setLayoutData(eGenericExceptionsData);
		this.eGenericExceptions.setLowerBound(0);
		this.eGenericExceptions.setUpperBound(-1);
		eGenericExceptions.setID(EcoreViewsRepository.EOperation.Properties.eGenericExceptions);
		eGenericExceptions.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
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
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#getOrdered()
	 * 
	 */
	public Boolean getOrdered() {
		return Boolean.valueOf(ordered.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#setOrdered(Boolean newValue)
	 * 
	 */
	public void setOrdered(Boolean newValue) {
		if (newValue != null) {
			ordered.setSelection(newValue.booleanValue());
		} else {
			ordered.setSelection(false);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#getUnique()
	 * 
	 */
	public Boolean getUnique() {
		return Boolean.valueOf(unique.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#setUnique(Boolean newValue)
	 * 
	 */
	public void setUnique(Boolean newValue) {
		if (newValue != null) {
			unique.setSelection(newValue.booleanValue());
		} else {
			unique.setSelection(false);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#getLowerBound()
	 * 
	 */
	public String getLowerBound() {
		return lowerBound.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#setLowerBound(String newValue)
	 * 
	 */
	public void setLowerBound(String newValue) {
		if (newValue != null) {
			lowerBound.setText(newValue);
		} else {
			lowerBound.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#getUpperBound()
	 * 
	 */
	public String getUpperBound() {
		return upperBound.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#setUpperBound(String newValue)
	 * 
	 */
	public void setUpperBound(String newValue) {
		if (newValue != null) {
			upperBound.setText(newValue);
		} else {
			upperBound.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#getEType()
	 * 
	 */
	public EObject getEType() {
		if (eType.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) eType.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#initEType(EObjectFlatComboSettings)
	 */
	public void initEType(EObjectFlatComboSettings settings) {
		eType.setInput(settings);
		if (current != null) {
			eType.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#setEType(EObject newValue)
	 * 
	 */
	public void setEType(EObject newValue) {
		if (newValue != null) {
			eType.setSelection(new StructuredSelection(newValue));
		} else {
			eType.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#setETypeButtonMode(ButtonsModeEnum newValue)
	 */
	public void setETypeButtonMode(ButtonsModeEnum newValue) {
		eType.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#addFilterEType(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEType(ViewerFilter filter) {
		eType.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#addBusinessFilterEType(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEType(ViewerFilter filter) {
		eType.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#getEContainingClass()
	 * 
	 */
	public EObject getEContainingClass() {
		if (eContainingClass.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) eContainingClass.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#initEContainingClass(EObjectFlatComboSettings)
	 */
	public void initEContainingClass(EObjectFlatComboSettings settings) {
		eContainingClass.setInput(settings);
		if (current != null) {
			eContainingClass.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#setEContainingClass(EObject newValue)
	 * 
	 */
	public void setEContainingClass(EObject newValue) {
		if (newValue != null) {
			eContainingClass.setSelection(new StructuredSelection(newValue));
		} else {
			eContainingClass.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#setEContainingClassButtonMode(ButtonsModeEnum newValue)
	 */
	public void setEContainingClassButtonMode(ButtonsModeEnum newValue) {
		eContainingClass.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#addFilterEContainingClass(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEContainingClass(ViewerFilter filter) {
		eContainingClass.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#addBusinessFilterEContainingClass(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEContainingClass(ViewerFilter filter) {
		eContainingClass.addBusinessRuleFilter(filter);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#initEExceptions(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initEExceptions(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		eExceptions.setContentProvider(contentProvider);
		eExceptions.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#updateEExceptions()
	 * 
	 */
	public void updateEExceptions() {
	eExceptions.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#addFilterEExceptions(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEExceptions(ViewerFilter filter) {
		eExceptionsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#addBusinessFilterEExceptions(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEExceptions(ViewerFilter filter) {
		eExceptionsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#isContainedInEExceptionsTable(EObject element)
	 * 
	 */
	public boolean isContainedInEExceptionsTable(EObject element) {
		return ((ReferencesTableSettings)eExceptions.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#initEGenericExceptions(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initEGenericExceptions(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		eGenericExceptions.setContentProvider(contentProvider);
		eGenericExceptions.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#updateEGenericExceptions()
	 * 
	 */
	public void updateEGenericExceptions() {
	eGenericExceptions.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#addFilterEGenericExceptions(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEGenericExceptions(ViewerFilter filter) {
		eGenericExceptionsFilters.add(filter);
		if (this.eGenericExceptions != null) {
			this.eGenericExceptions.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#addBusinessFilterEGenericExceptions(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEGenericExceptions(ViewerFilter filter) {
		eGenericExceptionsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart#isContainedInEGenericExceptionsTable(EObject element)
	 * 
	 */
	public boolean isContainedInEGenericExceptionsTable(EObject element) {
		return ((ReferencesTableSettings)eGenericExceptions.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EcoreMessages.EOperation_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
