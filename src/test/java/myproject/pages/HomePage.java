package myproject.pages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
    @FindBy(css = "#searchTerm")
    private WebElement inputSearch;
    
    @FindBy(css = "#btnSearch")
    private WebElement searchButton;

	
	private WebDriver driver;

	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public void search(String itemCode) {
		inputSearch.sendKeys(itemCode);
		searchButton.click();
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
