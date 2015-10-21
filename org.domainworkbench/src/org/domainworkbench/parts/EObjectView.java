package org.domainworkbench.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.ui.view.ECPRendererException;
import org.eclipse.emf.ecp.ui.view.swt.ECPSWTViewRenderer;
import org.eclipse.swt.widgets.Composite;

public class EObjectView {

	@Inject
	MPart part;

	@PostConstruct
	public void createControls(Composite parent) {
		EObject domainObject = (EObject) part.getTransientData().get("org.domainworkbench.input.eObject");
		try {
			ECPSWTViewRenderer.INSTANCE.render(parent, domainObject);
		} catch (ECPRendererException e) {
			e.printStackTrace();
		}
	}

}
