/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.parts.forms;

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

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

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
public class EReferencePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, EReferencePropertiesEditionPart {

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
	 * For {@link ISection} use only.
	 */
	public EReferencePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EReferencePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.ordered) {
					return createOrderedCheckbox(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.unique) {
					return createUniqueCheckbox(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.lowerBound) {
					return createLowerBoundText(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.upperBound) {
					return createUpperBoundText(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.eType) {
					return createETypeFlatComboViewer(parent, widgetFactory);
				}
				if (key == EcoreViewsRepository.EReference.Properties.changeable) {
					return createChangeableCheckbox(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.volatile_) {
					return createVolatile_Checkbox(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.transient_) {
					return createTransient_Checkbox(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.defaultValueLiteral) {
					return createDefaultValueLiteralText(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.unsettable) {
					return createUnsettableCheckbox(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.derived) {
					return createDerivedCheckbox(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.eContainingClass) {
					return createEContainingClassFlatComboViewer(parent, widgetFactory);
				}
				if (key == EcoreViewsRepository.EReference.Properties.containment) {
					return createContainmentCheckbox(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.resolveProxies) {
					return createResolveProxiesCheckbox(widgetFactory, parent);
				}
				if (key == EcoreViewsRepository.EReference.Properties.eOpposite) {
					return createEOppositeFlatComboViewer(parent, widgetFactory);
				}
				if (key == EcoreViewsRepository.EReference.Properties.eKeys) {
					return createEKeysReferencesTable(widgetFactory, parent);
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
		propertiesSection.setText(EcoreMessages.EReferencePropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, EcoreViewsRepository.EReference.Properties.name, EcoreMessages.EReferencePropertiesEditionPart_NameLabel);
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
							EReferencePropertiesEditionPartForm.this,
							EcoreViewsRepository.EReference.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EReferencePropertiesEditionPartForm.this,
									EcoreViewsRepository.EReference.Properties.name,
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
									EReferencePropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartForm.this, EcoreViewsRepository.EReference.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, EcoreViewsRepository.EReference.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.name, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createOrderedCheckbox(FormToolkit widgetFactory, Composite parent) {
		ordered = widgetFactory.createButton(parent, getDescription(EcoreViewsRepository.EReference.Properties.ordered, EcoreMessages.EReferencePropertiesEditionPart_OrderedLabel), SWT.CHECK);
		ordered.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartForm.this, EcoreViewsRepository.EReference.Properties.ordered, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(ordered.getSelection())));
			}

		});
		GridData orderedData = new GridData(GridData.FILL_HORIZONTAL);
		orderedData.horizontalSpan = 2;
		ordered.setLayoutData(orderedData);
		EditingUtils.setID(ordered, EcoreViewsRepository.EReference.Properties.ordered);
		EditingUtils.setEEFtype(ordered, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.ordered, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createUniqueCheckbox(FormToolkit widgetFactory, Composite parent) {
		unique = widgetFactory.createButton(parent, getDescription(EcoreViewsRepository.EReference.Properties.unique, EcoreMessages.EReferencePropertiesEditionPart_UniqueLabel), SWT.CHECK);
		unique.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartForm.this, EcoreViewsRepository.EReference.Properties.unique, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(unique.getSelection())));
			}

		});
		GridData uniqueData = new GridData(GridData.FILL_HORIZONTAL);
		uniqueData.horizontalSpan = 2;
		unique.setLayoutData(uniqueData);
		EditingUtils.setID(unique, EcoreViewsRepository.EReference.Properties.unique);
		EditingUtils.setEEFtype(unique, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.unique, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createLowerBoundText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EcoreViewsRepository.EReference.Properties.lowerBound, EcoreMessages.EReferencePropertiesEditionPart_LowerBoundLabel);
		lowerBound = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		lowerBound.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData lowerBoundData = new GridData(GridData.FILL_HORIZONTAL);
		lowerBound.setLayoutData(lowerBoundData);
		lowerBound.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EReferencePropertiesEditionPartForm.this,
							EcoreViewsRepository.EReference.Properties.lowerBound,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, lowerBound.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EReferencePropertiesEditionPartForm.this,
									EcoreViewsRepository.EReference.Properties.lowerBound,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, lowerBound.getText()));
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
									EReferencePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		lowerBound.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartForm.this, EcoreViewsRepository.EReference.Properties.lowerBound, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, lowerBound.getText()));
				}
			}
		});
		EditingUtils.setID(lowerBound, EcoreViewsRepository.EReference.Properties.lowerBound);
		EditingUtils.setEEFtype(lowerBound, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.lowerBound, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createUpperBoundText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EcoreViewsRepository.EReference.Properties.upperBound, EcoreMessages.EReferencePropertiesEditionPart_UpperBoundLabel);
		upperBound = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		upperBound.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData upperBoundData = new GridData(GridData.FILL_HORIZONTAL);
		upperBound.setLayoutData(upperBoundData);
		upperBound.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EReferencePropertiesEditionPartForm.this,
							EcoreViewsRepository.EReference.Properties.upperBound,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, upperBound.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EReferencePropertiesEditionPartForm.this,
									EcoreViewsRepository.EReference.Properties.upperBound,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, upperBound.getText()));
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
									EReferencePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		upperBound.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartForm.this, EcoreViewsRepository.EReference.Properties.upperBound, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, upperBound.getText()));
				}
			}
		});
		EditingUtils.setID(upperBound, EcoreViewsRepository.EReference.Properties.upperBound);
		EditingUtils.setEEFtype(upperBound, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.upperBound, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createETypeFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EcoreViewsRepository.EReference.Properties.eType, EcoreMessages.EReferencePropertiesEditionPart_ETypeLabel);
		eType = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EReference.Properties.eType, EcoreViewsRepository.FORM_KIND));
		widgetFactory.adapt(eType);
		eType.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData eTypeData = new GridData(GridData.FILL_HORIZONTAL);
		eType.setLayoutData(eTypeData);
		eType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartForm.this, EcoreViewsRepository.EReference.Properties.eType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEType()));
			}

		});
		eType.setID(EcoreViewsRepository.EReference.Properties.eType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.eType, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createChangeableCheckbox(FormToolkit widgetFactory, Composite parent) {
		changeable = widgetFactory.createButton(parent, getDescription(EcoreViewsRepository.EReference.Properties.changeable, EcoreMessages.EReferencePropertiesEditionPart_ChangeableLabel), SWT.CHECK);
		changeable.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartForm.this, EcoreViewsRepository.EReference.Properties.changeable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(changeable.getSelection())));
			}

		});
		GridData changeableData = new GridData(GridData.FILL_HORIZONTAL);
		changeableData.horizontalSpan = 2;
		changeable.setLayoutData(changeableData);
		EditingUtils.setID(changeable, EcoreViewsRepository.EReference.Properties.changeable);
		EditingUtils.setEEFtype(changeable, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.changeable, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createVolatile_Checkbox(FormToolkit widgetFactory, Composite parent) {
		volatile_ = widgetFactory.createButton(parent, getDescription(EcoreViewsRepository.EReference.Properties.volatile_, EcoreMessages.EReferencePropertiesEditionPart_Volatile_Label), SWT.CHECK);
		volatile_.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartForm.this, EcoreViewsRepository.EReference.Properties.volatile_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(volatile_.getSelection())));
			}

		});
		GridData volatile_Data = new GridData(GridData.FILL_HORIZONTAL);
		volatile_Data.horizontalSpan = 2;
		volatile_.setLayoutData(volatile_Data);
		EditingUtils.setID(volatile_, EcoreViewsRepository.EReference.Properties.volatile_);
		EditingUtils.setEEFtype(volatile_, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.volatile_, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createTransient_Checkbox(FormToolkit widgetFactory, Composite parent) {
		transient_ = widgetFactory.createButton(parent, getDescription(EcoreViewsRepository.EReference.Properties.transient_, EcoreMessages.EReferencePropertiesEditionPart_Transient_Label), SWT.CHECK);
		transient_.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartForm.this, EcoreViewsRepository.EReference.Properties.transient_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(transient_.getSelection())));
			}

		});
		GridData transient_Data = new GridData(GridData.FILL_HORIZONTAL);
		transient_Data.horizontalSpan = 2;
		transient_.setLayoutData(transient_Data);
		EditingUtils.setID(transient_, EcoreViewsRepository.EReference.Properties.transient_);
		EditingUtils.setEEFtype(transient_, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.transient_, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createDefaultValueLiteralText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EcoreViewsRepository.EReference.Properties.defaultValueLiteral, EcoreMessages.EReferencePropertiesEditionPart_DefaultValueLiteralLabel);
		defaultValueLiteral = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		defaultValueLiteral.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData defaultValueLiteralData = new GridData(GridData.FILL_HORIZONTAL);
		defaultValueLiteral.setLayoutData(defaultValueLiteralData);
		defaultValueLiteral.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							EReferencePropertiesEditionPartForm.this,
							EcoreViewsRepository.EReference.Properties.defaultValueLiteral,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, defaultValueLiteral.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									EReferencePropertiesEditionPartForm.this,
									EcoreViewsRepository.EReference.Properties.defaultValueLiteral,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, defaultValueLiteral.getText()));
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
									EReferencePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		defaultValueLiteral.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartForm.this, EcoreViewsRepository.EReference.Properties.defaultValueLiteral, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, defaultValueLiteral.getText()));
				}
			}
		});
		EditingUtils.setID(defaultValueLiteral, EcoreViewsRepository.EReference.Properties.defaultValueLiteral);
		EditingUtils.setEEFtype(defaultValueLiteral, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.defaultValueLiteral, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createUnsettableCheckbox(FormToolkit widgetFactory, Composite parent) {
		unsettable = widgetFactory.createButton(parent, getDescription(EcoreViewsRepository.EReference.Properties.unsettable, EcoreMessages.EReferencePropertiesEditionPart_UnsettableLabel), SWT.CHECK);
		unsettable.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartForm.this, EcoreViewsRepository.EReference.Properties.unsettable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(unsettable.getSelection())));
			}

		});
		GridData unsettableData = new GridData(GridData.FILL_HORIZONTAL);
		unsettableData.horizontalSpan = 2;
		unsettable.setLayoutData(unsettableData);
		EditingUtils.setID(unsettable, EcoreViewsRepository.EReference.Properties.unsettable);
		EditingUtils.setEEFtype(unsettable, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.unsettable, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createDerivedCheckbox(FormToolkit widgetFactory, Composite parent) {
		derived = widgetFactory.createButton(parent, getDescription(EcoreViewsRepository.EReference.Properties.derived, EcoreMessages.EReferencePropertiesEditionPart_DerivedLabel), SWT.CHECK);
		derived.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartForm.this, EcoreViewsRepository.EReference.Properties.derived, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(derived.getSelection())));
			}

		});
		GridData derivedData = new GridData(GridData.FILL_HORIZONTAL);
		derivedData.horizontalSpan = 2;
		derived.setLayoutData(derivedData);
		EditingUtils.setID(derived, EcoreViewsRepository.EReference.Properties.derived);
		EditingUtils.setEEFtype(derived, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.derived, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createEContainingClassFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EcoreViewsRepository.EReference.Properties.eContainingClass, EcoreMessages.EReferencePropertiesEditionPart_EContainingClassLabel);
		eContainingClass = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EReference.Properties.eContainingClass, EcoreViewsRepository.FORM_KIND));
		widgetFactory.adapt(eContainingClass);
		eContainingClass.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData eContainingClassData = new GridData(GridData.FILL_HORIZONTAL);
		eContainingClass.setLayoutData(eContainingClassData);
		eContainingClass.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartForm.this, EcoreViewsRepository.EReference.Properties.eContainingClass, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEContainingClass()));
			}

		});
		eContainingClass.setID(EcoreViewsRepository.EReference.Properties.eContainingClass);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.eContainingClass, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createContainmentCheckbox(FormToolkit widgetFactory, Composite parent) {
		containment = widgetFactory.createButton(parent, getDescription(EcoreViewsRepository.EReference.Properties.containment, EcoreMessages.EReferencePropertiesEditionPart_ContainmentLabel), SWT.CHECK);
		containment.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartForm.this, EcoreViewsRepository.EReference.Properties.containment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(containment.getSelection())));
			}

		});
		GridData containmentData = new GridData(GridData.FILL_HORIZONTAL);
		containmentData.horizontalSpan = 2;
		containment.setLayoutData(containmentData);
		EditingUtils.setID(containment, EcoreViewsRepository.EReference.Properties.containment);
		EditingUtils.setEEFtype(containment, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.containment, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createResolveProxiesCheckbox(FormToolkit widgetFactory, Composite parent) {
		resolveProxies = widgetFactory.createButton(parent, getDescription(EcoreViewsRepository.EReference.Properties.resolveProxies, EcoreMessages.EReferencePropertiesEditionPart_ResolveProxiesLabel), SWT.CHECK);
		resolveProxies.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartForm.this, EcoreViewsRepository.EReference.Properties.resolveProxies, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(resolveProxies.getSelection())));
			}

		});
		GridData resolveProxiesData = new GridData(GridData.FILL_HORIZONTAL);
		resolveProxiesData.horizontalSpan = 2;
		resolveProxies.setLayoutData(resolveProxiesData);
		EditingUtils.setID(resolveProxies, EcoreViewsRepository.EReference.Properties.resolveProxies);
		EditingUtils.setEEFtype(resolveProxies, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.resolveProxies, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createEOppositeFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EcoreViewsRepository.EReference.Properties.eOpposite, EcoreMessages.EReferencePropertiesEditionPart_EOppositeLabel);
		eOpposite = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EcoreViewsRepository.EReference.Properties.eOpposite, EcoreViewsRepository.FORM_KIND));
		widgetFactory.adapt(eOpposite);
		eOpposite.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData eOppositeData = new GridData(GridData.FILL_HORIZONTAL);
		eOpposite.setLayoutData(eOppositeData);
		eOpposite.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartForm.this, EcoreViewsRepository.EReference.Properties.eOpposite, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEOpposite()));
			}

		});
		eOpposite.setID(EcoreViewsRepository.EReference.Properties.eOpposite);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.eOpposite, EcoreViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createEKeysReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.eKeys = new ReferencesTable(getDescription(EcoreViewsRepository.EReference.Properties.eKeys, EcoreMessages.EReferencePropertiesEditionPart_EKeysLabel), new ReferencesTableListener	() {
			public void handleAdd() { addEKeys(); }
			public void handleEdit(EObject element) { editEKeys(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveEKeys(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromEKeys(element); }
			public void navigateTo(EObject element) { }
		});
		this.eKeys.setHelpText(propertiesEditionComponent.getHelpContent(EcoreViewsRepository.EReference.Properties.eKeys, EcoreViewsRepository.FORM_KIND));
		this.eKeys.createControls(parent, widgetFactory);
		this.eKeys.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartForm.this, EcoreViewsRepository.EReference.Properties.eKeys, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartForm.this, EcoreViewsRepository.EReference.Properties.eKeys,
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartForm.this, EcoreViewsRepository.EReference.Properties.eKeys, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		eKeys.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromEKeys(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EReferencePropertiesEditionPartForm.this, EcoreViewsRepository.EReference.Properties.eKeys, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
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
