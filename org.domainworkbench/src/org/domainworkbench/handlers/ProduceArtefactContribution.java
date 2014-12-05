package org.domainworkbench.handlers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.classupplier.Artefact;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.AboutToHide;
import org.eclipse.e4.ui.di.AboutToShow;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.MCommandsFactory;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;

public class ProduceArtefactContribution {

	@Inject
	protected IEditingDomainProvider editingDomainProvider;

	@Optional
	protected IEditingDomainItemProvider itemProvider;

	@Inject
	protected ECommandService commandService;

	private EObject eObject;

	@Inject
	public void setSelection(
			@Optional @Named(IServiceConstants.ACTIVE_SELECTION) EObject eObject) {
		this.eObject = eObject;
	}

	@AboutToShow
	public void aboutToShow(List<MMenuElement> items) {
		items.clear();
		if (eObject == null || !(eObject instanceof Artefact))
			return;
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("org.domainworkbench.commandparameter.artefact",
				(Artefact) eObject);
		MCommand mCommand = MCommandsFactory.INSTANCE.createCommand();
		mCommand.setElementId("org.domainworkbench.command.produceArtefact");
		Command command = commandService.getCommand(mCommand.getElementId());
		ParameterizedCommand parameterizedCommand = ParameterizedCommand
				.generateCommand(command, parameters);
		MHandledMenuItem menuItem = MMenuFactory.INSTANCE
				.createHandledMenuItem();
		menuItem.setCommand(mCommand);
		menuItem.setWbCommand(parameterizedCommand);
		menuItem.setLabel("Materialize");
		menuItem.setContributorURI("platform:/plugin/org.domainworkbench");
		items.add(menuItem);
	}

	@AboutToHide
	public void aboutToHide() {

	}

}
