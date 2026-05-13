package stepDefinitions;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testPages.RegisterFormPage;
import utils.ExcelReaderCucumber;

public class RegFormPage {

	RegisterFormPage regform = new RegisterFormPage();

	@Given("user launches the url")
	public void launchBrowser() throws IOException {
		regform.init();
	}

	@When("user gets data using {string}")
	public void getDataFromSheet(String testcaseid) throws EncryptedDocumentException, IOException {

		Map<String, String> eachKey = ExcelReaderCucumber.getCellData("regforms", testcaseid);
		String firstName = eachKey.get("firstName");
		String lastName = eachKey.get("lastName");
		String address = eachKey.get("address");
		String street = eachKey.get("street");
		String email = eachKey.get("email");

		regform.registerForm(testcaseid, firstName, lastName, address, street, email);

	}

	@Then("user clicks submit button")
	public void clickSubmit() {

		System.out.println("cucumber executed");

	}

}
