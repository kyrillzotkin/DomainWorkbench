/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.parts.EOperationPropertiesEditionPart;
import org.eclipse.emf.ecore.parts.EcoreViewsRepository;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public class EOperationPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for eType EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings eTypeSettings;
	
	/**
	 * Settings for eContainingClass EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings eContainingClassSettings;
	
	/**
	 * Settings for eExceptions ReferencesTable
	 */
	private ReferencesTableSettings eExceptionsSettings;
	
	/**
	 * Settings for eGenericExceptions ReferencesTable
	 */
	protected ReferencesTableSettings eGenericExceptionsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public EOperationPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject eOperation, String editing_mode) {
		super(editingContext, eOperation, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EcoreViewsRepository.class;
		partKey = EcoreViewsRepository.EOperation.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			final EOperation eOperation = (EOperation)elt;
			final EOperationPropertiesEditionPart basePart = (EOperationPropertiesEditionPart)editingPart;
			// init values
			if (eOperation.getName() != null && isAccessible(EcoreViewsRepository.EOperation.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, eOperation.getName()));
			
			if (isAccessible(EcoreViewsRepository.EOperation.Properties.ordered)) {
				basePart.setOrdered(eOperation.isOrdered());
			}
			if (isAccessible(EcoreViewsRepository.EOperation.Properties.unique)) {
				basePart.setUnique(eOperation.isUnique());
			}
			if (isAccessible(EcoreViewsRepository.EOperation.Properties.lowerBound)) {
				basePart.setLowerBound(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, eOperation.getLowerBound()));
			}
			
			if (isAccessible(EcoreViewsRepository.EOperation.Properties.upperBound)) {
				basePart.setUpperBound(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, eOperation.getUpperBound()));
			}
			
			if (isAccessible(EcoreViewsRepository.EOperation.Properties.eType)) {
				// init part
				eTypeSettings = new EObjectFlatComboSettings(eOperation, EcorePackage.eINSTANCE.getETypedElement_EType());
				basePart.initEType(eTypeSettings);
				// set the button mode
				basePart.setETypeButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EcoreViewsRepository.EOperation.Properties.eContainingClass)) {
				// init part
				eContainingClassSettings = new EObjectFlatComboSettings(eOperation, EcorePackage.eINSTANCE.getEOperation_EContainingClass());
				basePart.initEContainingClass(eContainingClassSettings);
				// set the button mode
				basePart.setEContainingClassButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EcoreViewsRepository.EOperation.Properties.eExceptions)) {
				eExceptionsSettings = new ReferencesTableSettings(eOperation, EcorePackage.eINSTANCE.getEOperation_EExceptions());
				basePart.initEExceptions(eExceptionsSettings);
			}
			if (isAccessible(EcoreViewsRepository.EOperation.Properties.eGenericExceptions)) {
				eGenericExceptionsSettings = new ReferencesTableSettings(eOperation, EcorePackage.eINSTANCE.getEOperation_EGenericExceptions());
				basePart.initEGenericExceptions(eGenericExceptionsSettings);
			}
			// init filters
			
			
			
			
			
			if (isAccessible(EcoreViewsRepository.EOperation.Properties.eType)) {
				basePart.addFilterToEType(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof EClassifier); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for eType
				// End of user code
			}
			if (isAccessible(EcoreViewsRepository.EOperation.Properties.eContainingClass)) {
				basePart.addFilterToEContainingClass(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof EClass); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for eContainingClass
				// End of user code
			}
			if (isAccessible(EcoreViewsRepository.EOperation.Properties.eExceptions)) {
				basePart.addFilterToEExceptions(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!basePart.isContainedInEExceptionsTable((EObject)element));
						return element instanceof Resource;
					}
				
				});
				basePart.addFilterToEExceptions(new EObjectFilter(EcorePackage.Literals.ECLASSIFIER));
				// Start of user code for additional businessfilters for eExceptions
				// End of user code
			}
			if (isAccessible(EcoreViewsRepository.EOperation.Properties.eGenericExceptions)) {
				basePart.addFilterToEGenericExceptions(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof EGenericType); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for eGenericExceptions
				// End of user code
			}
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}












	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == EcoreViewsRepository.EOperation.Properties.name) {
			return EcorePackage.eINSTANCE.getENamedElement_Name();
		}
		if (editorKey == EcoreViewsRepository.EOperation.Properties.ordered) {
			return EcorePackage.eINSTANCE.getETypedElement_Ordered();
		}
		if (editorKey == EcoreViewsRepository.EOperation.Properties.unique) {
			return EcorePackage.eINSTANCE.getETypedElement_Unique();
		}
		if (editorKey == EcoreViewsRepository.EOperation.Properties.lowerBound) {
			return EcorePackage.eINSTANCE.getETypedElement_LowerBound();
		}
		if (editorKey == EcoreViewsRepository.EOperation.Properties.upperBound) {
			return EcorePackage.eINSTANCE.getETypedElement_UpperBound();
		}
		if (editorKey == EcoreViewsRepository.EOperation.Properties.eType) {
			return EcorePackage.eINSTANCE.getETypedElement_EType();
		}
		if (editorKey == EcoreViewsRepository.EOperation.Properties.eContainingClass) {
			return EcorePackage.eINSTANCE.getEOperation_EContainingClass();
		}
		if (editorKey == EcoreViewsRepository.EOperation.Properties.eExceptions) {
			return EcorePackage.eINSTANCE.getEOperation_EExceptions();
		}
		if (editorKey == EcoreViewsRepository.EOperation.Properties.eGenericExceptions) {
			return EcorePackage.eINSTANCE.getEOperation_EGenericExceptions();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		EOperation eOperation = (EOperation)semanticObject;
		if (EcoreViewsRepository.EOperation.Properties.name == event.getAffectedEditor()) {
			eOperation.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EcoreViewsRepository.EOperation.Properties.ordered == event.getAffectedEditor()) {
			eOperation.setOrdered((Boolean)event.getNewValue());
		}
		if (EcoreViewsRepository.EOperation.Properties.unique == event.getAffectedEditor()) {
			eOperation.setUnique((Boolean)event.getNewValue());
		}
		if (EcoreViewsRepository.EOperation.Properties.lowerBound == event.getAffectedEditor()) {
			eOperation.setLowerBound((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EcoreViewsRepository.EOperation.Properties.upperBound == event.getAffectedEditor()) {
			eOperation.setUpperBound((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EcoreViewsRepository.EOperation.Properties.eType == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				eTypeSettings.setToReference((EClassifier)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, eTypeSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			}
		}
		if (EcoreViewsRepository.EOperation.Properties.eExceptions == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof EClassifier) {
					eExceptionsSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				eExceptionsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				eExceptionsSettings.move(event.getNewIndex(), (EClassifier) event.getNewValue());
			}
		}
		if (EcoreViewsRepository.EOperation.Properties.eGenericExceptions == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, eGenericExceptionsSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				eGenericExceptionsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				eGenericExceptionsSettings.move(event.getNewIndex(), (EGenericType) event.getNewValue());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			EOperationPropertiesEditionPart basePart = (EOperationPropertiesEditionPart)editingPart;
			if (EcorePackage.eINSTANCE.getENamedElement_Name().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EOperation.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (EcorePackage.eINSTANCE.getETypedElement_Ordered().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EOperation.Properties.ordered))
				basePart.setOrdered((Boolean)msg.getNewValue());
			
			if (EcorePackage.eINSTANCE.getETypedElement_Unique().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EOperation.Properties.unique))
				basePart.setUnique((Boolean)msg.getNewValue());
			
			if (EcorePackage.eINSTANCE.getETypedElement_LowerBound().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EOperation.Properties.lowerBound)) {
				if (msg.getNewValue() != null) {
					basePart.setLowerBound(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setLowerBound("");
				}
			}
			if (EcorePackage.eINSTANCE.getETypedElement_UpperBound().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EOperation.Properties.upperBound)) {
				if (msg.getNewValue() != null) {
					basePart.setUpperBound(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setUpperBound("");
				}
			}
			if (EcorePackage.eINSTANCE.getETypedElement_EType().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EOperation.Properties.eType))
				basePart.setEType((EObject)msg.getNewValue());
			if (EcorePackage.eINSTANCE.getEOperation_EContainingClass().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EOperation.Properties.eContainingClass))
				basePart.setEContainingClass((EObject)msg.getNewValue());
			if (EcorePackage.eINSTANCE.getEOperation_EExceptions().equals(msg.getFeature())  && isAccessible(EcoreViewsRepository.EOperation.Properties.eExceptions))
				basePart.updateEExceptions();
			if (EcorePackage.eINSTANCE.getEOperation_EGenericExceptions().equals(msg.getFeature()) && isAccessible(EcoreViewsRepository.EOperation.Properties.eGenericExceptions))
				basePart.updateEGenericExceptions();
			
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
		if (key == EcoreViewsRepository.EOperation.Properties.name)
			return "The name of this model element"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EOperation.Properties.ordered)
			return "Whether the order in which values occur is meaningful"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EOperation.Properties.unique)
			return "Whether the same value may occur more than once"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EOperation.Properties.lowerBound)
			return "The minimum number of values that must occur"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EOperation.Properties.upperBound)
			return "The maximum number of values that may occur; -1 represents unbounded and -2 represents unspecified"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EOperation.Properties.eType)
			return "The type of this element"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EOperation.Properties.eExceptions)
			return "The exceptions thrown by this operation"; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
				if (EcoreViewsRepository.EOperation.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getENamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getENamedElement_Name().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.EOperation.Properties.ordered == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getETypedElement_Ordered().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getETypedElement_Ordered().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.EOperation.Properties.unique == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getETypedElement_Unique().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getETypedElement_Unique().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.EOperation.Properties.lowerBound == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getETypedElement_LowerBound().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getETypedElement_LowerBound().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.EOperation.Properties.upperBound == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getETypedElement_UpperBound().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getETypedElement_UpperBound().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}

}
