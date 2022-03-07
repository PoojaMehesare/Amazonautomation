package com.automate.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;

public class HomePage {
    WebDriver driver;
    String HomePage_URL = "https://www.amazon.in/";
    String Product_URL = "https://www.amazon.in/Rockerz-370-Headphone-Bluetooth-Lightweight/dp/B0856HNMR7/ref=sr_1_3?keywords=headphones&qid=1646651026&sr=8-3&th=1";
    @FindBy(id = "twotabsearchtextbox")
    WebElement SearchProduct;
    @FindBy(id = "nav-search-submit-button")
    WebElement SearchButton;
    @FindBy(id = "add-to-cart-button")
    WebElement AddToCartButton;
    @FindBy(xpath = "//div[@class='aok-relative']")
    List<WebElement> SEARCH_LIST;

    public HomePage(WebDriver driver) throws AWTException {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchAndSelectProduct(String productName, int productIndex) {
        SearchProduct.sendKeys(productName);
        SearchButton.click();
        SEARCH_LIST.get(productIndex).click();
    }

    public void setSearchButton() {

        SearchButton.click();
    }

    public void addToCart() {

        AddToCartButton.click();
    }

    public String getHomePage_URL() {
        return HomePage_URL;
    }


    public String getProduct_URL() {
        return Product_URL;
    }
}
