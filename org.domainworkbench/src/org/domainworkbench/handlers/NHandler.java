 
package org.domainworkbench.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;

public class NHandler {
	@Execute
	public void execute(@Named("org.domainworkbench.commandparameter.0") Object v) {
		System.out.println(v);
		
	}
		
}