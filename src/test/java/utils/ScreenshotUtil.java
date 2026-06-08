package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import basePackage.BaseClass;

public class ScreenshotUtil {

	public static String getScreenshot(WebDriver driver, String name) throws IOException {

		if (driver == null) {

			throw new IllegalArgumentException("driver is null");
		}
		String timeStamp = new SimpleDateFormat("HH-mm-ss").format(new Date());
		String filePath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + timeStamp
				+ "_" + name + ".png";
		File destination = new File(filePath);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, destination);

		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception io) {
			io.printStackTrace();
		} finally {
			System.out.println("Screenshot is copied");
		}
		return filePath;
	}

}
