package com.emap.ta.page.pastebin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.emap.ta.page.BasePage;

public class PastebinPageResults extends BasePage {

    @FindBy (xpath = "//a[text()='Bash']")
    private WebElement btnBash;

    @FindBy (xpath = "//textarea[@class='textarea']")
    private WebElement textOfCreatedPaste;

    @FindBy (xpath = "//ol[@class='bash']")
    private WebElement textOfCode;

    public PastebinPageResults(WebDriver driver) {
        super(driver);
    }

    public WebElement getTextOfCode() {
        return textOfCode;
    }

    public WebElement getBtnBash() {
        return btnBash;
    }

    public WebElement getTextOfCreatedPaste() {
        return textOfCreatedPaste;
    }
}
