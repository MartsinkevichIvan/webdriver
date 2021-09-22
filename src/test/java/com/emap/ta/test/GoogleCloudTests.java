package com.emap.ta.test;

import com.emap.ta.page.googleCloud.CalculatorEmailPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.emap.ta.page.googleCloud.CalculatorCountResultPage;
import com.emap.ta.page.googleCloud.CloudGoogleHomePage;
import com.emap.ta.page.googleCloud.YopMailHomePage;
import com.emap.ta.utils.commonUtils;

public class GoogleCloudTests extends BaseTest {

    @Test
    public void hurtMePlantyTest() {
        CalculatorCountResultPage calculatorCountResultPage = new CloudGoogleHomePage(getDriver())
                .openPage()
                .searchForTerms("Google Cloud Platform Pricing Calculator")
                .openLinkToSearchTerm()
                .activateSectionComputerEngine()
                .fillInFormCalculator();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(calculatorCountResultPage.getValueOfVMClass().getText().
                replace("VM class:", "").trim(), "regular");
        softAssert.assertEquals(commonUtils.getTextOfRootElement(calculatorCountResultPage.getValueOfInstanceType()).
                replace("Instance type:", "").trim(), "n1-standard-8");
        softAssert.assertEquals(calculatorCountResultPage.getValueOfRegion().getText().
                replace("Region:", "").trim(), "Frankfurt");
        softAssert.assertEquals(commonUtils.getTextOfRootElement(calculatorCountResultPage.getValueOfLocalSSD()).
                replace("Local SSD:", "").trim(), "2x375 GiB");
        softAssert.assertEquals(calculatorCountResultPage.getValueOfCommitmentTerm().getText().
                replace("Commitment term:", "").trim(), "1 Year");
        softAssert.assertEquals(calculatorCountResultPage.getValueOfTotalEstimateCostPerMonth().getText().
                replace("Total Estimated Cost: USD", "").replace("per 1 month", "")
                .trim(), "1,083.33");
        softAssert.assertAll();
    }

    @Test
    public void hardcoreTest() {
        CalculatorCountResultPage calculatorCountResultPage = new CloudGoogleHomePage(getDriver())
                .openPage()
                .searchForTerms("Google Cloud Platform Pricing Calculator")
                .openLinkToSearchTerm()
                .activateSectionComputerEngine()
                .fillInFormCalculator();

        String totalEstimateCostInCalculator = calculatorCountResultPage.getValueOfTotalEstimateCostPerMonth().getText()
                .replace("Total Estimated Cost: USD", "").replace("per 1 month", "")
                .trim();

        commonUtils.openNewTab(getDriver());
        commonUtils.switchToTabByIndex(getDriver(), 1);
        YopMailHomePage yopMailPage = new YopMailHomePage(getDriver()).openPage();
        String generatedEmail = yopMailPage.generateEmail();
        commonUtils.switchToTabByIndex(getDriver(), 0);
        CalculatorEmailPage emailForm = calculatorCountResultPage.openSendingToEmailForm();
        emailForm.sendCalculationToEmail(generatedEmail);
        commonUtils.switchToTabByIndex(getDriver(), 1);
        String totalEstimateCostInLetter = yopMailPage.checkMail().waitForMail().getTotalEstimateCost().getText()
                .replace("USD", "").trim();
        Assert.assertEquals(totalEstimateCostInLetter, totalEstimateCostInCalculator);
    }
}
