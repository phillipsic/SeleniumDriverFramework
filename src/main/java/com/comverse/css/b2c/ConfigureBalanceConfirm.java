package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfigureBalanceConfirm extends B2CMenu {

    public ConfigureBalanceConfirm(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Configure balance - Confirm";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ViewBalances clickBack() throws Exception {
        driver.findElement(By.cssSelector("input[type='submit'][value='Back']")).click();
        return new ViewBalances(driver);

    }
}
