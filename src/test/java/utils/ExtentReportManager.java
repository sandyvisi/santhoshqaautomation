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

public class ExtentReportManager implements ITestListener {

	String timeStamp = new SimpleDateFormat("HH-mm-ss").format(new Date());

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;

	public String reportsPath = System.getProperty("user.dir") + "\\reports\\" + timeStamp + "report.html";

	@Override
	public void onStart(ITestContext context) {
		sparkReporter = new ExtentSparkReporter(reportsPath);
		sparkReporter.config().setDocumentTitle("Smoke Test Document");
		sparkReporter.config().setReportName("smoke report");
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
		extentTest = extentReports.createTest(result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.PASS, "Test case is passed" + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {

		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.FAIL, "Test case is failed" + result.getName());
		extentTest.log(Status.FAIL, result.getThrowable());
		try {
			String path = ScreenshotUtil.getScreenshot(result.getName());
			extentTest.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.SKIP, "Test case is failed" + result.getName());

	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();

	}
}
