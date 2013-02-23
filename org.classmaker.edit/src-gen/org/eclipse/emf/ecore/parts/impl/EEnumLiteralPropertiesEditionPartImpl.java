/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.parts.impl;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.parts.EEnumLiteralPropertiesEditionPart;
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

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * 
 * 
 */
public class EEnumLiteralPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EEnumLiteralPropertiesEditionPart {

	protected Text name;
	protected Text value;
	protected Text instance;
	protected Text literal;
	protected EObjectFlatComboViewer eEnum;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EEnumLiteralPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence eEnumLiteralStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = eEnumLiteralStep.addStep(EcoreViewsRepository.EEnumLiteral.Properties.class);
		propertiesStep.addStep(EcoreViewsRepository.EEnumLiteral.Properties.name);
		propertiesStep.addStep(EcoreViewsRepository.EEnumLiteral.Properties.value);
		propertiesStep.addStep(EcoreViewsRepository.EEnumLiteral.Properties.instance);
		propertiesStep.addStep(EcoreViewsRepository.EEnumLiteral.Properties.literal);
		propertiesStep.addStep(EcoreViewsRepository.EEnumLiteral.Properties.eEnum);
		
		
		composer = new PartComposer(eEnumLiteralStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EcoreViewsRepository.EEnumLiteral.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EcoreViewsRepository.EEnumLiteral.Properties.name) {
					return createNameText(parent);
				}
				if (key == EcoreViewsRepository.EEnumLiteral.Properties.value) {
					return createValueText(parent);
				}
				if (key == EcoreViewsRepository.EEnumLiteral.Properties.instance) {
					return createInstanceText(parent);
				}
				if (key == EcoreViewsRepository.EEnumLiteral.Properties.literal) {
					return createLiteralText(parent);
				}
				if (key == EcoreViewsRepository.EEnumLiteral.Properties.eEnum) {
					return createEEnumFlatComboViewer(parent);
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
		propertiesGroup.setText(EcoreMessages.EEnumLiteralPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EEnumLiteral.Properties.name, EcoreMessages.EEnumLiteralPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEnumLiteralPropertiesEditionPartImpl.this, EcoreViewsRepository.EEnumLiteral.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEnumLiteralPropertiesEditionPartImpl.this, EcoreViewsRepository.EEnumLiteral.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, EcoreViewsRepository.EEnumLiteral.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EEnumLiteral.Properties.name, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createValueText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EEnumLiteral.Properties.value, EcoreMessages.EEnumLiteralPropertiesEditionPart_ValueLabel);
		value = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
		value.setLayoutData(valueData);
		value.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEnumLiteralPropertiesEditionPartImpl.this, EcoreViewsRepository.EEnumLiteral.Properties.value, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, value.getText()));
			}

		});
		value.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEnumLiteralPropertiesEditionPartImpl.this, EcoreViewsRepository.EEnumLiteral.Properties.value, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, value.getText()));
				}
			}

		});
		EditingUtils.setID(value, EcoreViewsRepository.EEnumLiteral.Properties.value);
		EditingUtils.setEEFtype(value, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EEnumLiteral.Properties.value, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createInstanceText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EEnumLiteral.Properties.instance, EcoreMessages.EEnumLiteralPropertiesEditionPart_InstanceLabel);
		instance = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData instanceData = new GridData(GridData.FILL_HORIZONTAL);
		instance.setLayoutData(instanceData);
		instance.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEnumLiteralPropertiesEditionPartImpl.this, EcoreViewsRepository.EEnumLiteral.Properties.instance, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, instance.getText()));
			}

		});
		instance.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEnumLiteralPropertiesEditionPartImpl.this, EcoreViewsRepository.EEnumLiteral.Properties.instance, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, instance.getText()));
				}
			}

		});
		EditingUtils.setID(instance, EcoreViewsRepository.EEnumLiteral.Properties.instance);
		EditingUtils.setEEFtype(instance, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EEnumLiteral.Properties.instance, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createLiteralText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EEnumLiteral.Properties.literal, EcoreMessages.EEnumLiteralPropertiesEditionPart_LiteralLabel);
		literal = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData literalData = new GridData(GridData.FILL_HORIZONTAL);
		literal.setLayoutData(literalData);
		literal.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEnumLiteralPropertiesEditionPartImpl.this, EcoreViewsRepository.EEnumLiteral.Properties.literal, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, literal.getText()));
			}

		});
		literal.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEnumLiteralPropertiesEditionPartImpl.this, EcoreViewsRepository.EEnumLiteral.Properties.literal, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, literal.getText()));
				}
			}

		});
		EditingUtils.setID(literal, EcoreViewsRepository.EEnumLiteral.Properties.literal);
		EditingUtils.setEEFtype(literal, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EEnumLiteral.Properties.literal, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createEEnumFlatComboViewer(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EEnumLiteral.Properties.eEnum, EcoreMessages.EEnumLiteralPropertiesEditionPart_EEnumLabel);
		eEnum = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EEnumLiteral.Properties.eEnum, EcoreViewsRepository.SWT_KIND));
		eEnum.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		eEnum.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEnumLiteralPropertiesEditionPartImpl.this, EcoreViewsRepository.EEnumLiteral.Properties.eEnum, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getEEnum()));
			}

		});
		GridData eEnumData = new GridData(GridData.FILL_HORIZONTAL);
		eEnum.setLayoutData(eEnumData);
		eEnum.setID(EcoreViewsRepository.EEnumLiteral.Properties.eEnum);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EEnumLiteral.Properties.eEnum, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.eclipse.emf.ecore.parts.EEnumLiteralPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EEnumLiteralPropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EEnumLiteralPropertiesEditionPart#getValue()
	 * 
	 */
	public String getValue() {
		return value.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EEnumLiteralPropertiesEditionPart#setValue(String newValue)
	 * 
	 */
	public void setValue(String newValue) {
		if (newValue != null) {
			value.setText(newValue);
		} else {
			value.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EEnumLiteralPropertiesEditionPart#getInstance()
	 * 
	 */
	public String getInstance() {
		return instance.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EEnumLiteralPropertiesEditionPart#setInstance(String newValue)
	 * 
	 */
	public void setInstance(String newValue) {
		if (newValue != null) {
			instance.setText(newValue);
		} else {
			instance.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EEnumLiteralPropertiesEditionPart#getLiteral()
	 * 
	 */
	public String getLiteral() {
		return literal.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EEnumLiteralPropertiesEditionPart#setLiteral(String newValue)
	 * 
	 */
	public void setLiteral(String newValue) {
		if (newValue != null) {
			literal.setText(newValue);
		} else {
			literal.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EEnumLiteralPropertiesEditionPart#getEEnum()
	 * 
	 */
	public EObject getEEnum() {
		if (eEnum.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) eEnum.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EEnumLiteralPropertiesEditionPart#initEEnum(EObjectFlatComboSettings)
	 */
	public void initEEnum(EObjectFlatComboSettings settings) {
		eEnum.setInput(settings);
		if (current != null) {
			eEnum.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EEnumLiteralPropertiesEditionPart#setEEnum(EObject newValue)
	 * 
	 */
	public void setEEnum(EObject newValue) {
		if (newValue != null) {
			eEnum.setSelection(new StructuredSelection(newValue));
		} else {
			eEnum.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EEnumLiteralPropertiesEditionPart#setEEnumButtonMode(ButtonsModeEnum newValue)
	 */
	public void setEEnumButtonMode(ButtonsModeEnum newValue) {
		eEnum.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EEnumLiteralPropertiesEditionPart#addFilterEEnum(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEEnum(ViewerFilter filter) {
		eEnum.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EEnumLiteralPropertiesEditionPart#addBusinessFilterEEnum(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEEnum(ViewerFilter filter) {
		eEnum.addBusinessRuleFilter(filter);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EcoreMessages.EEnumLiteral_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
