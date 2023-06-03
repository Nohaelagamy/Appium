package Screens;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.TouchActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeScreen {
	private By mobileBtn   = By.xpath("//*[contains(@resource-id, 'btnmobileNumber')]");
	private By userNameFld = By.xpath("//*[contains(@resource-id, 'editText_username')]");
	private By passwordBtn = By.xpath("//*[contains(@resource-id, 'editText_password')");
	private By loginBtn    = By.xpath("//*[contains(@resource-id, 'button_login')]");
	private By NationalIdFld  = By.xpath("//*[contains(@resource-id, 'et_nationa_id')]");
	private By NationalIDConfirmBtn = By.xpath("//*[contains(@resource-id, 'btn_nation_id_confirm')]");

    private SHAFT.GUI.WebDriver mobile;

	public HomeScreen(SHAFT.GUI.WebDriver mobile) {
		this.mobile = mobile;
	}

	public HomeScreen dismissAlert() {
		// dismiss alert message
		new TouchActions((WebDriver) mobile)
				.performElementAction();

		return this;
	}

	// Generic method to click on navigation menu icons in home page
	public void clickOnNavigationMenuLinks(String navigationLink) {
		new TouchActions((WebDriver) mobile)
				//.tap(MobileBy.id(String.format(navigation_link, navigationLink)))
				.performElementAction();
	}



}
