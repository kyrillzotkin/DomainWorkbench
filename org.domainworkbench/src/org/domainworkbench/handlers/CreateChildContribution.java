
package org.domainworkbench.handlers;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ParameterType;
import org.eclipse.core.commands.ParameterValueConversionException;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.AboutToShow;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.MCommandParameter;
import org.eclipse.e4.ui.model.application.commands.MParameter;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;

public class CreateChildContribution {

	@Inject
	protected EModelService modelService;

	@Inject
	protected ECommandService commandService;

	@Inject
	protected EHandlerService handlerService;

	@Inject
	protected IEditingDomainProvider provider;

	@Optional
	protected IEditingDomainItemProvider itemProvider;

	private EObject eObject;

	@Inject
	public void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) EObject eObject) {
		this.eObject = eObject;
	}

	@AboutToShow
	public void aboutToShow(List<MMenuElement> items, MApplication app) {
		items.clear();
		if (eObject == null)
			return;

		EditingDomain domain = provider.getEditingDomain();

		Collection<?> newChildDescriptors = domain.getNewChildDescriptors(eObject, null);

		if (newChildDescriptors == null)
			return;
		MCommand mCommand = null;

		for (MCommand c : app.getCommands())
			if (c.getElementId().equals(Constants.COMMAND_ID))
				mCommand = c;

		if (mCommand == null) {
			System.out.println("MCommand not found");
			return;
		}
		MCommandParameter mParam = null;
		for (MCommandParameter param : mCommand.getParameters())
			if (param.getElementId().equals(Constants.COMMAND_PARAMETER_ID))
				mParam = param;

		if (mParam == null) {
			System.out.println("MCommandParameter not found");
			return;
		}

		handlerService.activateHandler(mCommand.getElementId(), new CreateChildHandler());

		for (Object descriptor : newChildDescriptors) {
			org.eclipse.emf.common.command.Command emfCommand = CreateChildCommand.create(domain, itemProvider,
					descriptor, Collections.singletonList(eObject));

			Command command = commandService.getCommand(mCommand.getElementId());
			Map<String, Object> parameters = new HashMap<String, Object>();
			MParameter parameter = modelService.createModelElement(MParameter.class);
			parameter.setName(mParam.getElementId());
			String value;
			try {
				ParameterType type = command.getParameterType(mParam.getElementId());
				value = type.getValueConverter().convertToString(emfCommand);
				parameter.setValue(value);
			} catch (ParameterValueConversionException e) {
				e.printStackTrace();
			} catch (NotDefinedException e) {
				e.printStackTrace();
			}

			parameters.put(Constants.OBJECT_PARAMETER_ID, eObject);
			parameters.put(Constants.COMMAND_PARAMETER_ID, emfCommand);
			parameters.put(Constants.FEATURE_PARAMETER_ID, descriptor);
			ParameterizedCommand parameterizedCommand = commandService.createCommand(command.getId(), parameters);

			MHandledMenuItem menuItem = modelService.createModelElement(MHandledMenuItem.class);
			menuItem.setToBeRendered(true);
			menuItem.setLabel(emfCommand.getLabel());
			menuItem.setContributorURI("platform:/plugin/org.domainworkbench");
			menuItem.getParameters().add(parameter);
			menuItem.setCommand(mCommand);
			menuItem.setWbCommand(parameterizedCommand);
			items.add(menuItem);
		}
	}

}