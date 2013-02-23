/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.parts.EGenericTypePropertiesEditionPart;
import org.eclipse.emf.ecore.parts.EcoreViewsRepository;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

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
public class EGenericTypePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for eTypeArguments ReferencesTable
	 */
	protected ReferencesTableSettings eTypeArgumentsSettings;
	
	/**
	 * Settings for eTypeParameter EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings eTypeParameterSettings;
	
	/**
	 * Settings for eClassifier EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings eClassifierSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public EGenericTypePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject eGenericType, String editing_mode) {
		super(editingContext, eGenericType, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EcoreViewsRepository.class;
		partKey = EcoreViewsRepository.EGenericType.class;
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
			final EGenericType eGenericType = (EGenericType)elt;
			final EGenericTypePropertiesEditionPart basePart = (EGenericTypePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EcoreViewsRepository.EGenericType.Properties.eTypeArguments)) {
				eTypeArgumentsSettings = new ReferencesTableSettings(eGenericType, EcorePackage.eINSTANCE.getEGenericType_ETypeArguments());
				basePart.initETypeArguments(eTypeArgumentsSettings);
			}
			if (isAccessible(EcoreViewsRepository.EGenericType.Properties.eTypeParameter)) {
				// init part
				eTypeParameterSettings = new EObjectFlatComboSettings(eGenericType, EcorePackage.eINSTANCE.getEGenericType_ETypeParameter());
				basePart.initETypeParameter(eTypeParameterSettings);
				// set the button mode
				basePart.setETypeParameterButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EcoreViewsRepository.EGenericType.Properties.eClassifier)) {
				// init part
				eClassifierSettings = new EObjectFlatComboSettings(eGenericType, EcorePackage.eINSTANCE.getEGenericType_EClassifier());
				basePart.initEClassifier(eClassifierSettings);
				// set the button mode
				basePart.setEClassifierButtonMode(ButtonsModeEnum.BROWSE);
			}
			// init filters
			if (isAccessible(EcoreViewsRepository.EGenericType.Properties.eTypeArguments)) {
				basePart.addFilterToETypeArguments(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof EGenericType); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for eTypeArguments
				// End of user code
			}
			if (isAccessible(EcoreViewsRepository.EGenericType.Properties.eTypeParameter)) {
				basePart.addFilterToETypeParameter(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof ETypeParameter); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for eTypeParameter
				// End of user code
			}
			if (isAccessible(EcoreViewsRepository.EGenericType.Properties.eClassifier)) {
				basePart.addFilterToEClassifier(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof EClassifier); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for eClassifier
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
		if (editorKey == EcoreViewsRepository.EGenericType.Properties.eTypeArguments) {
			return EcorePackage.eINSTANCE.getEGenericType_ETypeArguments();
		}
		if (editorKey == EcoreViewsRepository.EGenericType.Properties.eTypeParameter) {
			return EcorePackage.eINSTANCE.getEGenericType_ETypeParameter();
		}
		if (editorKey == EcoreViewsRepository.EGenericType.Properties.eClassifier) {
			return EcorePackage.eINSTANCE.getEGenericType_EClassifier();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		EGenericType eGenericType = (EGenericType)semanticObject;
		if (EcoreViewsRepository.EGenericType.Properties.eTypeArguments == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, eTypeArgumentsSettings, editingContext.getAdapterFactory());
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
				eTypeArgumentsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				eTypeArgumentsSettings.move(event.getNewIndex(), (EGenericType) event.getNewValue());
			}
		}
		if (EcoreViewsRepository.EGenericType.Properties.eTypeParameter == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				eTypeParameterSettings.setToReference((ETypeParameter)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				ETypeParameter eObject = EcoreFactory.eINSTANCE.createETypeParameter();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				eTypeParameterSettings.setToReference(eObject);
			}
		}
		if (EcoreViewsRepository.EGenericType.Properties.eClassifier == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				eClassifierSettings.setToReference((EClassifier)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, eClassifierSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {
			EGenericTypePropertiesEditionPart basePart = (EGenericTypePropertiesEditionPart)editingPart;
			if (EcorePackage.eINSTANCE.getEGenericType_ETypeArguments().equals(msg.getFeature()) && isAccessible(EcoreViewsRepository.EGenericType.Properties.eTypeArguments))
				basePart.updateETypeArguments();
			if (EcorePackage.eINSTANCE.getEGenericType_ETypeParameter().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EGenericType.Properties.eTypeParameter))
				basePart.setETypeParameter((EObject)msg.getNewValue());
			if (EcorePackage.eINSTANCE.getEGenericType_EClassifier().equals(msg.getFeature()) && basePart != null && isAccessible(EcoreViewsRepository.EGenericType.Properties.eClassifier))
				basePart.setEClassifier((EObject)msg.getNewValue());
			
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
		if (key == EcoreViewsRepository.EGenericType.Properties.eTypeParameter)
			return "The type parameter denoted by this generic type"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EGenericType.Properties.eClassifier)
			return "The classifier denoted by this generic type"; //$NON-NLS-1$
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
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}

}
