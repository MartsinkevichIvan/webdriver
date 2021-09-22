package com.emap.ta.page.googleCloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.emap.ta.page.BasePage;

import java.util.List;

public class YopMailPrivatePage extends BasePage {

    @FindBy(xpath = "//h3[text()='Total Estimated Monthly Cost']/parent::td/following-sibling::td/h3[contains(text(),'USD')]")
    private WebElement totalEstimateCost;

    @FindBy(id = "refresh")
    private WebElement buttonRefresh;

    public YopMailPrivatePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTotalEstimateCost() {
        driver.switchTo().frame("ifmail");
        return wait.until(ExpectedConditions.visibilityOf(totalEstimateCost));
    }

    public YopMailPrivatePage waitForMail() {

        for (int i = 0; i < 50; i++) {
            driver.switchTo().frame("ifmail");
            List<WebElement> letters = driver.findElements(By.xpath("//h3[text()='Total Estimated Monthly Cost']" +
                    "/parent::td/following-sibling::td/h3[contains(text(),'USD')]"));
            driver.switchTo().defaultContent();
            if (letters.size() != 0) {
                return this;
            } else {
                try {
                    buttonRefresh.click();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }
}
