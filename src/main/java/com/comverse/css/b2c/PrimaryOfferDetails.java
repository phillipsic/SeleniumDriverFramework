package com.comverse.css.b2c;

import org.openqa.selenium.WebDriver;

public class PrimaryOfferDetails extends B2CMenu {

    public PrimaryOfferDetails(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Primary Offer Details";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    
}
