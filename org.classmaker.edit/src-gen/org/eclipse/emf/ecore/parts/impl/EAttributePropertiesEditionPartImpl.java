/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.parts.impl;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart;
import org.eclipse.emf.ecore.parts.EcoreViewsRepository;

import org.eclipse.emf.ecore.providers.EcoreMessages;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ISelectionChangedListener;
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
public class EAttributePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EAttributePropertiesEditionPart {

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
	protected Button iD;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EAttributePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence eAttributeStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = eAttributeStep.addStep(EcoreViewsRepository.EAttribute.Properties.class);
		propertiesStep.addStep(EcoreViewsRepository.EAttribute.Properties.name);
		propertiesStep.addStep(EcoreViewsRepository.EAttribute.Properties.ordered);
		propertiesStep.addStep(EcoreViewsRepository.EAttribute.Properties.unique);
		propertiesStep.addStep(EcoreViewsRepository.EAttribute.Properties.lowerBound);
		propertiesStep.addStep(EcoreViewsRepository.EAttribute.Properties.upperBound);
		propertiesStep.addStep(EcoreViewsRepository.EAttribute.Properties.eType);
		propertiesStep.addStep(EcoreViewsRepository.EAttribute.Properties.changeable);
		propertiesStep.addStep(EcoreViewsRepository.EAttribute.Properties.volatile_);
		propertiesStep.addStep(EcoreViewsRepository.EAttribute.Properties.transient_);
		propertiesStep.addStep(EcoreViewsRepository.EAttribute.Properties.defaultValueLiteral);
		propertiesStep.addStep(EcoreViewsRepository.EAttribute.Properties.unsettable);
		propertiesStep.addStep(EcoreViewsRepository.EAttribute.Properties.derived);
		propertiesStep.addStep(EcoreViewsRepository.EAttribute.Properties.eContainingClass);
		propertiesStep.addStep(EcoreViewsRepository.EAttribute.Properties.iD);
		
		
		composer = new PartComposer(eAttributeStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EcoreViewsRepository.EAttribute.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EcoreViewsRepository.EAttribute.Properties.name) {
					return createNameText(parent);
				}
				if (key == EcoreViewsRepository.EAttribute.Properties.ordered) {
					return createOrderedCheckbox(parent);
				}
				if (key == EcoreViewsRepository.EAttribute.Properties.unique) {
					return createUniqueCheckbox(parent);
				}
				if (key == EcoreViewsRepository.EAttribute.Properties.lowerBound) {
					return createLowerBoundText(parent);
				}
				if (key == EcoreViewsRepository.EAttribute.Properties.upperBound) {
					return createUpperBoundText(parent);
				}
				if (key == EcoreViewsRepository.EAttribute.Properties.eType) {
					return createETypeFlatComboViewer(parent);
				}
				if (key == EcoreViewsRepository.EAttribute.Properties.changeable) {
					return createChangeableCheckbox(parent);
				}
				if (key == EcoreViewsRepository.EAttribute.Properties.volatile_) {
					return createVolatile_Checkbox(parent);
				}
				if (key == EcoreViewsRepository.EAttribute.Properties.transient_) {
					return createTransient_Checkbox(parent);
				}
				if (key == EcoreViewsRepository.EAttribute.Properties.defaultValueLiteral) {
					return createDefaultValueLiteralText(parent);
				}
				if (key == EcoreViewsRepository.EAttribute.Properties.unsettable) {
					return createUnsettableCheckbox(parent);
				}
				if (key == EcoreViewsRepository.EAttribute.Properties.derived) {
					return createDerivedCheckbox(parent);
				}
				if (key == EcoreViewsRepository.EAttribute.Properties.eContainingClass) {
					return createEContainingClassFlatComboViewer(parent);
				}
				if (key == EcoreViewsRepository.EAttribute.Properties.iD) {
					return createIDCheckbox(parent);
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
		propertiesGroup.setText(EcoreMessages.EAttributePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EAttribute.Properties.name, EcoreMessages.EAttributePropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EAttributePropertiesEditionPartImpl.this, EcoreViewsRepository.EAttribute.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EAttributePropertiesEditionPartImpl.this, EcoreViewsRepository.EAttribute.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, EcoreViewsRepository.EAttribute.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EAttribute.Properties.name, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createOrderedCheckbox(Composite parent) {
		ordered = new Button(parent, SWT.CHECK);
		ordered.setText(getDescription(EcoreViewsRepository.EAttribute.Properties.ordered, EcoreMessages.EAttributePropertiesEditionPart_OrderedLabel));
		ordered.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EAttributePropertiesEditionPartImpl.this, EcoreViewsRepository.EAttribute.Properties.ordered, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(ordered.getSelection())));
			}

		});
		GridData orderedData = new GridData(GridData.FILL_HORIZONTAL);
		orderedData.horizontalSpan = 2;
		ordered.setLayoutData(orderedData);
		EditingUtils.setID(ordered, EcoreViewsRepository.EAttribute.Properties.ordered);
		EditingUtils.setEEFtype(ordered, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EAttribute.Properties.ordered, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createUniqueCheckbox(Composite parent) {
		unique = new Button(parent, SWT.CHECK);
		unique.setText(getDescription(EcoreViewsRepository.EAttribute.Properties.unique, EcoreMessages.EAttributePropertiesEditionPart_UniqueLabel));
		unique.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EAttributePropertiesEditionPartImpl.this, EcoreViewsRepository.EAttribute.Properties.unique, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(unique.getSelection())));
			}

		});
		GridData uniqueData = new GridData(GridData.FILL_HORIZONTAL);
		uniqueData.horizontalSpan = 2;
		unique.setLayoutData(uniqueData);
		EditingUtils.setID(unique, EcoreViewsRepository.EAttribute.Properties.unique);
		EditingUtils.setEEFtype(unique, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EAttribute.Properties.unique, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createLowerBoundText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EAttribute.Properties.lowerBound, EcoreMessages.EAttributePropertiesEditionPart_LowerBoundLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EAttributePropertiesEditionPartImpl.this, EcoreViewsRepository.EAttribute.Properties.lowerBound, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, lowerBound.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EAttributePropertiesEditionPartImpl.this, EcoreViewsRepository.EAttribute.Properties.lowerBound, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, lowerBound.getText()));
				}
			}

		});
		EditingUtils.setID(lowerBound, EcoreViewsRepository.EAttribute.Properties.lowerBound);
		EditingUtils.setEEFtype(lowerBound, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EAttribute.Properties.lowerBound, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createUpperBoundText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EAttribute.Properties.upperBound, EcoreMessages.EAttributePropertiesEditionPart_UpperBoundLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EAttributePropertiesEditionPartImpl.this, EcoreViewsRepository.EAttribute.Properties.upperBound, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, upperBound.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EAttributePropertiesEditionPartImpl.this, EcoreViewsRepository.EAttribute.Properties.upperBound, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, upperBound.getText()));
				}
			}

		});
		EditingUtils.setID(upperBound, EcoreViewsRepository.EAttribute.Properties.upperBound);
		EditingUtils.setEEFtype(upperBound, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EAttribute.Properties.upperBound, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createETypeFlatComboViewer(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EAttribute.Properties.eType, EcoreMessages.EAttributePropertiesEditionPart_ETypeLabel);
		eType = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EAttribute.Properties.eType, EcoreViewsRepository.SWT_KIND));
		eType.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		eType.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EAttributePropertiesEditionPartImpl.this, EcoreViewsRepository.EAttribute.Properties.eType, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getEType()));
			}

		});
		GridData eTypeData = new GridData(GridData.FILL_HORIZONTAL);
		eType.setLayoutData(eTypeData);
		eType.setID(EcoreViewsRepository.EAttribute.Properties.eType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EAttribute.Properties.eType, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createChangeableCheckbox(Composite parent) {
		changeable = new Button(parent, SWT.CHECK);
		changeable.setText(getDescription(EcoreViewsRepository.EAttribute.Properties.changeable, EcoreMessages.EAttributePropertiesEditionPart_ChangeableLabel));
		changeable.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EAttributePropertiesEditionPartImpl.this, EcoreViewsRepository.EAttribute.Properties.changeable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(changeable.getSelection())));
			}

		});
		GridData changeableData = new GridData(GridData.FILL_HORIZONTAL);
		changeableData.horizontalSpan = 2;
		changeable.setLayoutData(changeableData);
		EditingUtils.setID(changeable, EcoreViewsRepository.EAttribute.Properties.changeable);
		EditingUtils.setEEFtype(changeable, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EAttribute.Properties.changeable, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createVolatile_Checkbox(Composite parent) {
		volatile_ = new Button(parent, SWT.CHECK);
		volatile_.setText(getDescription(EcoreViewsRepository.EAttribute.Properties.volatile_, EcoreMessages.EAttributePropertiesEditionPart_Volatile_Label));
		volatile_.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EAttributePropertiesEditionPartImpl.this, EcoreViewsRepository.EAttribute.Properties.volatile_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(volatile_.getSelection())));
			}

		});
		GridData volatile_Data = new GridData(GridData.FILL_HORIZONTAL);
		volatile_Data.horizontalSpan = 2;
		volatile_.setLayoutData(volatile_Data);
		EditingUtils.setID(volatile_, EcoreViewsRepository.EAttribute.Properties.volatile_);
		EditingUtils.setEEFtype(volatile_, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EAttribute.Properties.volatile_, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createTransient_Checkbox(Composite parent) {
		transient_ = new Button(parent, SWT.CHECK);
		transient_.setText(getDescription(EcoreViewsRepository.EAttribute.Properties.transient_, EcoreMessages.EAttributePropertiesEditionPart_Transient_Label));
		transient_.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EAttributePropertiesEditionPartImpl.this, EcoreViewsRepository.EAttribute.Properties.transient_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(transient_.getSelection())));
			}

		});
		GridData transient_Data = new GridData(GridData.FILL_HORIZONTAL);
		transient_Data.horizontalSpan = 2;
		transient_.setLayoutData(transient_Data);
		EditingUtils.setID(transient_, EcoreViewsRepository.EAttribute.Properties.transient_);
		EditingUtils.setEEFtype(transient_, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EAttribute.Properties.transient_, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createDefaultValueLiteralText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EAttribute.Properties.defaultValueLiteral, EcoreMessages.EAttributePropertiesEditionPart_DefaultValueLiteralLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EAttributePropertiesEditionPartImpl.this, EcoreViewsRepository.EAttribute.Properties.defaultValueLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, defaultValueLiteral.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EAttributePropertiesEditionPartImpl.this, EcoreViewsRepository.EAttribute.Properties.defaultValueLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, defaultValueLiteral.getText()));
				}
			}

		});
		EditingUtils.setID(defaultValueLiteral, EcoreViewsRepository.EAttribute.Properties.defaultValueLiteral);
		EditingUtils.setEEFtype(defaultValueLiteral, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EAttribute.Properties.defaultValueLiteral, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createUnsettableCheckbox(Composite parent) {
		unsettable = new Button(parent, SWT.CHECK);
		unsettable.setText(getDescription(EcoreViewsRepository.EAttribute.Properties.unsettable, EcoreMessages.EAttributePropertiesEditionPart_UnsettableLabel));
		unsettable.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EAttributePropertiesEditionPartImpl.this, EcoreViewsRepository.EAttribute.Properties.unsettable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(unsettable.getSelection())));
			}

		});
		GridData unsettableData = new GridData(GridData.FILL_HORIZONTAL);
		unsettableData.horizontalSpan = 2;
		unsettable.setLayoutData(unsettableData);
		EditingUtils.setID(unsettable, EcoreViewsRepository.EAttribute.Properties.unsettable);
		EditingUtils.setEEFtype(unsettable, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EAttribute.Properties.unsettable, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createDerivedCheckbox(Composite parent) {
		derived = new Button(parent, SWT.CHECK);
		derived.setText(getDescription(EcoreViewsRepository.EAttribute.Properties.derived, EcoreMessages.EAttributePropertiesEditionPart_DerivedLabel));
		derived.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EAttributePropertiesEditionPartImpl.this, EcoreViewsRepository.EAttribute.Properties.derived, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(derived.getSelection())));
			}

		});
		GridData derivedData = new GridData(GridData.FILL_HORIZONTAL);
		derivedData.horizontalSpan = 2;
		derived.setLayoutData(derivedData);
		EditingUtils.setID(derived, EcoreViewsRepository.EAttribute.Properties.derived);
		EditingUtils.setEEFtype(derived, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EAttribute.Properties.derived, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createEContainingClassFlatComboViewer(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EAttribute.Properties.eContainingClass, EcoreMessages.EAttributePropertiesEditionPart_EContainingClassLabel);
		eContainingClass = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EAttribute.Properties.eContainingClass, EcoreViewsRepository.SWT_KIND));
		eContainingClass.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		eContainingClass.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EAttributePropertiesEditionPartImpl.this, EcoreViewsRepository.EAttribute.Properties.eContainingClass, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getEContainingClass()));
			}

		});
		GridData eContainingClassData = new GridData(GridData.FILL_HORIZONTAL);
		eContainingClass.setLayoutData(eContainingClassData);
		eContainingClass.setID(EcoreViewsRepository.EAttribute.Properties.eContainingClass);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EAttribute.Properties.eContainingClass, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createIDCheckbox(Composite parent) {
		iD = new Button(parent, SWT.CHECK);
		iD.setText(getDescription(EcoreViewsRepository.EAttribute.Properties.iD, EcoreMessages.EAttributePropertiesEditionPart_IDLabel));
		iD.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EAttributePropertiesEditionPartImpl.this, EcoreViewsRepository.EAttribute.Properties.iD, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(iD.getSelection())));
			}

		});
		GridData iDData = new GridData(GridData.FILL_HORIZONTAL);
		iDData.horizontalSpan = 2;
		iD.setLayoutData(iDData);
		EditingUtils.setID(iD, EcoreViewsRepository.EAttribute.Properties.iD);
		EditingUtils.setEEFtype(iD, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EAttribute.Properties.iD, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#getOrdered()
	 * 
	 */
	public Boolean getOrdered() {
		return Boolean.valueOf(ordered.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#setOrdered(Boolean newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#getUnique()
	 * 
	 */
	public Boolean getUnique() {
		return Boolean.valueOf(unique.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#setUnique(Boolean newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#getLowerBound()
	 * 
	 */
	public String getLowerBound() {
		return lowerBound.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#setLowerBound(String newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#getUpperBound()
	 * 
	 */
	public String getUpperBound() {
		return upperBound.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#setUpperBound(String newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#getEType()
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
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#initEType(EObjectFlatComboSettings)
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
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#setEType(EObject newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#setETypeButtonMode(ButtonsModeEnum newValue)
	 */
	public void setETypeButtonMode(ButtonsModeEnum newValue) {
		eType.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#addFilterEType(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEType(ViewerFilter filter) {
		eType.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#addBusinessFilterEType(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEType(ViewerFilter filter) {
		eType.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#getChangeable()
	 * 
	 */
	public Boolean getChangeable() {
		return Boolean.valueOf(changeable.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#setChangeable(Boolean newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#getVolatile_()
	 * 
	 */
	public Boolean getVolatile_() {
		return Boolean.valueOf(volatile_.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#setVolatile_(Boolean newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#getTransient_()
	 * 
	 */
	public Boolean getTransient_() {
		return Boolean.valueOf(transient_.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#setTransient_(Boolean newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#getDefaultValueLiteral()
	 * 
	 */
	public String getDefaultValueLiteral() {
		return defaultValueLiteral.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#setDefaultValueLiteral(String newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#getUnsettable()
	 * 
	 */
	public Boolean getUnsettable() {
		return Boolean.valueOf(unsettable.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#setUnsettable(Boolean newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#getDerived()
	 * 
	 */
	public Boolean getDerived() {
		return Boolean.valueOf(derived.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#setDerived(Boolean newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#getEContainingClass()
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
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#initEContainingClass(EObjectFlatComboSettings)
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
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#setEContainingClass(EObject newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#setEContainingClassButtonMode(ButtonsModeEnum newValue)
	 */
	public void setEContainingClassButtonMode(ButtonsModeEnum newValue) {
		eContainingClass.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#addFilterEContainingClass(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEContainingClass(ViewerFilter filter) {
		eContainingClass.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#addBusinessFilterEContainingClass(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEContainingClass(ViewerFilter filter) {
		eContainingClass.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#getID()
	 * 
	 */
	public Boolean getID() {
		return Boolean.valueOf(iD.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EAttributePropertiesEditionPart#setID(Boolean newValue)
	 * 
	 */
	public void setID(Boolean newValue) {
		if (newValue != null) {
			iD.setSelection(newValue.booleanValue());
		} else {
			iD.setSelection(false);
		}
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EcoreMessages.EAttribute_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
