package org.domainworkbench.handlers;

import javax.inject.Named;

import org.classupplier.Artefact;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.emf.codegen.util.CodeGenUtil;

public class ProduceArtefactHandler {

	@CanExecute
	public boolean canExecute() {
		return true;
	}

	@Execute
	public void execute(
			@Named("org.domainworkbench.commandparameter.artefact") Artefact artefact) {
		artefact.produce(new CodeGenUtil.EclipseUtil.StreamProgressMonitor(
				System.out));
	}
}
