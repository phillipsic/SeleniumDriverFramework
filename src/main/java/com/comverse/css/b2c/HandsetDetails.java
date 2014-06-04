package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HandsetDetails extends B2CMenu {

    public HandsetDetails(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Handset Details";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasket clickBuyOutRight() throws Exception {
        driver.findElement(By.cssSelector("input[type='submit'][value='Buy Outright']")).click();
        return new MyBasket(driver);
    }

    public void clickTermsAndConditionsTab() throws Exception {
        driver.findElement(By.xpath(" .//em[contains(.,'Terms and Conditions')]")).click();

    }

    public ChooseYourHandset clickReturnToList() throws Exception {
        driver.findElement(By.cssSelector("input[type='submit'][value='Return to List']")).click();
        return new ChooseYourHandset(driver);
    }
}
