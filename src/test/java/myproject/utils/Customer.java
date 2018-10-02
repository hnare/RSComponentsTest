package myproject.utils;

public class Customer {
	
	private String firstName;
	private String surName;
	private String mobile;
	private String postcode;
	private String addressLine1;
	private String town;
	private String title;
	private String companyName;

	
	public Customer(String title,String firstName, String surName, String mobile, String country, String postcode,
			String addressLine1, String addressLine2, String addressLine3, String town, String companyName) {
		this.firstName = firstName;
		this.surName = surName;
		this.mobile = mobile;
		this.postcode = postcode;
		this.addressLine1 = addressLine1;
		this.town = town;
		this.title = title;
		this.companyName = companyName;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}


	@Override
	public String toString() {
		return "Customer [title=" + title +",firstName=" + firstName + ", surName=" + surName + ", companyName=" + companyName + ", postcode=" + postcode + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ ", town=" + town + "]";
	}


}
