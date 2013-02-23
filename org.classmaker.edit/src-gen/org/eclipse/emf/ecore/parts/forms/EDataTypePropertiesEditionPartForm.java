/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.parts.forms;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.parts.EDataTypePropertiesEditionPart;
import org.eclipse.emf.ecore.parts.EcoreViewsRepository;

import org.eclipse.emf.ecore.providers.EcoreMessages;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

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
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

// End of user code

/**
 * 
 * 
 */
public class EDataTypePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, EDataTypePropertiesEditionPart {

	protected Text name;
	protected Text instanceClassName;
	protected Text instanceTypeName;
	protected EObjectFlatComboViewer ePackage;
	protected Button serializable;



	/**
	 * For {@link ISection} use only.
	 */
	public EDataTypePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EDataTypePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
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
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EDataType.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EDataType.Properties.instanceClassName) {
					return createInstanceClassNameText(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EDataType.Properties.instanceTypeName) {
					return createInstanceTypeNameText(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EDataType.Properties.ePackage) {
					return createEPackageFlatComboViewer(parent, widgetFactory);
				}
				if (key == EcoreViewsRepository.EDataType.Properties.serializable) {
					return createSerializableCheckbox(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EcoreMessages.EDataTypePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EcoreViewsRepository.EDataType.Properties.name, EcoreMessages.EDataTypePropertiesEditionPart_NameLabel);
		name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EDataTypePropertiesEditionPartForm.this,
							EcoreViewsRepository.EDataType.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EDataTypePropertiesEditionPartForm.this,
									EcoreViewsRepository.EDataType.Properties.name,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, name.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EDataTypePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		name.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EDataTypePropertiesEditionPartForm.this, EcoreViewsRepository.EDataType.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, EcoreViewsRepository.EDataType.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EDataType.Properties.name, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createInstanceClassNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EcoreViewsRepository.EDataType.Properties.instanceClassName, EcoreMessages.EDataTypePropertiesEditionPart_InstanceClassNameLabel);
		instanceClassName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		instanceClassName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData instanceClassNameData = new GridData(GridData.FILL_HORIZONTAL);
		instanceClassName.setLayoutData(instanceClassNameData);
		instanceClassName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EDataTypePropertiesEditionPartForm.this,
							EcoreViewsRepository.EDataType.Properties.instanceClassName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, instanceClassName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EDataTypePropertiesEditionPartForm.this,
									EcoreViewsRepository.EDataType.Properties.instanceClassName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, instanceClassName.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EDataTypePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		instanceClassName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EDataTypePropertiesEditionPartForm.this, EcoreViewsRepository.EDataType.Properties.instanceClassName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, instanceClassName.getText()));
				}
			}
		});
		EditingUtils.setID(instanceClassName, EcoreViewsRepository.EDataType.Properties.instanceClassName);
		EditingUtils.setEEFtype(instanceClassName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EDataType.Properties.instanceClassName, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createInstanceTypeNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EcoreViewsRepository.EDataType.Properties.instanceTypeName, EcoreMessages.EDataTypePropertiesEditionPart_InstanceTypeNameLabel);
		instanceTypeName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		instanceTypeName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData instanceTypeNameData = new GridData(GridData.FILL_HORIZONTAL);
		instanceTypeName.setLayoutData(instanceTypeNameData);
		instanceTypeName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EDataTypePropertiesEditionPartForm.this,
							EcoreViewsRepository.EDataType.Properties.instanceTypeName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, instanceTypeName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EDataTypePropertiesEditionPartForm.this,
									EcoreViewsRepository.EDataType.Properties.instanceTypeName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, instanceTypeName.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EDataTypePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		instanceTypeName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EDataTypePropertiesEditionPartForm.this, EcoreViewsRepository.EDataType.Properties.instanceTypeName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, instanceTypeName.getText()));
				}
			}
		});
		EditingUtils.setID(instanceTypeName, EcoreViewsRepository.EDataType.Properties.instanceTypeName);
		EditingUtils.setEEFtype(instanceTypeName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EDataType.Properties.instanceTypeName, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createEPackageFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EcoreViewsRepository.EDataType.Properties.ePackage, EcoreMessages.EDataTypePropertiesEditionPart_EPackageLabel);
		ePackage = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EDataType.Properties.ePackage, EcoreViewsRepository.FORM_KIND));
		widgetFactory.adapt(ePackage);
		ePackage.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData ePackageData = new GridData(GridData.FILL_HORIZONTAL);
		ePackage.setLayoutData(ePackageData);
		ePackage.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EDataTypePropertiesEditionPartForm.this, EcoreViewsRepository.EDataType.Properties.ePackage, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEPackage()));
			}

		});
		ePackage.setID(EcoreViewsRepository.EDataType.Properties.ePackage);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EDataType.Properties.ePackage, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createSerializableCheckbox(FormToolkit widgetFactory, Composite parent) {
		serializable = widgetFactory.createButton(parent, getDescription(EcoreViewsRepository.EDataType.Properties.serializable, EcoreMessages.EDataTypePropertiesEditionPart_SerializableLabel), SWT.CHECK);
		serializable.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EDataTypePropertiesEditionPartForm.this, EcoreViewsRepository.EDataType.Properties.serializable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(serializable.getSelection())));
			}

		});
		GridData serializableData = new GridData(GridData.FILL_HORIZONTAL);
		serializableData.horizontalSpan = 2;
		serializable.setLayoutData(serializableData);
		EditingUtils.setID(serializable, EcoreViewsRepository.EDataType.Properties.serializable);
		EditingUtils.setEEFtype(serializable, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EDataType.Properties.serializable, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
