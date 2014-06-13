/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ChooseYourPrimaryOfferInThisAccountBundle extends B2CMenu {

    public ChooseYourPrimaryOfferInThisAccountBundle(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Choose Your Primary Offer in This Account Bundle";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        System.out.println(">>" + currentScreen);
    }

    public ConfirmAccountBundleChoice selectPrimaryOfferByNameWithoutDevice(String primaryOfferName) throws Exception {

        SelectPOByName(primaryOfferName);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ConfirmAccountBundleChoice(tool, test, user);
    }

    public EnterYourSubscriptionDetails selectPrimaryOfferByNameExpectingSubscriptionDetails(String primaryOfferName) throws Exception {

        SelectPOByName(primaryOfferName);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new EnterYourSubscriptionDetails(tool, test, user);
    }

    public ConfirmAccountBundleChoice selectPrimaryOfferInBundleByName(String primaryOfferName) throws Exception {

        SelectPOByName(primaryOfferName);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ConfirmAccountBundleChoice(tool, test, user);
    }

    public void SelectPOByName(String primaryOfferName) throws Exception {

        int pageCounter = 2;

        boolean beresult = Common.isOfferTextOnPage(tool, primaryOfferName);
        System.out.println("Found offer?  - " + beresult);

        while (beresult == false) {

            // System.out.println("Result - " + bresult + "page - " +
            // pageCounter);
            System.out.println("Now trying to navigate to page - " + pageCounter);

            // tool.driver.findElement(By.xpath("//img[@alt='Next Page (" +
            // pageCounter + ")']")).click();
            tool.driver.findElement(By.xpath("//a[@id='lnk_NAV_NEXT']/img")).click();
            beresult = Common.isOfferTextOnPage(tool, primaryOfferName);
            System.out.println("Found offer? - " + beresult);
            pageCounter++;
        }

        String temp[];

        String str = tool.driver.getPageSource();

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
        tool.clickUsingCssSelector(tool, "#selectButton_" + temp[0]);
        // tool.driver.findElement(By.id("selectButton_" + temp[0])).click();

        System.out.println("Checking for device page");
        if ("Choose Your Device".equals(tool.driver.getTitle())) {

            tool.clickUsingCssSelector(tool, "input[name='nothanks']");
            System.out.println("Checking for device page - found - No Thanks");
        }

    }

    public ChooseAccessories clickNoThanks() throws Exception {
        tool.driver.findElement(By.xpath("//input[@name='nothanks']")).click();
        return new ChooseAccessories(tool, test, user);
    }

    public SubscriberBundleDetails viewDetailsOfPrimaryOffer(String PO) throws Exception {

        tool.driver.findElement(By.xpath(".//p[contains(text(),'" + PO + "')]/../following-sibling::div[1]//input[@type='submit' and @value='View Details']")).click();
        return new SubscriberBundleDetails(tool, test, user);
    }

    public ChooseYourPrimaryOffer clickSwitchToBrowsePrimaryOffers() throws Exception {

        tool.clickUsingCssSelector(tool, "input[type='submit'][value='Switch to Browse Primary Offers']");
        return new ChooseYourPrimaryOffer(tool, test, user);
    }

}
