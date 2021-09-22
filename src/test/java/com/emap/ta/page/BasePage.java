package com.emap.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected final int WAIT_TIMEOUT_SECONDS=10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS);
        PageFactory.initElements(driver,this);
    }
}
