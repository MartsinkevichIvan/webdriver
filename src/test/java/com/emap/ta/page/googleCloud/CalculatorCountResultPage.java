package com.emap.ta.page.googleCloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.emap.ta.page.BasePage;

public class CalculatorCountResultPage extends BasePage {

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(text(),'VM class')]")
    private WebElement valueOfVMClass;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding cpc-cart-multiline flex' " +
            "and contains(text(),'Instance type:')]")
    private WebElement valueOfInstanceType;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(text(),'Region:')]")
    private WebElement valueOfRegion;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding cpc-cart-multiline flex' and contains(text(),'Local SSD:')]")
    private WebElement valueOfLocalSSD;

    @FindBy(xpath = "//div[@class='md-list-item-text ng-binding' and contains(text(),'Commitment term:')]")
    private WebElement valueOfCommitmentTerm;

    @FindBy(xpath = "//b[@class='ng-binding' and contains(text(),'Total Estimated Cost')]")
    private WebElement valueOfTotalEstimateCostPerMonth;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement btnEmailEstimate;

    public CalculatorCountResultPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getValueOfVMClass() {
        return valueOfVMClass;
    }

    public WebElement getValueOfInstanceType() {
        return valueOfInstanceType;
    }

    public WebElement getValueOfRegion() {
        return valueOfRegion;
    }

    public WebElement getValueOfLocalSSD() {
        return valueOfLocalSSD;
    }

    public WebElement getValueOfCommitmentTerm() {
        return valueOfCommitmentTerm;
    }

    public WebElement getValueOfTotalEstimateCostPerMonth() {
        return valueOfTotalEstimateCostPerMonth;
    }

    public CalculatorEmailPage openSendingToEmailForm() {
        switchToMyFrame();
        btnEmailEstimate.click();
        return new CalculatorEmailPage(driver);
    }

    private void switchToMyFrame() {
        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//article[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame(frame);
        WebElement myFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myFrame")));
        driver.switchTo().frame(myFrame);
    }
}
