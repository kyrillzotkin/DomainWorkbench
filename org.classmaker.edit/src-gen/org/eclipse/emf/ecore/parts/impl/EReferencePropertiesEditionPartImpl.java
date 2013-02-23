/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart;
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
public class EReferencePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EReferencePropertiesEditionPart {

	protected Text name;
	protected Button ordered;
	protected Button unique;
	protected Text lowerBound;
	protected Text upperBound;
	protected EObjectFlatComboViewer eType;
	protected Button changeable;
	protected Button volatile_;
	protected Button transient_;
	protected Text defaultValueLiteral;
	protected Button unsettable;
	protected Button derived;
	protected EObjectFlatComboViewer eContainingClass;
	protected Button containment;
	protected Button resolveProxies;
	protected EObjectFlatComboViewer eOpposite;
	protected ReferencesTable eKeys;
	protected List<ViewerFilter> eKeysBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> eKeysFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EReferencePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence eReferenceStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = eReferenceStep.addStep(EcoreViewsRepository.EReference.Properties.class);
		propertiesStep.addStep(EcoreViewsRepository.EReference.Properties.name);
		propertiesStep.addStep(EcoreViewsRepository.EReference.Properties.ordered);
		propertiesStep.addStep(EcoreViewsRepository.EReference.Properties.unique);
		propertiesStep.addStep(EcoreViewsRepository.EReference.Properties.lowerBound);
		propertiesStep.addStep(EcoreViewsRepository.EReference.Properties.upperBound);
		propertiesStep.addStep(EcoreViewsRepository.EReference.Properties.eType);
		propertiesStep.addStep(EcoreViewsRepository.EReference.Properties.changeable);
		propertiesStep.addStep(EcoreViewsRepository.EReference.Properties.volatile_);
		propertiesStep.addStep(EcoreViewsRepository.EReference.Properties.transient_);
		propertiesStep.addStep(EcoreViewsRepository.EReference.Properties.defaultValueLiteral);
		propertiesStep.addStep(EcoreViewsRepository.EReference.Properties.unsettable);
		propertiesStep.addStep(EcoreViewsRepository.EReference.Properties.derived);
		propertiesStep.addStep(EcoreViewsRepository.EReference.Properties.eContainingClass);
		propertiesStep.addStep(EcoreViewsRepository.EReference.Properties.containment);
		propertiesStep.addStep(EcoreViewsRepository.EReference.Properties.resolveProxies);
		propertiesStep.addStep(EcoreViewsRepository.EReference.Properties.eOpposite);
		propertiesStep.addStep(EcoreViewsRepository.EReference.Properties.eKeys);
		
		
		composer = new PartComposer(eReferenceStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EcoreViewsRepository.EReference.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.name) {
					return createNameText(parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.ordered) {
					return createOrderedCheckbox(parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.unique) {
					return createUniqueCheckbox(parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.lowerBound) {
					return createLowerBoundText(parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.upperBound) {
					return createUpperBoundText(parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.eType) {
					return createETypeFlatComboViewer(parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.changeable) {
					return createChangeableCheckbox(parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.volatile_) {
					return createVolatile_Checkbox(parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.transient_) {
					return createTransient_Checkbox(parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.defaultValueLiteral) {
					return createDefaultValueLiteralText(parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.unsettable) {
					return createUnsettableCheckbox(parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.derived) {
					return createDerivedCheckbox(parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.eContainingClass) {
					return createEContainingClassFlatComboViewer(parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.containment) {
					return createContainmentCheckbox(parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.resolveProxies) {
					return createResolveProxiesCheckbox(parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.eOpposite) {
					return createEOppositeFlatComboViewer(parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.eKeys) {
					return createEKeysAdvancedReferencesTable(parent);
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
		propertiesGroup.setText(EcoreMessages.EReferencePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EReference.Properties.name, EcoreMessages.EReferencePropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, EcoreViewsRepository.EReference.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.name, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createOrderedCheckbox(Composite parent) {
		ordered = new Button(parent, SWT.CHECK);
		ordered.setText(getDescription(EcoreViewsRepository.EReference.Properties.ordered, EcoreMessages.EReferencePropertiesEditionPart_OrderedLabel));
		ordered.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.ordered, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(ordered.getSelection())));
			}

		});
		GridData orderedData = new GridData(GridData.FILL_HORIZONTAL);
		orderedData.horizontalSpan = 2;
		ordered.setLayoutData(orderedData);
		EditingUtils.setID(ordered, EcoreViewsRepository.EReference.Properties.ordered);
		EditingUtils.setEEFtype(ordered, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.ordered, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createUniqueCheckbox(Composite parent) {
		unique = new Button(parent, SWT.CHECK);
		unique.setText(getDescription(EcoreViewsRepository.EReference.Properties.unique, EcoreMessages.EReferencePropertiesEditionPart_UniqueLabel));
		unique.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.unique, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(unique.getSelection())));
			}

		});
		GridData uniqueData = new GridData(GridData.FILL_HORIZONTAL);
		uniqueData.horizontalSpan = 2;
		unique.setLayoutData(uniqueData);
		EditingUtils.setID(unique, EcoreViewsRepository.EReference.Properties.unique);
		EditingUtils.setEEFtype(unique, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.unique, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createLowerBoundText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EReference.Properties.lowerBound, EcoreMessages.EReferencePropertiesEditionPart_LowerBoundLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.lowerBound, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, lowerBound.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.lowerBound, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, lowerBound.getText()));
				}
			}

		});
		EditingUtils.setID(lowerBound, EcoreViewsRepository.EReference.Properties.lowerBound);
		EditingUtils.setEEFtype(lowerBound, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.lowerBound, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createUpperBoundText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EReference.Properties.upperBound, EcoreMessages.EReferencePropertiesEditionPart_UpperBoundLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.upperBound, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, upperBound.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.upperBound, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, upperBound.getText()));
				}
			}

		});
		EditingUtils.setID(upperBound, EcoreViewsRepository.EReference.Properties.upperBound);
		EditingUtils.setEEFtype(upperBound, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.upperBound, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createETypeFlatComboViewer(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EReference.Properties.eType, EcoreMessages.EReferencePropertiesEditionPart_ETypeLabel);
		eType = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EReference.Properties.eType, EcoreViewsRepository.SWT_KIND));
		eType.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		eType.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.eType, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getEType()));
			}

		});
		GridData eTypeData = new GridData(GridData.FILL_HORIZONTAL);
		eType.setLayoutData(eTypeData);
		eType.setID(EcoreViewsRepository.EReference.Properties.eType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.eType, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createChangeableCheckbox(Composite parent) {
		changeable = new Button(parent, SWT.CHECK);
		changeable.setText(getDescription(EcoreViewsRepository.EReference.Properties.changeable, EcoreMessages.EReferencePropertiesEditionPart_ChangeableLabel));
		changeable.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.changeable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(changeable.getSelection())));
			}

		});
		GridData changeableData = new GridData(GridData.FILL_HORIZONTAL);
		changeableData.horizontalSpan = 2;
		changeable.setLayoutData(changeableData);
		EditingUtils.setID(changeable, EcoreViewsRepository.EReference.Properties.changeable);
		EditingUtils.setEEFtype(changeable, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.changeable, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createVolatile_Checkbox(Composite parent) {
		volatile_ = new Button(parent, SWT.CHECK);
		volatile_.setText(getDescription(EcoreViewsRepository.EReference.Properties.volatile_, EcoreMessages.EReferencePropertiesEditionPart_Volatile_Label));
		volatile_.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.volatile_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(volatile_.getSelection())));
			}

		});
		GridData volatile_Data = new GridData(GridData.FILL_HORIZONTAL);
		volatile_Data.horizontalSpan = 2;
		volatile_.setLayoutData(volatile_Data);
		EditingUtils.setID(volatile_, EcoreViewsRepository.EReference.Properties.volatile_);
		EditingUtils.setEEFtype(volatile_, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.volatile_, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createTransient_Checkbox(Composite parent) {
		transient_ = new Button(parent, SWT.CHECK);
		transient_.setText(getDescription(EcoreViewsRepository.EReference.Properties.transient_, EcoreMessages.EReferencePropertiesEditionPart_Transient_Label));
		transient_.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.transient_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(transient_.getSelection())));
			}

		});
		GridData transient_Data = new GridData(GridData.FILL_HORIZONTAL);
		transient_Data.horizontalSpan = 2;
		transient_.setLayoutData(transient_Data);
		EditingUtils.setID(transient_, EcoreViewsRepository.EReference.Properties.transient_);
		EditingUtils.setEEFtype(transient_, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.transient_, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createDefaultValueLiteralText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EReference.Properties.defaultValueLiteral, EcoreMessages.EReferencePropertiesEditionPart_DefaultValueLiteralLabel);
		defaultValueLiteral = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData defaultValueLiteralData = new GridData(GridData.FILL_HORIZONTAL);
		defaultValueLiteral.setLayoutData(defaultValueLiteralData);
		defaultValueLiteral.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.defaultValueLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, defaultValueLiteral.getText()));
			}

		});
		defaultValueLiteral.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.defaultValueLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, defaultValueLiteral.getText()));
				}
			}

		});
		EditingUtils.setID(defaultValueLiteral, EcoreViewsRepository.EReference.Properties.defaultValueLiteral);
		EditingUtils.setEEFtype(defaultValueLiteral, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.defaultValueLiteral, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createUnsettableCheckbox(Composite parent) {
		unsettable = new Button(parent, SWT.CHECK);
		unsettable.setText(getDescription(EcoreViewsRepository.EReference.Properties.unsettable, EcoreMessages.EReferencePropertiesEditionPart_UnsettableLabel));
		unsettable.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.unsettable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(unsettable.getSelection())));
			}

		});
		GridData unsettableData = new GridData(GridData.FILL_HORIZONTAL);
		unsettableData.horizontalSpan = 2;
		unsettable.setLayoutData(unsettableData);
		EditingUtils.setID(unsettable, EcoreViewsRepository.EReference.Properties.unsettable);
		EditingUtils.setEEFtype(unsettable, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.unsettable, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createDerivedCheckbox(Composite parent) {
		derived = new Button(parent, SWT.CHECK);
		derived.setText(getDescription(EcoreViewsRepository.EReference.Properties.derived, EcoreMessages.EReferencePropertiesEditionPart_DerivedLabel));
		derived.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.derived, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(derived.getSelection())));
			}

		});
		GridData derivedData = new GridData(GridData.FILL_HORIZONTAL);
		derivedData.horizontalSpan = 2;
		derived.setLayoutData(derivedData);
		EditingUtils.setID(derived, EcoreViewsRepository.EReference.Properties.derived);
		EditingUtils.setEEFtype(derived, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.derived, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createEContainingClassFlatComboViewer(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EReference.Properties.eContainingClass, EcoreMessages.EReferencePropertiesEditionPart_EContainingClassLabel);
		eContainingClass = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EReference.Properties.eContainingClass, EcoreViewsRepository.SWT_KIND));
		eContainingClass.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		eContainingClass.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.eContainingClass, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getEContainingClass()));
			}

		});
		GridData eContainingClassData = new GridData(GridData.FILL_HORIZONTAL);
		eContainingClass.setLayoutData(eContainingClassData);
		eContainingClass.setID(EcoreViewsRepository.EReference.Properties.eContainingClass);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.eContainingClass, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createContainmentCheckbox(Composite parent) {
		containment = new Button(parent, SWT.CHECK);
		containment.setText(getDescription(EcoreViewsRepository.EReference.Properties.containment, EcoreMessages.EReferencePropertiesEditionPart_ContainmentLabel));
		containment.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.containment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(containment.getSelection())));
			}

		});
		GridData containmentData = new GridData(GridData.FILL_HORIZONTAL);
		containmentData.horizontalSpan = 2;
		containment.setLayoutData(containmentData);
		EditingUtils.setID(containment, EcoreViewsRepository.EReference.Properties.containment);
		EditingUtils.setEEFtype(containment, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.containment, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createResolveProxiesCheckbox(Composite parent) {
		resolveProxies = new Button(parent, SWT.CHECK);
		resolveProxies.setText(getDescription(EcoreViewsRepository.EReference.Properties.resolveProxies, EcoreMessages.EReferencePropertiesEditionPart_ResolveProxiesLabel));
		resolveProxies.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.resolveProxies, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(resolveProxies.getSelection())));
			}

		});
		GridData resolveProxiesData = new GridData(GridData.FILL_HORIZONTAL);
		resolveProxiesData.horizontalSpan = 2;
		resolveProxies.setLayoutData(resolveProxiesData);
		EditingUtils.setID(resolveProxies, EcoreViewsRepository.EReference.Properties.resolveProxies);
		EditingUtils.setEEFtype(resolveProxies, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.resolveProxies, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createEOppositeFlatComboViewer(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EReference.Properties.eOpposite, EcoreMessages.EReferencePropertiesEditionPart_EOppositeLabel);
		eOpposite = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EReference.Properties.eOpposite, EcoreViewsRepository.SWT_KIND));
		eOpposite.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		eOpposite.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.eOpposite, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getEOpposite()));
			}

		});
		GridData eOppositeData = new GridData(GridData.FILL_HORIZONTAL);
		eOpposite.setLayoutData(eOppositeData);
		eOpposite.setID(EcoreViewsRepository.EReference.Properties.eOpposite);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.eOpposite, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createEKeysAdvancedReferencesTable(Composite parent) {
		String label = getDescription(EcoreViewsRepository.EReference.Properties.eKeys, EcoreMessages.EReferencePropertiesEditionPart_EKeysLabel);		 
		this.eKeys = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addEKeys(); }
			public void handleEdit(EObject element) { editEKeys(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveEKeys(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromEKeys(element); }
			public void navigateTo(EObject element) { }
		});
		this.eKeys.setHelpText(propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.eKeys, EcoreViewsRepository.SWT_KIND));
		this.eKeys.createControls(parent);
		this.eKeys.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.eKeys, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData eKeysData = new GridData(GridData.FILL_HORIZONTAL);
		eKeysData.horizontalSpan = 3;
		this.eKeys.setLayoutData(eKeysData);
		this.eKeys.disableMove();
		eKeys.setID(EcoreViewsRepository.EReference.Properties.eKeys);
		eKeys.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addEKeys() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(eKeys.getInput(), eKeysFilters, eKeysBusinessFilters,
		"eKeys", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.eKeys,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				eKeys.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveEKeys(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.eKeys, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		eKeys.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromEKeys(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartImpl.this, EcoreViewsRepository.EReference.Properties.eKeys, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		eKeys.refresh();
	}

	/**
	 * 
	 */
	protected void editEKeys(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				eKeys.refresh();
			}
		}
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
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#getOrdered()
	 * 
	 */
	public Boolean getOrdered() {
		return Boolean.valueOf(ordered.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#setOrdered(Boolean newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#getUnique()
	 * 
	 */
	public Boolean getUnique() {
		return Boolean.valueOf(unique.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#setUnique(Boolean newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#getLowerBound()
	 * 
	 */
	public String getLowerBound() {
		return lowerBound.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#setLowerBound(String newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#getUpperBound()
	 * 
	 */
	public String getUpperBound() {
		return upperBound.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#setUpperBound(String newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#getEType()
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
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#initEType(EObjectFlatComboSettings)
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
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#setEType(EObject newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#setETypeButtonMode(ButtonsModeEnum newValue)
	 */
	public void setETypeButtonMode(ButtonsModeEnum newValue) {
		eType.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#addFilterEType(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEType(ViewerFilter filter) {
		eType.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#addBusinessFilterEType(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEType(ViewerFilter filter) {
		eType.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#getChangeable()
	 * 
	 */
	public Boolean getChangeable() {
		return Boolean.valueOf(changeable.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#setChangeable(Boolean newValue)
	 * 
	 */
	public void setChangeable(Boolean newValue) {
		if (newValue != null) {
			changeable.setSelection(newValue.booleanValue());
		} else {
			changeable.setSelection(false);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#getVolatile_()
	 * 
	 */
	public Boolean getVolatile_() {
		return Boolean.valueOf(volatile_.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#setVolatile_(Boolean newValue)
	 * 
	 */
	public void setVolatile_(Boolean newValue) {
		if (newValue != null) {
			volatile_.setSelection(newValue.booleanValue());
		} else {
			volatile_.setSelection(false);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#getTransient_()
	 * 
	 */
	public Boolean getTransient_() {
		return Boolean.valueOf(transient_.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#setTransient_(Boolean newValue)
	 * 
	 */
	public void setTransient_(Boolean newValue) {
		if (newValue != null) {
			transient_.setSelection(newValue.booleanValue());
		} else {
			transient_.setSelection(false);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#getDefaultValueLiteral()
	 * 
	 */
	public String getDefaultValueLiteral() {
		return defaultValueLiteral.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#setDefaultValueLiteral(String newValue)
	 * 
	 */
	public void setDefaultValueLiteral(String newValue) {
		if (newValue != null) {
			defaultValueLiteral.setText(newValue);
		} else {
			defaultValueLiteral.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#getUnsettable()
	 * 
	 */
	public Boolean getUnsettable() {
		return Boolean.valueOf(unsettable.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#setUnsettable(Boolean newValue)
	 * 
	 */
	public void setUnsettable(Boolean newValue) {
		if (newValue != null) {
			unsettable.setSelection(newValue.booleanValue());
		} else {
			unsettable.setSelection(false);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#getDerived()
	 * 
	 */
	public Boolean getDerived() {
		return Boolean.valueOf(derived.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#setDerived(Boolean newValue)
	 * 
	 */
	public void setDerived(Boolean newValue) {
		if (newValue != null) {
			derived.setSelection(newValue.booleanValue());
		} else {
			derived.setSelection(false);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#getEContainingClass()
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
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#initEContainingClass(EObjectFlatComboSettings)
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
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#setEContainingClass(EObject newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#setEContainingClassButtonMode(ButtonsModeEnum newValue)
	 */
	public void setEContainingClassButtonMode(ButtonsModeEnum newValue) {
		eContainingClass.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#addFilterEContainingClass(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEContainingClass(ViewerFilter filter) {
		eContainingClass.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#addBusinessFilterEContainingClass(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEContainingClass(ViewerFilter filter) {
		eContainingClass.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#getContainment()
	 * 
	 */
	public Boolean getContainment() {
		return Boolean.valueOf(containment.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#setContainment(Boolean newValue)
	 * 
	 */
	public void setContainment(Boolean newValue) {
		if (newValue != null) {
			containment.setSelection(newValue.booleanValue());
		} else {
			containment.setSelection(false);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#getResolveProxies()
	 * 
	 */
	public Boolean getResolveProxies() {
		return Boolean.valueOf(resolveProxies.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#setResolveProxies(Boolean newValue)
	 * 
	 */
	public void setResolveProxies(Boolean newValue) {
		if (newValue != null) {
			resolveProxies.setSelection(newValue.booleanValue());
		} else {
			resolveProxies.setSelection(false);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#getEOpposite()
	 * 
	 */
	public EObject getEOpposite() {
		if (eOpposite.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) eOpposite.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#initEOpposite(EObjectFlatComboSettings)
	 */
	public void initEOpposite(EObjectFlatComboSettings settings) {
		eOpposite.setInput(settings);
		if (current != null) {
			eOpposite.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#setEOpposite(EObject newValue)
	 * 
	 */
	public void setEOpposite(EObject newValue) {
		if (newValue != null) {
			eOpposite.setSelection(new StructuredSelection(newValue));
		} else {
			eOpposite.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#setEOppositeButtonMode(ButtonsModeEnum newValue)
	 */
	public void setEOppositeButtonMode(ButtonsModeEnum newValue) {
		eOpposite.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#addFilterEOpposite(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEOpposite(ViewerFilter filter) {
		eOpposite.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#addBusinessFilterEOpposite(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEOpposite(ViewerFilter filter) {
		eOpposite.addBusinessRuleFilter(filter);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#initEKeys(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initEKeys(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		eKeys.setContentProvider(contentProvider);
		eKeys.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#updateEKeys()
	 * 
	 */
	public void updateEKeys() {
	eKeys.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#addFilterEKeys(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEKeys(ViewerFilter filter) {
		eKeysFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#addBusinessFilterEKeys(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEKeys(ViewerFilter filter) {
		eKeysBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EReferencePropertiesEditionPart#isContainedInEKeysTable(EObject element)
	 * 
	 */
	public boolean isContainedInEKeysTable(EObject element) {
		return ((ReferencesTableSettings)eKeys.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EcoreMessages.EReference_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
