package testPages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.BaseClass;

public class RegisterFormPage extends BaseClass {

	public String code;
	public String codeText;
	public WebElement element;

	private By firstNameLocator = By.id("vfb-5");
	private By lastNameLocator = By.id("vfb-7");
	private By maleLocator = By.id("vfb-31-1");
	private By seleniumCheckboxLocator = By.id("vfb-20-0");
	private By uncheckCheckboxLocator = By.id("vfb-20-3");
	private By addressFieldLocator = By.id("vfb-13-address");
	private By streetLocator = By.id("vfb-13-address-2");
	private By emailLocator = By.id("vfb-14");
	private By verificationCodeLocator = By.xpath("//input[@id='vfb-3']/following-sibling::label");

	private By enterNumberLocator = By.id("vfb-3");
	private By submitLocator = By.xpath("//fieldset[@id='item-vfb-2']//ul//li/input[@id='vfb-4']");
	private By regFormSuccessMessageLocator = By.xpath("//div[@id='messageContainer']");

	private void enterFirstName(String firstName) {
		sendKeys(firstNameLocator, firstName);
	}

	private void enterLastName(String lastName) {
		sendKeys(lastNameLocator, lastName);
	}

	private void clickMale() {
		click(maleLocator);
	}

	private void selectSeleniumCheckBox() {
		click(seleniumCheckboxLocator);
	}

	private void uncheckDevopsCheckBox() {
		click(uncheckCheckboxLocator);
	}

	private void enterAddress(String address) {

		sendKeys(addressFieldLocator, address);
	}

	private void enterStreet(String street) {
		sendKeys(streetLocator, street);
	}

	private void enterEmail(String email) {

		sendKeys(emailLocator, email);

	}

	private void waitForCodeVisible() {
		waitForVisibility(verificationCodeLocator);
	}

	private void getText() {
		codeText = getElementText(verificationCodeLocator);
	}

	private void getCode() {
		code = getOnlyNumbers(codeText);
	}

	private void scrollDown() {
		scrollDownToElement(enterNumberLocator);
	}

	private void enterCode(String code) {
		sendKeys(enterNumberLocator, code);
	}

	private void scrollDownToSubmit() {
		scrollToBottom();
	}

	private void clickSubmit() {
		jsClick(submitLocator);
	}

	private void successElement() {
		element = returnElement(regFormSuccessMessageLocator);

	}

	private void assertElementIsAvailable() {

		WebElement element = waitForVisibility(regFormSuccessMessageLocator);
		Assert.assertTrue(element.isDisplayed());
		System.out.println(element.getText());

	}

	public void registerForm(String tcID, String firstName, String lastName, String address, String street,
			String email) {

		enterFirstName(firstName);
		enterLastName(lastName);
		clickMale();
		selectSeleniumCheckBox();
		uncheckDevopsCheckBox();
		enterAddress(address);
		enterStreet(street);
		enterEmail(email);
		waitForCodeVisible();
		getText();
		getCode();
		System.out.println("code text is :" + codeText + " <------>" + "code is :" + code);
		enterCode(code);
		scrollDownToSubmit();
		clickSubmit();
		successElement();
		assertElementIsAvailable();

		System.out.println("code is compelted");

	}

}
