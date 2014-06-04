package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RemoveOffer extends B2CMenu {

    public RemoveOffer(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Remove Offer";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public OfferCancellation ClickYes() throws Exception {
        driver.findElement(By.cssSelector("input[type='submit'][value='Yes']")).click();
        return new OfferCancellation(driver);
    }

}
