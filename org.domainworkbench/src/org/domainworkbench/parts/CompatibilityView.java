package org.domainworkbench.parts;

import javax.annotation.PostConstruct;

import org.eclipse.e4.tools.compat.parts.DIViewPart;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;

@SuppressWarnings("restriction")
public class CompatibilityView extends DIViewPart<NavigationView> {

	public CompatibilityView() {
		super(NavigationView.class);
	}

	@PostConstruct
	@Override
	public void createPartControl(Composite parent) {
		 super.createPartControl(parent);
//		 getComponent().g
		// NavigationView.this.createControls(parent, getContext());
		// getSite().setSelectionProvider(viewer);
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
	}
	
}
