package com.comverse.css.commonpages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;

public class PrimaryOfferDetailsCommon extends CommonMenu {

    public PrimaryOfferDetailsCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Primary Offer Details";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickRPOCompatiblePrimaryOffersTab() throws Exception {
        driver.findElement(By.xpath("//em[contains(text(),'Compatible Offers')]")).click();
    }

    public void clickRPOTermsandConditionsTab() throws Exception {
        driver.findElement(By.xpath("//em[contains(text(),'Terms And Conditions')]")).click();
    }
}
