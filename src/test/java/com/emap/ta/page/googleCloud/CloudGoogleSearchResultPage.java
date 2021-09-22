package com.emap.ta.page.googleCloud;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.emap.ta.page.BasePage;

public class CloudGoogleSearchResultPage extends BasePage {

    @FindBy(xpath = "//div/a[contains(@href, 'https://cloud.google.com/products/calculator')]")
    private WebElement calculatorResult;

    private String searchTerm;

    public CloudGoogleSearchResultPage(WebDriver driver, String searchTerm) {
        super(driver);
        this.searchTerm = searchTerm;
    }

    public CalculatorHomePage openLinkToSearchTerm() {
        wait.until(ExpectedConditions.visibilityOf(calculatorResult)).click();
        wait.until(driver -> ((JavascriptExecutor) driver).
                executeScript("return document.readyState").equals("complete"));
        return new CalculatorHomePage(driver);
    }
}
