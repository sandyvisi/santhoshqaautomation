package stepDefinitions;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testPages.RegisterFormPage;
import utils.ExcelReader;
import utils.ExcelReaderCucumber;

public class FillingForms {

	RegisterFormPage regform = new RegisterFormPage();

	@Given("user launches the url")
	public void launchBrowser() throws IOException {
		regform.init();
	}

	@When("user gets data using {string}")
	public void getDataFromExcel() throws EncryptedDocumentException, IOException {

		Map<String, String> formDatas = ExcelReaderCucumber.getCellData("regforms", "TC_01");

		String tcid = formDatas.get("TC_ID");
		String firstName = formDatas.get("firstName");
		String lastName = formDatas.get("lastName");
		String address = formDatas.get("address");
		String street = formDatas.get("street");
		String email = formDatas.get("email");

		regform.registerForm(tcid, firstName, lastName, address, street, email);

	}

	@Then("user clicks submit button")
	public void userCompleted() {
		System.out.println("form is filled");

	}

}
