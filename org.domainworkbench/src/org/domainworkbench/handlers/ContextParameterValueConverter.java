package org.domainworkbench.handlers;

import org.eclipse.core.commands.AbstractParameterValueConverter;
import org.eclipse.core.commands.ParameterValueConversionException;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;

public class ContextParameterValueConverter extends AbstractParameterValueConverter {

	protected IEclipseContext context;

	public ContextParameterValueConverter() {
		super();
		this.context = getContext();
	}

	private IEclipseContext getContext() {
		// return context = EclipseContextFactory
		// .getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());
		return context = EclipseContextFactory.create();
	}

	@Override
	public Object convertToObject(String parameterValue) throws ParameterValueConversionException {
		return context.get(parameterValue);
	}

	@Override
	public String convertToString(Object parameterValue) throws ParameterValueConversionException {
		String result = parameterValue.getClass().getName() + "@" + parameterValue.hashCode();
		context.set(result, parameterValue);
		return result;
	}
}
