package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressAdministrationCommon {
    public WebDriver driver;
    static String expectedScreen = "Address Administration";

    public AddressAdministrationCommon(WebDriver driver) {
        this.driver = driver;
        String currentScreen = driver.getTitle();

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public AddressAddCommon clickAdd() throws Exception {

        driver.findElement(By.xpath("//input[@value='Add']")).click();

        return new AddressAddCommon(driver);
    }
}
