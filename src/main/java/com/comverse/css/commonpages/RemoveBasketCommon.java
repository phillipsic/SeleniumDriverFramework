package com.comverse.css.commonpages;

import org.openqa.selenium.WebDriver;

public class RemoveBasketCommon extends CommonMenu {

    public RemoveBasketCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Remove Basket";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

}
