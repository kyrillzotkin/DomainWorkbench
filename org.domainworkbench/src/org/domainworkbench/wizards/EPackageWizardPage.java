package org.domainworkbench.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class EPackageWizardPage extends WizardPage {
	private Text nameText;

	private ModifyListener modifyListener = new ModifyListener() {

		@Override
		public void modifyText(ModifyEvent e) {
			if (isInputComplete())
				setPageComplete(true);
			if (e.getSource() == nameText) {
				nsPrefixText.setText(produceNsPrefix(nameText.getText()));
				nsURIText.setText(produceNsURI(nameText.getText()));
			}
		}

	};
	private Text nsPrefixText;
	private Text nsURIText;

	protected EPackageWizardPage() {
		super("EPackageWizardPage");
		setTitle("New Epackage");
		setDescription("Create the new EPackage");

	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(2, false));

		Label lblName = new Label(container, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		lblName.setText("Name:");

		nameText = new Text(container, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Label lblNsPrefix = new Label(container, SWT.NONE);
		lblNsPrefix.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblNsPrefix.setText("Ns Prefix:");

		nsPrefixText = new Text(container, SWT.BORDER);
		nsPrefixText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Label lblNsUri = new Label(container, SWT.NONE);
		lblNsUri.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblNsUri.setText("Ns URI:");

		nsURIText = new Text(container, SWT.BORDER);
		nsURIText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		nameText.addModifyListener(modifyListener);
		nsPrefixText.addModifyListener(modifyListener);
		nsURIText.addModifyListener(modifyListener);
	}

	private boolean isInputComplete() {
		return !nameText.getText().isEmpty()
				&& !nsPrefixText.getText().isEmpty()
				&& nsURIText.getText().matches("http:\\/\\/.+\\/.*");
	}

	private String produceNsPrefix(String name) {
		return name.replaceAll(" ", "").toLowerCase();
	}

	private String produceNsURI(String name) {
		return "http://" + name.replaceAll(" ", "") + "/1.0";
	}

	public String getName() {
		return nameText.getText();

	}

	public String getNsPrefix() {
		return nsPrefixText.getText();

	}

	public String getNsURI() {
		return nsURIText.getText();

	}

}
