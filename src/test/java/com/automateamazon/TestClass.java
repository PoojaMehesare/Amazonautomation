package com.automateamazon;

import com.automate.amazon.BaseClass;
import com.automate.amazon.ExcelUtils;
import com.automate.amazon.JavaScriptUtil;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestClass extends BaseClass {
    @Test(priority = 1)
    @Description("Verify Valid Credentials")
    @Epic("EP001")
    @Feature("Feature1 : Login")
    @Story("Valid login")
    @Step("Verify login")
    @Severity(SeverityLevel.BLOCKER)
    public void testSignIn() {
        driver.get("https://www.amazon.in/");
        driver.get(login.getLogin_URL());
        login.setEmail(ExcelUtils.getCellData(0, 2));
        login.clickContinueBtn();
        login.setPassword(ExcelUtils.getCellData(1, 2));
        login.clickSignInBtn();

    }

    @Test(priority = 2)
    @Description("Verify Search Product")
    @Epic("EP001")
    @Feature("Feature2 : Search")
    @Story("Search Product")
    @Step("Verify Serach Product")
    @Severity(SeverityLevel.CRITICAL)
    public void searchProduct() throws InterruptedException {
        driver.get(home.getHomePage_URL());
        home.searchAndSelectProduct("headphones", 2);
        Thread.sleep(2000);
        JavaScriptUtil.scrollPageDown(driver);
        home.setSearchButton();
    }

    @Test(priority = 3)
    @Description("Verify Product Quantity")
    @Epic("EP001")
    @Feature("Feature3 : Select")
    @Story("Select Product Quantity")
    @Step("Verify Product Quantity")
    @Severity(SeverityLevel.CRITICAL)
    public void productQuantity() {
        driver.get(home.getProduct_URL());
        Select quantity = new Select(driver.findElement(By.id("quantity")));
        quantity.selectByIndex(1);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4)
    @Description("Verify Add To Cart Button")
    @Epic("EP001")
    @Feature("Feature4 : Add")
    @Story("Add To Cart Button")
    @Step("Verify Add To Cart Button")
    @Severity(SeverityLevel.CRITICAL)
    public void addToCart() {
        driver.get(cart.getCartPage_URL());
        cart.clickAddToCartbtn();

    }

    @Test(priority = 5)
    @Description("Verify Cart ")
    @Epic("EP001")
    @Feature("Feature5 : Click")
    @Story("Click Cart ")
    @Step("Verify cart")
    @Severity(SeverityLevel.CRITICAL)
    public void clickCart() {
        driver.get(home.getHomePage_URL());
        cart.addToCartButton();
    }
}
