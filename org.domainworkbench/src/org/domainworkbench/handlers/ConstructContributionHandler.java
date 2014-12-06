package org.domainworkbench.handlers;

import javax.inject.Named;

import org.classupplier.Contribution;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.emf.codegen.util.CodeGenUtil;

public class ConstructContributionHandler {

	@CanExecute
	public boolean canExecute() {
		return true;
	}

	@Execute
	public void execute(
			@Named("org.domainworkbench.commandparameter.contribution") Contribution contribution) {
		contribution.construct(new CodeGenUtil.EclipseUtil.StreamProgressMonitor(
				System.out));
	}
}
