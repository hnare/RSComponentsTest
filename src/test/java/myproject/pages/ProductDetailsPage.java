package myproject.pages;

import static myproject.steps.WebDriverUtils.waitForLoad;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import myproject.steps.WebDriverUtils;

public class ProductDetailsPage {
	private WebDriver driver;
	private String pageUrl;
	protected WebDriverWait wait;
	public WebDriverUtils utils;
	private static final String PATH = "/p/";
	
	@FindBy(css = ".add-to-basket-container")
	private WebElement addBasketButton;
	
	@FindBy(css = ".icon-cart")
	private WebElement visitBasket;

	public ProductDetailsPage(WebDriver driver){
		this.driver = driver;
	}

	public void clickAddToBasketButton() {
		addBasketButton.click();	
	}

	public void visitBasketPage() {
		waitForLoad(driver);
		visitBasket.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addItem(String itemCode) {
		setPageUrl(PATH + itemCode);
	}
	
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
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
