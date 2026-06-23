package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testPages.Handleframes;

public class HandleFramesTestcase {

	String firstiFrameName = "employeetable";
	String secondiFrameName = "popuppage";
	String thirdiFrameName = "registeruser";

	Handleframes hf = new Handleframes();

	@BeforeClass
	public void launchBrowser() throws IOException {

		hf.init("chrome");
	}

	@Test
	public void frameFunctions() {

		hf.handleFramesFunctions(firstiFrameName);
	}

}
