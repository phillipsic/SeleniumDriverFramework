/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author iphilli
 */
public class CheckOutBillingAccountInformation extends B2CMenu {

    public CheckOutBillingAccountInformation(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Checkout - Billing Account Information";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public CheckoutReview clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new CheckoutReview(driver);
    }

    public BillingManagement clickContinueExpectingBillingManagement() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new BillingManagement(driver);
    }

    public void clickCheckRadioButton() throws Exception {

        driver.findElement(By.xpath("//input[@id='paymentMethodCode' and @value='CHECK']")).click();
    }

    public void clickDirectDebitRadioButton() throws Exception {

        driver.findElement(By.xpath("//input[@id='paymentMethodCode' and @value='DIRECT_DEBIT']")).click();
    }

    public void enterBankCode(String bankCode) throws Exception {
        driver.findElement(By.id("p-PAYMENT-L3:1360")).clear();
        driver.findElement(By.id("p-PAYMENT-L3:1360")).sendKeys(bankCode);
    }

    public void enterBankAgencyCode(String bankAgencyCode) throws Exception {
        driver.findElement(By.id("p-PAYMENT-L3:1370")).clear();
        driver.findElement(By.id("p-PAYMENT-L3:1370")).sendKeys(bankAgencyCode);
    }

    public void enterBankAccountNumber(String bankAccountNumber) throws Exception {
        driver.findElement(By.id("p-PAYMENT-L3:1380")).clear();
        driver.findElement(By.id("p-PAYMENT-L3:1380")).sendKeys(bankAccountNumber);
    }

    public void enterOwnerLastName(String ownerLastName) throws Exception {
        driver.findElement(By.id("p-PAYMENT-L3:1270")).clear();
        driver.findElement(By.id("p-PAYMENT-L3:1270")).sendKeys(ownerLastName);
    }

    public void selectAccountAttributeLanguage(String language) throws Exception {
        new Select(driver.findElement(By.id("p-ACCOUNT-L4:80000"))).selectByVisibleText(language);
    }

    public void enterCity(String city) throws Exception {

        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys(city);

    }

    public void enterAddressLine1(String addressLine1) throws Exception {

        driver.findElement(By.id("address_line_1")).clear();
        driver.findElement(By.id("address_line_1")).sendKeys(addressLine1);

    }

    public void enterZipPostalCode(String zipCode) throws Exception {

        driver.findElement(By.id("zip")).clear();
        driver.findElement(By.id("zip")).sendKeys(zipCode);

    }

    public void enterState(String state) throws Exception {

        new Select(driver.findElement(By.id("state"))).selectByVisibleText(state);

    }
}
