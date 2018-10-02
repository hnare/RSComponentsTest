@searchResults
Feature: Search and Navigation
  I want to use this template for my feature file

  @topCategories
  Scenario: Search Item - Top Category displayed
		Given I am on home page
		And I search for "lamps"
		When I am navigated to search results page 
		Then Top matching categories includes the below categories
		  | Safety Cone Warning Lamps |
      | Neon Indicator Lamps      |
      | Filament Indicator Lamps  |
      | Heat Lamps                |
      | Automotive Halogen Lamps  |
      | Halogen Capsule Lamps     |
      | Non-Integrated Compact Fluorescent Lamps |
      | Fly Killer Lamps |
		 
	 @categoryFacet
	  Scenario: Search Item - Left Category facet displayed
		Given I am on home page
		And I search for "lamps"
		And I am navigated to search results page 
		And I can see the category facet menu displayed on the page
		And the categories are expanded by default
		When I click on collapse
		Then I can see the following subcategories displayed
		 |LED Lamps|
		 |Fluorescent Lamps & Tubes|
		 |Light Fittings & Luminaires|
		 |Halogen Lamps|
		 
	 @allProducts	
	  Scenario: Search Item - All products displayed
		Given I am on home page
		And I search for "lamps"
		When I am navigated to search results page 
		Then I can see "20" products displayed on the page
		And pagination is displayed to view more products 
	
	
		 
		 