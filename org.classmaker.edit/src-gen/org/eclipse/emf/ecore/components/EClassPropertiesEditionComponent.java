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
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.parts.EClassPropertiesEditionPart;
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
public class EClassPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for ePackage EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings ePackageSettings;
	
	/**
	 * Settings for eSuperTypes ReferencesTable
	 */
	private ReferencesTableSettings eSuperTypesSettings;
	
	/**
	 * Settings for eGenericSuperTypes ReferencesTable
	 */
	protected ReferencesTableSettings eGenericSuperTypesSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public EClassPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject eClass, String editing_mode) {
		super(editingContext, eClass, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EcoreViewsRepository.class;
		partKey = EcoreViewsRepository.EClass.class;
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
			final EClass eClass = (EClass)elt;
			final EClassPropertiesEditionPart basePart = (EClassPropertiesEditionPart)editingPart;
			// init values
			if (eClass.getName() != null && isAccessible(EcoreViewsRepository.EClass.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, eClass.getName()));
			
			if (eClass.getInstanceClassName() != null && isAccessible(EcoreViewsRepository.EClass.Properties.instanceClassName))
				basePart.setInstanceClassName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, eClass.getInstanceClassName()));
			
			if (eClass.getInstanceTypeName() != null && isAccessible(EcoreViewsRepository.EClass.Properties.instanceTypeName))
				basePart.setInstanceTypeName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, eClass.getInstanceTypeName()));
			
			if (isAccessible(EcoreViewsRepository.EClass.Properties.ePackage)) {
				// init part
				ePackageSettings = new EObjectFlatComboSettings(eClass, EcorePackage.eINSTANCE.getEClassifier_EPackage());
				basePart.initEPackage(ePackageSettings);
				// set the button mode
				basePart.setEPackageButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EcoreViewsRepository.EClass.Properties.abstract_)) {
				basePart.setAbstract_(eClass.isAbstract());
			}
			if (isAccessible(EcoreViewsRepository.EClass.Properties.interface_)) {
				basePart.setInterface_(eClass.isInterface());
			}
			if (isAccessible(EcoreViewsRepository.EClass.Properties.eSuperTypes)) {
				eSuperTypesSettings = new ReferencesTableSettings(eClass, EcorePackage.eINSTANCE.getEClass_ESuperTypes());
				basePart.initESuperTypes(eSuperTypesSettings);
			}
			if (isAccessible(EcoreViewsRepository.EClass.Properties.eGenericSuperTypes)) {
				eGenericSuperTypesSettings = new ReferencesTableSettings(eClass, EcorePackage.eINSTANCE.getEClass_EGenericSuperTypes());
				basePart.initEGenericSuperTypes(eGenericSuperTypesSettings);
			}
			// init filters
			
			
			
			if (isAccessible(EcoreViewsRepository.EClass.Properties.ePackage)) {
				basePart.addFilterToEPackage(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof EPackage); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for ePackage
				// End of user code
			}
			
			
			if (isAccessible(EcoreViewsRepository.EClass.Properties.eSuperTypes)) {
				basePart.addFilterToESuperTypes(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						if (element instanceof EObject)
							return (!basePart.isContainedInESuperTypesTable((EObject)element));
						return element instanceof Resource;
					}
				
				});
				basePart.addFilterToESuperTypes(new EObjectFilter(EcorePackage.Literals.ECLASS));
				// Start of user code for additional businessfilters for eSuperTypes
				// End of user code
			}
			if (isAccessible(EcoreViewsRepository.EClass.Properties.eGenericSuperTypes)) {
				basePart.addFilterToEGenericSuperTypes(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof EGenericType); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for eGenericSuperTypes
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
		if (editorKey == EcoreViewsRepository.EClass.Properties.name) {
			return EcorePackage.eINSTANCE.getENamedElement_Name();
		}
		if (editorKey == EcoreViewsRepository.EClass.Properties.instanceClassName) {
			return EcorePackage.eINSTANCE.getEClassifier_InstanceClassName();
		}
		if (editorKey == EcoreViewsRepository.EClass.Properties.instanceTypeName) {
			return EcorePackage.eINSTANCE.getEClassifier_InstanceTypeName();
		}
		if (editorKey == EcoreViewsRepository.EClass.Properties.ePackage) {
			return EcorePackage.eINSTANCE.getEClassifier_EPackage();
		}
		if (editorKey == EcoreViewsRepository.EClass.Properties.abstract_) {
			return EcorePackage.eINSTANCE.getEClass_Abstract();
		}
		if (editorKey == EcoreViewsRepository.EClass.Properties.interface_) {
			return EcorePackage.eINSTANCE.getEClass_Interface();
		}
		if (editorKey == EcoreViewsRepository.EClass.Properties.eSuperTypes) {
			return EcorePackage.eINSTANCE.getEClass_ESuperTypes();
		}
		if (editorKey == EcoreViewsRepository.EClass.Properties.eGenericSuperTypes) {
			return EcorePackage.eINSTANCE.getEClass_EGenericSuperTypes();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		EClass eClass = (EClass)semanticObject;
		if (EcoreViewsRepository.EClass.Properties.name == event.getAffectedEditor()) {
			eClass.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EcoreViewsRepository.EClass.Properties.instanceClassName == event.getAffectedEditor()) {
			eClass.setInstanceClassName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EcoreViewsRepository.EClass.Properties.instanceTypeName == event.getAffectedEditor()) {
			eClass.setInstanceTypeName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EcoreViewsRepository.EClass.Properties.abstract_ == event.getAffectedEditor()) {
			eClass.setAbstract((Boolean)event.getNewValue());
		}
		if (EcoreViewsRepository.EClass.Properties.interface_ == event.getAffectedEditor()) {
			eClass.setInterface((Boolean)event.getNewValue());
		}
		if (EcoreViewsRepository.EClass.Properties.eSuperTypes == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof EClass) {
					eSuperTypesSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				eSuperTypesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				eSuperTypesSettings.move(event.getNewIndex(), (EClass) event.getNewValue());
			}
		}
		if (EcoreViewsRepository.EClass.Properties.eGenericSuperTypes == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, eGenericSuperTypesSettings, editingContext.getAdapterFactory());
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
				eGenericSuperTypesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				eGenericSuperTypesSettings.move(event.getNewIndex(), (EGenericType) event.getNewValue());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			EClassPropertiesEditionPart basePart = (EClassPropertiesEditionPart)editingPart;
			if (EcorePackage.eINSTANCE.getENamedElement_Name().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EClass.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (EcorePackage.eINSTANCE.getEClassifier_InstanceClassName().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EClass.Properties.instanceClassName)) {
				if (msg.getNewValue() != null) {
					basePart.setInstanceClassName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInstanceClassName("");
				}
			}
			if (EcorePackage.eINSTANCE.getEClassifier_InstanceTypeName().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EClass.Properties.instanceTypeName)) {
				if (msg.getNewValue() != null) {
					basePart.setInstanceTypeName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInstanceTypeName("");
				}
			}
			if (EcorePackage.eINSTANCE.getEClassifier_EPackage().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EClass.Properties.ePackage))
				basePart.setEPackage((EObject)msg.getNewValue());
			if (EcorePackage.eINSTANCE.getEClass_Abstract().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EClass.Properties.abstract_))
				basePart.setAbstract_((Boolean)msg.getNewValue());
			
			if (EcorePackage.eINSTANCE.getEClass_Interface().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EClass.Properties.interface_))
				basePart.setInterface_((Boolean)msg.getNewValue());
			
			if (EcorePackage.eINSTANCE.getEClass_ESuperTypes().equals(msg.getFeature())  && isAccessible(EcoreViewsRepository.EClass.Properties.eSuperTypes))
				basePart.updateESuperTypes();
			if (EcorePackage.eINSTANCE.getEClass_EGenericSuperTypes().equals(msg.getFeature()) && isAccessible(EcoreViewsRepository.EClass.Properties.eGenericSuperTypes))
				basePart.updateEGenericSuperTypes();
			
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
		if (key == EcoreViewsRepository.EClass.Properties.name)
			return "The name of this model element"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EClass.Properties.instanceClassName)
			return "The erased instance class name denoted by this classifier"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EClass.Properties.instanceTypeName)
			return "The full instance type name denoted by this classifier"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EClass.Properties.abstract_)
			return "Whether instances of this class can be created"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EClass.Properties.interface_)
			return "Whether no corresponding implementation will be generated for this class"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EClass.Properties.eSuperTypes)
			return "The immediate super types of this class"; //$NON-NLS-1$
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
				if (EcoreViewsRepository.EClass.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getENamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getENamedElement_Name().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.EClass.Properties.instanceClassName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEClassifier_InstanceClassName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getEClassifier_InstanceClassName().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.EClass.Properties.instanceTypeName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEClassifier_InstanceTypeName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getEClassifier_InstanceTypeName().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.EClass.Properties.abstract_ == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEClass_Abstract().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getEClass_Abstract().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.EClass.Properties.interface_ == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEClass_Interface().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getEClass_Interface().getEAttributeType(), newValue);
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
