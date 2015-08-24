package org.domainworkbench.handlers;

import org.classupplier.ClassSupplier;
import org.classupplier.Contribution;
import org.eclipse.core.commands.AbstractParameterValueConverter;
import org.eclipse.core.commands.ParameterValueConversionException;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osgi.framework.FrameworkUtil;

public class ContributionConverter extends AbstractParameterValueConverter {

	protected IEclipseContext context;

	public ContributionConverter() {
		super();
		this.context = getContext();
	}

	private IEclipseContext getContext() {
		return context = EclipseContextFactory
				.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
	}

	@Override
	public Object convertToObject(String parameterValue) throws ParameterValueConversionException {
		ClassSupplier supplier = context.get(ClassSupplier.class);
		return supplier.getWorkspace().getContribution(parameterValue);
	}

	@Override
	public String convertToString(Object parameterValue) throws ParameterValueConversionException {
		if (parameterValue instanceof Contribution)
			return ((Contribution) parameterValue).getProjectName();
		throw new ParameterValueConversionException("parameterValue is not Contribution");
	}

}
