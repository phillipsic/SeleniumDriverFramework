/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SupplementaryOfferDetailsCommon extends CommonMenu {

    public SupplementaryOfferDetailsCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Supplementary Offer Details";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SelectOffersForYourSubscriberCommon clickReturnToList() throws Exception {
        driver.findElement(By.name("select")).click();
        return new SelectOffersForYourSubscriberCommon(driver);
    }
}
