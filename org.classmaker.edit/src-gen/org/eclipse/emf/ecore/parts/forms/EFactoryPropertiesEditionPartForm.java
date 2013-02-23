/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.parts.forms;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.parts.EFactoryPropertiesEditionPart;
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

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

// End of user code

/**
 * 
 * 
 */
public class EFactoryPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, EFactoryPropertiesEditionPart {

	protected EObjectFlatComboViewer ePackage;



	/**
	 * For {@link ISection} use only.
	 */
	public EFactoryPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EFactoryPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence eFactoryStep = new BindingCompositionSequence(propertiesEditionComponent);
		eFactoryStep
			.addStep(EcoreViewsRepository.EFactory.Properties.class)
			.addStep(EcoreViewsRepository.EFactory.Properties.ePackage);
		
		
		composer = new PartComposer(eFactoryStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EcoreViewsRepository.EFactory.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EFactory.Properties.ePackage) {
					return createEPackageFlatComboViewer(parent, widgetFactory);
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
		propertiesSection.setText(EcoreMessages.EFactoryPropertiesEditionPart_PropertiesGroupLabel);
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

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createEPackageFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EcoreViewsRepository.EFactory.Properties.ePackage, EcoreMessages.EFactoryPropertiesEditionPart_EPackageLabel);
		ePackage = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EFactory.Properties.ePackage, EcoreViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EFactoryPropertiesEditionPartForm.this, EcoreViewsRepository.EFactory.Properties.ePackage, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEPackage()));
			}

		});
		ePackage.setID(EcoreViewsRepository.EFactory.Properties.ePackage);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EFactory.Properties.ePackage, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.eclipse.emf.ecore.parts.EFactoryPropertiesEditionPart#getEPackage()
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
	 * @see org.eclipse.emf.ecore.parts.EFactoryPropertiesEditionPart#initEPackage(EObjectFlatComboSettings)
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
	 * @see org.eclipse.emf.ecore.parts.EFactoryPropertiesEditionPart#setEPackage(EObject newValue)
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
	 * @see org.eclipse.emf.ecore.parts.EFactoryPropertiesEditionPart#setEPackageButtonMode(ButtonsModeEnum newValue)
	 */
	public void setEPackageButtonMode(ButtonsModeEnum newValue) {
		ePackage.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EFactoryPropertiesEditionPart#addFilterEPackage(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEPackage(ViewerFilter filter) {
		ePackage.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EFactoryPropertiesEditionPart#addBusinessFilterEPackage(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEPackage(ViewerFilter filter) {
		ePackage.addBusinessRuleFilter(filter);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EcoreMessages.EFactory_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
