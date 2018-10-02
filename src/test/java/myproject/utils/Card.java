package myproject.utils;

public class Card {
	
	private String cardNumber;
	private String cardHolderName;
	private String expiry;
	private String cvv;
	private String cardName;
	
	
	public Card(String cardNumber, String cardHolderName, String expiry, String cvv, String cardName) {
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.expiry = expiry;
		this.cvv = cvv;
		this.cardName = cardName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	@Override
	public String toString() {
		return "Card [cardNumber=" + cardNumber + ", cardHolderName=" + cardHolderName + ", expiry=" + expiry + ", cvv="
				+ cvv + ", cardName=" + cardName + "]";
	}

}
