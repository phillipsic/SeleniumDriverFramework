/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author gmaroth
 */
public class RechargeWithVoucherCommon extends CommonMenu {

    public RechargeWithVoucherCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Recharge with voucher";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

       public void enterVoucherNumber(String voucherNumber) throws Exception {
        driver.findElement(By.id("pkgnumber")).clear();
        driver.findElement(By.id("pkgnumber")).sendKeys(voucherNumber);
    }

       public RechargeSubscriberCommon clickContinue() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new RechargeSubscriberCommon(driver);
    }

}
