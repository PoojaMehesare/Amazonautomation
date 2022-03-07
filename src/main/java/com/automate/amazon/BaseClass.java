package com.automate.amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static final String URL = "https://www.amazon.in/";
    public static final String FILE_PATH = "C:\\Users\\win\\IdeaProjects\\DataDriven\\testdata\\AmazonLoginSheet.xlsx";
    public static final String SHEET_NAME = "Sheet1";
    public static WebDriver driver;
    public static Actions action;
    public static Select select;
    public static LoginPage login;
    public static HomePage home;
    public static CartPage cart;
    public static ExcelUtils excel;

    public static WebDriver getDriver() {
        return driver;
    }

    @Parameters("browserName")
    @BeforeTest
    public void intialize(String browserName) throws Exception {
        //   System.setProperty("webdriver.chrome.driver", "C:\\Users\\win\\IdeaProjects\\cromedriver\\chromedriver.exe");

        if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        //  driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        login = new LoginPage(driver);
        home = new HomePage(driver);
        cart = new CartPage(driver);
        excel = new ExcelUtils(FILE_PATH);
        excel.setExcelFile(FILE_PATH, SHEET_NAME);
    }

    @AfterTest
    public void tearDown() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();

    }
}