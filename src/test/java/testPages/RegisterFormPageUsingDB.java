package testPages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackage.BaseClass;

public class RegisterFormPageUsingDB extends BaseClass {

	public String code;
	public String codeText;
	public WebElement element;

	private By firstNameLocator = By.id("vfb-5");
	private By lastNameLocator = By.id("vfb-7");
	private By maleLocator = By.id("vfb-31-1");
	private By seleniumCheckboxLocator = By.id("vfb-20-0");
	private By uncheckCheckboxLocator = By.id("vfb-20-3");
	private By streetAddressLocator = By.id("vfb-13-address");
	private By apartmentLocator = By.id("vfb-13-address-2");
	private By cityLocator = By.id("vfb-13-city");
	private By stateLocator = By.id("vfb-13-state");
	private By postalCodeLocator = By.id("vfb-13-zip");

	private By countryListLocator = By.xpath("//span/ul[@id='select2-vfb-13-country-results']/li");

	private By countryContainerLocator = By.xpath("//span[@id='select2-vfb-13-country-container']/parent::span");

	private By searchCountryByentryLocator = By.xpath("//input[@class='select2-search__field']");

	private By waitForEnteredCountryLocator = By.xpath("//span[@id='select2-vfb-13-country-container']/parent::span");

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

		sendKeys(streetAddressLocator, address);
	}

	private void enterStreet(String street) {
		sendKeys(apartmentLocator, street);
	}

	private void enterCity(String city) {
		sendKeys(cityLocator, city);
	}

	private void enterState(String state) {
		sendKeys(stateLocator, state);
	}

	private void enterPostalcode(String postalcode) {
		sendKeys(postalCodeLocator, postalcode);
	}

	private void clickCtryDropdown() {
		click(countryContainerLocator);
	}

	private void enterCtryName(String ctry) {
		sendKeys(searchCountryByentryLocator, ctry);
	}

	private void clickSearchedCtry() {
		click(waitForEnteredCountryLocator);
	}

	private void enterEmail(String email) {

		sendKeys(emailLocator, email);

	}

	private void selectAcountry(String countryName) {

		List<WebElement> listOfcountries = checkVisibilityOfAllElements(countryListLocator);
		for (WebElement country : listOfcountries) {
			if (country.getText().equals("India")) {
				elementClickable(country);
				break;
			}

		}

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

	public void registerForm(String firstName, String lastName, String address, String street, String email,
			String city, String state, String postalcode, String ctry) {

		enterFirstName(firstName);
		enterLastName(lastName);
		clickMale();
		selectSeleniumCheckBox();
		uncheckDevopsCheckBox();
		enterAddress(address);
		enterStreet(street);
		enterCity(city);
		enterState(state);
		enterPostalcode(postalcode);
		clickCtryDropdown();
//		enterCtryName(ctry);
//		clickSearchedCtry();
		selectAcountry(ctry);
		enterEmail(email);
		waitForCodeVisible();
		getText();
		getCode();
		System.out.println("code text is :" + codeText + " ============ " + "code is :" + code);
		enterCode(code);
		scrollDownToSubmit();
		clickSubmit();
		successElement();
		assertElementIsAvailable();

	}

}
