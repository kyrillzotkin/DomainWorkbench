/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.parts.EPackagePropertiesEditionPart;
import org.eclipse.emf.ecore.parts.EcoreViewsRepository;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public class EPackagePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for eFactoryInstance EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings eFactoryInstanceSettings;
	
	/**
	 * Settings for eSuperPackage EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings eSuperPackageSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public EPackagePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject ePackage, String editing_mode) {
		super(editingContext, ePackage, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EcoreViewsRepository.class;
		partKey = EcoreViewsRepository.EPackage.class;
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
			final EPackage ePackage = (EPackage)elt;
			final EPackagePropertiesEditionPart basePart = (EPackagePropertiesEditionPart)editingPart;
			// init values
			if (ePackage.getName() != null && isAccessible(EcoreViewsRepository.EPackage.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ePackage.getName()));
			
			if (ePackage.getNsURI() != null && isAccessible(EcoreViewsRepository.EPackage.Properties.nsURI))
				basePart.setNsURI(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ePackage.getNsURI()));
			
			if (ePackage.getNsPrefix() != null && isAccessible(EcoreViewsRepository.EPackage.Properties.nsPrefix))
				basePart.setNsPrefix(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, ePackage.getNsPrefix()));
			
			if (isAccessible(EcoreViewsRepository.EPackage.Properties.eFactoryInstance)) {
				// init part
				eFactoryInstanceSettings = new EObjectFlatComboSettings(ePackage, EcorePackage.eINSTANCE.getEPackage_EFactoryInstance());
				basePart.initEFactoryInstance(eFactoryInstanceSettings);
				// set the button mode
				basePart.setEFactoryInstanceButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EcoreViewsRepository.EPackage.Properties.eSuperPackage)) {
				// init part
				eSuperPackageSettings = new EObjectFlatComboSettings(ePackage, EcorePackage.eINSTANCE.getEPackage_ESuperPackage());
				basePart.initESuperPackage(eSuperPackageSettings);
				// set the button mode
				basePart.setESuperPackageButtonMode(ButtonsModeEnum.BROWSE);
			}
			// init filters
			
			
			
			if (isAccessible(EcoreViewsRepository.EPackage.Properties.eFactoryInstance)) {
				basePart.addFilterToEFactoryInstance(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof EFactory);
					}
					
				});
				// Start of user code for additional businessfilters for eFactoryInstance
				// End of user code
			}
			if (isAccessible(EcoreViewsRepository.EPackage.Properties.eSuperPackage)) {
				basePart.addFilterToESuperPackage(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof EPackage); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for eSuperPackage
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
		if (editorKey == EcoreViewsRepository.EPackage.Properties.name) {
			return EcorePackage.eINSTANCE.getENamedElement_Name();
		}
		if (editorKey == EcoreViewsRepository.EPackage.Properties.nsURI) {
			return EcorePackage.eINSTANCE.getEPackage_NsURI();
		}
		if (editorKey == EcoreViewsRepository.EPackage.Properties.nsPrefix) {
			return EcorePackage.eINSTANCE.getEPackage_NsPrefix();
		}
		if (editorKey == EcoreViewsRepository.EPackage.Properties.eFactoryInstance) {
			return EcorePackage.eINSTANCE.getEPackage_EFactoryInstance();
		}
		if (editorKey == EcoreViewsRepository.EPackage.Properties.eSuperPackage) {
			return EcorePackage.eINSTANCE.getEPackage_ESuperPackage();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		EPackage ePackage = (EPackage)semanticObject;
		if (EcoreViewsRepository.EPackage.Properties.name == event.getAffectedEditor()) {
			ePackage.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EcoreViewsRepository.EPackage.Properties.nsURI == event.getAffectedEditor()) {
			ePackage.setNsURI((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EcoreViewsRepository.EPackage.Properties.nsPrefix == event.getAffectedEditor()) {
			ePackage.setNsPrefix((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EcoreViewsRepository.EPackage.Properties.eFactoryInstance == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				eFactoryInstanceSettings.setToReference((EFactory)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EFactory eObject = EcoreFactory.eINSTANCE.createEFactory();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				eFactoryInstanceSettings.setToReference(eObject);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			EPackagePropertiesEditionPart basePart = (EPackagePropertiesEditionPart)editingPart;
			if (EcorePackage.eINSTANCE.getENamedElement_Name().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EPackage.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (EcorePackage.eINSTANCE.getEPackage_NsURI().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EPackage.Properties.nsURI)) {
				if (msg.getNewValue() != null) {
					basePart.setNsURI(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setNsURI("");
				}
			}
			if (EcorePackage.eINSTANCE.getEPackage_NsPrefix().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EPackage.Properties.nsPrefix)) {
				if (msg.getNewValue() != null) {
					basePart.setNsPrefix(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setNsPrefix("");
				}
			}
			if (EcorePackage.eINSTANCE.getEPackage_EFactoryInstance().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EPackage.Properties.eFactoryInstance))
				basePart.setEFactoryInstance((EObject)msg.getNewValue());
			if (EcorePackage.eINSTANCE.getEPackage_ESuperPackage().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EPackage.Properties.eSuperPackage))
				basePart.setESuperPackage((EObject)msg.getNewValue());
			
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == EcoreViewsRepository.EPackage.Properties.eFactoryInstance;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
		if (key == EcoreViewsRepository.EPackage.Properties.name)
			return "The name of this model element"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EPackage.Properties.nsURI)
			return "The universally unique namespace identifier, typically an absolute URI, for this package"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EPackage.Properties.nsPrefix)
			return "The namespace prefix used by default when serializing instances of the package's classes"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EPackage.Properties.eFactoryInstance)
			return "The factory corresponding to this package"; //$NON-NLS-1$
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
				if (EcoreViewsRepository.EPackage.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getENamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getENamedElement_Name().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.EPackage.Properties.nsURI == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEPackage_NsURI().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getEPackage_NsURI().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.EPackage.Properties.nsPrefix == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEPackage_NsPrefix().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getEPackage_NsPrefix().getEAttributeType(), newValue);
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
