package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author iphilli
 */
public class UpdateAccountContactInformationsCommon extends CommonMenu {

    public UpdateAccountContactInformationsCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Update account contact informations";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public String getLastName() throws Exception {

        return driver.findElement(By.id("last_name")).getAttribute("value");
    }

    public String getFirstName() throws Exception {

        return driver.findElement(By.xpath("first_name")).getAttribute("value");
    }

    public String getTitle() throws Exception {

        return driver.findElement(By.xpath("titleString")).getAttribute("value");
    }
}
