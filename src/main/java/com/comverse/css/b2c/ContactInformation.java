package com.comverse.css.b2c;

import org.openqa.selenium.WebDriver;

public class ContactInformation extends B2CMenu {

    public ContactInformation(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Contact Information";

        if (!expectedScreen.equals(driver.getTitle())) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

}
