package testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Threadd {

	ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public void setDriver() {

		driver.set(new ChromeDriver());

	}

	public WebDriver getDriver() {

		return driver.get();

	}

	public static void main(String[] args) {

		Threadd threaddd = new Threadd();
		threaddd.setDriver();
		threaddd.getDriver().manage().window().maximize();
		threaddd.getDriver().get("https://chatgpt.com/");
		
		Long l = Thread.currentThread().getId();
		System.out.println(l);

		threaddd.setDriver();
		threaddd.getDriver().manage().window().maximize();
		threaddd.getDriver().get("https://internet-banking.retail.dbsbank.in/login");
		Long l1 = Thread.currentThread().getId();
		System.out.println(l1);
	}

}
