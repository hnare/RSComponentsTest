package myproject.steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myproject.pages.BasketPage;
import myproject.pages.DeliveryDetailsPage;
import myproject.pages.HomePage;
import myproject.pages.LoginPage;
import myproject.pages.PaymentDetailsPage;
import myproject.pages.ProductDetailsPage;
import myproject.pages.SearchResultsPage;
import myproject.pages.loginFrame;
import myproject.utils.Card;
import myproject.utils.Customer;

public class BrowserUtils{
	
    public WebDriver driver;
    private final Log log = LogFactory.getLog(this.getClass());
    public BrowserUtils()
    {
    	driver = WebDriverUtils.driver;
    }
    
	private HomePage homePage;
	private ProductDetailsPage pdpPage;
	private BasketPage basketPage;
	private loginFrame loginframe;
	private DeliveryDetailsPage deliveryDetailsPage;
	private PaymentDetailsPage paymentDetailsPage;
	private LoginPage loginPage;
	private SearchResultsPage searchResultsPage;
	private final String homePageurl = "http://uk.rs-online.com/web";
	private final String loginUrl = "https://uk.rs-online.com/web/authHome.html";

	   @Given("^I am on home page$")
	   public void I_am_on_the_home_page() {
		  driver.get(homePageurl);
		  driver.manage().window().fullscreen();
		  log.info("driver loaded with the url = " + homePageurl);
		  homePage = PageFactory.initElements(driver, HomePage.class);
	   }
	   
	   @When("^I add the product \"(.*?)\" to my basket$")
	   public void I_have_added_the_product_to_my_basket(String itemCode) {
		   homePage = PageFactory.initElements(driver, HomePage.class);
		   homePage.acceptFrame();
		   homePage.search(itemCode);
		   pdpPage = PageFactory.initElements(driver, ProductDetailsPage.class);
		   pdpPage.clickAddToBasketButton();
		   pdpPage.acceptFrame();
		   pdpPage.visitBasketPage();
	   }
	   
	   @Then("^I am navigated to basket page$")
	   public void I_am_navigated_to_basket_page() {
		   basketPage = PageFactory.initElements(driver, BasketPage.class);
		   basketPage.acceptFrame();
			assertThat(basketPage.isBasketPageTitleDisplayed())
			.as("Basket Page title is not displayed").isTrue();
	   }
	   
	   @When("^I proceed to checkout as guest$")
	   public void I_proceed_to_checkout_as_guest() throws InterruptedException {
		   basketPage.acceptFrame();
		   basketPage.clickCheckout();
		   basketPage.acceptFrame();
		   loginframe = PageFactory.initElements(driver, loginFrame.class);
			assertThat(basketPage.isLoginFrameDisplayed()).as("Login Frame should be displayed").isTrue();
			loginframe.acceptFrame();
			loginframe.populateEmail();
			loginframe.clickGuestCheckout();
	   }
	   
	   @When("^I proceed to checkout$")
	   public void I_proceed_to_checkout() {
		   basketPage.proceedToCheckout();
	   }
	   
	   @Then("^I submit my delivery details$")
	   public void I_submit_my_delivery_details(List<Customer> billingAddressList) {
		   deliveryDetailsPage = PageFactory.initElements(driver, DeliveryDetailsPage.class);
		   Customer customerInfo = billingAddressList.get(0); 
		   deliveryDetailsPage.fillDeliveryDetails(customerInfo);
		   deliveryDetailsPage.clickContinueToPayment();
	   }
	   
	   @Then("^I submit delivery details$")
	   public void I_submit_delivery_details(List<Customer> billingAddressList) {
		   deliveryDetailsPage = PageFactory.initElements(driver, DeliveryDetailsPage.class);
		   Customer customerInfo = billingAddressList.get(0); 
		   deliveryDetailsPage.fillMyDeliveryDetails(customerInfo);
		   deliveryDetailsPage.clickContinueToPayment();
	   }

	   
	   @Then("^I am navigated to payment details page$")
	   public void I_am_navigated_to_payment_details_page() {
		   paymentDetailsPage = PageFactory.initElements(driver, PaymentDetailsPage.class);
			assertThat(paymentDetailsPage.isPaymentPageTitleDisplayed()).as("Payment Page title is not displayed").isTrue();
	   }
	   
	   @When("^I submit my payment details$")
	   public void I_submit_my_payment_details(List<Card> PaymentDetailsList) {
	   }
	   
	   @Then("^I have logged with username as \"(.*?)\" and password \"(.*?)\"$")
	   public void I_have_logged_with_username_and_password(String username, String password) throws InterruptedException {
		   loginPage = PageFactory.initElements(driver, LoginPage.class);
		   driver.get(loginUrl);
		   loginPage.populateLoginDetails();
		   loginPage.clickLogin();
	   }
	   
	   @When("^I search for \"(.*?)\"$")
	   public void I_search_for(String serachItem) {
		   homePage = PageFactory.initElements(driver, HomePage.class);
		   homePage.search(serachItem);
	   }
	   
	   @Then("I am navigated to search results page")
	   public void I_am_navigated_to_search_results_page() {
		   searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
		   searchResultsPage.isSearchUrlDisplayed();
		   searchResultsPage.isSearchPageTitleDisplayed();
	   }
	   
	   @Then("^Top matching categories includes the below categories$")
	   public void Top_matching_categories_includes_the_below_categories(List<String> categories) {
		  assertThat(searchResultsPage.allTopCategories().containsAll(categories));
	   }
	  
	   
	   @Then("^I can see the category facet menu displayed on the page$")
	   public void I_can_see_the_category_facet_menu_displayed_on_the_page() {
		   assertThat(searchResultsPage.isSideBarDisplayed()).isTrue();
	   }
	   
	   @Then("^the categories are expanded by default$")
	   public void the_categories_are_expanded_by_default() {
		   assertThat(searchResultsPage.isSideBarExpanded()).isTrue();
	   }
	   
	   @When("^I click on collapse$")
	   public void I_click_on_collapse() {
		   searchResultsPage.clickCollapse();
	   }
	   
	   @Then("^I can see the following subcategories displayed$")
	   public void I_can_see_the_following_subcategories_displayed(List<String> categories) {
		   assertThat(searchResultsPage.allSideCategories().containsAll(categories));
	   }
	   
	   @Then("^I can see \"(.*?)\" products displayed on the page$")
	   public void I_can_see_products_displayed_on_the_page(int number) {
		   assertThat(searchResultsPage.allProductCount()).isSameAs(number);
	   }
	   
	   @Then("^pagination is displayed to view more products$")
	   public void pagination_is_displayed_to_view_more_products(){
		   searchResultsPage.isPaginationDisplayed();
	   }
	   
	   
	     
}
