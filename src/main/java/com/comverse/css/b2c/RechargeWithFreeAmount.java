package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RechargeWithFreeAmount extends B2CMenu {

    public RechargeWithFreeAmount(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Recharge with free amount";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterRechargeAmount(String rechargeAmount) throws Exception {

        driver.findElement(By.id("rechargeAmount")).clear();
        driver.findElement(By.id("rechargeAmount")).sendKeys(rechargeAmount);
    }

    public SelectRechargePaymentMethod clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new SelectRechargePaymentMethod(driver);
    }
}
