package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AdjustBalanceDetailsCommon extends CommonMenu {
    static String expectedScreen = "Adjust balance - details";

    public AdjustBalanceDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public void enterAdjustmentAmount(String amount) throws Exception {

        tool.driver.findElement(By.id("adjustmentValue")).clear();
        tool.driver.findElement(By.id("adjustmentValue")).sendKeys(amount);
    }

    public AdjustBalanceReviewCommon clickContinue() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new AdjustBalanceReviewCommon(tool, test, user);
    }
}
