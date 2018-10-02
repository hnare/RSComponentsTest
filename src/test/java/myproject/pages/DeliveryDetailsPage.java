package myproject.pages;

import static myproject.steps.WebDriverUtils.waitForLoad;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import myproject.utils.Customer;

public class DeliveryDetailsPage {
	
	private static WebDriver driver;
	public DeliveryDetailsPage(WebDriver driver){
		this.driver = driver;
	}
	
	@FindBy(css = "select.title")
	private WebElement titledropDown;

	@FindBy(css = ".firstName")
	private WebElement firstNameInput;
	
	@FindBy(css = ".surName")
	private WebElement surNameInput;
	
	@FindBy(css = ".contactNumber")
	private WebElement mobileInput;

	@FindBy(css = ".addressLineOne")
	private WebElement address1Input;
	
	@FindBy(xpath = "//input[contains(@placeholder,'e.g. AnyTown')]")
	private WebElement townInput;
	
	@FindBy(css = ".postCode")
	private WebElement postcodeInput;
	
	@FindBy(css = "#checkoutSecurelyBtn")
	private WebElement continueToPaymentButton;
	
	@FindBy(css = ".companyNameOne")
	private WebElement companyNameInput;

	
	public void setFirstName(String firstName) {
		firstNameInput.clear();
		firstNameInput.sendKeys(firstName);
	}
	
	public void setSurName(String surName) {
		surNameInput.clear();
		surNameInput.sendKeys(surName);
	}
	
	public void setTitle(String title) {
		selectDropDownValueByText(titledropDown, title);
	}
	
	public void setMobile(String mobile) {
		mobileInput.clear();
		mobileInput.sendKeys(mobile);
	}
	
	public void setaddress1(String address1) {
		address1Input.clear();
		address1Input.sendKeys(address1);
	}
	
	public void setTown(String town) {
		townInput.clear();
		townInput.sendKeys(town);
	}

	public void setPostcode(String postcode) {
		postcodeInput.clear();
		postcodeInput.sendKeys(postcode);
	}
	
	public void setCompanyName(String companyName) {
		companyNameInput.clear();
		companyNameInput.sendKeys(companyName);
	}
	

	public void fillDeliveryDetails(Customer customer) {
		setTitle(customer.getTitle());
		setFirstName(customer.getFirstName());
		setSurName(customer.getSurName());
		setMobile(customer.getMobile());
		setCompanyName(customer.getCompanyName());
		setaddress1(customer.getAddressLine1());
		setTown(customer.getTown());
		setPostcode(customer.getPostcode());
	}
	
	public void fillMyDeliveryDetails(Customer customer) {
		setCompanyName(customer.getCompanyName());
		setaddress1(customer.getAddressLine1());
		setTown(customer.getTown());
		setPostcode(customer.getPostcode());
	}

	
	public static void selectDropDownValueByText(WebElement dropdown, String text) {
		List<WebElement> options = new Select(dropdown).getOptions();
		for (WebElement el : options)
			if (text != null && text.equals(el.getText())) {
				el.click();
				return;
			}
	}

	public void clickContinueToPayment() {
		continueToPaymentButton.click();
		waitForLoad(driver);
	}

}
