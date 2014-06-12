package com.comverse.sfa;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class sfaProduct extends SFAMenu {

    public sfaProduct(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        /*
         * String expectedTitle = "Products"; String currentTitle =
         * tool.driver.findElement
         * (By.xpath("//span[contains(text(), 'Products')]")).getText(); if
         * (!currentTitle.equals(expectedTitle)) { throw new
         * IllegalStateException("Expected Product screen doesn't show");
         * 
         * }
         */
    }

    sfaB2BLead selectProductForB2BLead(String productName) throws Exception {

        String curentWindow = Common.getCurrentWindowHandle(tool);

        tool.driver.findElement(By.id("I7olilf")).clear();
        tool.driver.findElement(By.id("I7olilf")).sendKeys(productName);
        tool.driver.findElement(By.id("$n1almt_filterbutton")).click();
        Common.sleepForNumberOfSeconds(2);
        if (!driver.findElement(By.id("$n1almt_rowChkBox_0")).isSelected()) {
            tool.driver.findElement(By.id("$n1almt_rowChkBox_0")).click();
        }
        tool.driver.findElement(By.id("Af7fj1i")).click();
        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, curentWindow);

        return new sfaB2BLead(tool, test, user);
    }

    sfaOpportunity selectProductForOpportunity(String productName) throws Exception {
        String curentWindow = Common.getCurrentWindowHandle(tool);

        tool.driver.findElement(By.id("Imintjv")).clear();
        tool.driver.findElement(By.id("Imintjv")).sendKeys(productName);
        tool.driver.findElement(By.id("$ncrm6b_filterbutton")).click();
        Common.sleepForNumberOfSeconds(2);
        if (!driver.findElement(By.id("$ncrm6b_rowChkBox_0")).isSelected()) {
            tool.driver.findElement(By.id("$ncrm6b_rowChkBox_0")).click();
        }
        tool.driver.findElement(By.id("Ar4pj4u")).click();
        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, curentWindow);

        return new sfaOpportunity(tool, test, user);
    }

}
