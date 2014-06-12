package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class SwapImpactCommon extends CommonMenu {
    static String expectedScreen = "Swap Impact";

    public SwapImpactCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasketCommon clickOK() throws Exception {
        tool.driver.findElement(By.name("ON_OK")).click();
        return new MyBasketCommon(tool, test, user);
    }

    public ConfigureBalanceCommon clickOKExpectingConfigureBalance() throws Exception {
        tool.driver.findElement(By.name("ON_OK")).click();
        return new ConfigureBalanceCommon(tool, test, user);
    }
}
