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
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ViewCombinedHistoryCommon extends CommonMenu {
    static String expectedScreen = "View combined history";

    public ViewCombinedHistoryCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

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

        tool.driver.findElement(By.id("fromDate")).clear();
        tool.driver.findElement(By.id("fromDate")).sendKeys(fromDate);

    }

    public void enterToDate(String toDate) throws Exception {

        tool.driver.findElement(By.id("toDate")).clear();
        tool.driver.findElement(By.id("toDate")).sendKeys(toDate);

    }

    public void deselectbox() throws Exception {

        Select selectBox = new Select(tool.searchUsingID(tool, "R_SYSTEM_Combined_History_P_TRANSACTION_TYPES_PROMPT"));
        selectBox.deselectByVisibleText("Adjustment");
        selectBox.deselectByVisibleText("MTR");
        selectBox.deselectByVisibleText("RC");
        selectBox.deselectByVisibleText("Recharge");
        selectBox.deselectByVisibleText("Usage");

    }

    public void clickSearch() throws Exception {

        tool.driver.findElement(By.name("B1")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public String getSearchResults() throws Exception {

        String text = tool.driver.findElement(By.className("inverseHeaderText")).getText();
        System.out.println("Output:" + text);
        return text;
    }

    public ViewNRCTermDetailsCommon ViewNRCTermDetails() throws Exception {

        tool.driver.findElement(By.id("transactionDetails")).click();

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new ViewNRCTermDetailsCommon(tool, test, user);

    }

}
