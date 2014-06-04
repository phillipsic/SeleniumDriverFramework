package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectModeOfRecharge extends B2CMenu {

    public SelectModeOfRecharge(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Select mode of recharge";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectFreeAmount() throws Exception {

        driver.findElement(By.xpath("//input[@value='freeAmount']")).click();
    }

    public RechargeWithFreeAmount clickSubmit() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new RechargeWithFreeAmount(driver);
    }
}
