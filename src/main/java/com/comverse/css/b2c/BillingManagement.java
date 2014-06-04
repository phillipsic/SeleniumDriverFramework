package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillingManagement extends B2CMenu {

    public BillingManagement(WebDriver driver) {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Billing Management";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public CheckoutReview clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new CheckoutReview(driver);
    }

    public CheckOutBillingAccountInformation clickIWantASeparateBillForFirstSubscriber() throws Exception {

        driver.findElement(By.id("change_billing_contract_0")).click();
        return new CheckOutBillingAccountInformation(driver);
    }

    public CheckOutBillingAccountInformation clickIWantASeparateBillForSecondSubscriber() throws Exception {

        driver.findElement(By.id("change_billing_contract_1")).click();
        return new CheckOutBillingAccountInformation(driver);
    }
}
