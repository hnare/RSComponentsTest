package myproject.pages;

import static myproject.steps.WebDriverUtils.waitForLoad;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	private static final CharSequence USERNAME = "userhimani";
	private static final CharSequence PASSWORD = "Mpl1003496*";

	private static WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	
	@FindBy(name = "username")
	private WebElement userNameInput;
	
	@FindBy(name = "j_password")
	private WebElement passwordInput;
	
	@FindBy(css = ".regButton")
	private WebElement loginButton;

	
	
	public void populateLoginDetails() {
		userNameInput.clear();
		userNameInput.sendKeys(USERNAME);
		passwordInput.clear();
		passwordInput.sendKeys(PASSWORD);
	}

	public void clickLogin() {
		loginButton.click();
		waitForLoad(driver);
	}

}
