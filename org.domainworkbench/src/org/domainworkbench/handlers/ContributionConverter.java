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
		return context = EclipseContextFactory.getServiceContext(FrameworkUtil
				.getBundle(getClass()).getBundleContext());
	}

	@Override
	public Object convertToObject(String parameterValue)
			throws ParameterValueConversionException {
		ClassSupplier s = context.get(ClassSupplier.class);
		return s.getWorkspace().findContribution(parameterValue);
	}

	@Override
	public String convertToString(Object parameterValue)
			throws ParameterValueConversionException {
		return ((Contribution) parameterValue).getProjectName();
	}

}
