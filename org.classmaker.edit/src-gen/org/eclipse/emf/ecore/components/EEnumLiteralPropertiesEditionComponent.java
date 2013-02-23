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
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.parts.EEnumLiteralPropertiesEditionPart;
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
public class EEnumLiteralPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for eEnum EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings eEnumSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public EEnumLiteralPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject eEnumLiteral, String editing_mode) {
		super(editingContext, eEnumLiteral, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EcoreViewsRepository.class;
		partKey = EcoreViewsRepository.EEnumLiteral.class;
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
			final EEnumLiteral eEnumLiteral = (EEnumLiteral)elt;
			final EEnumLiteralPropertiesEditionPart basePart = (EEnumLiteralPropertiesEditionPart)editingPart;
			// init values
			if (eEnumLiteral.getName() != null && isAccessible(EcoreViewsRepository.EEnumLiteral.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, eEnumLiteral.getName()));
			
			if (isAccessible(EcoreViewsRepository.EEnumLiteral.Properties.value)) {
				basePart.setValue(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, eEnumLiteral.getValue()));
			}
			
			if (eEnumLiteral.getInstance() != null && isAccessible(EcoreViewsRepository.EEnumLiteral.Properties.instance))
				basePart.setInstance(EEFConverterUtil.convertToString(EcorePackage.Literals.EENUMERATOR, eEnumLiteral.getInstance()));
			
			if (eEnumLiteral.getLiteral() != null && isAccessible(EcoreViewsRepository.EEnumLiteral.Properties.literal))
				basePart.setLiteral(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, eEnumLiteral.getLiteral()));
			
			if (isAccessible(EcoreViewsRepository.EEnumLiteral.Properties.eEnum)) {
				// init part
				eEnumSettings = new EObjectFlatComboSettings(eEnumLiteral, EcorePackage.eINSTANCE.getEEnumLiteral_EEnum());
				basePart.initEEnum(eEnumSettings);
				// set the button mode
				basePart.setEEnumButtonMode(ButtonsModeEnum.BROWSE);
			}
			// init filters
			
			
			
			
			if (isAccessible(EcoreViewsRepository.EEnumLiteral.Properties.eEnum)) {
				basePart.addFilterToEEnum(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof EEnum); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for eEnum
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
		if (editorKey == EcoreViewsRepository.EEnumLiteral.Properties.name) {
			return EcorePackage.eINSTANCE.getENamedElement_Name();
		}
		if (editorKey == EcoreViewsRepository.EEnumLiteral.Properties.value) {
			return EcorePackage.eINSTANCE.getEEnumLiteral_Value();
		}
		if (editorKey == EcoreViewsRepository.EEnumLiteral.Properties.instance) {
			return EcorePackage.eINSTANCE.getEEnumLiteral_Instance();
		}
		if (editorKey == EcoreViewsRepository.EEnumLiteral.Properties.literal) {
			return EcorePackage.eINSTANCE.getEEnumLiteral_Literal();
		}
		if (editorKey == EcoreViewsRepository.EEnumLiteral.Properties.eEnum) {
			return EcorePackage.eINSTANCE.getEEnumLiteral_EEnum();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		EEnumLiteral eEnumLiteral = (EEnumLiteral)semanticObject;
		if (EcoreViewsRepository.EEnumLiteral.Properties.name == event.getAffectedEditor()) {
			eEnumLiteral.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EcoreViewsRepository.EEnumLiteral.Properties.value == event.getAffectedEditor()) {
			eEnumLiteral.setValue((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EcoreViewsRepository.EEnumLiteral.Properties.instance == event.getAffectedEditor()) {
			eEnumLiteral.setInstance((org.eclipse.emf.common.util.Enumerator)EEFConverterUtil.createFromString(EcorePackage.Literals.EENUMERATOR, (String)event.getNewValue()));
		}
		if (EcoreViewsRepository.EEnumLiteral.Properties.literal == event.getAffectedEditor()) {
			eEnumLiteral.setLiteral((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			EEnumLiteralPropertiesEditionPart basePart = (EEnumLiteralPropertiesEditionPart)editingPart;
			if (EcorePackage.eINSTANCE.getENamedElement_Name().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EEnumLiteral.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (EcorePackage.eINSTANCE.getEEnumLiteral_Value().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EEnumLiteral.Properties.value)) {
				if (msg.getNewValue() != null) {
					basePart.setValue(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					basePart.setValue("");
				}
			}
			if (EcorePackage.eINSTANCE.getEEnumLiteral_Instance().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EEnumLiteral.Properties.instance)) {
				if (msg.getNewValue() != null) {
					basePart.setInstance(EcoreUtil.convertToString(EcorePackage.Literals.EENUMERATOR, msg.getNewValue()));
				} else {
					basePart.setInstance("");
				}
			}
			if (EcorePackage.eINSTANCE.getEEnumLiteral_Literal().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EEnumLiteral.Properties.literal)) {
				if (msg.getNewValue() != null) {
					basePart.setLiteral(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setLiteral("");
				}
			}
			if (EcorePackage.eINSTANCE.getEEnumLiteral_EEnum().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EEnumLiteral.Properties.eEnum))
				basePart.setEEnum((EObject)msg.getNewValue());
			
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
		if (key == EcoreViewsRepository.EEnumLiteral.Properties.name)
			return "The name of this model element"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EEnumLiteral.Properties.value)
			return "The integer value associated with this enumerator"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EEnumLiteral.Properties.literal)
			return "The literal value associated with this enumerator"; //$NON-NLS-1$
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
				if (EcoreViewsRepository.EEnumLiteral.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getENamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getENamedElement_Name().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.EEnumLiteral.Properties.value == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEEnumLiteral_Value().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getEEnumLiteral_Value().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.EEnumLiteral.Properties.instance == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEEnumLiteral_Instance().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getEEnumLiteral_Instance().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.EEnumLiteral.Properties.literal == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEEnumLiteral_Literal().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getEEnumLiteral_Literal().getEAttributeType(), newValue);
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
