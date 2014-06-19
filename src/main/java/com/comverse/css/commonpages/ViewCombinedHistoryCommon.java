/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ViewCombinedHistoryCommon extends CommonMenu {
    static String expectedScreen = "View combined history";

    public ViewCombinedHistoryCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle(tool);

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public static String formatDate(Calendar cal) {

        SimpleDateFormat simpleFormatter = new SimpleDateFormat("MM/dd/yyyy");
        return simpleFormatter.format(cal.getTime());

    }

    public void enterToDateTodayFromDateMinus10() throws Exception {

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        this.enterToDate(currentDate);
        Calendar cal = Calendar.getInstance();
        cal.get(Calendar.MONTH);
        cal.add(Calendar.MONTH, -10);
        String fromDate = formatDate(cal);
        this.enterFromDate(fromDate);

    }

    public void enterFromDate(String fromDate) throws Exception {

        tool.enterStringUsingId(tool, "fromDate", fromDate);

    }

    public void enterToDate(String toDate) throws Exception {

        tool.enterStringUsingId(tool, "toDate", toDate);

    }

    public void deselectbox() throws Exception {
        tool.deselectVisibleTextByID(tool, "R_SYSTEM_Combined_History_P_TRANSACTION_TYPES_PROMPT", "Adjustment");
        tool.deselectVisibleTextByID(tool, "R_SYSTEM_Combined_History_P_TRANSACTION_TYPES_PROMPT", "MTR");
        tool.deselectVisibleTextByID(tool, "R_SYSTEM_Combined_History_P_TRANSACTION_TYPES_PROMPT", "RC");
        tool.deselectVisibleTextByID(tool, "R_SYSTEM_Combined_History_P_TRANSACTION_TYPES_PROMPT", "Recharge");
        tool.deselectVisibleTextByID(tool, "R_SYSTEM_Combined_History_P_TRANSACTION_TYPES_PROMPT", "Usage");
    }

    public void clickSearch() throws Exception {

        tool.clickUsingName(tool, "B1");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public String getSearchResults() throws Exception {
        String text = tool.getTextUsingClassName(tool, "inverseHeaderText");
        System.out.println("Output:" + text);
        return text;
    }

    public ViewNRCTermDetailsCommon ViewNRCTermDetails() throws Exception {

        tool.clickUsingID(tool, "transactionDetails");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new ViewNRCTermDetailsCommon(tool, test, user);

    }

}
