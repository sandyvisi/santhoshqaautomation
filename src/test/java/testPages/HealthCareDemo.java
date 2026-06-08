package testPages;

import org.openqa.selenium.By;

import basePackage.BaseClass;

public class HealthCareDemo extends BaseClass {

	private By patientNameLocator = By.id("patient-name");
	private By patientIdLocator = By.id("patient-id");
	private By genderLocator = By.xpath("//input[@value='male']");
	private By symptomsLocator = By.xpath("//input[@value='headache']");
	private By submitLocator = By.xpath("//button[contains(text(),'Submit')]");

	public String id;

	private void enterPatientName(String patientName) {
		sendKeys(patientNameLocator, patientName);

	}

	private void checkIdFieldIsEnabled(String value) {

		if (!returnElement(patientIdLocator).isEnabled()) {

			id = returnAttributeValue(patientIdLocator, value);
			System.out.println(id);

		}

	}

	private void selectMaleGender() {
		click(genderLocator);

	}

	private void selectHeadeAcheSymptoms() {
		click(genderLocator);

	}

	private void submit() {
		click(submitLocator);

	}

	public void healthcareActions(String patientName, String value) {

		enterPatientName(patientName);
		checkIdFieldIsEnabled(value);
		selectMaleGender();
		selectHeadeAcheSymptoms();
		scrollDownToElement(submitLocator);
		submit();
	}

}
