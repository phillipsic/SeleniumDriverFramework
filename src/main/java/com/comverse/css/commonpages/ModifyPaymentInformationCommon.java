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
public class ModifyPaymentInformationCommon extends CommonMenu {

    public ModifyPaymentInformationCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Modify Payment Information";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setPaymentMethodDirectDebit() throws Exception {

        driver.findElement(By.name("method")).click();
    }

    public void setBankCode(String value) throws Exception {

        driver.findElement(By.id("p-L1:1-L3:1360")).clear();
        driver.findElement(By.id("p-L1:1-L3:1360")).sendKeys(value);
    }

    public void setBankAgencyCode(String value) throws Exception {

        driver.findElement(By.id("p-L1:1-L3:1370")).clear();
        driver.findElement(By.id("p-L1:1-L3:1370")).sendKeys(value);
    }

    public void setBankAccountNumber(String value) throws Exception {

        driver.findElement(By.id("p-L1:1-L3:1380")).clear();
        driver.findElement(By.id("p-L1:1-L3:1380")).sendKeys(value);
    }

    public void setOwnerlastName(String value) throws Exception {

        driver.findElement(By.id("p-L1:1-L3:1270")).clear();
        driver.findElement(By.id("p-L1:1-L3:1270")).sendKeys(value);
    }

    public ModifyPaymentMethodCommon clickModifyPaymentButton() throws Exception {

        driver.findElement(By.xpath("//input[@value='Modify Payment Method']")).click();
        return new ModifyPaymentMethodCommon(driver);
    }

    public String getBankCode() throws Exception {

        return driver.findElement(By.id("p-L1:1-L3:1360")).getAttribute("value");
    }

    public String getBankAgencyCode() throws Exception {

        return driver.findElement(By.id("p-L1:1-L3:1370")).getAttribute("value");
    }

    public String getBankAccountNumber() throws Exception {

        return driver.findElement(By.id("p-L1:1-L3:1380")).getAttribute("value");
    }
}
