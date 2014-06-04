package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPrepaymentConfirmCommon extends CommonMenu {

    public RegisterPrepaymentConfirmCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Register PrePayment";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AccountDetailsCommon clickBackToAccount() throws Exception {

        driver.findElement(By.xpath("//input[@name='confirm']")).click();
        return new AccountDetailsCommon(driver);
    }
}
