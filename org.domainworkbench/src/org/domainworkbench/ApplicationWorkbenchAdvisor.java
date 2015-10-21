package org.domainworkbench;

import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.ide.IDE;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	@Override
	public void initialize(IWorkbenchConfigurer configurer) {
		super.initialize(configurer);
		// inserted: register workbench adapters
		IDE.registerAdapters();

	}

	@Override
	public String getInitialWindowPerspectiveId() {
		return "org.domainworkbench.perspective.work";
	}

}
