package com.emap.ta.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeSuite
    public void beforeSuite(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void afterSuite(){
        if(driver!=null){
            driver.close();
            driver.quit();
        }
    }

    public WebDriver getDriver(){
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
