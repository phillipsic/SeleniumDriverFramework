package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClearTheCurrentBasketCommon extends CommonMenu {

    public ClearTheCurrentBasketCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Clear the current basket";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AccountDetailsCommon clickOK() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new AccountDetailsCommon(driver);
    }

}
