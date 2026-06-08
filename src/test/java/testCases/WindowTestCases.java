package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testPages.MultipleWindowsPage;

public class WindowTestCases {

	MultipleWindowsPage windows = new MultipleWindowsPage();

	@BeforeMethod
	public void lauchBrowser() throws IOException {

		windows.init();

	}

	@Test
	public void multipleWindowsFunctions() {

		windows.windoFunctions();

	}

}
