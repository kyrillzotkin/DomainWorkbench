/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.parts.ETypeParameterPropertiesEditionPart;
import org.eclipse.emf.ecore.parts.EcoreViewsRepository;

import org.eclipse.emf.ecore.providers.EcoreMessages;

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

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

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

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * 
 * 
 */
public class ETypeParameterPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ETypeParameterPropertiesEditionPart {

	protected Text name;
	protected ReferencesTable eBounds;
	protected List<ViewerFilter> eBoundsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> eBoundsFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ETypeParameterPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence eTypeParameterStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = eTypeParameterStep.addStep(EcoreViewsRepository.ETypeParameter.Properties.class);
		propertiesStep.addStep(EcoreViewsRepository.ETypeParameter.Properties.name);
		propertiesStep.addStep(EcoreViewsRepository.ETypeParameter.Properties.eBounds);
		
		
		composer = new PartComposer(eTypeParameterStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EcoreViewsRepository.ETypeParameter.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EcoreViewsRepository.ETypeParameter.Properties.name) {
					return createNameText(parent);
				}
				if (key == EcoreViewsRepository.ETypeParameter.Properties.eBounds) {
					return createEBoundsAdvancedTableComposition(parent);
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
		propertiesGroup.setText(EcoreMessages.ETypeParameterPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, EcoreViewsRepository.ETypeParameter.Properties.name, EcoreMessages.ETypeParameterPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ETypeParameterPropertiesEditionPartImpl.this, EcoreViewsRepository.ETypeParameter.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ETypeParameterPropertiesEditionPartImpl.this, EcoreViewsRepository.ETypeParameter.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, EcoreViewsRepository.ETypeParameter.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.ETypeParameter.Properties.name, EcoreViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createEBoundsAdvancedTableComposition(Composite parent) {
		this.eBounds = new ReferencesTable(getDescription(EcoreViewsRepository.ETypeParameter.Properties.eBounds, EcoreMessages.ETypeParameterPropertiesEditionPart_EBoundsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ETypeParameterPropertiesEditionPartImpl.this, EcoreViewsRepository.ETypeParameter.Properties.eBounds, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				eBounds.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ETypeParameterPropertiesEditionPartImpl.this, EcoreViewsRepository.ETypeParameter.Properties.eBounds, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				eBounds.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ETypeParameterPropertiesEditionPartImpl.this, EcoreViewsRepository.ETypeParameter.Properties.eBounds, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				eBounds.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ETypeParameterPropertiesEditionPartImpl.this, EcoreViewsRepository.ETypeParameter.Properties.eBounds, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				eBounds.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.eBoundsFilters) {
			this.eBounds.addFilter(filter);
		}
		this.eBounds.setHelpText(propertiesEditionComponent.getHelpContent(EcoreViewsRepository.ETypeParameter.Properties.eBounds, EcoreViewsRepository.SWT_KIND));
		this.eBounds.createControls(parent);
		this.eBounds.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ETypeParameterPropertiesEditionPartImpl.this, EcoreViewsRepository.ETypeParameter.Properties.eBounds, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData eBoundsData = new GridData(GridData.FILL_HORIZONTAL);
		eBoundsData.horizontalSpan = 3;
		this.eBounds.setLayoutData(eBoundsData);
		this.eBounds.setLowerBound(0);
		this.eBounds.setUpperBound(-1);
		eBounds.setID(EcoreViewsRepository.ETypeParameter.Properties.eBounds);
		eBounds.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
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
	 * @see org.eclipse.emf.ecore.parts.ETypeParameterPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.ETypeParameterPropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.emf.ecore.parts.ETypeParameterPropertiesEditionPart#initEBounds(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initEBounds(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		eBounds.setContentProvider(contentProvider);
		eBounds.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.ETypeParameterPropertiesEditionPart#updateEBounds()
	 * 
	 */
	public void updateEBounds() {
	eBounds.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.ETypeParameterPropertiesEditionPart#addFilterEBounds(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEBounds(ViewerFilter filter) {
		eBoundsFilters.add(filter);
		if (this.eBounds != null) {
			this.eBounds.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.ETypeParameterPropertiesEditionPart#addBusinessFilterEBounds(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEBounds(ViewerFilter filter) {
		eBoundsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.parts.ETypeParameterPropertiesEditionPart#isContainedInEBoundsTable(EObject element)
	 * 
	 */
	public boolean isContainedInEBoundsTable(EObject element) {
		return ((ReferencesTableSettings)eBounds.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EcoreMessages.ETypeParameter_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
