package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ViewBalances extends B2CMenu {

    public ViewBalances(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "View Balances";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public double getBalanceValue(String balanceName) throws Exception {

        String balanceValue = tool.driver.findElement(By.xpath("//a[contains(text(),'" + balanceName + "')]/../../td[2]")).getText();

        double balanceValueDouble = Common.removeCurrencyAndConvertToDouble(balanceValue);
        return balanceValueDouble;
    }

    public void clickRefreshButton() throws Exception {
        tool.clickUsingXPath(tool, "//img[@id='refreshCacheImg']");
    }

    public ConfigureBalance clickConfigure() throws Exception {
        tool.clickUsingLinkText(tool, "Configure");
        return new ConfigureBalance(tool, test, user);
    }

    public BalanceDetails clickBalanceDetails(String balanceName) throws Exception {
        tool.clickUsingXPath(tool, "//tr[td/a[contains(text(),'" + balanceName + "')]]/td/a[contains(text(),'Details')]");
        return new BalanceDetails(tool, test, user);
    }

    public SubscriberDetail clickBack() throws Exception {
        tool.clickUsingID(tool, "youcan_ON_BACK");
        return new SubscriberDetail(tool, test, user);
    }
}
