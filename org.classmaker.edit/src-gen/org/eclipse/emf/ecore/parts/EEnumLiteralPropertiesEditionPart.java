/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface EEnumLiteralPropertiesEditionPart {

	/**
	 * @return the name
	 * 
	 */
	public String getName();

	/**
	 * Defines a new name
	 * @param newValue the new name to set
	 * 
	 */
	public void setName(String newValue);


	/**
	 * @return the value
	 * 
	 */
	public String getValue();

	/**
	 * Defines a new value
	 * @param newValue the new value to set
	 * 
	 */
	public void setValue(String newValue);


	/**
	 * @return the instance
	 * 
	 */
	public String getInstance();

	/**
	 * Defines a new instance
	 * @param newValue the new instance to set
	 * 
	 */
	public void setInstance(String newValue);


	/**
	 * @return the literal
	 * 
	 */
	public String getLiteral();

	/**
	 * Defines a new literal
	 * @param newValue the new literal to set
	 * 
	 */
	public void setLiteral(String newValue);


	/**
	 * @return the eEnum
	 * 
	 */
	public EObject getEEnum();

	/**
	 * Init the eEnum
	 * @param settings the combo setting
	 */
	public void initEEnum(EObjectFlatComboSettings settings);

	/**
	 * Defines a new eEnum
	 * @param newValue the new eEnum to set
	 * 
	 */
	public void setEEnum(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setEEnumButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the eEnum edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToEEnum(ViewerFilter filter);

	/**
	 * Adds the given filter to the eEnum edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToEEnum(ViewerFilter filter);





	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
