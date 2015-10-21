package org.domainworkbench.parts;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.spi.model.VFeaturePathDomainModelReference;
import org.eclipse.emf.ecp.view.spi.model.VView;
import org.eclipse.emf.ecp.view.spi.model.VViewFactory;
import org.eclipse.emf.ecp.view.spi.model.VViewModelProperties;
import org.eclipse.emf.ecp.view.spi.provider.IViewProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;

public class ViewProvider implements IViewProvider {

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.ecp.view.spi.provider.IViewProvider#canRender(EObject,
	 *      Map)
	 */
	private boolean isReadOnly(AdapterFactoryItemDelegator delegator, EObject owner, EStructuralFeature feature) {
		if (!feature.isChangeable()) {
			return true;
		}
		final IItemPropertyDescriptor descriptor = delegator.getPropertyDescriptor(owner, feature);
		return !descriptor.canSetProperty(feature);
	}

	private boolean isInvalidFeature(EStructuralFeature feature) {
		return isContainerReference(feature) || isTransient(feature); // ||
		// isVolatile(feature);
	}

	private boolean isContainerReference(EStructuralFeature feature) {
		if (feature instanceof EReference) {
			final EReference reference = (EReference) feature;
			if (reference.isContainer()) {
				return true;
			}
		}

		return false;
	}

	private boolean isTransient(EStructuralFeature feature) {
		return feature.isTransient();
	}

	// private boolean isVolatile(EStructuralFeature feature) {
	// return feature.isVolatile();
	// }

	private Set<EStructuralFeature> getValidFeatures(AdapterFactoryItemDelegator itemDelegator, EObject eObject) {
		final Collection<EStructuralFeature> features = eObject.eClass().getEAllStructuralFeatures();
		final Set<EStructuralFeature> featuresToAdd = new LinkedHashSet<EStructuralFeature>();
		IItemPropertyDescriptor propertyDescriptor = null;
		for (final EStructuralFeature feature : features) {
			propertyDescriptor = itemDelegator.getPropertyDescriptor(eObject, feature);
			if (propertyDescriptor == null || isInvalidFeature(feature)) {
				continue;
			}

			featuresToAdd.add(feature);

		}
		return featuresToAdd;
	}

	@Override
	public double canProvideViewModel(EObject eObject, VViewModelProperties properties) {
		return 1;
	}

	@Override
	public VView provideViewModel(EObject eObject, VViewModelProperties properties) {
		final VView view = VViewFactory.eINSTANCE.createView();
		final ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
				new AdapterFactory[] { new ReflectiveItemProviderAdapterFactory(),
						new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE) });
		final AdapterFactoryItemDelegator delegator = new AdapterFactoryItemDelegator(composedAdapterFactory);
		for (final EStructuralFeature feature : getValidFeatures(delegator, eObject)) {

			final VControl control = VViewFactory.eINSTANCE.createControl();
			final VFeaturePathDomainModelReference modelReference = VViewFactory.eINSTANCE
					.createFeaturePathDomainModelReference();
			modelReference.setDomainModelEFeature(feature);
			control.setDomainModelReference(modelReference);
			control.setReadonly(isReadOnly(delegator, eObject, feature));
			view.getChildren().add(control);
		}
		composedAdapterFactory.dispose();
		return view;
	}

}
