package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ConfigureBalance extends B2CMenu {

    public ConfigureBalance(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Configure Balance";

         if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public void configureBalance(String balanceName, String balanceValue) throws Exception {

        
        tool.enterStringUsingId(balanceName + "_limit", balanceValue);
    }

    public void setSpendingLimit(String limitName, String spendingLimit) throws Exception {
        
        tool.enterStringUsingId(limitName + "_limit", spendingLimit);
    }

    public void selectTargetAccount(String targetBalance) throws Exception {
        tool.selectVisibleTextByID("targetBalance", targetBalance);
    }

    public ChooseAccessories clickContinue() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ChooseAccessories(tool, test, user);
    }

    public MyBasket clickContinueExpectingMyBasket() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasket(tool, test, user);
    }

    public ConfigureServiceConnectionDetails clickContinueExpectingConfigureServiceConnectionDetails() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        return new ConfigureServiceConnectionDetails(tool, test, user);
    }

    public ConfigureBalanceReview clickConfigureBalance() throws Exception {
        tool.clickUsingXPath("//input[@value= 'Reconfigure Balance']");
        return new ConfigureBalanceReview(tool, test, user);

    }

}
