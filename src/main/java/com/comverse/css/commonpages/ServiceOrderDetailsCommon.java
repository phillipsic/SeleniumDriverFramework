/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Account;

public class ServiceOrderDetailsCommon extends CommonMenu {

    public ServiceOrderDetailsCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Service Order Details";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void getAccountID(Account account) throws Exception {
        String accountID = driver.findElement(By.xpath("//td[2]/a")).getText();
        System.out.println("AccountID = " + accountID);
        account.setBillingAccountIDProperty(accountID);
    }
    public SearchOrdersCommon clickBack () throws Exception {
    	driver.findElement(By.cssSelector("input[type='submit'][value='Back']")).click();
    	return new SearchOrdersCommon(driver);
    }
}
