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
public interface EPackagePropertiesEditionPart {

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
	 * @return the nsURI
	 * 
	 */
	public String getNsURI();

	/**
	 * Defines a new nsURI
	 * @param newValue the new nsURI to set
	 * 
	 */
	public void setNsURI(String newValue);


	/**
	 * @return the nsPrefix
	 * 
	 */
	public String getNsPrefix();

	/**
	 * Defines a new nsPrefix
	 * @param newValue the new nsPrefix to set
	 * 
	 */
	public void setNsPrefix(String newValue);


	/**
	 * @return the eFactoryInstance
	 * 
	 */
	public EObject getEFactoryInstance();

	/**
	 * Init the eFactoryInstance
	 * @param settings the combo setting
	 */
	public void initEFactoryInstance(EObjectFlatComboSettings settings);

	/**
	 * Defines a new eFactoryInstance
	 * @param newValue the new eFactoryInstance to set
	 * 
	 */
	public void setEFactoryInstance(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setEFactoryInstanceButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the eFactoryInstance edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToEFactoryInstance(ViewerFilter filter);

	/**
	 * Adds the given filter to the eFactoryInstance edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToEFactoryInstance(ViewerFilter filter);


	/**
	 * @return the eSuperPackage
	 * 
	 */
	public EObject getESuperPackage();

	/**
	 * Init the eSuperPackage
	 * @param settings the combo setting
	 */
	public void initESuperPackage(EObjectFlatComboSettings settings);

	/**
	 * Defines a new eSuperPackage
	 * @param newValue the new eSuperPackage to set
	 * 
	 */
	public void setESuperPackage(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setESuperPackageButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the eSuperPackage edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToESuperPackage(ViewerFilter filter);

	/**
	 * Adds the given filter to the eSuperPackage edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToESuperPackage(ViewerFilter filter);





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
