/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecore.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface EClassPropertiesEditionPart {

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
	 * @return the abstract
	 * 
	 */
	public Boolean getAbstract_();

	/**
	 * Defines a new abstract
	 * @param newValue the new abstract to set
	 * 
	 */
	public void setAbstract_(Boolean newValue);


	/**
	 * @return the interface
	 * 
	 */
	public Boolean getInterface_();

	/**
	 * Defines a new interface
	 * @param newValue the new interface to set
	 * 
	 */
	public void setInterface_(Boolean newValue);




	/**
	 * Init the eSuperTypes
	 * @param settings settings for the eSuperTypes ReferencesTable 
	 */
	public void initESuperTypes(ReferencesTableSettings settings);

	/**
	 * Update the eSuperTypes
	 * @param newValue the eSuperTypes to update
	 * 
	 */
	public void updateESuperTypes();

	/**
	 * Adds the given filter to the eSuperTypes edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToESuperTypes(ViewerFilter filter);

	/**
	 * Adds the given filter to the eSuperTypes edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToESuperTypes(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the eSuperTypes table
	 * 
	 */
	public boolean isContainedInESuperTypesTable(EObject element);




	/**
	 * Init the eGenericSuperTypes
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initEGenericSuperTypes(ReferencesTableSettings settings);

	/**
	 * Update the eGenericSuperTypes
	 * @param newValue the eGenericSuperTypes to update
	 * 
	 */
	public void updateEGenericSuperTypes();

	/**
	 * Adds the given filter to the eGenericSuperTypes edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToEGenericSuperTypes(ViewerFilter filter);

	/**
	 * Adds the given filter to the eGenericSuperTypes edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToEGenericSuperTypes(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the eGenericSuperTypes table
	 * 
	 */
	public boolean isContainedInEGenericSuperTypesTable(EObject element);





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
