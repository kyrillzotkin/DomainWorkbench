package org.domainworkbench.wizards;

import org.classupplier.ClassSupplier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.jface.wizard.Wizard;

public class NewEPackageWizard extends Wizard {

	EPackageWizardPage page;

	private ClassSupplier classuplier;

	public NewEPackageWizard(ClassSupplier classuplier) {
		this.classuplier = classuplier;
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
		classuplier.getWorkspace().createContribution(ePackage);
		return true;
	}

}
