package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	protected static WebDriverWait explicitWait;
	protected static Properties properties;
	protected static String propertiesFilePath = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "resources" + File.separator + "configProperties.properties";
//	src\test\resources\configProperties.properties
	protected static FileInputStream fis;
	protected static Select select;
	protected static JavascriptExecutor js;

	public void init() throws IOException {
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("autofill.profile_enabled", false);
		prefs.put("autofill.credit_card_enabled", false);
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("profile.default_content_setting_values.popups", 2);
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-popup-blocking");

		options.setExperimentalOption("prefs", prefs);
		fis = new FileInputStream(propertiesFilePath);
		properties = new Properties();
		properties.load(fis);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(properties.getProperty("registrationFormUrl"));

		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		js = (JavascriptExecutor) driver;
		fis.close();

	}

	public String getOnlyNumbers(String text) {

		char[] ch = text.toCharArray();
		int size = ch.length;
		String code = "";

		for (int a = 0; a < size; a++) {

			if (Character.isDigit(ch[a])) {
				code = code + ch[a];
			}

		}

		return code;

	}

	public void jsClick(By locator) {

		WebElement element = explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollToBottom() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}

	public WebElement returnElement(By locator) {
		return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForVisibility(By locator) {

		return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public String getElementText(By locator) {

		return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();

	}

	public void moveToAlertAndAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void alertClose() {
		try {
			Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
			alert.dismiss();
		} catch (TimeoutException e) {
			System.out.println("No alert present within the given time.");
			e.printStackTrace();
		}
	}

	public void elementVisibleClose(By locator) {
		try {
			WebElement popup = explicitWait.until(ExpectedConditions.presenceOfElementLocated(locator));
			popup.click();

		} catch (TimeoutException e) {
			System.out.println("Element not visible: " + locator);
			throw e;
		} catch (Exception e) {
			System.out.println("Unexpected error while clicking element: " + locator);
			throw e;
		}
	}

	public void scrollDownToElement(By locator) {
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
	}

	public void selectList(By locator, String text) {
		select = new Select(driver.findElement(locator));
		select.selectByVisibleText(text);

	}

	public String webElementWaitGetText(By locator) {

		WebElement headerElement = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return headerElement.getText();

	}

	public void click(By locator) {

		explicitWait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public void sendKeys(By locator, String text) {

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
	}

}
