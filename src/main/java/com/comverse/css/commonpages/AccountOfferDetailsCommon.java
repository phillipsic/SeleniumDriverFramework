/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountOfferDetailsCommon extends CommonMenu {
    static String expectedScreen = "Account Offer Detail";

    public AccountOfferDetailsCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SelectOffersForYourAccountCommon clickReturnToList() throws Exception {
        driver.findElement(By.name("select")).click();
        return new SelectOffersForYourAccountCommon(driver);
    }

}
