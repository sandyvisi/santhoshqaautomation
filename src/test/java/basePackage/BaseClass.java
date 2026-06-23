package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public Properties properties;

	protected WebDriverWait explicitWait;

	protected String propertiesFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "test" + File.separator + "resources" + File.separator + "configProperties.properties";
//	src\test\resources\configProperties.properties

	protected JavascriptExecutor js;

	public void init(String browser) throws IOException {

		FileInputStream fis = new FileInputStream(propertiesFilePath);
		properties = new Properties();
		properties.load(fis);

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());

		}

		else if (browser.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());

		} else {
			System.out.println("No proper browser is being called");
		}

//		driver.get().get(properties.getProperty("registrationFormUrl"));
//		driver.get().get(properties.getProperty("healthCareUrl"));
//		driver.get().get(properties.getProperty("multiplewindow"));
//		driver.get().get(properties.getProperty("handledropdowns"));
		driver.get().get(properties.getProperty("handleframes"));
		driver.get().manage().window().maximize();
		driver.get().manage().deleteAllCookies();

		explicitWait = new WebDriverWait(driver.get(), Duration.ofSeconds(30));
		js = (JavascriptExecutor) driver.get();
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

	public void switchToParentFrame() {

		driver.get().switchTo().parentFrame();
	}

	public void switchToDefaultContent() {

		driver.get().switchTo().defaultContent();
	}

	public void switchToFrameUsingName(String name) {

		driver.get().switchTo().frame(name);

	}

	public List<WebElement> checkVisibilityOfAllElements(By locator) {

		List<WebElement> allelements = explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return allelements;
	}

	public void jsClick(By locator) {

		WebElement element = explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollToBottom() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}

	public void elementClickable(WebElement element) {
		WebElement clickElement = explicitWait.until(ExpectedConditions.elementToBeClickable(element));
		clickElement.click();
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
		Alert alert = driver.get().switchTo().alert();
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

	public String returnAttributeValue(By locator, String attribute) {

		WebElement element = driver.get().findElement(locator);
		return element.getAttribute(attribute);

	}

	public void scrollDownToElement(By locator) {
		WebElement element = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void selectList(By locator, String text) {
		Select select = new Select(driver.get().findElement(locator));
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

	public String getCurrentWinId() {
		return driver.get().getWindowHandle();

	}

	public void switchToNewWindow() {
		Set<String> mul = driver.get().getWindowHandles();

		for (String win : mul) {

			if (!getCurrentWinId().equals(win)) {

				driver.get().switchTo().window(win);
				driver.get().manage().window().maximize();

			}

		}

	}

	public void switchToNewTab() {
		driver.get().switchTo().newWindow(WindowType.TAB);

	}

	public List<WebElement> getLists(By locator) {

		return driver.get().findElements(locator);

	}

	public String gettextOfElement(WebElement element) {

		return element.getText();

	}

	public void tearDown() {

		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}

	}

}
