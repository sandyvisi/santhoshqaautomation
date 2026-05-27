package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testPages.HealthCareDemo;
import utils.ExcelReader;

public class PatientFormTestcases {

	HealthCareDemo hdemo = new HealthCareDemo();

	@BeforeMethod()
	public void initBrowser() throws IOException {
		hdemo.init();
	}

	@Test(priority = 1, dataProvider = "patientData")
	public void healthCareActions(String patientName, String value) {

		hdemo.healthcareActions(patientName, value);
		System.out.println("Thread ID : " + Thread.currentThread().getId());

	}

	@DataProvider(name = "patientData", parallel = true)
	public Object[][] getPatientData() throws EncryptedDocumentException, IOException {

		return ExcelReader.excelDatas("patientDetails");

	}

	@AfterMethod()
	public void closeBrowser() {
		hdemo.tearDown();
	}

}
