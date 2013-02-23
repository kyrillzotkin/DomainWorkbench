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
public interface EDataTypePropertiesEditionPart {

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
	 * @return the instanceClassName
	 * 
	 */
	public String getInstanceClassName();

	/**
	 * Defines a new instanceClassName
	 * @param newValue the new instanceClassName to set
	 * 
	 */
	public void setInstanceClassName(String newValue);


	/**
	 * @return the instanceTypeName
	 * 
	 */
	public String getInstanceTypeName();

	/**
	 * Defines a new instanceTypeName
	 * @param newValue the new instanceTypeName to set
	 * 
	 */
	public void setInstanceTypeName(String newValue);


	/**
	 * @return the ePackage
	 * 
	 */
	public EObject getEPackage();

	/**
	 * Init the ePackage
	 * @param settings the combo setting
	 */
	public void initEPackage(EObjectFlatComboSettings settings);

	/**
	 * Defines a new ePackage
	 * @param newValue the new ePackage to set
	 * 
	 */
	public void setEPackage(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setEPackageButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the ePackage edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToEPackage(ViewerFilter filter);

	/**
	 * Adds the given filter to the ePackage edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToEPackage(ViewerFilter filter);


	/**
	 * @return the serializable
	 * 
	 */
	public Boolean getSerializable();

	/**
	 * Defines a new serializable
	 * @param newValue the new serializable to set
	 * 
	 */
	public void setSerializable(Boolean newValue);





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
