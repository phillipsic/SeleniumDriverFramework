package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

/**
 * 
 * @author iphilli
 */
public class ChooseYourPrimaryOffer extends B2CMenu {

    public ChooseYourPrimaryOffer(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Choose Your Primary Offer";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        System.out.println(">>" + currentScreen);
    }

    public EnterYourSubscriptionDetails selectPrimaryOfferByNameWithoutDevice(String primaryOfferName) throws Exception {

        String offerID = this.getPrimaryOfferID(primaryOfferName);
        System.out.println("link = #selectButton_" + offerID);
        driver.findElement(By.cssSelector("#selectButton_" + offerID)).click();
        // driver.findElement(By.id("selectButton_" + temp[0])).click();

        System.out.println("Checking for device page");
        if ("Choose Your Device".equals(driver.getTitle())) {

            driver.findElement(By.cssSelector("input[name='nothanks']")).click();
            System.out.println("Checking for device page - found - No Thanks");
        }

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new EnterYourSubscriptionDetails(driver);
    }

    public ChooseYourDevice selectPrimaryOfferByNameWithDevice(String primaryOfferName) throws Exception {

        String offerID = this.getPrimaryOfferID(primaryOfferName);
        System.out.println("link = #selectButton_" + offerID);
        driver.findElement(By.cssSelector("#selectButton_" + offerID)).click();
        // driver.findElement(By.id("selectButton_" + temp[0])).click();

        System.out.println("Checking for device page");
        if ("Choose Your Device".equals(driver.getTitle())) {

            driver.findElement(By.cssSelector("input[name='nothanks']")).click();
            System.out.println("Checking for device page - found - No Thanks");
        }

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ChooseYourDevice(driver);
    }

    public EnterYourSubscriptionDetails selectSubscriberBundleByNameWithoutDevice(String subscriberBundleName, String primaryOfferName) throws Exception {

        String subscriberbundleID = this.getSubscriberBundleID(subscriberBundleName);
        String offerID = this.getPrimaryOfferID(primaryOfferName);
        System.out.println("link = #selectButton_" + subscriberbundleID);
        driver.findElement(By.cssSelector("#select_cb_" + subscriberbundleID + " > #selectButton_" + offerID)).click();
        // driver.findElement(By.id("selectButton_" + temp[0])).click();

        System.out.println("Checking for device page");
        if ("Choose Your Device".equals(driver.getTitle())) {

            driver.findElement(By.cssSelector("input[name='nothanks']")).click();
            System.out.println("Checking for device page - found - No Thanks");
        }

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new EnterYourSubscriptionDetails(driver);
    }

    public ChooseAccessories clickNoThanks() throws Exception {
        driver.findElement(By.xpath("//input[@name='nothanks']")).click();
        return new ChooseAccessories(driver);
    }

    public String getPrimaryOfferID(String primaryOfferName) throws Exception {
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
            temp = str.split("select_pp_");
            str = temp[1];
            temp = str.split("\"");
            System.out.println("Offer ID is = " + temp[0]);

        } else {

            str = temp[1];
            temp = str.split("select_pp_");
            str = temp[1];
            temp = str.split(" ");
            System.out.println("Offer ID is = " + temp[0]);
        }
        return temp[0];
    }

    public String getSubscriberBundleID(String subscriberBundleName) throws Exception {
        int pageCounter = 2;

        boolean beresult = Common.isOfferTextOnPage(driver, subscriberBundleName);
        System.out.println("Found bundle?  - " + beresult);

        while (beresult == false) {

            // System.out.println("Result - " + bresult + "page - " +
            // pageCounter);
            System.out.println("Now trying to navigate to page - " + pageCounter);

            // driver.findElement(By.xpath("//img[@alt='Next Page (" +
            // pageCounter + ")']")).click();
            driver.findElement(By.xpath("//a[@id='lnk_NAV_NEXT']/img")).click();
            beresult = Common.isOfferTextOnPage(driver, subscriberBundleName);
            System.out.println("Found bundle? - " + beresult);
            pageCounter++;
        }

        String temp[];

        String str = driver.getPageSource();

        temp = str.split(subscriberBundleName + " </[pP]>"); // works in IE

        if (temp.length == 1) { // This is to cope with chrome

            temp = str.split(subscriberBundleName + "\n");
            str = temp[1];
            temp = str.split("select_cb_");
            str = temp[1];
            temp = str.split("\"");
            System.out.println("Bundle ID is = " + temp[0]);

        } else {

            str = temp[1];
            temp = str.split("select_cb_");
            str = temp[1];
            temp = str.split(" ");
            System.out.println("Bundle ID is = " + temp[0]);
        }

        return temp[0];
    }
}
