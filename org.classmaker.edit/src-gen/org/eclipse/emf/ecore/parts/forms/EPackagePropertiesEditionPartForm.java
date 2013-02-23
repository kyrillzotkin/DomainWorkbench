/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.parts.forms;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart;
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

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

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
public class EPackagePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, EPackagePropertiesEditionPart {

	protected Text name;
	protected Text nsURI;
	protected Text nsPrefix;
	protected EObjectFlatComboViewer eFactoryInstance;
	protected EObjectFlatComboViewer eSuperPackage;



	/**
	 * For {@link ISection} use only.
	 */
	public EPackagePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EPackagePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence ePackageStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = ePackageStep.addStep(EcoreViewsRepository.EPackage.Properties.class);
		propertiesStep.addStep(EcoreViewsRepository.EPackage.Properties.name);
		propertiesStep.addStep(EcoreViewsRepository.EPackage.Properties.nsURI);
		propertiesStep.addStep(EcoreViewsRepository.EPackage.Properties.nsPrefix);
		propertiesStep.addStep(EcoreViewsRepository.EPackage.Properties.eFactoryInstance);
		propertiesStep.addStep(EcoreViewsRepository.EPackage.Properties.eSuperPackage);
		
		
		composer = new PartComposer(ePackageStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EcoreViewsRepository.EPackage.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EPackage.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EPackage.Properties.nsURI) {
					return createNsURIText(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EPackage.Properties.nsPrefix) {
					return createNsPrefixText(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EPackage.Properties.eFactoryInstance) {
					return createEFactoryInstanceFlatComboViewer(parent, widgetFactory);
				}
				if (key == EcoreViewsRepository.EPackage.Properties.eSuperPackage) {
					return createESuperPackageFlatComboViewer(parent, widgetFactory);
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
		propertiesSection.setText(EcoreMessages.EPackagePropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, EcoreViewsRepository.EPackage.Properties.name, EcoreMessages.EPackagePropertiesEditionPart_NameLabel);
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
							EPackagePropertiesEditionPartForm.this,
							EcoreViewsRepository.EPackage.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EPackagePropertiesEditionPartForm.this,
									EcoreViewsRepository.EPackage.Properties.name,
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
									EPackagePropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EPackagePropertiesEditionPartForm.this, EcoreViewsRepository.EPackage.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, EcoreViewsRepository.EPackage.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EPackage.Properties.name, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createNsURIText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EcoreViewsRepository.EPackage.Properties.nsURI, EcoreMessages.EPackagePropertiesEditionPart_NsURILabel);
		nsURI = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		nsURI.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nsURIData = new GridData(GridData.FILL_HORIZONTAL);
		nsURI.setLayoutData(nsURIData);
		nsURI.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EPackagePropertiesEditionPartForm.this,
							EcoreViewsRepository.EPackage.Properties.nsURI,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, nsURI.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EPackagePropertiesEditionPartForm.this,
									EcoreViewsRepository.EPackage.Properties.nsURI,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, nsURI.getText()));
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
									EPackagePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		nsURI.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EPackagePropertiesEditionPartForm.this, EcoreViewsRepository.EPackage.Properties.nsURI, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, nsURI.getText()));
				}
			}
		});
		EditingUtils.setID(nsURI, EcoreViewsRepository.EPackage.Properties.nsURI);
		EditingUtils.setEEFtype(nsURI, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EPackage.Properties.nsURI, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createNsPrefixText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EcoreViewsRepository.EPackage.Properties.nsPrefix, EcoreMessages.EPackagePropertiesEditionPart_NsPrefixLabel);
		nsPrefix = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		nsPrefix.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nsPrefixData = new GridData(GridData.FILL_HORIZONTAL);
		nsPrefix.setLayoutData(nsPrefixData);
		nsPrefix.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EPackagePropertiesEditionPartForm.this,
							EcoreViewsRepository.EPackage.Properties.nsPrefix,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, nsPrefix.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EPackagePropertiesEditionPartForm.this,
									EcoreViewsRepository.EPackage.Properties.nsPrefix,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, nsPrefix.getText()));
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
									EPackagePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		nsPrefix.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EPackagePropertiesEditionPartForm.this, EcoreViewsRepository.EPackage.Properties.nsPrefix, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, nsPrefix.getText()));
				}
			}
		});
		EditingUtils.setID(nsPrefix, EcoreViewsRepository.EPackage.Properties.nsPrefix);
		EditingUtils.setEEFtype(nsPrefix, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EPackage.Properties.nsPrefix, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createEFactoryInstanceFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EcoreViewsRepository.EPackage.Properties.eFactoryInstance, EcoreMessages.EPackagePropertiesEditionPart_EFactoryInstanceLabel);
		eFactoryInstance = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EPackage.Properties.eFactoryInstance, EcoreViewsRepository.FORM_KIND));
		widgetFactory.adapt(eFactoryInstance);
		eFactoryInstance.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData eFactoryInstanceData = new GridData(GridData.FILL_HORIZONTAL);
		eFactoryInstance.setLayoutData(eFactoryInstanceData);
		eFactoryInstance.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EPackagePropertiesEditionPartForm.this, EcoreViewsRepository.EPackage.Properties.eFactoryInstance, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEFactoryInstance()));
			}

		});
		eFactoryInstance.setID(EcoreViewsRepository.EPackage.Properties.eFactoryInstance);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EPackage.Properties.eFactoryInstance, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createESuperPackageFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EcoreViewsRepository.EPackage.Properties.eSuperPackage, EcoreMessages.EPackagePropertiesEditionPart_ESuperPackageLabel);
		eSuperPackage = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EPackage.Properties.eSuperPackage, EcoreViewsRepository.FORM_KIND));
		widgetFactory.adapt(eSuperPackage);
		eSuperPackage.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData eSuperPackageData = new GridData(GridData.FILL_HORIZONTAL);
		eSuperPackage.setLayoutData(eSuperPackageData);
		eSuperPackage.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EPackagePropertiesEditionPartForm.this, EcoreViewsRepository.EPackage.Properties.eSuperPackage, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getESuperPackage()));
			}

		});
		eSuperPackage.setID(EcoreViewsRepository.EPackage.Properties.eSuperPackage);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EPackage.Properties.eSuperPackage, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart#getNsURI()
	 * 
	 */
	public String getNsURI() {
		return nsURI.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart#setNsURI(String newValue)
	 * 
	 */
	public void setNsURI(String newValue) {
		if (newValue != null) {
			nsURI.setText(newValue);
		} else {
			nsURI.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart#getNsPrefix()
	 * 
	 */
	public String getNsPrefix() {
		return nsPrefix.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart#setNsPrefix(String newValue)
	 * 
	 */
	public void setNsPrefix(String newValue) {
		if (newValue != null) {
			nsPrefix.setText(newValue);
		} else {
			nsPrefix.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart#getEFactoryInstance()
	 * 
	 */
	public EObject getEFactoryInstance() {
		if (eFactoryInstance.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) eFactoryInstance.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart#initEFactoryInstance(EObjectFlatComboSettings)
	 */
	public void initEFactoryInstance(EObjectFlatComboSettings settings) {
		eFactoryInstance.setInput(settings);
		if (current != null) {
			eFactoryInstance.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart#setEFactoryInstance(EObject newValue)
	 * 
	 */
	public void setEFactoryInstance(EObject newValue) {
		if (newValue != null) {
			eFactoryInstance.setSelection(new StructuredSelection(newValue));
		} else {
			eFactoryInstance.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart#setEFactoryInstanceButtonMode(ButtonsModeEnum newValue)
	 */
	public void setEFactoryInstanceButtonMode(ButtonsModeEnum newValue) {
		eFactoryInstance.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart#addFilterEFactoryInstance(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEFactoryInstance(ViewerFilter filter) {
		eFactoryInstance.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart#addBusinessFilterEFactoryInstance(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEFactoryInstance(ViewerFilter filter) {
		eFactoryInstance.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart#getESuperPackage()
	 * 
	 */
	public EObject getESuperPackage() {
		if (eSuperPackage.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) eSuperPackage.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart#initESuperPackage(EObjectFlatComboSettings)
	 */
	public void initESuperPackage(EObjectFlatComboSettings settings) {
		eSuperPackage.setInput(settings);
		if (current != null) {
			eSuperPackage.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart#setESuperPackage(EObject newValue)
	 * 
	 */
	public void setESuperPackage(EObject newValue) {
		if (newValue != null) {
			eSuperPackage.setSelection(new StructuredSelection(newValue));
		} else {
			eSuperPackage.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart#setESuperPackageButtonMode(ButtonsModeEnum newValue)
	 */
	public void setESuperPackageButtonMode(ButtonsModeEnum newValue) {
		eSuperPackage.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart#addFilterESuperPackage(ViewerFilter filter)
	 * 
	 */
	public void addFilterToESuperPackage(ViewerFilter filter) {
		eSuperPackage.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart#addBusinessFilterESuperPackage(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToESuperPackage(ViewerFilter filter) {
		eSuperPackage.addBusinessRuleFilter(filter);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EcoreMessages.EPackage_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
