package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ParkTheCurrentBasketCommon extends CommonMenu {

    public ParkTheCurrentBasketCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Park the Current Basket";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterBasketID(String value) throws Exception {

        driver.findElement(By.id("basket")).clear();
        driver.findElement(By.id("basket")).sendKeys(value);
    }

    public void clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
    }
}
