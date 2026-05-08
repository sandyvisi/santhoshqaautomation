package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import testPages.RegisterFormPage;
import utils.ExcelReader;

public class RegistrationFormTescases {

	BaseClass base = new BaseClass();
	RegisterFormPage regForm = new RegisterFormPage();

	@BeforeMethod
	public void launchBrowser() throws IOException {
		base.init();
	}

	@Test(priority = 1, dataProvider = "regform", invocationCount = 4)
	public void regFormFunctions(String firstName, String lastName, String address, String street, String email) {
		regForm.registerForm(firstName, lastName, address, street, email);
	}

	@DataProvider(name = "regform")
	public Object[][] regFormdatas() throws EncryptedDocumentException, IOException {
		return ExcelReader.excelDatas("regforms");
	}

}
