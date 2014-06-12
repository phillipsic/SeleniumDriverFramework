package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class AccountBundleDistributionConfigurationCommon extends CommonMenu {
    static String expectedScreen = "Account Bundle Distribution/Configuration";

    public AccountBundleDistributionConfigurationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickSBSelectiveOffers() throws Exception {
        // Need to remove xpath here
        tool.driver.findElement(By.xpath("//tr[6]/td/input")).click();
    }

    public ConfigureContractDetailsCommon clickContinue() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ConfigureContractDetailsCommon(tool, test, user);
    }
}