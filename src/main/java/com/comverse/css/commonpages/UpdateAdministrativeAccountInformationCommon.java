/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author cchadai
 */
public class UpdateAdministrativeAccountInformationCommon extends CommonMenu {

    public UpdateAdministrativeAccountInformationCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Update administrative account information";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public EnterIdentificationDataCommon clickConfirm() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new EnterIdentificationDataCommon(driver);
    }

    public void setBillingBillDispatchMethod(String SocialSecurityNumber) throws Exception {

        driver.findElement(By.id("p-param-L4:91310")).sendKeys(SocialSecurityNumber);
    }

    public void setBillingBillFormatOption(String PurchaseOrder) throws Exception {

        driver.findElement(By.id("p-param-L4:91300")).sendKeys(PurchaseOrder);
    }

    public void setBillingExchangeRateClass(String SalesCode) throws Exception {

        driver.findElement(By.id("p-param-L4:91380")).sendKeys(SalesCode);
    }

    public void setBillingTML(String BillingTML) throws Exception {

        driver.findElement(By.id("p-param-L4:81270" + BillingTML)).click();
    }

    public void setBillingVIPCode(String SICCode) throws Exception {

        driver.findElement(By.id("p-param-L4:80080")).sendKeys(SICCode);
    }

    public void setBillingBillPeriod(String SICCode) throws Exception {

        driver.findElement(By.id("p-param-L4:81010")).sendKeys(SICCode);
    }

}
