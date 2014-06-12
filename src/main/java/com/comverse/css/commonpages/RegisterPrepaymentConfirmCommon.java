package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class RegisterPrepaymentConfirmCommon extends CommonMenu {

    public RegisterPrepaymentConfirmCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Register PrePayment";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AccountDetailsCommon clickBackToAccount() throws Exception {

        tool.driver.findElement(By.xpath("//input[@name='confirm']")).click();
        return new AccountDetailsCommon(tool, test, user);
    }
}
