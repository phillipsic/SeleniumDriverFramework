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
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

/**
 * 
 * @author Vikram Sharma
 */
public class ViewUsageHistoryCommon extends CommonMenu {

    public ViewUsageHistoryCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        // Check that we're on the right page.
        if (!"View usage history".equals(currentScreen)) {

            throw new IllegalStateException("Expecting: View usage history, but got: " + currentScreen);

        }

    }

    public static String formatDate(Calendar cal) {

        SimpleDateFormat simpleFormatter = new SimpleDateFormat("MM/dd/yyyy");
        return simpleFormatter.format(cal.getTime());

    }

    public void enterToDateTodayFromDateMinus20() throws Exception {

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

    public void enterFromDate(String fromDate) throws Exception {

        driver.findElement(By.id("fromDate")).clear();
        driver.findElement(By.id("fromDate")).sendKeys(fromDate);

    }

    public void enterToDate(String toDate) throws Exception {

        driver.findElement(By.id("toDate")).clear();
        driver.findElement(By.id("toDate")).sendKeys(toDate);

    }

    public void clickSearch() throws Exception {

        driver.findElement(By.xpath("(//input[@value='Search'])[3]")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
    }

    public String getSearchResults() throws Exception {

        String text = driver.findElement(By.xpath("//table[2]/tbody/tr[3]/td")).getText();

        System.out.println("Output:" + text);

        return text;
    }

    public ViewUsageDetailsCommon ViewUsageDetails() throws Exception {

        driver.findElement(By.id("usageDetails")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewUsageDetailsCommon(driver);
    }
}
