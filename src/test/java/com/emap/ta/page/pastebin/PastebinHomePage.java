package com.emap.ta.page.pastebin;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.emap.ta.page.BasePage;


public class PastebinHomePage extends BasePage {

    private final String HOMEPAGE_URL = "https://pastebin.com";

    @FindBy(id = "postform-text")
    private WebElement codeField;

    @FindBy(xpath = "//div[@class='form-group field-postform-expiration']/div[@class='col-sm-9 field-wrapper']")
    private WebElement pasteExpirationDropDown;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement tenMinutesPasteExpirationValue;

    @FindBy(id = "postform-name")
    private WebElement pasteName;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement btnCreateNewPaste;

    @FindBy(xpath = "//div[@class='form-group field-postform-format']/div/span")
    private WebElement syntaxHighligthingDropDown;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement bashSyntaxHighligthingValue;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }

    public PastebinPageResults fillInICanWinPaste() {
        codeField.sendKeys("Hello from WebDriver");
        pasteExpirationDropDown.click();
        tenMinutesPasteExpirationValue.click();
        pasteName.sendKeys("helloweb");
        btnCreateNewPaste.click();
        return new PastebinPageResults(driver);
    }

    public PastebinPageResults fillInBringItOnPaste() {
        codeField.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");
        syntaxHighligthingDropDown.click();
        bashSyntaxHighligthingValue.click();
        pasteName.sendKeys("how to gain dominance among developers");
        btnCreateNewPaste.click();
        return new PastebinPageResults(driver);
    }
}
