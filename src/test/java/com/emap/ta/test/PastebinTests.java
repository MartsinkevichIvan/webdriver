package com.emap.ta.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.emap.ta.page.pastebin.PastebinHomePage;
import com.emap.ta.page.pastebin.PastebinPageResults;

public class PastebinTests extends BaseTest {

    @Test
    public void iCanWinTest() {
        new PastebinHomePage(getDriver()).openPage().fillInICanWinPaste();
    }

    @Test
    public void bringItOnTests() {
        PastebinPageResults pastebinPageResults = new PastebinHomePage(getDriver()).openPage().fillInBringItOnPaste();
        Assert.assertTrue(getWait().until(ExpectedConditions.visibilityOf
                (pastebinPageResults.getBtnBash())).isDisplayed());
        String currentTitle = getDriver().getTitle();
        String expectedTitle = "how to gain dominance among developers - Pastebin.com";
        Assert.assertEquals(currentTitle, expectedTitle, "title of created paste is correct.");
        String expectedCode = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String actualCode = pastebinPageResults.getTextOfCode().getText();
        Assert.assertEquals(actualCode, expectedCode);
    }
}
