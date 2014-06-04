/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RemoveOfferCommon extends CommonMenu {

    public RemoveOfferCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Remove Offer";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public OfferCancellationCommon clickYes() throws Exception {
        driver.findElement(By.xpath("(//input[@value='Yes'])")).click();
        return new OfferCancellationCommon(driver);
    }
}
