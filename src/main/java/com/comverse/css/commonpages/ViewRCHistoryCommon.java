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

public class ViewRCHistoryCommon extends CommonMenu {

    public ViewRCHistoryCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();

        // Check that we're on the right page.
        if (!"View RC history".equals(currentScreen)) {

            throw new IllegalStateException("Expecting: View RC history , but got: " + currentScreen);

        }

    }

    public static String formatDate(Calendar cal) {

        SimpleDateFormat simpleFormatter = new SimpleDateFormat("MM/dd/yyyy");
        return simpleFormatter.format(cal.getTime());

    }

    public void enterToDateTodayFromDateMinus10() throws Exception {
        test.writeInLogFile(Common.getMethodName());

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
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("startDate", fromDate);

    }

    public void enterToDate(String toDate) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("endDate", toDate);

    }

    public void clickSearch() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("(//input[@value='Search'])[3]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public String getSearchResults() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        String text = tool.getTextUsingClassName("resultListTabTitle");

        System.out.println("Output:" + text);

        return text;
    }

    public ViewRCTermDetailsCommon ViewRCTermDetails() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//fieldset/div/table/tbody[2]/tr/td/div/a");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new ViewRCTermDetailsCommon(tool, test, user);

    }

}
