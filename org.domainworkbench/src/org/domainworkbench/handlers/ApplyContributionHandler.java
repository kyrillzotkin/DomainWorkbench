package org.domainworkbench.handlers;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;
import javax.inject.Named;

import org.classupplier.ClassSupplier;
import org.classupplier.Contribution;
import org.classupplier.Phase;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;

public class ApplyContributionHandler {

	@Inject
	protected ClassSupplier classupplier;

	@CanExecute
	public boolean canExecute(@Named(IServiceConstants.ACTIVE_SELECTION) EObject selection) {
		return (selection != null && selection instanceof Contribution)
				|| classupplier.getWorkspace().getContribution(selection) != null;
	}

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SELECTION) final EObject selection,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
		dialog.open();

		try {
			dialog.run(true, true, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					Contribution contribution = null;
					if (selection instanceof Contribution)
						contribution = ((Contribution) selection);
					else
						contribution = classupplier.getWorkspace().getContribution(selection);

					if (contribution != null) {
						if (contribution.getStage().getValue() > Phase.MODELED_VALUE)
							contribution.newState();
						contribution.apply(monitor);
					}
				}
			});
		} catch (InvocationTargetException e) {
			MessageDialog.openError(shell, "Error", e.getLocalizedMessage());
		} catch (InterruptedException e) {
			MessageDialog.openError(shell, "Error", e.getLocalizedMessage());
		}
	}
}
