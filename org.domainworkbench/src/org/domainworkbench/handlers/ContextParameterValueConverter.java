package org.domainworkbench.handlers;

import org.eclipse.core.commands.AbstractParameterValueConverter;
import org.eclipse.core.commands.ParameterValueConversionException;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

public class ContextParameterValueConverter extends
		AbstractParameterValueConverter {

	protected IEclipseContext context;

	public ContextParameterValueConverter() {
		super();
		this.context = createContext();
	}

	private IEclipseContext createContext() {
		return context = EclipseContextFactory.create();

		// Bundle bundle = FrameworkUtil
		// .getBundle(ContextParameterValueConverter.class);
		// BundleContext bundleContext = bundle.getBundleContext();
		// IEclipseContext serviceContext = EclipseContextFactory
		// .getServiceContext(bundleContext);
		// return serviceContext.getActiveLeaf();
	}

	@Override
	public Object convertToObject(String parameterValue)
			throws ParameterValueConversionException {
		return context.get(parameterValue);
	}

	@Override
	public String convertToString(Object parameterValue)
			throws ParameterValueConversionException {
		return parameterValue.toString();		
	}
}
