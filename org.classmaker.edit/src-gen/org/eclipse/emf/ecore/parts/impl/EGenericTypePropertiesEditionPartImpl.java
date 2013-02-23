/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.parts.EGenericTypePropertiesEditionPart;
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

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

// End of user code

/**
 * 
 * 
 */
public class EGenericTypePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EGenericTypePropertiesEditionPart {

	protected ReferencesTable eTypeArguments;
	protected List<ViewerFilter> eTypeArgumentsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> eTypeArgumentsFilters = new ArrayList<ViewerFilter>();
	protected EObjectFlatComboViewer eTypeParameter;
	protected EObjectFlatComboViewer eClassifier;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EGenericTypePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence eGenericTypeStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = eGenericTypeStep.addStep(EcoreViewsRepository.EGenericType.Properties.class);
		propertiesStep.addStep(EcoreViewsRepository.EGenericType.Properties.eTypeArguments);
		propertiesStep.addStep(EcoreViewsRepository.EGenericType.Properties.eTypeParameter);
		propertiesStep.addStep(EcoreViewsRepository.EGenericType.Properties.eClassifier);
		
		
		composer = new PartComposer(eGenericTypeStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EcoreViewsRepository.EGenericType.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EcoreViewsRepository.EGenericType.Properties.eTypeArguments) {
					return createETypeArgumentsAdvancedTableComposition(parent);
				}
				if (key == EcoreViewsRepository.EGenericType.Properties.eTypeParameter) {
					return createETypeParameterFlatComboViewer(parent);
				}
				if (key == EcoreViewsRepository.EGenericType.Properties.eClassifier) {
					return createEClassifierFlatComboViewer(parent);
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
		propertiesGroup.setText(EcoreMessages.EGenericTypePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createETypeArgumentsAdvancedTableComposition(Composite parent) {
		this.eTypeArguments = new ReferencesTable(getDescription(EcoreViewsRepository.EGenericType.Properties.eTypeArguments, EcoreMessages.EGenericTypePropertiesEditionPart_ETypeArgumentsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EGenericTypePropertiesEditionPartImpl.this, EcoreViewsRepository.EGenericType.Properties.eTypeArguments, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				eTypeArguments.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EGenericTypePropertiesEditionPartImpl.this, EcoreViewsRepository.EGenericType.Properties.eTypeArguments, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				eTypeArguments.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EGenericTypePropertiesEditionPartImpl.this, EcoreViewsRepository.EGenericType.Properties.eTypeArguments, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				eTypeArguments.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EGenericTypePropertiesEditionPartImpl.this, EcoreViewsRepository.EGenericType.Properties.eTypeArguments, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				eTypeArguments.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.eTypeArgumentsFilters) {
			this.eTypeArguments.addFilter(filter);
		}
		this.eTypeArguments.setHelpText(propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EGenericType.Properties.eTypeArguments, EcoreViewsRepository.SWT_KIND));
		this.eTypeArguments.createControls(parent);
		this.eTypeArguments.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EGenericTypePropertiesEditionPartImpl.this, EcoreViewsRepository.EGenericType.Properties.eTypeArguments, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData eTypeArgumentsData = new GridData(GridData.FILL_HORIZONTAL);
		eTypeArgumentsData.horizontalSpan = 3;
		this.eTypeArguments.setLayoutData(eTypeArgumentsData);
		this.eTypeArguments.setLowerBound(0);
		this.eTypeArguments.setUpperBound(-1);
		eTypeArguments.setID(EcoreViewsRepository.EGenericType.Properties.eTypeArguments);
		eTypeArguments.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createETypeParameterFlatComboViewer(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EGenericType.Properties.eTypeParameter, EcoreMessages.EGenericTypePropertiesEditionPart_ETypeParameterLabel);
		eTypeParameter = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EGenericType.Properties.eTypeParameter, EcoreViewsRepository.SWT_KIND));
		eTypeParameter.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		eTypeParameter.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EGenericTypePropertiesEditionPartImpl.this, EcoreViewsRepository.EGenericType.Properties.eTypeParameter, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getETypeParameter()));
			}

		});
		GridData eTypeParameterData = new GridData(GridData.FILL_HORIZONTAL);
		eTypeParameter.setLayoutData(eTypeParameterData);
		eTypeParameter.setID(EcoreViewsRepository.EGenericType.Properties.eTypeParameter);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EGenericType.Properties.eTypeParameter, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createEClassifierFlatComboViewer(Composite parent) {
		createDescription(parent, EcoreViewsRepository.EGenericType.Properties.eClassifier, EcoreMessages.EGenericTypePropertiesEditionPart_EClassifierLabel);
		eClassifier = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EGenericType.Properties.eClassifier, EcoreViewsRepository.SWT_KIND));
		eClassifier.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		eClassifier.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EGenericTypePropertiesEditionPartImpl.this, EcoreViewsRepository.EGenericType.Properties.eClassifier, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getEClassifier()));
			}

		});
		GridData eClassifierData = new GridData(GridData.FILL_HORIZONTAL);
		eClassifier.setLayoutData(eClassifierData);
		eClassifier.setID(EcoreViewsRepository.EGenericType.Properties.eClassifier);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EGenericType.Properties.eClassifier, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.eclipse.emf.ecore.parts.EGenericTypePropertiesEditionPart#initETypeArguments(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initETypeArguments(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		eTypeArguments.setContentProvider(contentProvider);
		eTypeArguments.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EGenericTypePropertiesEditionPart#updateETypeArguments()
	 * 
	 */
	public void updateETypeArguments() {
	eTypeArguments.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EGenericTypePropertiesEditionPart#addFilterETypeArguments(ViewerFilter filter)
	 * 
	 */
	public void addFilterToETypeArguments(ViewerFilter filter) {
		eTypeArgumentsFilters.add(filter);
		if (this.eTypeArguments != null) {
			this.eTypeArguments.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EGenericTypePropertiesEditionPart#addBusinessFilterETypeArguments(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToETypeArguments(ViewerFilter filter) {
		eTypeArgumentsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EGenericTypePropertiesEditionPart#isContainedInETypeArgumentsTable(EObject element)
	 * 
	 */
	public boolean isContainedInETypeArgumentsTable(EObject element) {
		return ((ReferencesTableSettings)eTypeArguments.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EGenericTypePropertiesEditionPart#getETypeParameter()
	 * 
	 */
	public EObject getETypeParameter() {
		if (eTypeParameter.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) eTypeParameter.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EGenericTypePropertiesEditionPart#initETypeParameter(EObjectFlatComboSettings)
	 */
	public void initETypeParameter(EObjectFlatComboSettings settings) {
		eTypeParameter.setInput(settings);
		if (current != null) {
			eTypeParameter.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EGenericTypePropertiesEditionPart#setETypeParameter(EObject newValue)
	 * 
	 */
	public void setETypeParameter(EObject newValue) {
		if (newValue != null) {
			eTypeParameter.setSelection(new StructuredSelection(newValue));
		} else {
			eTypeParameter.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EGenericTypePropertiesEditionPart#setETypeParameterButtonMode(ButtonsModeEnum newValue)
	 */
	public void setETypeParameterButtonMode(ButtonsModeEnum newValue) {
		eTypeParameter.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EGenericTypePropertiesEditionPart#addFilterETypeParameter(ViewerFilter filter)
	 * 
	 */
	public void addFilterToETypeParameter(ViewerFilter filter) {
		eTypeParameter.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EGenericTypePropertiesEditionPart#addBusinessFilterETypeParameter(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToETypeParameter(ViewerFilter filter) {
		eTypeParameter.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EGenericTypePropertiesEditionPart#getEClassifier()
	 * 
	 */
	public EObject getEClassifier() {
		if (eClassifier.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) eClassifier.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EGenericTypePropertiesEditionPart#initEClassifier(EObjectFlatComboSettings)
	 */
	public void initEClassifier(EObjectFlatComboSettings settings) {
		eClassifier.setInput(settings);
		if (current != null) {
			eClassifier.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EGenericTypePropertiesEditionPart#setEClassifier(EObject newValue)
	 * 
	 */
	public void setEClassifier(EObject newValue) {
		if (newValue != null) {
			eClassifier.setSelection(new StructuredSelection(newValue));
		} else {
			eClassifier.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EGenericTypePropertiesEditionPart#setEClassifierButtonMode(ButtonsModeEnum newValue)
	 */
	public void setEClassifierButtonMode(ButtonsModeEnum newValue) {
		eClassifier.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EGenericTypePropertiesEditionPart#addFilterEClassifier(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEClassifier(ViewerFilter filter) {
		eClassifier.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.EGenericTypePropertiesEditionPart#addBusinessFilterEClassifier(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEClassifier(ViewerFilter filter) {
		eClassifier.addBusinessRuleFilter(filter);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EcoreMessages.EGenericType_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
