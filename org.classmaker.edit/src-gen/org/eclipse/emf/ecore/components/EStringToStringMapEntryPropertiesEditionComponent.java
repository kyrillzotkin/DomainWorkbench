/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.components;

// Start of user code for imports
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.parts.EStringToStringMapEntryPropertiesEditionPart;
import org.eclipse.emf.ecore.parts.EcoreViewsRepository;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;


// End of user code

/**
 * 
 * 
 */
public class EStringToStringMapEntryPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public EStringToStringMapEntryPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject entry, String editing_mode) {
		super(editingContext, entry, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EcoreViewsRepository.class;
		partKey = EcoreViewsRepository.EStringToStringMapEntry.class;
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
			final Entry entry = (Entry)elt;
			final EStringToStringMapEntryPropertiesEditionPart basePart = (EStringToStringMapEntryPropertiesEditionPart)editingPart;
			// init values
			if (entry.getKey() != null && isAccessible(EcoreViewsRepository.EStringToStringMapEntry.Properties.key))
				basePart.setKey(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, entry.getKey()));
			
			if (entry.getValue() != null && isAccessible(EcoreViewsRepository.EStringToStringMapEntry.Properties.value))
				basePart.setValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, entry.getValue()));
			
			// init filters
			
			
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
		if (editorKey == EcoreViewsRepository.EStringToStringMapEntry.Properties.key) {
			return EcorePackage.eINSTANCE.getEStringToStringMapEntry_Key();
		}
		if (editorKey == EcoreViewsRepository.EStringToStringMapEntry.Properties.value) {
			return EcorePackage.eINSTANCE.getEStringToStringMapEntry_Value();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		Entry entry = (Entry)semanticObject;
		if (EcoreViewsRepository.EStringToStringMapEntry.Properties.key == event.getAffectedEditor()) {
			((EStringToStringMapEntryPropertiesEditionPart) entry).setKey((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EcoreViewsRepository.EStringToStringMapEntry.Properties.value == event.getAffectedEditor()) {
			entry.setValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			EStringToStringMapEntryPropertiesEditionPart basePart = (EStringToStringMapEntryPropertiesEditionPart)editingPart;
			if (EcorePackage.eINSTANCE.getEStringToStringMapEntry_Key().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EStringToStringMapEntry.Properties.key)) {
				if (msg.getNewValue() != null) {
					basePart.setKey(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setKey("");
				}
			}
			if (EcorePackage.eINSTANCE.getEStringToStringMapEntry_Value().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EStringToStringMapEntry.Properties.value)) {
				if (msg.getNewValue() != null) {
					basePart.setValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setValue("");
				}
			}
			
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
		if (key == EcoreViewsRepository.EStringToStringMapEntry.Properties.key)
			return "The key of this map entry"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EStringToStringMapEntry.Properties.value)
			return "The value of this map entry"; //$NON-NLS-1$
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
				if (EcoreViewsRepository.EStringToStringMapEntry.Properties.key == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEStringToStringMapEntry_Key().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getEStringToStringMapEntry_Key().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.EStringToStringMapEntry.Properties.value == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEStringToStringMapEntry_Value().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getEStringToStringMapEntry_Value().getEAttributeType(), newValue);
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
