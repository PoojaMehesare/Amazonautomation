package com.automate.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final String Login_URL = "https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&";
    WebDriver driver;
    @FindBy(id = "nav-link-accountList")
    WebElement SignIn;
    @FindBy(id = "ap_email")
    WebElement Email;
    @FindBy(id = "continue")
    WebElement ContinueBtn;
    @FindBy(id = "ap_password")
    WebElement Password;
    @FindBy(id = "signInSubmit")
    WebElement Sign_In_Submit;

    public LoginPage(WebDriver d) {
        driver = d;
        PageFactory.initElements(d, this);
    }

    public void setEmail(String email) {

        Email.sendKeys(email);
    }

    public void clickContinueBtn() {

        ContinueBtn.click();
    }

    public void setPassword(String password) {

        Password.sendKeys(password);
    }

    public void clickSignInBtn() {

        Sign_In_Submit.click();
    }

    public String getLogin_URL() {
        return Login_URL;
    }
}
