/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.parts.impl;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart;
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
public class EPackagePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EPackagePropertiesEditionPart {

	protected Text name;
	protected Text nsURI;
	protected Text nsPrefix;
	protected EObjectFlatComboViewer eFactoryInstance;
	protected EObjectFlatComboViewer eSuperPackage;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EPackagePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
					return createPropertiesGroup(parent);
				}
				if (key == EcoreViewsRepository.EPackage.Properties.name) {
					return createNameText(parent);
				}
				if (key == EcoreViewsRepository.EPackage.Properties.nsURI) {
					return createNsURIText(parent);
				}
				if (key == EcoreViewsRepository.EPackage.Properties.nsPrefix) {
					return createNsPrefixText(parent);
				}
				if (key == EcoreViewsRepository.EPackage.Properties.eFactoryInstance) {
					return createEFactoryInstanceFlatComboViewer(parent);
				}
				if (key == EcoreViewsRepository.EPackage.Properties.eSuperPackage) {
					return createESuperPackageFlatComboViewer(parent);
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
		propertiesGroup.setText(EcoreMessages.EPackagePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EPackage.Properties.name, EcoreMessages.EPackagePropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EPackagePropertiesEditionPartImpl.this, EcoreViewsRepository.EPackage.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EPackagePropertiesEditionPartImpl.this, EcoreViewsRepository.EPackage.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, EcoreViewsRepository.EPackage.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EPackage.Properties.name, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createNsURIText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EPackage.Properties.nsURI, EcoreMessages.EPackagePropertiesEditionPart_NsURILabel);
		nsURI = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData nsURIData = new GridData(GridData.FILL_HORIZONTAL);
		nsURI.setLayoutData(nsURIData);
		nsURI.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EPackagePropertiesEditionPartImpl.this, EcoreViewsRepository.EPackage.Properties.nsURI, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, nsURI.getText()));
			}

		});
		nsURI.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EPackagePropertiesEditionPartImpl.this, EcoreViewsRepository.EPackage.Properties.nsURI, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, nsURI.getText()));
				}
			}

		});
		EditingUtils.setID(nsURI, EcoreViewsRepository.EPackage.Properties.nsURI);
		EditingUtils.setEEFtype(nsURI, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EPackage.Properties.nsURI, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createNsPrefixText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EPackage.Properties.nsPrefix, EcoreMessages.EPackagePropertiesEditionPart_NsPrefixLabel);
		nsPrefix = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData nsPrefixData = new GridData(GridData.FILL_HORIZONTAL);
		nsPrefix.setLayoutData(nsPrefixData);
		nsPrefix.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EPackagePropertiesEditionPartImpl.this, EcoreViewsRepository.EPackage.Properties.nsPrefix, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, nsPrefix.getText()));
			}

		});
		nsPrefix.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EPackagePropertiesEditionPartImpl.this, EcoreViewsRepository.EPackage.Properties.nsPrefix, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, nsPrefix.getText()));
				}
			}

		});
		EditingUtils.setID(nsPrefix, EcoreViewsRepository.EPackage.Properties.nsPrefix);
		EditingUtils.setEEFtype(nsPrefix, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EPackage.Properties.nsPrefix, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createEFactoryInstanceFlatComboViewer(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EPackage.Properties.eFactoryInstance, EcoreMessages.EPackagePropertiesEditionPart_EFactoryInstanceLabel);
		eFactoryInstance = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EPackage.Properties.eFactoryInstance, EcoreViewsRepository.SWT_KIND));
		eFactoryInstance.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		eFactoryInstance.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EPackagePropertiesEditionPartImpl.this, EcoreViewsRepository.EPackage.Properties.eFactoryInstance, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getEFactoryInstance()));
			}

		});
		GridData eFactoryInstanceData = new GridData(GridData.FILL_HORIZONTAL);
		eFactoryInstance.setLayoutData(eFactoryInstanceData);
		eFactoryInstance.setID(EcoreViewsRepository.EPackage.Properties.eFactoryInstance);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EPackage.Properties.eFactoryInstance, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createESuperPackageFlatComboViewer(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EPackage.Properties.eSuperPackage, EcoreMessages.EPackagePropertiesEditionPart_ESuperPackageLabel);
		eSuperPackage = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EPackage.Properties.eSuperPackage, EcoreViewsRepository.SWT_KIND));
		eSuperPackage.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		eSuperPackage.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EPackagePropertiesEditionPartImpl.this, EcoreViewsRepository.EPackage.Properties.eSuperPackage, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getESuperPackage()));
			}

		});
		GridData eSuperPackageData = new GridData(GridData.FILL_HORIZONTAL);
		eSuperPackage.setLayoutData(eSuperPackageData);
		eSuperPackage.setID(EcoreViewsRepository.EPackage.Properties.eSuperPackage);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EPackage.Properties.eSuperPackage, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
