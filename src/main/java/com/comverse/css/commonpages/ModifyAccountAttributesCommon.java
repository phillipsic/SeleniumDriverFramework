/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

/**
 * 
 * @author iphilli
 */
public class ModifyAccountAttributesCommon extends CommonMenu {

    public ModifyAccountAttributesCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Modify Account Attributes";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterSecurityNumber(String value) throws Exception {
        driver.findElement(By.xpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[2]/input")).clear();
        driver.findElement(By.xpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[2]/input")).sendKeys(value);
    }

    public void enterPurchaseOrder(String value) throws Exception {
        driver.findElement(By.xpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[3]/input")).clear();
        driver.findElement(By.xpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[3]/input")).sendKeys(value);
    }

    public void enterSalesCode(String value) throws Exception {
        driver.findElement(By.xpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[4]/input")).clear();
        driver.findElement(By.xpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[4]/input")).sendKeys(value);
    }

    public void enterSecurityWord(String value) throws Exception {
        driver.findElement(By.xpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[5]/input")).clear();
        driver.findElement(By.xpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[5]/input")).sendKeys(value);
    }

    public void enterSICWord(String value) throws Exception {
        driver.findElement(By.xpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[6]/input")).clear();
        driver.findElement(By.xpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[6]/input")).sendKeys(value);
    }

    public RequestSubmissionCommon clickModifyAttributes() throws Exception {

        driver.findElement(By.xpath("//input[@value='Modify Attributes']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new RequestSubmissionCommon(driver);
    }

    public String getSecurityNumber() throws Exception {

        return driver.findElement(By.xpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[2]/input")).getAttribute("value");
    }

    public String getPurchaseOrder() throws Exception {

        return driver.findElement(By.xpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[3]/input")).getAttribute("value");
    }

    public String getSalesCode() throws Exception {

        return driver.findElement(By.xpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[4]/input")).getAttribute("value");
    }

    public String getSecurityWord() throws Exception {

        return driver.findElement(By.xpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[5]/input")).getAttribute("value");
    }

    public String getSICWord() throws Exception {

        return driver.findElement(By.xpath("//form[@id='MODIFY_ATTRIBUTES']/div/div[2]/fieldset/div[6]/input")).getAttribute("value");
    }
}
