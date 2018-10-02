package myproject.pages;

import static myproject.steps.WebDriverUtils.waitForLoad;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import myproject.steps.WebDriverUtils;

public class BasketPage {
	private WebDriver driver;
	private WebDriverWait wait;
	public static final String PAGE_TITLE = "My basket";

	public BasketPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(css = ".pageTitleBlack")
	private WebElement pageTitle;

	@FindBy(css = ".checkoutSecurelyAndPunchoutNavigationDiv")
	private WebElement checkoutButton;

	@FindBy(css = "#loginModelPanel_container")
	private WebElement loginFrame;

	@FindBy(css = "#checkoutSecurelyAndPuchBtn")
	private WebElement proceedToCheckoutButton;

	public boolean isBasketPageTitleDisplayed() {
		waitForLoad(driver);
		System.out.println("**********************************" +pageTitle.getText());
		return pageTitle.getText().equals(PAGE_TITLE);
	}

	public void clickCheckout() {
		checkoutButton.click();
//		wait.wait(3000);
		waitForLoad(driver);
	}

	public boolean isLoginFrameDisplayed() {
		waitForLoad(driver);
		return loginFrame.isDisplayed();
	}

	public void proceedToCheckout() {
		proceedToCheckoutButton.click();
		waitForLoad(driver);
	}

	public void acceptFrame() {
		if(isAlertPresent())
		driver.switchTo().alert().accept();
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} 
		catch (NoAlertPresentException Ex) {
			return false;
		}
	}

}
