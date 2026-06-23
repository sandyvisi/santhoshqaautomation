package testPages;

import org.openqa.selenium.By;

import basePackage.BaseClass;

public class Handleframes extends BaseClass {

	private By fNameLocator = By.xpath("//table[@id='details']//td/input[@id='nameInput']");

	private void switchToIframe(String firstName) {
		switchToFrameUsingName(firstName);
	}

	private void enterFirstName(By locator, String firstName) {
		sendKeys(locator, firstName);
	}

	public void handleFramesFunctions(String firstName) {

		switchToIframe(firstName);
		enterFirstName(fNameLocator, "santhosh");

	}

}
