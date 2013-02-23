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
public interface EOperationPropertiesEditionPart {

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
	 * @return the ordered
	 * 
	 */
	public Boolean getOrdered();

	/**
	 * Defines a new ordered
	 * @param newValue the new ordered to set
	 * 
	 */
	public void setOrdered(Boolean newValue);


	/**
	 * @return the unique
	 * 
	 */
	public Boolean getUnique();

	/**
	 * Defines a new unique
	 * @param newValue the new unique to set
	 * 
	 */
	public void setUnique(Boolean newValue);


	/**
	 * @return the lowerBound
	 * 
	 */
	public String getLowerBound();

	/**
	 * Defines a new lowerBound
	 * @param newValue the new lowerBound to set
	 * 
	 */
	public void setLowerBound(String newValue);


	/**
	 * @return the upperBound
	 * 
	 */
	public String getUpperBound();

	/**
	 * Defines a new upperBound
	 * @param newValue the new upperBound to set
	 * 
	 */
	public void setUpperBound(String newValue);


	/**
	 * @return the eType
	 * 
	 */
	public EObject getEType();

	/**
	 * Init the eType
	 * @param settings the combo setting
	 */
	public void initEType(EObjectFlatComboSettings settings);

	/**
	 * Defines a new eType
	 * @param newValue the new eType to set
	 * 
	 */
	public void setEType(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setETypeButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the eType edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToEType(ViewerFilter filter);

	/**
	 * Adds the given filter to the eType edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToEType(ViewerFilter filter);


	/**
	 * @return the eContainingClass
	 * 
	 */
	public EObject getEContainingClass();

	/**
	 * Init the eContainingClass
	 * @param settings the combo setting
	 */
	public void initEContainingClass(EObjectFlatComboSettings settings);

	/**
	 * Defines a new eContainingClass
	 * @param newValue the new eContainingClass to set
	 * 
	 */
	public void setEContainingClass(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setEContainingClassButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the eContainingClass edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToEContainingClass(ViewerFilter filter);

	/**
	 * Adds the given filter to the eContainingClass edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToEContainingClass(ViewerFilter filter);




	/**
	 * Init the eExceptions
	 * @param settings settings for the eExceptions ReferencesTable 
	 */
	public void initEExceptions(ReferencesTableSettings settings);

	/**
	 * Update the eExceptions
	 * @param newValue the eExceptions to update
	 * 
	 */
	public void updateEExceptions();

	/**
	 * Adds the given filter to the eExceptions edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToEExceptions(ViewerFilter filter);

	/**
	 * Adds the given filter to the eExceptions edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToEExceptions(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the eExceptions table
	 * 
	 */
	public boolean isContainedInEExceptionsTable(EObject element);




	/**
	 * Init the eGenericExceptions
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initEGenericExceptions(ReferencesTableSettings settings);

	/**
	 * Update the eGenericExceptions
	 * @param newValue the eGenericExceptions to update
	 * 
	 */
	public void updateEGenericExceptions();

	/**
	 * Adds the given filter to the eGenericExceptions edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToEGenericExceptions(ViewerFilter filter);

	/**
	 * Adds the given filter to the eGenericExceptions edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToEGenericExceptions(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the eGenericExceptions table
	 * 
	 */
	public boolean isContainedInEGenericExceptionsTable(EObject element);





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
