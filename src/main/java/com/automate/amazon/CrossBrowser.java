package com.automate.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class CrossBrowser {
    WebDriver driver;

    @Parameters("browserName")
    @BeforeTest
    public void setup(String browserName) {

        if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gicko.driver", "G:\\Bridgelab\\Selenium\\geckodriver.exe");
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\win\\IdeaProjects\\cromedriver\\chromedriver.exe");
            driver = new ChromeDriver();

        }}
    @Test
    public void browserTesting(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
    }


    @AfterTest
    public void afterTest(){

        driver.close();
    }
}


