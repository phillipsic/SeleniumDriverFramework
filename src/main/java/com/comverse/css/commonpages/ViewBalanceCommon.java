/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ViewBalanceCommon extends CommonMenu {
    static String expectedScreen = "View Balances";

    public ViewBalanceCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public NonVoucherRechargeCommon clickNonVoucherRechargeFreeAmount() throws Exception {

        tool.clickUsingLinkText(tool, "Non voucher Recharge (free amount)");

        return new NonVoucherRechargeCommon(tool, test, user);
    }

    public RechargeWithVoucherCommon clickRechargeByVoucher() throws Exception {

        tool.clickUsingLinkText(tool, "Recharge by voucher");

        return new RechargeWithVoucherCommon(tool, test, user);
    }

    public AdjustBalanceDetailsCommon clickAdjustBalance(String balancename) throws Exception {
        tool.clickUsingXPath(tool, "//tr[td/a[contains(text(),'" + balancename + "')]]/td/a[contains(text(),'Adjust')]");

        return new AdjustBalanceDetailsCommon(tool, test, user);
    }

    public ReconfigureBalanceCommon clickConfigureSharedBalance(String balanceName) throws Exception {

        String balanceID = retrieveBalanceID(balanceName);
        tool.clickUsingXPath(tool, "//a[contains(@id, 'configure_balance_') and contains(@id, '_" + balanceID + "')]");
        return new ReconfigureBalanceCommon(tool, test, user);
    }

    public ReconfigureBalanceCommon clickConfigureLimit(String balanceName) throws Exception {

        String balanceID = retrieveBalanceID(balanceName);

        Actions action = new Actions(tool.driver);
        action.moveToElement(tool.driver.findElement(By.xpath("//div[contains(@id, 'youCan_') and contains(@id, '_" + balanceID + "')]"))).perform();
        action.moveToElement(tool.driver.findElement(By.xpath("//a[contains(@id, 'configure_balance_') and contains(@id, '_" + balanceID + "')]"))).click().perform();
        Common.sleepForNumberOfSeconds(3);

        return new ReconfigureBalanceCommon(tool, test, user);
    }

    public void clickBack() throws Exception {

        tool.clickUsingID(tool, "youcan_ON_BACK");
    }

    public Double getCoreBalance() throws Exception {

        String coreBalanceString = tool.getTextUsingXPath(tool, "//a[contains(.,'CORE BALANCE')]/../../td[2]");
        coreBalanceString = coreBalanceString.replaceAll(",", "");
        Double coreBalance = Double.parseDouble(coreBalanceString.substring(1));
        System.out.println("Core Balance is " + coreBalance);
        return coreBalance;
    }

    public BalanceDetailsCommon viewBalanceDetails(String balanceName) throws Exception {

        tool.clickUsingLinkText(tool, balanceName);
        return new BalanceDetailsCommon(tool, test, user);
    }

    // @SuppressWarnings("unused")
    private String retrieveBalanceID(String balanceName) throws Exception {

        /*
         * String pageSource = tool.driver.getPageSource(); String temp[]; String
         * cleanString;
         * 
         * temp = pageSource.split("abtr:" + balanceName); temp =
         * temp[1].split("value="); temp = temp[1].split(">");
         * 
         * cleanString = Common.cleanStringOfIllegalChars(temp[0]); cleanString
         * = cleanString.replaceAll("\\(", ""); cleanString =
         * cleanString.replaceAll("\\)", ""); cleanString =
         * cleanString.replaceAll(",", ""); String balanceID =
         * cleanString.replaceAll(">", "");
         */
        String temp[];
        String balanceIdDirty = tool.driver.findElement(By.xpath("//a[contains(text(), '" + balanceName + "')]")).getAttribute("id");
        temp = balanceIdDirty.split("_");
        int tempSize = temp.length;
        String balanceID = temp[tempSize - 1].trim();

        return balanceID;
    }
}
