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

public class ViewUsageHistoryCommon extends CommonMenu {

    public ViewUsageHistoryCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();

        // Check that we're on the right page.
        if (!"View usage history".equals(currentScreen)) {

            throw new IllegalStateException("Expecting: View usage history, but got: " + currentScreen);

        }

    }

    public static String formatDate(Calendar cal) {

        SimpleDateFormat simpleFormatter = new SimpleDateFormat("MM/dd/yyyy");
        return simpleFormatter.format(cal.getTime());

    }

    public void enterToDateTodayFromDateMinus20() throws Exception {  test.writeInLog(Common.getMethodName());

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        this.enterToDate(currentDate);
        Calendar cal = Calendar.getInstance();
        cal.get(Calendar.DAY_OF_MONTH);
        cal.add(Calendar.DAY_OF_MONTH, -20);
        String fromDate = formatDate(cal);
        this.enterFromDate(fromDate);

    }

    public void enterFromDate(String fromDate) throws Exception {  test.writeInLog(Common.getMethodName());

        
        tool.enterStringUsingId("fromDate", fromDate);

    }

    public void enterToDate(String toDate) throws Exception {  test.writeInLog(Common.getMethodName());

        
        tool.enterStringUsingId("toDate", toDate);

    }

    public void clickSearch() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("(//input[@value='Search'])[3]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public String getSearchResults() throws Exception {  test.writeInLog(Common.getMethodName());

        String text = tool.getTextUsingXPath("//table[2]/tbody/tr[3]/td");

        System.out.println("Output:" + text);

        return text;
    }

    public ViewUsageDetailsCommon ViewUsageDetails() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingID("usageDetails");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewUsageDetailsCommon(tool, test, user);
    }
}
