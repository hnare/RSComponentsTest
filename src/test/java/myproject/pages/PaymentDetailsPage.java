package myproject.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentDetailsPage {
	
	private static final String PAGE_TITLE = "Payment";
	private WebDriver driver;

	public PaymentDetailsPage(WebDriver driver){
		this.driver = driver;
	}
	
	@FindBy(css = ".deliveryHeaderDiv")
	private WebElement pageTitle;

	@FindBy(css = ".deliveryHeaderDiv")
	private WebElement cardNumber;

	
	public boolean isPaymentPageTitleDisplayed() {
		return pageTitle.getText().equals(PAGE_TITLE);
		}


}
