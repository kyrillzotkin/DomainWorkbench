
package org.domainworkbench.handlers;

import org.eclipse.core.commands.ParameterType;
import org.eclipse.core.commands.ParameterValueConversionException;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;

public class CreateChildHandler {

	private ECommandService commandService;

	@Execute
	public void execute(ParameterizedCommand command, IEditingDomainProvider provider, ECommandService commandService) {
		this.commandService = commandService;
		Object obj = null;
		Command cmd = null;
		Object feature = null;
		obj = convertParameter(command, Constants.OBJECT_PARAMETER_ID);
		cmd = (Command) convertParameter(command, Constants.COMMAND_PARAMETER_ID);
		feature = convertParameter(command, Constants.FEATURE_PARAMETER_ID);
		if (cmd.canExecute())
			cmd.execute();
		Command addCmd = AddCommand.create(provider.getEditingDomain(), obj, feature, cmd.getResult());
		if (addCmd.canExecute())
			addCmd.execute();
	}

	public Object convertParameter(ParameterizedCommand command, String parameterId) {
		String parameterValue = (String) command.getParameterMap().get(parameterId);
		org.eclipse.core.commands.Command c = commandService.getCommand(Constants.COMMAND_ID);
		Object result = null;
		ParameterType type;
		try {
			type = c.getParameterType(parameterId);
			result = type.getValueConverter().convertToObject(parameterValue);
		} catch (ParameterValueConversionException e) {
			e.printStackTrace();
		} catch (NotDefinedException e) {
			e.printStackTrace();
		}
		return result;
	}

}