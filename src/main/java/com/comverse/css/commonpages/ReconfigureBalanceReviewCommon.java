package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ReconfigureBalanceReviewCommon extends CommonMenu {

    static String expectedScreen = "Configure balance - Review";

    public ReconfigureBalanceReviewCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!currentScreen.equals(expectedScreen)) {
            throw new IllegalStateException("Expected: " + expectedScreen + " but got: " + currentScreen);
        }
    }

    public ReconfigureBalanceConfirmCommon clickConfirm() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        return new ReconfigureBalanceConfirmCommon(tool, test, user);
    }

}
