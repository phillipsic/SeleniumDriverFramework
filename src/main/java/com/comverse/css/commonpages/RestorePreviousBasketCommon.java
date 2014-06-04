package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class RestorePreviousBasketCommon extends CommonMenu {

    public RestorePreviousBasketCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Restore Previous Basket";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasketCommon clickRestoreSavedBasket() throws Exception {

        driver.findElement(By.xpath("//input[@value='Restore the basket']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new MyBasketCommon(driver);
    }
}
