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
public interface EGenericTypePropertiesEditionPart {



	/**
	 * Init the eTypeArguments
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initETypeArguments(ReferencesTableSettings settings);

	/**
	 * Update the eTypeArguments
	 * @param newValue the eTypeArguments to update
	 * 
	 */
	public void updateETypeArguments();

	/**
	 * Adds the given filter to the eTypeArguments edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToETypeArguments(ViewerFilter filter);

	/**
	 * Adds the given filter to the eTypeArguments edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToETypeArguments(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the eTypeArguments table
	 * 
	 */
	public boolean isContainedInETypeArgumentsTable(EObject element);


	/**
	 * @return the eTypeParameter
	 * 
	 */
	public EObject getETypeParameter();

	/**
	 * Init the eTypeParameter
	 * @param settings the combo setting
	 */
	public void initETypeParameter(EObjectFlatComboSettings settings);

	/**
	 * Defines a new eTypeParameter
	 * @param newValue the new eTypeParameter to set
	 * 
	 */
	public void setETypeParameter(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setETypeParameterButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the eTypeParameter edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToETypeParameter(ViewerFilter filter);

	/**
	 * Adds the given filter to the eTypeParameter edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToETypeParameter(ViewerFilter filter);


	/**
	 * @return the eClassifier
	 * 
	 */
	public EObject getEClassifier();

	/**
	 * Init the eClassifier
	 * @param settings the combo setting
	 */
	public void initEClassifier(EObjectFlatComboSettings settings);

	/**
	 * Defines a new eClassifier
	 * @param newValue the new eClassifier to set
	 * 
	 */
	public void setEClassifier(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setEClassifierButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the eClassifier edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToEClassifier(ViewerFilter filter);

	/**
	 * Adds the given filter to the eClassifier edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToEClassifier(ViewerFilter filter);





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
