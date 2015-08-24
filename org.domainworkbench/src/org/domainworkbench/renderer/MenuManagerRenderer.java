package org.domainworkbench.renderer;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.jface.internal.MenuManagerEventHelper;

public class MenuManagerRenderer extends org.eclipse.e4.ui.workbench.renderers.swt.MenuManagerRenderer {

	@Override
	@PostConstruct
	public void init() {
		super.init();
		MenuManagerEventHelper.getInstance().setHideHelper(
				ContextInjectionFactory.make(MenuManagerHideProcessor.class,
						context));
	}

}
