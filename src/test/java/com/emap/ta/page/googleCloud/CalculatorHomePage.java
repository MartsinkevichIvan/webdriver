package com.emap.ta.page.googleCloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.emap.ta.page.BasePage;

public class CalculatorHomePage extends BasePage {

    @FindBy(xpath = "//md-tab-item//div[contains(@title, 'Compute Engine')]//div[@class='hexagon-in2']")
    private WebElement btnComputeEngine;

    @FindBy(xpath = "//label[contains(text(),'Number of instances')]/following-sibling::input")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//label[text()='Operating System / Software']/following-sibling::md-select")
    private WebElement operatingSystemDropDown;

    @FindBy(xpath = "//md-select-menu//div[contains(text(),'Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License')]")
    private WebElement freeDebianOperatingSystem;

    @FindBy(xpath = "//label[text()='Machine Class']/parent::md-input-container/md-select")
    private WebElement machineClassDropDown;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='regular']")
    private WebElement regularMachineClassValue;

    @FindBy(name = "series")
    private WebElement seriesDropDown;

    @FindBy(xpath = "//md-option[@value='n1']")
    private WebElement n1SeriesValue;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement machineTypeDropDown;

    @FindBy(xpath = "//div[contains(text(),'n1-standard-8 (vCPUs: 8, RAM: 30GB)')]")
    private WebElement n1Standart8CPU830GB;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-checkbox[@aria-label='Add GPUs']")
    private WebElement checkBoxAddGPUs;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement countOfGPUsDropDown;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='1']")
    private WebElement oneGPUsValue;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement typeOfGPUDropDown;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement nVidiaTeslaV100typeGPUValue;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSSDDropDown;

    @FindBy(xpath = "//md-option//div[contains(text(),'2x375 GB')]")
    private WebElement localSSDValue2x375Gb;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement datacenterLocationDropDown;

    @FindBy(xpath = "//md-select-menu[@class='md-overflow']//md-option[@value='europe-west3']")
    private WebElement dataCenterValueFrankfurt;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement commitedUsageDropDown;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//div[text()='1 Year']")
    private WebElement commitedUsageValue1Year;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[@aria-label='Add to Estimate']")
    private WebElement btnAddToEstimate;

    public CalculatorHomePage(WebDriver driver) {
        super(driver);
    }

    public CalculatorHomePage activateSectionComputerEngine() {
        switchToMyFrame();
        wait.until(ExpectedConditions.elementToBeClickable(btnComputeEngine)).click();
        driver.switchTo().defaultContent();
        return this;
    }

    public CalculatorCountResultPage fillInFormCalculator() {
        switchToMyFrame();
        wait.until(ExpectedConditions.visibilityOf(numberOfInstances)).sendKeys("4");
        wait.until(ExpectedConditions.visibilityOf(operatingSystemDropDown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(freeDebianOperatingSystem)).click();
        wait.until(ExpectedConditions.visibilityOf(machineClassDropDown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(regularMachineClassValue)).click();
        wait.until(ExpectedConditions.visibilityOf(seriesDropDown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(n1SeriesValue)).click();
        wait.until(ExpectedConditions.visibilityOf(machineTypeDropDown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(n1Standart8CPU830GB)).click();
        wait.until(ExpectedConditions.visibilityOf(checkBoxAddGPUs)).click();
        wait.until(ExpectedConditions.visibilityOf(countOfGPUsDropDown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(oneGPUsValue)).click();
        wait.until(ExpectedConditions.visibilityOf(typeOfGPUDropDown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(nVidiaTeslaV100typeGPUValue)).click();
        wait.until(ExpectedConditions.visibilityOf(localSSDDropDown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(localSSDValue2x375Gb)).click();
        wait.until(ExpectedConditions.visibilityOf(datacenterLocationDropDown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(dataCenterValueFrankfurt)).click();
        wait.until(ExpectedConditions.visibilityOf(commitedUsageDropDown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(commitedUsageValue1Year)).click();
        wait.until(ExpectedConditions.visibilityOf(btnAddToEstimate)).click();
        return new CalculatorCountResultPage(driver);
    }

    private void switchToMyFrame() {
        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//article[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame(frame);
        WebElement myFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myFrame")));
        driver.switchTo().frame(myFrame);
    }
}
