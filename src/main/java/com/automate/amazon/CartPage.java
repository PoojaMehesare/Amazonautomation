package com.automate.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

public class CartPage {
    WebDriver driver;

    String CartPage_URL = "https://www.amazon.in/Rockerz-370-Headphone-Bluetooth-Lightweight/dp/B0856HNMR7/ref=sr_1_3?keywords=headphones&qid=1646574548&sr=8-3&th=1";
    @FindBy(id = "add-to-cart-button")
    WebElement AddToCartButton;
    @FindBy(id = "nav-cart-count")
    WebElement AddToCart;

    public CartPage(WebDriver driver) throws AWTException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCartbtn() {

        AddToCartButton.click();
    }

    public void addToCartButton() {

        AddToCart.click();
    }

    public String getCartPage_URL() {
        return CartPage_URL;
    }

}
