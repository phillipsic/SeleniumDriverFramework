/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class CheckOutBillingAccountInformation extends B2CMenu {

    public CheckOutBillingAccountInformation(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Checkout - Billing Account Information";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public CheckoutReview clickContinue() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new CheckoutReview(tool, test, user);
    }

    public BillingManagement clickContinueExpectingBillingManagement() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new BillingManagement(tool, test, user);
    }

    public void clickCheckRadioButton() throws Exception {

        tool.driver.findElement(By.xpath("//input[@id='paymentMethodCode' and @value='CHECK']")).click();
    }

    public void clickDirectDebitRadioButton() throws Exception {

        tool.driver.findElement(By.xpath("//input[@id='paymentMethodCode' and @value='DIRECT_DEBIT']")).click();
    }

    public void enterBankCode(String bankCode) throws Exception {
        tool.driver.findElement(By.id("p-PAYMENT-L3:1360")).clear();
        tool.driver.findElement(By.id("p-PAYMENT-L3:1360")).sendKeys(bankCode);
    }

    public void enterBankAgencyCode(String bankAgencyCode) throws Exception {
        tool.driver.findElement(By.id("p-PAYMENT-L3:1370")).clear();
        tool.driver.findElement(By.id("p-PAYMENT-L3:1370")).sendKeys(bankAgencyCode);
    }

    public void enterBankAccountNumber(String bankAccountNumber) throws Exception {
        tool.driver.findElement(By.id("p-PAYMENT-L3:1380")).clear();
        tool.driver.findElement(By.id("p-PAYMENT-L3:1380")).sendKeys(bankAccountNumber);
    }

    public void enterOwnerLastName(String ownerLastName) throws Exception {
        tool.driver.findElement(By.id("p-PAYMENT-L3:1270")).clear();
        tool.driver.findElement(By.id("p-PAYMENT-L3:1270")).sendKeys(ownerLastName);
    }

    public void selectAccountAttributeLanguage(String language) throws Exception {
        new Select(tool.driver.findElement(By.id("p-ACCOUNT-L4:80000"))).selectByVisibleText(language);
    }

    public void enterCity(String city) throws Exception {

        tool.driver.findElement(By.id("city")).clear();
        tool.driver.findElement(By.id("city")).sendKeys(city);

    }

    public void enterAddressLine1(String addressLine1) throws Exception {

        tool.driver.findElement(By.id("address_line_1")).clear();
        tool.driver.findElement(By.id("address_line_1")).sendKeys(addressLine1);

    }

    public void enterZipPostalCode(String zipCode) throws Exception {

        tool.driver.findElement(By.id("zip")).clear();
        tool.driver.findElement(By.id("zip")).sendKeys(zipCode);

    }

    public void enterState(String state) throws Exception {

        new Select(tool.driver.findElement(By.id("state"))).selectByVisibleText(state);

    }
}
