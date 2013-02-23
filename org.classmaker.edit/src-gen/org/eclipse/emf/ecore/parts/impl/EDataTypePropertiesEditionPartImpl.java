/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.parts.impl;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.parts.EDataTypePropertiesEditionPart;
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
public class EDataTypePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EDataTypePropertiesEditionPart {

	protected Text name;
	protected Text instanceClassName;
	protected Text instanceTypeName;
	protected EObjectFlatComboViewer ePackage;
	protected Button serializable;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EDataTypePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence eDataTypeStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = eDataTypeStep.addStep(EcoreViewsRepository.EDataType.Properties.class);
		propertiesStep.addStep(EcoreViewsRepository.EDataType.Properties.name);
		propertiesStep.addStep(EcoreViewsRepository.EDataType.Properties.instanceClassName);
		propertiesStep.addStep(EcoreViewsRepository.EDataType.Properties.instanceTypeName);
		propertiesStep.addStep(EcoreViewsRepository.EDataType.Properties.ePackage);
		propertiesStep.addStep(EcoreViewsRepository.EDataType.Properties.serializable);
		
		
		composer = new PartComposer(eDataTypeStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EcoreViewsRepository.EDataType.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EcoreViewsRepository.EDataType.Properties.name) {
					return createNameText(parent);
				}
				if (key == EcoreViewsRepository.EDataType.Properties.instanceClassName) {
					return createInstanceClassNameText(parent);
				}
				if (key == EcoreViewsRepository.EDataType.Properties.instanceTypeName) {
					return createInstanceTypeNameText(parent);
				}
				if (key == EcoreViewsRepository.EDataType.Properties.ePackage) {
					return createEPackageFlatComboViewer(parent);
				}
				if (key == EcoreViewsRepository.EDataType.Properties.serializable) {
					return createSerializableCheckbox(parent);
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
		propertiesGroup.setText(EcoreMessages.EDataTypePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EDataType.Properties.name, EcoreMessages.EDataTypePropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EDataTypePropertiesEditionPartImpl.this, EcoreViewsRepository.EDataType.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EDataTypePropertiesEditionPartImpl.this, EcoreViewsRepository.EDataType.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, EcoreViewsRepository.EDataType.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EDataType.Properties.name, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createInstanceClassNameText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EDataType.Properties.instanceClassName, EcoreMessages.EDataTypePropertiesEditionPart_InstanceClassNameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EDataTypePropertiesEditionPartImpl.this, EcoreViewsRepository.EDataType.Properties.instanceClassName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, instanceClassName.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EDataTypePropertiesEditionPartImpl.this, EcoreViewsRepository.EDataType.Properties.instanceClassName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, instanceClassName.getText()));
				}
			}

		});
		EditingUtils.setID(instanceClassName, EcoreViewsRepository.EDataType.Properties.instanceClassName);
		EditingUtils.setEEFtype(instanceClassName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EDataType.Properties.instanceClassName, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createInstanceTypeNameText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EDataType.Properties.instanceTypeName, EcoreMessages.EDataTypePropertiesEditionPart_InstanceTypeNameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EDataTypePropertiesEditionPartImpl.this, EcoreViewsRepository.EDataType.Properties.instanceTypeName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, instanceTypeName.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EDataTypePropertiesEditionPartImpl.this, EcoreViewsRepository.EDataType.Properties.instanceTypeName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, instanceTypeName.getText()));
				}
			}

		});
		EditingUtils.setID(instanceTypeName, EcoreViewsRepository.EDataType.Properties.instanceTypeName);
		EditingUtils.setEEFtype(instanceTypeName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EDataType.Properties.instanceTypeName, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createEPackageFlatComboViewer(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EDataType.Properties.ePackage, EcoreMessages.EDataTypePropertiesEditionPart_EPackageLabel);
		ePackage = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EDataType.Properties.ePackage, EcoreViewsRepository.SWT_KIND));
		ePackage.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		ePackage.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EDataTypePropertiesEditionPartImpl.this, EcoreViewsRepository.EDataType.Properties.ePackage, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getEPackage()));
			}

		});
		GridData ePackageData = new GridData(GridData.FILL_HORIZONTAL);
		ePackage.setLayoutData(ePackageData);
		ePackage.setID(EcoreViewsRepository.EDataType.Properties.ePackage);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EDataType.Properties.ePackage, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createSerializableCheckbox(Composite parent) {
		serializable = new Button(parent, SWT.CHECK);
		serializable.setText(getDescription(EcoreViewsRepository.EDataType.Properties.serializable, EcoreMessages.EDataTypePropertiesEditionPart_SerializableLabel));
		serializable.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EDataTypePropertiesEditionPartImpl.this, EcoreViewsRepository.EDataType.Properties.serializable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(serializable.getSelection())));
			}

		});
		GridData serializableData = new GridData(GridData.FILL_HORIZONTAL);
		serializableData.horizontalSpan = 2;
		serializable.setLayoutData(serializableData);
		EditingUtils.setID(serializable, EcoreViewsRepository.EDataType.Properties.serializable);
		EditingUtils.setEEFtype(serializable, "eef::Checkbox"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EDataType.Properties.serializable, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.eclipse.emf.ecore.parts.EDataTypePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EDataTypePropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EDataTypePropertiesEditionPart#getInstanceClassName()
	 * 
	 */
	public String getInstanceClassName() {
		return instanceClassName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EDataTypePropertiesEditionPart#setInstanceClassName(String newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EDataTypePropertiesEditionPart#getInstanceTypeName()
	 * 
	 */
	public String getInstanceTypeName() {
		return instanceTypeName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EDataTypePropertiesEditionPart#setInstanceTypeName(String newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EDataTypePropertiesEditionPart#getEPackage()
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
	 * @see org.eclipse.emf.ecore.parts.EDataTypePropertiesEditionPart#initEPackage(EObjectFlatComboSettings)
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
	 * @see org.eclipse.emf.ecore.parts.EDataTypePropertiesEditionPart#setEPackage(EObject newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EDataTypePropertiesEditionPart#setEPackageButtonMode(ButtonsModeEnum newValue)
	 */
	public void setEPackageButtonMode(ButtonsModeEnum newValue) {
		ePackage.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EDataTypePropertiesEditionPart#addFilterEPackage(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEPackage(ViewerFilter filter) {
		ePackage.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EDataTypePropertiesEditionPart#addBusinessFilterEPackage(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEPackage(ViewerFilter filter) {
		ePackage.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EDataTypePropertiesEditionPart#getSerializable()
	 * 
	 */
	public Boolean getSerializable() {
		return Boolean.valueOf(serializable.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EDataTypePropertiesEditionPart#setSerializable(Boolean newValue)
	 * 
	 */
	public void setSerializable(Boolean newValue) {
		if (newValue != null) {
			serializable.setSelection(newValue.booleanValue());
		} else {
			serializable.setSelection(false);
		}
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EcoreMessages.EDataType_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
