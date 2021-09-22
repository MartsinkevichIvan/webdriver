package com.emap.ta.page.googleCloud;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.emap.ta.page.BasePage;
import com.emap.ta.utils.commonUtils;

public class YopMailHomePage extends BasePage {

    private final String HOMEPAGE_URL = "https://yopmail.com/";

    @FindBy(xpath = "//a[@href='email-generator']")
    private WebElement btnGenerateEmail;

    @FindBy(id = "egen")
    private WebElement generatedEmail;

    @FindBy(xpath = "//span[text()='Проверить почту']/parent::button")
    private WebElement btnCheckPost;

    public YopMailHomePage(WebDriver driver) {
        super(driver);
    }

    public YopMailHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        wait.until(driver -> ((JavascriptExecutor) driver).
                executeScript("return document.readyState").equals("complete"));
        return this;
    }

    public String generateEmail() {
        btnGenerateEmail.click();
        return commonUtils.getTextOfRootElement(generatedEmail);
    }

    public YopMailPrivatePage checkMail() {
        btnCheckPost.click();
        return new YopMailPrivatePage(driver);
    }
}
