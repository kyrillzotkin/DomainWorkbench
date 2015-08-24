
package org.domainworkbench.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;

public class RemoveHandler {
	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) EObject selection, IEditingDomainProvider domainProvider) {
		Command cmd = RemoveCommand.create(domainProvider.getEditingDomain(), selection);
		if (cmd.canExecute())
			cmd.execute();
	}

	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) EObject selection) {
		return selection != null;
	}

}