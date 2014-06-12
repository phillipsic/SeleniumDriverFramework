package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ConfigureBalanceReview extends B2CMenu {

    public ConfigureBalanceReview(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Configure balance - Review";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ConfigureBalanceConfirm clickConfirm() throws Exception {
        tool.driver.findElement(By.cssSelector("input[type='button'][value='Confirm']")).click();
        return new ConfigureBalanceConfirm(tool, test, user);

    }

    public ViewBalances clickBack() throws Exception {
        tool.driver.findElement(By.cssSelector("input[type='submit'][value='Back']")).click();
        return new ViewBalances(tool, test, user);

    }
}
