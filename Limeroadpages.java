package com.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Limeroadpages {
	WebDriver driver;
	public Limeroadpages(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[contains(text(),'SHOP WOMEN')]")
	WebElement Shopwomen;
	public WebElement getShopwomen() {
		return Shopwomen;
	}
	
	@FindBy(xpath="//body/div[@id='vSt']/div[@id='vHdr']/a[3]/*[1]")
	WebElement Search;
	public WebElement getSearch() {
		return Search;
	}
	@FindBy(xpath="//input[@id='srcInpu']")
	WebElement Searchbox;
	public WebElement getSearchbox() {
		return Searchbox;
	}
	
	@FindBy(xpath="//div[contains(text(),'Low Price')]")
	WebElement Lowprice;
	public WebElement getLowprice() {
		return Lowprice;
	}
	
	@FindBy(xpath="//div[contains(text(),'color')]")
	WebElement Color;
	public WebElement getColor() {
		return Color;
	}
	
	@FindBy(xpath="//div[contains(text(),'black')]")
	WebElement Black;
	public WebElement getBlack() {
		return Black;
	}
	
	
	@FindBy(xpath="//div[@data-a=\"price\"]")
	WebElement Pricerange;
	public WebElement getPricerange() {
		return Pricerange;
	}
	@FindBy(xpath="//div[contains(text(),'0 To 499')]")
	WebElement Pricerange1;
	public WebElement getPricerange1() {
		return Pricerange1;
	}
	
	@FindBy(xpath="//body/div[@id='vSt']/div[@id='vHdr']/a[@id='cartB']/div[2]/*[1]")
	WebElement Cart;
	public WebElement getCart() {
		return Cart;
	}
	@FindBy(xpath="//a[contains(text(),'CONTINUE')]")
	WebElement Continue;
	public WebElement getContinue() {
		return Continue;
	}
}
