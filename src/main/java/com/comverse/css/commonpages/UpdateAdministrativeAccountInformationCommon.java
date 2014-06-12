/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class UpdateAdministrativeAccountInformationCommon extends CommonMenu {

    public UpdateAdministrativeAccountInformationCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Update administrative account information";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public EnterIdentificationDataCommon clickConfirm() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new EnterIdentificationDataCommon(tool, test, user);
    }

    public void setBillingBillDispatchMethod(String SocialSecurityNumber) throws Exception {

        tool.driver.findElement(By.id("p-param-L4:91310")).sendKeys(SocialSecurityNumber);
    }

    public void setBillingBillFormatOption(String PurchaseOrder) throws Exception {

        tool.driver.findElement(By.id("p-param-L4:91300")).sendKeys(PurchaseOrder);
    }

    public void setBillingExchangeRateClass(String SalesCode) throws Exception {

        tool.driver.findElement(By.id("p-param-L4:91380")).sendKeys(SalesCode);
    }

    public void setBillingTML(String BillingTML) throws Exception {

        tool.driver.findElement(By.id("p-param-L4:81270" + BillingTML)).click();
    }

    public void setBillingVIPCode(String SICCode) throws Exception {

        tool.driver.findElement(By.id("p-param-L4:80080")).sendKeys(SICCode);
    }

    public void setBillingBillPeriod(String SICCode) throws Exception {

        tool.driver.findElement(By.id("p-param-L4:81010")).sendKeys(SICCode);
    }

}
