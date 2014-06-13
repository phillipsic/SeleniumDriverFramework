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
        
        tool.enterStringUsingId(tool, "p-PAYMENT-L3:1360", bankCode);
    }

    public void enterBankAgencyCode(String bankAgencyCode) throws Exception {
        
        tool.enterStringUsingId(tool, "p-PAYMENT-L3:1370", bankAgencyCode);
    }

    public void enterBankAccountNumber(String bankAccountNumber) throws Exception {
        
        tool.enterStringUsingId(tool, "p-PAYMENT-L3:1380", bankAccountNumber);
    }

    public void enterOwnerLastName(String ownerLastName) throws Exception {
        
        tool.enterStringUsingId(tool, "p-PAYMENT-L3:1270", ownerLastName);
    }

    public void selectAccountAttributeLanguage(String language) throws Exception {
        new Select(tool.searchUsingID(tool, "p-ACCOUNT-L4:80000")).selectByVisibleText(language);
    }

    public void enterCity(String city) throws Exception {

        
        tool.enterStringUsingId(tool, "city", city);

    }

    public void enterAddressLine1(String addressLine1) throws Exception {

        
        tool.enterStringUsingId(tool, "address_line_1", addressLine1);

    }

    public void enterZipPostalCode(String zipCode) throws Exception {

        
        tool.enterStringUsingId(tool, "zip", zipCode);

    }

    public void enterState(String state) throws Exception {

        new Select(tool.searchUsingID(tool, "state")).selectByVisibleText(state);

    }
}
