package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ChooseYourPrimaryOffer extends B2CMenu {

    public ChooseYourPrimaryOffer(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Choose Your Primary Offer";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        System.out.println(">>" + currentScreen);
    }

    public EnterYourSubscriptionDetails selectPrimaryOfferByNameWithoutDevice(String primaryOfferName) throws Exception {

        String offerID = this.getPrimaryOfferID(primaryOfferName);
        System.out.println("link = #selectButton_" + offerID);
        tool.clickUsingCssSelector(tool, "#selectButton_" + offerID);
        // tool.clickUsingID(tool, "selectButton_" + temp[0]);

        System.out.println("Checking for device page");
        if ("Choose Your Device".equals(tool.driver.getTitle())) {

            tool.clickUsingCssSelector(tool, "input[name='nothanks']");
            System.out.println("Checking for device page - found - No Thanks");
        }

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new EnterYourSubscriptionDetails(tool, test, user);
    }

    public ChooseYourDevice selectPrimaryOfferByNameWithDevice(String primaryOfferName) throws Exception {

        String offerID = this.getPrimaryOfferID(primaryOfferName);
        System.out.println("link = #selectButton_" + offerID);
        tool.clickUsingCssSelector(tool, "#selectButton_" + offerID);
        // tool.clickUsingID(tool, "selectButton_" + temp[0]);

       /* System.out.println("Checking for device page");
        if ("Choose Your Device".equals(tool.driver.getTitle())) {

            tool.clickUsingCssSelector(tool, "input[name='nothanks']");
            System.out.println("Checking for device page - found - No Thanks");
        }

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());*/
        return new ChooseYourDevice(tool, test, user);
    }

    public EnterYourSubscriptionDetails selectSubscriberBundleByNameWithoutDevice(String subscriberBundleName, String primaryOfferName) throws Exception {

        String subscriberbundleID = this.getSubscriberBundleID(subscriberBundleName);
        String offerID = this.getPrimaryOfferID(primaryOfferName);
        System.out.println("link = #selectButton_" + subscriberbundleID);
        tool.clickUsingCssSelector(tool, "#select_cb_" + subscriberbundleID + " > #selectButton_" + offerID);
        // tool.clickUsingID(tool, "selectButton_" + temp[0]);

        System.out.println("Checking for device page");
        if ("Choose Your Device".equals(tool.driver.getTitle())) {

            tool.clickUsingCssSelector(tool, "input[name='nothanks']");
            System.out.println("Checking for device page - found - No Thanks");
        }

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new EnterYourSubscriptionDetails(tool, test, user);
    }

    public ChooseAccessories clickNoThanks() throws Exception {
        tool.clickUsingXPath(tool, "//input[@name='nothanks']");
        return new ChooseAccessories(tool, test, user);
    }

    public String getPrimaryOfferID(String primaryOfferName) throws Exception {
        int pageCounter = 2;

        boolean beresult = Common.isOfferTextOnPage(tool, primaryOfferName);
        System.out.println("Found offer?  - " + beresult);

        while (beresult == false) {

            System.out.println("Result - " + beresult + "page - " + pageCounter);
            System.out.println("Now trying to navigate to page - " + pageCounter);

            tool.clickUsingXPath(tool, "//img[@alt='Next Page (" + pageCounter + ")']");
            //tool.clickUsingXPath(tool, "//a[@id='lnk_NAV_NEXT']/img");
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

        boolean beresult = Common.isOfferTextOnPage(tool, subscriberBundleName);
        System.out.println("Found bundle?  - " + beresult);

        while (beresult == false) {
            System.out.println("Now trying to navigate to page - " + pageCounter);
            tool.clickUsingXPath(tool, "//a[@id='lnk_NAV_NEXT']/img");
            beresult = Common.isOfferTextOnPage(tool, subscriberBundleName);
            System.out.println("Found bundle? - " + beresult);
            pageCounter++;
        }

        String temp[];

        String str = tool.driver.getPageSource();

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
