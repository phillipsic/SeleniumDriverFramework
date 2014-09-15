/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ViewBalanceCommon extends CommonMenu {
    static String expectedScreen = "View Balances";

    public ViewBalanceCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public NonVoucherRechargeCommon clickNonVoucherRechargeFreeAmount() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingLinkText("Non voucher Recharge (free amount)");

        return new NonVoucherRechargeCommon(tool, test, user);
    }

    public RechargeWithVoucherCommon clickRechargeByVoucher() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingLinkText("Recharge by voucher");

        return new RechargeWithVoucherCommon(tool, test, user);
    }

    public AdjustBalanceDetailsCommon clickAdjustBalance(String balancename) throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//tr[td/a[contains(text(),'" + balancename + "')]]/td/a[contains(text(),'Adjust')]");

        return new AdjustBalanceDetailsCommon(tool, test, user);
    }

    public ReconfigureBalanceCommon clickConfigureSharedBalance(String balanceName) throws Exception {
        test.writeInLog(Common.getMethodName());
        String balanceID = retrieveBalanceID(balanceName);
        tool.clickUsingXPath("//a[contains(@id, 'configure_balance_') and contains(@id, '_" + balanceID + "')]");
        return new ReconfigureBalanceCommon(tool, test, user);
    }

    public ReconfigureBalanceCommon clickConfigureLimit(String balanceName) throws Exception {
        test.writeInLog(Common.getMethodName());
        String balanceID = retrieveBalanceID(balanceName);

        tool.performUsingXPath("//div[contains(@id, 'youCan_') and contains(@id, '_" + balanceID + "')]");
        tool.clickPerformUsingXPath("//a[contains(@id, 'configure_balance_') and contains(@id, '_" + balanceID + "')]");
        Common.sleepForNumberOfSeconds(3);

        return new ReconfigureBalanceCommon(tool, test, user);
    }

    public void clickBack() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("youcan_ON_BACK");
    }

    public Double getCoreBalance() throws Exception {
        test.writeInLog(Common.getMethodName());

        String coreBalanceString = tool.getTextUsingXPath("//a[contains(.,'CORE BALANCE')]/../../td[2]");
        coreBalanceString = coreBalanceString.replaceAll(",", "");
        Double coreBalance = Double.parseDouble(coreBalanceString.substring(1));
        System.out.println("Core Balance is " + coreBalance);
        return coreBalance;
    }

    public BalanceDetailsCommon viewBalanceDetails(String balanceName) throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingLinkText(balanceName);
        return new BalanceDetailsCommon(tool, test, user);
    }

    // @SuppressWarnings("unused")
    private String retrieveBalanceID(String balanceName) throws Exception {
        test.writeInLog(Common.getMethodName());

        /*
         * String pageSource = tool.getPageSource(); String temp[]; String
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
        String balanceIdDirty = tool.getAttributeUsingXpath("//a[contains(text(), '" + balanceName + "')]", "id");
        temp = balanceIdDirty.split("_");
        int tempSize = temp.length;
        String balanceID = temp[tempSize - 1].trim();

        return balanceID;
    }
}
