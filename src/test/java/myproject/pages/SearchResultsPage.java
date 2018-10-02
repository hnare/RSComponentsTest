package myproject.pages;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import myproject.utils.Customer;

public class SearchResultsPage {
	

	private static final Object PAGE_TITLE = "4466 products found for lamps";
	private static final CharSequence SEARCH_TERM = "lamps";
	private WebDriver driver;

	public SearchResultsPage(WebDriver driver){
		this.driver = driver;
	}


	@FindBy(css = ".search-matches")
	private WebElement searchMatchText;
	
	@FindBy(css = ".found-message")
	private WebElement productFoundMessage;
	
	@FindBy(css = ".top-category-card span")
	private WebElement topcategory1;
	
	@FindBy(css = ".top-categories-container")
	private WebElement topCategoriesContainer1;

	@FindBy(css = ".category-list-container")
	private WebElement slideBar;
	
	@FindBy(css = ".small_2MXcXXHK")
	private WebElement expandButton;
	
	@FindBy(css = ".category-list-container")
	private WebElement sideBarCategtories;
	
	@FindBy(css = ".product-grid-container")
	private WebElement productGridContainer;

	@FindBy(css = ".container_roHxkxS7")
	private WebElement pagination;
	
	public boolean isSearchUrlDisplayed() {
		return driver.getCurrentUrl().contains(SEARCH_TERM);		
	}

	public boolean isSearchPageTitleDisplayed() {
		if(searchMatchText.getText().equals("products found for \""+SEARCH_TERM+ "\""))
				return true;
		return false;
	}
	
	public boolean categoriesMatch(List<String> categories) {
		
		for(String category : categories) {
			topcategory1.getText().equals(category);
		}
		return false;
		
	}
	
	public List<String> allTopCategories(){
		List<String> allcat = new ArrayList<>();
		List<WebElement> allCategories = topCategoriesContainer1.findElements(By.cssSelector(".top-category-card span:nth-of-type(1)"));
		for(int i =0; i<allCategories.size();i++) {
		allcat.add(allCategories.get(i).getText());
		}
		return allcat;
	}

	public boolean isSideBarDisplayed() {
		return slideBar.isDisplayed();
	}

	public boolean isSideBarExpanded() {
		return expandButton.getText().equals("Collapse All");
	}

	public void clickCollapse() {
		expandButton.click();
	}
	
	public List<String> allSideCategories(){
		List<String> allcat = new ArrayList<>();
		List<WebElement> allCategories = sideBarCategtories.findElements(By.cssSelector(".category-panel header"));
		for(int i =0; i<allCategories.size();i++) {
		allcat.add(allCategories.get(i).getText());
		}
		return allcat;
	}

	public int allProductCount(){
		List<WebElement> allCategories = productGridContainer.findElements(By.cssSelector(".tile"));
		return allCategories.size();
	}

	public boolean isPaginationDisplayed() {
		return pagination.isDisplayed();
	}
	
	

	
	
	
	}
