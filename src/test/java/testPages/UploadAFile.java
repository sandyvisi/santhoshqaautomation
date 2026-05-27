package testPages;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UploadAFile {

	public static void main(String[] args) throws MalformedURLException {

		String huburl = "http://192.168.0.231:4444/wd/hub";

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setPlatform(Platform.WINDOWS);

		caps.setBrowserName("chrome");

		URL gridUrl = new URL(huburl);

		WebDriver driver = new RemoteWebDriver(gridUrl, caps);

		driver.get("https://www.naukri.com");

	}

}
