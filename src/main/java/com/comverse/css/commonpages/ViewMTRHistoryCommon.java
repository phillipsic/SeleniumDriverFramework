/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ViewMTRHistoryCommon extends CommonMenu {

    public ViewMTRHistoryCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        // Check that we're on the right page.
        if (!"View MTR history".equals(currentScreen)) {

            throw new IllegalStateException("Expecting: View MTR history, but got: " + currentScreen);

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

        tool.driver.findElement(By.id("startDate")).clear();
        tool.driver.findElement(By.id("startDate")).sendKeys(fromDate);

    }

    public void enterToDate(String toDate) throws Exception {

        tool.driver.findElement(By.id("endDate")).clear();
        tool.driver.findElement(By.id("endDate")).sendKeys(toDate);

    }

    public void clickSearch() throws Exception {

        tool.driver.findElement(By.xpath("(//input[@value='Search'])[3]")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public String getSearchResults() throws Exception {

        String text = tool.driver.findElement(By.className("resultListTabTitle")).getText();

        // String text =
        // tool.driver.findElement(By.className("art-button").linkText("Submit")).getText();

        System.out.println("Output:" + text);

        return text;
    }

    public ViewMTRDetailsCommon ViewMTRDetails() throws Exception {

        tool.driver.findElement(By.xpath("//fieldset/div/table/tbody[2]/tr/td/div/a")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new ViewMTRDetailsCommon(tool, test, user);

    }

}
