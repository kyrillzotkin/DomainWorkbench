package org.domainworkbench.parts;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.core.swt.SimpleControlJFaceViewerSWTRenderer;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.DatabindingFailedException;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.core.services.editsupport.EMFFormsEditSupport;
import org.eclipse.emfforms.spi.core.services.label.EMFFormsLabelProvider;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;

public class ETypeComboViewerSWTRenderer extends SimpleControlJFaceViewerSWTRenderer {

	private final EMFFormsEditSupport emfFormsEditSupport;

	@Inject
	public ETypeComboViewerSWTRenderer(VControl vElement, ViewModelContext viewContext, ReportService reportService,
			EMFFormsDatabinding emfFormsDatabinding, EMFFormsLabelProvider emfFormsLabelProvider,
			VTViewTemplateProvider vtViewTemplateProvider, EMFFormsEditSupport emfFormsEditSupport) {
		super(vElement, viewContext, reportService, emfFormsDatabinding, emfFormsLabelProvider, vtViewTemplateProvider);
		this.emfFormsEditSupport = emfFormsEditSupport;
	}

	@SuppressWarnings("deprecation")
	@Override
	protected Binding[] createBindings(Viewer viewer) throws DatabindingFailedException {
		final Binding binding = getDataBindingContext().bindValue(ViewersObservables.observeSingleSelection(viewer),
				getModelValue());
		final Binding tooltipBinding = getDataBindingContext()
				.bindValue(SWTObservables.observeTooltipText(viewer.getControl()), getModelValue());
		return new Binding[] { binding, tooltipBinding };
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.ecp.view.spi.core.swt.SimpleControlJFaceViewerSWTRenderer#createJFaceViewer(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Viewer createJFaceViewer(Composite parent) throws DatabindingFailedException {

		final ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
				new AdapterFactory[] { new ReflectiveItemProviderAdapterFactory(),
						new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE) });
		final AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
				composedAdapterFactory);
		final IObservableValue observableValue = getEMFFormsDatabinding()
				.getObservableValue(getVElement().getDomainModelReference(), getViewModelContext().getDomainModel());

		final EStructuralFeature structuralFeature = (EReference) observableValue.getValueType();
		final EObject eObject = (EObject) ((IObserving) observableValue).getObserved();
		final IItemPropertyDescriptor itemPropertyDescriptor = adapterFactoryItemDelegator
				.getPropertyDescriptor(eObject, structuralFeature);

		final ComboViewer combo = new ComboViewer(parent);
		combo.setContentProvider(new ArrayContentProvider());
		combo.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(Object element) {
				return getEMFFormsEditSupport().getText(getVElement().getDomainModelReference(),
						getViewModelContext().getDomainModel(), element);
			}

		});
		final List<Object> inputValues = new ArrayList<Object>();
		for (final Object object : itemPropertyDescriptor.getChoiceOfValues(eObject)) {
			if (object != null)
				inputValues.add(object);
		}
		combo.setInput(inputValues);
		combo.setData(CUSTOM_VARIANT, "org_eclipse_emf_ecp_control_etype"); //$NON-NLS-1$
		composedAdapterFactory.dispose();
		return combo;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.ecp.view.spi.core.swt.SimpleControlSWTRenderer#getUnsetText()
	 */
	@Override
	protected String getUnsetText() {
		return "No value set! Click to set value.";
	}

	private EMFFormsEditSupport getEMFFormsEditSupport() {
		return emfFormsEditSupport;
	}

}
