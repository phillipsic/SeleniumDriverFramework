package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class SwapBundleCommon extends CommonMenu {

    public SwapBundleCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Swap Bundle";
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickToAccountBundle(String accountBundle) throws Exception {
        driver.findElement(By.xpath("//tr[@id='abtr:" + accountBundle + "']/td/input")).click();
    }

    public void clickAdditionalParticipants() throws Exception {
        driver.findElement(By.name("additionalPartChk")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
    }

    public AccountBundleDistributionConfigurationCommon clickContinue() throws Exception {
        driver.findElement(By.id("futureDistContinueBtn")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AccountBundleDistributionConfigurationCommon(driver);
    }
}