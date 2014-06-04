/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectOffersForYourAccountCommon extends CommonMenu {

    public SelectOffersForYourAccountCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Select offers for your Account";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ConfigureOffersCommon clickContinue() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new ConfigureOffersCommon(driver);
    }

    public MyBasketCommon clickContinueNoConfiguration() throws Exception {
        driver.findElement(By.xpath("//input[@value='Continue >']")).click();
        return new MyBasketCommon(driver);
    }

    public MyBasketCommon clickPrevious() throws Exception {
        driver.findElement(By.cssSelector("input.submitGrey")).click();
        return new MyBasketCommon(driver);
    }

    public void selectAccountOfferByName(String accountOfferName) throws Exception {
        driver.findElement(By.xpath("//div[@class = 'objectName' and contains(.,'" + accountOfferName + "')]/../../td/input")).click();
    }

    public AccountOfferDetailsCommon clickOfferDetail(String accountOfferName) throws Exception {
        driver.findElement(By.xpath("//div[@class = 'objectName' and contains(.,'" + accountOfferName + "')]/../a")).click();
        return new AccountOfferDetailsCommon(driver);
    }
    
    public void clickOfferDetailAndPopUp(String accountOfferName) throws Exception {
        driver.findElement(By.xpath("//div[@class = 'objectName' and contains(.,'" + accountOfferName + "')]/../a")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        
    }
}
