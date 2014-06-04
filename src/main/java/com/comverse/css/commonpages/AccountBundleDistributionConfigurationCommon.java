package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class AccountBundleDistributionConfigurationCommon extends CommonMenu {
    static String expectedScreen = "Account Bundle Distribution/Configuration";

    public AccountBundleDistributionConfigurationCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickSBSelectiveOffers() throws Exception {
        // Need to remove xpath here 
        driver.findElement(By.xpath("//tr[6]/td/input")).click();
    }

    public ConfigureContractDetailsCommon clickContinue() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ConfigureContractDetailsCommon(driver);
    }
}