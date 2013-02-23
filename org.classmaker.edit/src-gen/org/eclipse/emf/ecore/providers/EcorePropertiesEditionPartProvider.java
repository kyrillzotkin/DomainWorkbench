/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.providers;

import org.eclipse.emf.ecore.parts.EcoreViewsRepository;

import org.eclipse.emf.ecore.parts.forms.EAnnotationPropertiesEditionPartForm;
import org.eclipse.emf.ecore.parts.forms.EAttributePropertiesEditionPartForm;
import org.eclipse.emf.ecore.parts.forms.EClassPropertiesEditionPartForm;
import org.eclipse.emf.ecore.parts.forms.EDataTypePropertiesEditionPartForm;
import org.eclipse.emf.ecore.parts.forms.EEnumLiteralPropertiesEditionPartForm;
import org.eclipse.emf.ecore.parts.forms.EEnumPropertiesEditionPartForm;
import org.eclipse.emf.ecore.parts.forms.EFactoryPropertiesEditionPartForm;
import org.eclipse.emf.ecore.parts.forms.EGenericTypePropertiesEditionPartForm;
import org.eclipse.emf.ecore.parts.forms.EOperationPropertiesEditionPartForm;
import org.eclipse.emf.ecore.parts.forms.EPackagePropertiesEditionPartForm;
import org.eclipse.emf.ecore.parts.forms.EParameterPropertiesEditionPartForm;
import org.eclipse.emf.ecore.parts.forms.EReferencePropertiesEditionPartForm;
import org.eclipse.emf.ecore.parts.forms.EStringToStringMapEntryPropertiesEditionPartForm;
import org.eclipse.emf.ecore.parts.forms.ETypeParameterPropertiesEditionPartForm;

import org.eclipse.emf.ecore.parts.impl.EAnnotationPropertiesEditionPartImpl;
import org.eclipse.emf.ecore.parts.impl.EAttributePropertiesEditionPartImpl;
import org.eclipse.emf.ecore.parts.impl.EClassPropertiesEditionPartImpl;
import org.eclipse.emf.ecore.parts.impl.EDataTypePropertiesEditionPartImpl;
import org.eclipse.emf.ecore.parts.impl.EEnumLiteralPropertiesEditionPartImpl;
import org.eclipse.emf.ecore.parts.impl.EEnumPropertiesEditionPartImpl;
import org.eclipse.emf.ecore.parts.impl.EFactoryPropertiesEditionPartImpl;
import org.eclipse.emf.ecore.parts.impl.EGenericTypePropertiesEditionPartImpl;
import org.eclipse.emf.ecore.parts.impl.EOperationPropertiesEditionPartImpl;
import org.eclipse.emf.ecore.parts.impl.EPackagePropertiesEditionPartImpl;
import org.eclipse.emf.ecore.parts.impl.EParameterPropertiesEditionPartImpl;
import org.eclipse.emf.ecore.parts.impl.EReferencePropertiesEditionPartImpl;
import org.eclipse.emf.ecore.parts.impl.EStringToStringMapEntryPropertiesEditionPartImpl;
import org.eclipse.emf.ecore.parts.impl.ETypeParameterPropertiesEditionPartImpl;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;

/**
 * 
 * 
 */
public class EcorePropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
	 * 
	 */
	public boolean provides(Object key) {
		return key == EcoreViewsRepository.class;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == EcoreViewsRepository.EAttribute.class) {
			if (kind == EcoreViewsRepository.SWT_KIND)
				return new EAttributePropertiesEditionPartImpl(component);
			if (kind == EcoreViewsRepository.FORM_KIND)
				return new EAttributePropertiesEditionPartForm(component);
		}
		if (key == EcoreViewsRepository.EAnnotation.class) {
			if (kind == EcoreViewsRepository.SWT_KIND)
				return new EAnnotationPropertiesEditionPartImpl(component);
			if (kind == EcoreViewsRepository.FORM_KIND)
				return new EAnnotationPropertiesEditionPartForm(component);
		}
		if (key == EcoreViewsRepository.EClass.class) {
			if (kind == EcoreViewsRepository.SWT_KIND)
				return new EClassPropertiesEditionPartImpl(component);
			if (kind == EcoreViewsRepository.FORM_KIND)
				return new EClassPropertiesEditionPartForm(component);
		}
		if (key == EcoreViewsRepository.EDataType.class) {
			if (kind == EcoreViewsRepository.SWT_KIND)
				return new EDataTypePropertiesEditionPartImpl(component);
			if (kind == EcoreViewsRepository.FORM_KIND)
				return new EDataTypePropertiesEditionPartForm(component);
		}
		if (key == EcoreViewsRepository.EEnum.class) {
			if (kind == EcoreViewsRepository.SWT_KIND)
				return new EEnumPropertiesEditionPartImpl(component);
			if (kind == EcoreViewsRepository.FORM_KIND)
				return new EEnumPropertiesEditionPartForm(component);
		}
		if (key == EcoreViewsRepository.EEnumLiteral.class) {
			if (kind == EcoreViewsRepository.SWT_KIND)
				return new EEnumLiteralPropertiesEditionPartImpl(component);
			if (kind == EcoreViewsRepository.FORM_KIND)
				return new EEnumLiteralPropertiesEditionPartForm(component);
		}
		if (key == EcoreViewsRepository.EFactory.class) {
			if (kind == EcoreViewsRepository.SWT_KIND)
				return new EFactoryPropertiesEditionPartImpl(component);
			if (kind == EcoreViewsRepository.FORM_KIND)
				return new EFactoryPropertiesEditionPartForm(component);
		}
		if (key == EcoreViewsRepository.EOperation.class) {
			if (kind == EcoreViewsRepository.SWT_KIND)
				return new EOperationPropertiesEditionPartImpl(component);
			if (kind == EcoreViewsRepository.FORM_KIND)
				return new EOperationPropertiesEditionPartForm(component);
		}
		if (key == EcoreViewsRepository.EPackage.class) {
			if (kind == EcoreViewsRepository.SWT_KIND)
				return new EPackagePropertiesEditionPartImpl(component);
			if (kind == EcoreViewsRepository.FORM_KIND)
				return new EPackagePropertiesEditionPartForm(component);
		}
		if (key == EcoreViewsRepository.EParameter.class) {
			if (kind == EcoreViewsRepository.SWT_KIND)
				return new EParameterPropertiesEditionPartImpl(component);
			if (kind == EcoreViewsRepository.FORM_KIND)
				return new EParameterPropertiesEditionPartForm(component);
		}
		if (key == EcoreViewsRepository.EReference.class) {
			if (kind == EcoreViewsRepository.SWT_KIND)
				return new EReferencePropertiesEditionPartImpl(component);
			if (kind == EcoreViewsRepository.FORM_KIND)
				return new EReferencePropertiesEditionPartForm(component);
		}
		if (key == EcoreViewsRepository.EStringToStringMapEntry.class) {
			if (kind == EcoreViewsRepository.SWT_KIND)
				return new EStringToStringMapEntryPropertiesEditionPartImpl(component);
			if (kind == EcoreViewsRepository.FORM_KIND)
				return new EStringToStringMapEntryPropertiesEditionPartForm(component);
		}
		if (key == EcoreViewsRepository.EGenericType.class) {
			if (kind == EcoreViewsRepository.SWT_KIND)
				return new EGenericTypePropertiesEditionPartImpl(component);
			if (kind == EcoreViewsRepository.FORM_KIND)
				return new EGenericTypePropertiesEditionPartForm(component);
		}
		if (key == EcoreViewsRepository.ETypeParameter.class) {
			if (kind == EcoreViewsRepository.SWT_KIND)
				return new ETypeParameterPropertiesEditionPartImpl(component);
			if (kind == EcoreViewsRepository.FORM_KIND)
				return new ETypeParameterPropertiesEditionPartForm(component);
		}
		return null;
	}

}
