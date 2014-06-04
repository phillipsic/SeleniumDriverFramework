/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

/**
 * 
 * @author iphilli
 */
public class ChooseYourPrimaryOfferInThisAccountBundle extends B2CMenu {

    public ChooseYourPrimaryOfferInThisAccountBundle(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Choose Your Primary Offer in This Account Bundle";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        System.out.println(">>" + currentScreen);
    }

    public ConfirmAccountBundleChoice selectPrimaryOfferByNameWithoutDevice(String primaryOfferName) throws Exception {

        SelectPOByName(primaryOfferName);
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ConfirmAccountBundleChoice(driver);
    }

    public EnterYourSubscriptionDetails selectPrimaryOfferByNameExpectingSubscriptionDetails(String primaryOfferName) throws Exception {

        SelectPOByName(primaryOfferName);
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new EnterYourSubscriptionDetails(driver);
    }

    public ConfirmAccountBundleChoice selectPrimaryOfferInBundleByName(String primaryOfferName) throws Exception {

        SelectPOByName(primaryOfferName);
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ConfirmAccountBundleChoice(driver);
    }

    public void SelectPOByName(String primaryOfferName) throws Exception {

        int pageCounter = 2;

        boolean beresult = Common.isOfferTextOnPage(driver, primaryOfferName);
        System.out.println("Found offer?  - " + beresult);

        while (beresult == false) {

            // System.out.println("Result - " + bresult + "page - " +
            // pageCounter);
            System.out.println("Now trying to navigate to page - " + pageCounter);

            // driver.findElement(By.xpath("//img[@alt='Next Page (" +
            // pageCounter + ")']")).click();
            driver.findElement(By.xpath("//a[@id='lnk_NAV_NEXT']/img")).click();
            beresult = Common.isOfferTextOnPage(driver, primaryOfferName);
            System.out.println("Found offer? - " + beresult);
            pageCounter++;
        }

        String temp[];

        String str = driver.getPageSource();

        temp = str.split(primaryOfferName + " </[pP]>"); // works in IE

        if (temp.length == 1) { // This is to cope with chrome

            temp = str.split(primaryOfferName + "\n");
            str = temp[1];
            temp = str.split("selectButton_");
            str = temp[1];
            temp = str.split("\"");
            System.out.println("Offer ID is = " + temp[0]);

        } else {

            str = temp[1];
            temp = str.split("selectButton_");
            str = temp[1];
            temp = str.split(" ");
            System.out.println("Offer ID is = " + temp[0]);
        }

        System.out.println("link = #selectButton_" + temp[0]);
        driver.findElement(By.cssSelector("#selectButton_" + temp[0])).click();
        // driver.findElement(By.id("selectButton_" + temp[0])).click();

        System.out.println("Checking for device page");
        if ("Choose Your Device".equals(driver.getTitle())) {

            driver.findElement(By.cssSelector("input[name='nothanks']")).click();
            System.out.println("Checking for device page - found - No Thanks");
        }

    }

    public ChooseAccessories clickNoThanks() throws Exception {
        driver.findElement(By.xpath("//input[@name='nothanks']")).click();
        return new ChooseAccessories(driver);
    }

    public SubscriberBundleDetails viewDetailsOfPrimaryOffer(String PO) throws Exception {

        driver.findElement(By.xpath(".//p[contains(text(),'" + PO + "')]/../following-sibling::div[1]//input[@type='submit' and @value='View Details']")).click();
        return new SubscriberBundleDetails(driver);
    }

    public ChooseYourPrimaryOffer clickSwitchToBrowsePrimaryOffers() throws Exception {

        driver.findElement(By.cssSelector("input[type='submit'][value='Switch to Browse Primary Offers']")).click();
        return new ChooseYourPrimaryOffer(driver);
    }

}
