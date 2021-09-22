package com.emap.ta.page.googleCloud;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.emap.ta.page.BasePage;

public class CalculatorEmailPage extends BasePage {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement btnSendEmail;

    public CalculatorEmailPage(WebDriver driver) {
        super(driver);
    }

    public void sendCalculationToEmail(String email) {
        emailField.sendKeys(email);
        btnSendEmail.click();
    }
}
