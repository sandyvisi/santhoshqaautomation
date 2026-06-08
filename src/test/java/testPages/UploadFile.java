package testPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	public static void main(String[] args) throws AWTException, InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://leafground.com/file.xhtml");

//		driver.findElement(By.id("j_idt88:j_idt89_input")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", driver.findElement(By.id("j_idt88:j_idt89_input")));

		Thread.sleep(2000);

		String filePath = "D:\\files\\santhoshviin.txt";

		StringSelection file = new StringSelection(filePath);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);

		Robot rb = new Robot();

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(2000);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

	}

}
