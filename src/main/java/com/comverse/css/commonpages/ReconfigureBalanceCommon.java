package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ReconfigureBalanceCommon extends CommonMenu {

    static String expectedScreen = "Configure Balance";

    public ReconfigureBalanceCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!currentScreen.equals(expectedScreen)) {
            throw new IllegalStateException("Expected: " + expectedScreen + " but got: " + currentScreen);
        }

    }

    public ReconfigureBalanceCommon setMoreUnitsForThisPeriod(String unitsToAdd) throws Exception {

        tool.driver.findElement(By.id("balanceValue")).sendKeys(unitsToAdd);
        return new ReconfigureBalanceCommon(tool, test, user);
    }

    public ReconfigureBalanceReviewCommon clickAddUnits() throws Exception {

        tool.driver.findElement(By.name("submit_add_units")).click();
        return new ReconfigureBalanceReviewCommon(tool, test, user);
    }

    public ReconfigureBalanceCommon setCreditSpendingLimit(String limitValue) throws Exception {

        tool.driver.findElement(By.id("configuredLimit")).sendKeys(limitValue);
        return new ReconfigureBalanceCommon(tool, test, user);
    }

    public ReconfigureBalanceCommon setCreditSpendingLimitUnlimited() throws Exception {

        tool.driver.findElement(By.name("isUnlimitedCheckBox")).click();
        return new ReconfigureBalanceCommon(tool, test, user);
    }

    public void selectUseAccountUnitsFrom(String selectOption) throws Exception {
        new Select(tool.searchUsingID(tool, "targetBalance")).selectByVisibleText(selectOption);
    }

    public ReconfigureBalanceReviewCommon clickReconfigureBalance() throws Exception {

        tool.driver.findElement(By.name("submit_reconfigure_limit")).click();
        return new ReconfigureBalanceReviewCommon(tool, test, user);
    }

}
