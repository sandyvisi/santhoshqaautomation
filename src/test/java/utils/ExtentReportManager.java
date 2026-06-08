package utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import basePackage.BaseClass;

public class ExtentReportManager extends BaseClass implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentReports;

	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	@Override
	public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("HH-mm-ss").format(new Date());
		String reportsPath = System.getProperty("user.dir") + "\\reports\\" + timeStamp + "automationreport.html";

		sparkReporter = new ExtentSparkReporter(reportsPath);
		sparkReporter.config().setDocumentTitle("Automation Document");
		sparkReporter.config().setReportName("Automation Report");
		sparkReporter.config().setTheme(Theme.STANDARD);

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);

		extentReports.setSystemInfo("Computer Name", "Santhoshkumar M");
		extentReports.setSystemInfo("Environment", "Test");
		extentReports.setSystemInfo("os", "windows11 pro");
		extentReports.setSystemInfo("Browser Name", "Chrome");
		extentReports.setSystemInfo("Tester Name", "Santhoshkumar M");

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("---------Test Method Execution is Started------");
		extentTest.set(extentReports.createTest(result.getName()));

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		extentTest.get().log(Status.PASS, "Test case is passed" + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {

		extentTest.get().log(Status.FAIL, "Test case is failed" + result.getName());
		extentTest.get().log(Status.FAIL, result.getThrowable());
		try {
			String path = ScreenshotUtil.getScreenshot(driver.get(), result.getName());
			if (path != null) {
				extentTest.get().addScreenCaptureFromPath(path);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "Test case is failed" + result.getName());

	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();

	}
}
