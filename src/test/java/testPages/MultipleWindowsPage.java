package testPages;

import org.openqa.selenium.By;

import basePackage.BaseClass;

public class MultipleWindowsPage extends BaseClass {

	private By newBrowserWindowLocator = By.name("newbrowserwindow123");
	private By newBrowserTabLocator = By.name("145newbrowsertab234");
	private By newMessageWindowLocator = By.name("123newmessagewindow321");

	private void clickWindowButton(By locator) {

		click(locator);

	}

	private void maxWindow() {

		driver.get().manage().window().maximize();

	}

	private void clickWindowTab(By locator) {

		click(locator);

	}

	private void switchToNewBrowserTab() {

		switchToNewTab();

	}

	private void clickNewBrowserWindowMessage(By locator) {

		click(locator);

	}

	private void switchToNewBrowserMessageWindow() {

		switchToNewWindow();

	}

	public void windoFunctions() {

		clickWindowButton(newBrowserWindowLocator);
		switchToNewWindow();

//		clickWindowTab(newBrowserTabLocator);
//		switchToNewBrowserTab();
//		clickNewBrowserWindowMessage(newMessageWindowLocator);
//		switchToNewBrowserMessageWindow();
	}

}
