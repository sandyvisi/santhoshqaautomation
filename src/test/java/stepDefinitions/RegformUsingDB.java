package stepDefinitions;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testPages.RegisterFormPage;
import testPages.RegisterFormPageUsingDB;
import utils.DBConnect;
import utils.ExcelReaderCucumber;

public class RegformUsingDB {

	RegisterFormPageUsingDB regform = new RegisterFormPageUsingDB();
	String testcaseid = null;
	String firstName = null;
	String lastName = null;
	String address = null;
	String street = null;
	String email = null;
	String city = null;
	String state = null;
	String country = null;
	String postalcode = null;

	@Given("user launches the url")
	public void launchBrowser() throws IOException {
		regform.init();
	}

	@When("user gets data using DB")
	public void getDataFromSheet() throws EncryptedDocumentException, IOException, SQLException {

		DBConnect.connectDB();

		ResultSet rs = DBConnect.getDataByStringCondition("registrationform", "testcase_id", "TC_02");

		if (rs.next()) {

			testcaseid = rs.getString("testcase_id");
			firstName = rs.getString("firstname");
			lastName = rs.getString("lastname");
			address = rs.getString("address");
			street = rs.getString("streetaddress");
			city = rs.getString("city");
			state = rs.getString("state");
			postalcode = rs.getString("postalcode");
			email = rs.getString("email");
			country = rs.getString("country");
		}

		System.out.println(testcaseid);
		System.out.println("TC_01");

		regform.registerForm(firstName, lastName, address, street, email, city, state, postalcode, country);

	}

	@When("Except email field enter all other details")
	public void getDataFromDB() throws SQLException {
		DBConnect.connectDB();

		ResultSet rs = DBConnect.getDataByStringCondition("registrationform", "testcase_id", "TC_01");

		if (rs.next()) {

			testcaseid = rs.getString("testcase_id");
			firstName = rs.getString("firstname");
			lastName = rs.getString("lastname");
			address = rs.getString("address");
			street = rs.getString("streetaddress");
			city = rs.getString("city");
			state = rs.getString("state");
			postalcode = rs.getString("postalcode");
			email = rs.getString("email");
			country = rs.getString("country");

		}

		regform.registerForm(firstName, lastName, address, street, email, city, state, postalcode, country);

	}

	@When("the form should not submitted")
	public void formNotSubmitted() {
		 DBConnect.closeDB();
	}

	@Then("user clicks submit button")
	public void user_clicks_submit_button() {
		System.out.println("the db is executed successfully");
		DBConnect.closeDB();
	}

}
