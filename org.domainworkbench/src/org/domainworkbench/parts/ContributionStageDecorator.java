package org.domainworkbench.parts;

import org.classupplier.Contribution;
import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelDecorator;
import org.eclipse.swt.graphics.Image;

public class ContributionStageDecorator extends LabelDecorator implements ILabelDecorator {

	@Override
	public void addListener(ILabelProviderListener listener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {

	}

	@Override
	public Image decorateImage(Image image, Object element) {
		return null;
	}

	@Override
	public String decorateText(String text, Object element) {
		if (element instanceof Contribution) {
			return text + " [" + ((Contribution) element).getStage().toString().toLowerCase() + "]";
		}
		return null;
	}

	@Override
	public Image decorateImage(Image arg0, Object arg1, IDecorationContext arg2) {
		return null;
	}

	@Override
	public String decorateText(String text, Object element, IDecorationContext context) {
		if (element instanceof Contribution) {
			return text + " [" + ((Contribution) element).getStage().toString().toLowerCase() + "]";
		}
		return null;
	}

	@Override
	public boolean prepareDecoration(Object arg0, String arg1, IDecorationContext arg2) {
		return true;
	}
}
