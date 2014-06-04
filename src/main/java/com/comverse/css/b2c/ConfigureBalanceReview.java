package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfigureBalanceReview extends B2CMenu {

    public ConfigureBalanceReview(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Configure balance - Review";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ConfigureBalanceConfirm clickConfirm() throws Exception {
        driver.findElement(By.cssSelector("input[type='button'][value='Confirm']")).click();
        return new ConfigureBalanceConfirm(driver);

    }

    public ViewBalances clickBack() throws Exception {
        driver.findElement(By.cssSelector("input[type='submit'][value='Back']")).click();
        return new ViewBalances(driver);

    }
}
