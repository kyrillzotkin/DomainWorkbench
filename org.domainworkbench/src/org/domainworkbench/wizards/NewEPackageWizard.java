package org.domainworkbench.wizards;

import org.classupplier.ClassSupplier;
import org.classupplier.Contribution;
import org.domainworkbench.parts.NavigationView;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.jface.wizard.Wizard;

public class NewEPackageWizard extends Wizard {

	EPackageWizardPage page;

	private ClassSupplier classuplier;

	private EPartService parts;

	public NewEPackageWizard(ClassSupplier classuplier, EPartService partService) {
		this.classuplier = classuplier;
		this.parts = partService;
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		page = new EPackageWizardPage();
		addPage(page);
		super.addPages();
	}

	@Override
	public boolean performFinish() {
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName(page.getName());
		ePackage.setNsPrefix(page.getNsPrefix());
		ePackage.setNsURI(page.getNsURI());
		Contribution contrib = classuplier.getWorkspace().createContribution(ePackage);
		if (parts != null)
			contrib.eAdapters().add(((NavigationView) parts.findPart(NavigationView.ID).getObject()).getLabelAdapter());
		return true;
	}

}
