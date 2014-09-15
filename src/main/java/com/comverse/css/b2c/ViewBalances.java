package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ViewBalances extends B2CMenu {

    public ViewBalances(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "View Balances";

         if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public double getBalanceValue(String balanceName) throws Exception {

        String balanceValue = tool.getTextUsingXPath("//a[contains(text(),'" + balanceName + "')]/../../td[2]");

        double balanceValueDouble = Common.removeCurrencyAndConvertToDouble(balanceValue);
        return balanceValueDouble;
    }

    public void clickRefreshButton() throws Exception {
        tool.clickUsingXPath("//img[@id='refreshCacheImg']");
    }

    public ConfigureBalance clickConfigure() throws Exception {
        tool.clickUsingLinkText("Configure");
        return new ConfigureBalance(tool, test, user);
    }

    public BalanceDetails clickBalanceDetails(String balanceName) throws Exception {
        tool.clickUsingXPath("//tr[td/a[contains(text(),'" + balanceName + "')]]/td/a[contains(text(),'Details')]");
        return new BalanceDetails(tool, test, user);
    }

    public SubscriberDetail clickBack() throws Exception {
        tool.clickUsingID("youcan_ON_BACK");
        return new SubscriberDetail(tool, test, user);
    }
}
