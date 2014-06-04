package com.comverse.css.b2c;

import org.openqa.selenium.WebDriver;

public class OrderDetails extends B2CMenu {

    public OrderDetails(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Order Details";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

}
