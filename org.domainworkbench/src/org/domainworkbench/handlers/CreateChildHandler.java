package org.domainworkbench.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.emf.common.command.Command;

public class CreateChildHandler {

	@CanExecute
	public boolean canExecute() {
		return true;
	}

	@Execute
	public void execute(
			@Named("org.domainworkbench.commandparameter.emfCommand") Command emfCommand,
			@Named("org.domainworkbench.commandparameter.emfFeature") Object feature) {
		// emfCommand.execute();
//		System.out.println(emfCommand + "\n\t" + feature.toString());
		// System.out.println(emfCommand.getLabel() + " "
		// + emfCommand.getDescription());
		 System.out.println(emfCommand.getResult() + " " + feature.toString());

	}
}
