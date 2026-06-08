package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testPages.HandleDropDownsPage;

public class HandleDropDownsTestCases {

	HandleDropDownsPage dropdown = new HandleDropDownsPage();

	@BeforeMethod
	public void launchBrowser() throws IOException {

		dropdown.init();

	}

	@Test
	public void dropDown() {

		dropdown.dropDownHandleFunctions();

	}

}
