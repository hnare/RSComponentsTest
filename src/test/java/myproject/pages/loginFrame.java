package myproject.pages;

import static myproject.steps.WebDriverUtils.waitForLoad;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginFrame {
	
	private static WebDriver driver;
	private WebDriverWait wait;
	public loginFrame(WebDriver driver){
		this.driver = driver;
	}
	private static final String EMAIL = "testhdg@test.com";
	
	@FindBy(css = ".emailAddress")
	private WebElement emailInput;
	
	@FindBy(css = "input.redButton[value*='Guest checkout']")
	private WebElement guestCheckoutButton;
	
	public void populateEmail() throws InterruptedException {
		emailInput.clear();
		emailInput.sendKeys(EMAIL);
		Thread.sleep(3000);
	}


	public void clickGuestCheckout() throws InterruptedException {
		clickByJavaScript(guestCheckoutButton);
		
//		guestCheckoutButton.click();
		wait.wait(5000);
	}
	
	public static void clickByJavaScript(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void acceptFrame() {
		if(isAlertPresent())
		driver.switchTo().alert().dismiss();
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
