package org.domainworkbench.handlers;

import org.classupplier.Artefact;
import org.classupplier.ClassSupplier;
import org.eclipse.core.commands.AbstractParameterValueConverter;
import org.eclipse.core.commands.ParameterValueConversionException;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osgi.framework.FrameworkUtil;

public class ArtefactConverter extends
		AbstractParameterValueConverter {

	protected IEclipseContext context;

	public ArtefactConverter() {
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
		return s.getWorkspace().getArtefact(parameterValue);
	}

	@Override
	public String convertToString(Object parameterValue)
			throws ParameterValueConversionException {
		return ((Artefact) parameterValue).getProjectName();
	}

}
