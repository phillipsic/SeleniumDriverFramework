package com.comverse.css.commonpages;

import org.openqa.selenium.WebDriver;

public class OrderDetailsCommon {

    public WebDriver driver;

    public OrderDetailsCommon(WebDriver driver) {
        this.driver = driver;
        String currentScreen = driver.getTitle();
        String expectedScreen = "Order Details";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }
}
