package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SwapBundleCommon extends CommonMenu {

    public SwapBundleCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Swap Bundle";
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickToAccountBundle(String accountBundle) throws Exception {
        tool.driver.findElement(By.xpath("//tr[@id='abtr:" + accountBundle + "']/td/input")).click();
    }

    public void clickAdditionalParticipants() throws Exception {
        tool.clickUsingName(tool, "additionalPartChk");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public AccountBundleDistributionConfigurationCommon clickContinue() throws Exception {
        tool.driver.findElement(By.id("futureDistContinueBtn")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountBundleDistributionConfigurationCommon(tool, test, user);
    }
}