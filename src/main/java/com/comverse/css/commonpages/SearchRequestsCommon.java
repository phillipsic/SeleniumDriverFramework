/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author iphilli
 */
public class SearchRequestsCommon extends CommonMenu {

    public SearchRequestsCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Search RequestsView Requests";

        if (!expectedScreen.contains(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SearchOrdersCommon clickSearchOrders() throws Exception {

        driver.findElement(By.id("smnu_ORDER")).click();
        return new SearchOrdersCommon(driver);
    }

}
