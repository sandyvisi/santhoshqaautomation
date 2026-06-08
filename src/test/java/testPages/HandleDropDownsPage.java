package testPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import basePackage.BaseClass;

public class HandleDropDownsPage extends BaseClass {

	private By cityDropDown = By.id("select2-simpleDropdown-container");

	private By cityDropDownLists = By.xpath("//ul[@id='select2-simpleDropdown-results']/li[position()>1]");

	private void clickCityDropDown(By locator) {
		click(locator);

	}

	private void printAllTheOptions(By locator) {

		List<WebElement> cityLists = getLists(locator);

		for (WebElement ele : cityLists) {

			if (ele.getText().equals("Tokyo")) {
				ele.click();
				break;

			}

		}

	}

	public void dropDownHandleFunctions() {

		clickCityDropDown(cityDropDown);
		printAllTheOptions(cityDropDownLists);

	}

}
