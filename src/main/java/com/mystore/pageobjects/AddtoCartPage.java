package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddtoCartPage extends BaseClass{
	
	@FindBy(id = "quantity_wanted")
	WebElement qty;
	
	@FindBy(id = "group_1")
	WebElement size;
	
	@FindBy(xpath = "//span[normalize-space()='Add to cart']")
	WebElement addToCart;
	
	@FindBy(id="wishlist_button")
	WebElement wishList;
	
	@FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
	WebElement addtocartmsg;
	
	@FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
	WebElement proceedtoCheckout;
	
	public AddtoCartPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	public void selectQty(String q)
	{
		Action.type(qty, q);
	}
	
	public void selectSize(String size1)
	{
		Action.selectByVisibleText(size1, size);
	}
	
	public void addtocart()
	{
		Action.click(getDriver(), addToCart);
		
	}
	
	public boolean validateAddToCart()
	{
		Action.fluentWait(addtocartmsg, 10);
		return Action.isDisplayed(getDriver(), addtocartmsg);
	}
	
	public OrderPage clickOnCheckOut() throws Exception
	{
		Action.fluentWait(proceedtoCheckout, 10);
		Action.JSClick(getDriver(), proceedtoCheckout);
		
		return new OrderPage();
	}
	


}
