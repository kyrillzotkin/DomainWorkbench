/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.parts.EEnumPropertiesEditionPart;
import org.eclipse.emf.ecore.parts.EcoreViewsRepository;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public class EEnumPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for ePackage EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings ePackageSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public EEnumPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject eEnum, String editing_mode) {
		super(editingContext, eEnum, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EcoreViewsRepository.class;
		partKey = EcoreViewsRepository.EEnum.class;
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
			final EEnum eEnum = (EEnum)elt;
			final EEnumPropertiesEditionPart basePart = (EEnumPropertiesEditionPart)editingPart;
			// init values
			if (eEnum.getName() != null && isAccessible(EcoreViewsRepository.EEnum.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, eEnum.getName()));
			
			if (eEnum.getInstanceClassName() != null && isAccessible(EcoreViewsRepository.EEnum.Properties.instanceClassName))
				basePart.setInstanceClassName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, eEnum.getInstanceClassName()));
			
			if (eEnum.getInstanceTypeName() != null && isAccessible(EcoreViewsRepository.EEnum.Properties.instanceTypeName))
				basePart.setInstanceTypeName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, eEnum.getInstanceTypeName()));
			
			if (isAccessible(EcoreViewsRepository.EEnum.Properties.ePackage)) {
				// init part
				ePackageSettings = new EObjectFlatComboSettings(eEnum, EcorePackage.eINSTANCE.getEClassifier_EPackage());
				basePart.initEPackage(ePackageSettings);
				// set the button mode
				basePart.setEPackageButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EcoreViewsRepository.EEnum.Properties.serializable)) {
				basePart.setSerializable(eEnum.isSerializable());
			}
			// init filters
			
			
			
			if (isAccessible(EcoreViewsRepository.EEnum.Properties.ePackage)) {
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
		if (editorKey == EcoreViewsRepository.EEnum.Properties.name) {
			return EcorePackage.eINSTANCE.getENamedElement_Name();
		}
		if (editorKey == EcoreViewsRepository.EEnum.Properties.instanceClassName) {
			return EcorePackage.eINSTANCE.getEClassifier_InstanceClassName();
		}
		if (editorKey == EcoreViewsRepository.EEnum.Properties.instanceTypeName) {
			return EcorePackage.eINSTANCE.getEClassifier_InstanceTypeName();
		}
		if (editorKey == EcoreViewsRepository.EEnum.Properties.ePackage) {
			return EcorePackage.eINSTANCE.getEClassifier_EPackage();
		}
		if (editorKey == EcoreViewsRepository.EEnum.Properties.serializable) {
			return EcorePackage.eINSTANCE.getEDataType_Serializable();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		EEnum eEnum = (EEnum)semanticObject;
		if (EcoreViewsRepository.EEnum.Properties.name == event.getAffectedEditor()) {
			eEnum.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EcoreViewsRepository.EEnum.Properties.instanceClassName == event.getAffectedEditor()) {
			eEnum.setInstanceClassName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EcoreViewsRepository.EEnum.Properties.instanceTypeName == event.getAffectedEditor()) {
			eEnum.setInstanceTypeName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EcoreViewsRepository.EEnum.Properties.serializable == event.getAffectedEditor()) {
			eEnum.setSerializable((Boolean)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			EEnumPropertiesEditionPart basePart = (EEnumPropertiesEditionPart)editingPart;
			if (EcorePackage.eINSTANCE.getENamedElement_Name().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EEnum.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (EcorePackage.eINSTANCE.getEClassifier_InstanceClassName().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EEnum.Properties.instanceClassName)) {
				if (msg.getNewValue() != null) {
					basePart.setInstanceClassName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInstanceClassName("");
				}
			}
			if (EcorePackage.eINSTANCE.getEClassifier_InstanceTypeName().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EEnum.Properties.instanceTypeName)) {
				if (msg.getNewValue() != null) {
					basePart.setInstanceTypeName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setInstanceTypeName("");
				}
			}
			if (EcorePackage.eINSTANCE.getEClassifier_EPackage().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EEnum.Properties.ePackage))
				basePart.setEPackage((EObject)msg.getNewValue());
			if (EcorePackage.eINSTANCE.getEDataType_Serializable().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EEnum.Properties.serializable))
				basePart.setSerializable((Boolean)msg.getNewValue());
			
			
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
		if (key == EcoreViewsRepository.EEnum.Properties.name)
			return "The name of this model element"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EEnum.Properties.instanceClassName)
			return "The erased instance class name denoted by this classifier"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EEnum.Properties.instanceTypeName)
			return "The full instance type name denoted by this classifier"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EEnum.Properties.serializable)
			return "Whether a value of this data type can be serialized using the factory"; //$NON-NLS-1$
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
				if (EcoreViewsRepository.EEnum.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getENamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getENamedElement_Name().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.EEnum.Properties.instanceClassName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEClassifier_InstanceClassName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getEClassifier_InstanceClassName().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.EEnum.Properties.instanceTypeName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEClassifier_InstanceTypeName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getEClassifier_InstanceTypeName().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.EEnum.Properties.serializable == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEDataType_Serializable().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getEDataType_Serializable().getEAttributeType(), newValue);
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
