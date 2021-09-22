package com.emap.ta.page.googleCloud;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import com.emap.ta.page.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CloudGoogleHomePage extends BasePage {

    private final String HOMEPAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//button[@class='button button-white devsite-suggest-all-results']")
    private WebElement btnSearch;

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchInput;

    public CloudGoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public CloudGoogleHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        wait.until(driver -> (  (JavascriptExecutor) driver).
                executeScript("return document.readyState").equals("complete"));
        return this;
    }

    public CloudGoogleSearchResultPage searchForTerms(String term) {
        searchInput.click();
        searchInput.sendKeys(term);
        wait.until(ExpectedConditions.visibilityOf(btnSearch)).click();
        wait.until(driver -> ((JavascriptExecutor) driver).
                executeScript("return document.readyState").equals("complete"));
        return new CloudGoogleSearchResultPage(driver, term);
    }
}
