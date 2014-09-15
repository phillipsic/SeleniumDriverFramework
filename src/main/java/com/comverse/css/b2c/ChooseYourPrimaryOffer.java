package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ChooseYourPrimaryOffer extends B2CMenu {

    public ChooseYourPrimaryOffer(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Choose Your Primary Offer";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public EnterYourSubscriptionDetails selectPrimaryOfferByNameWithoutDevice(String primaryOfferName) throws Exception {

        test.writeInLog(Common.getMethodName() + "with data (" + primaryOfferName + ")");
        this.clickSelectPrimaryOffer(primaryOfferName);

        System.out.println("Checking for device page");
        if ("Choose Your Device".equals(tool.getTitle())) {

            tool.clickUsingCssSelector("input[name='nothanks']");
            System.out.println("Checking for device page - found - No Thanks");
        }

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new EnterYourSubscriptionDetails(tool, test, user);
    }

    public void clickSelectPrimaryOffer(String primaryOfferName) throws Exception {

        int pageCounter = 2;

        boolean beresult = Common.isOfferTextOnPage(tool, primaryOfferName);
        System.out.println("Found offer?  - " + beresult);

        while (beresult == false) {

            System.out.println("Result - " + beresult + "page - " + pageCounter);
            System.out.println("Now trying to navigate to page - " + pageCounter);

            tool.clickUsingXPath("//img[@alt='Next Page (" + pageCounter + ")']");
            // tool.clickUsingXPath("//a[@id='lnk_NAV_NEXT']/img");
            beresult = Common.isOfferTextOnPage(tool, primaryOfferName);
            System.out.println("Found offer? - " + beresult);
            pageCounter++;
        }

        tool.clickUsingXPath("//p[text()[normalize-space(.)='" + primaryOfferName + "']]/../..//input[@value='Select']");

    }

    public ChooseYourDevice selectPrimaryOfferByNameWithDevice(String primaryOfferName) throws Exception {

        this.clickSelectPrimaryOffer(primaryOfferName);
        return new ChooseYourDevice(tool, test, user);
    }

    public EnterYourSubscriptionDetails selectPrimaryOfferByNameWithOutDevice(String primaryOfferName) throws Exception {

        System.out.println("Checking for device page");
        if ("Choose Your Device".equals(tool.getTitle())) {

            tool.clickUsingCssSelector("input[name='nothanks']");
            System.out.println("Checking for device page - found - No Thanks");
        }
        this.clickSelectPrimaryOffer(primaryOfferName);
        return new EnterYourSubscriptionDetails(tool, test, user);
    }

    public EnterYourSubscriptionDetails selectSubscriberBundleByNameWithoutDevice(String subscriberBundleName, String primaryOfferName) throws Exception {

        // String subscriberbundleID =
        // this.clickSelectSubscriberBundle(subscriberBundleName);
        // String offerID = this.getPrimaryOfferID(primaryOfferName);
        // System.out.println("link = #selectButton_" + subscriberbundleID);
        // tool.clickUsingCssSelector("#select_cb_" + subscriberbundleID +
        // " > #selectButton_" + offerID);
        // tool.clickUsingID("selectButton_" + temp[0]);
        System.out.println("Checking for device page");
        if ("Choose Your Device".equals(tool.getTitle())) {

            tool.clickUsingCssSelector("input[name='nothanks']");
            System.out.println("Checking for device page - found - No Thanks");
        }

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new EnterYourSubscriptionDetails(tool, test, user);
    }

    public ChooseAccessories clickNoThanks() throws Exception {
        tool.clickUsingXPath("//input[@name='nothanks']");
        return new ChooseAccessories(tool, test, user);
    }

    public String getPrimaryOfferID(String primaryOfferName) throws Exception {
        int pageCounter = 2;

        boolean beresult = Common.isOfferTextOnPage(tool, primaryOfferName);
        System.out.println("Found offer?  - " + beresult);

        while (beresult == false) {

            System.out.println("Result - " + beresult + "page - " + pageCounter);
            System.out.println("Now trying to navigate to page - " + pageCounter);

            tool.clickUsingXPath("//img[@alt='Next Page (" + pageCounter + ")']");
            // tool.clickUsingXPath("//a[@id='lnk_NAV_NEXT']/img");
            beresult = Common.isOfferTextOnPage(tool, primaryOfferName);
            System.out.println("Found offer? - " + beresult);
            pageCounter++;
        }

        String temp[];

        String str = tool.getPageSource();

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

    public String clickSelectSubscriberBundle(String subscriberBundleName) throws Exception {
        int pageCounter = 2;

        boolean beresult = Common.isOfferTextOnPage(tool, subscriberBundleName);
        System.out.println("Found bundle?  - " + beresult);

        while (beresult == false) {
            System.out.println("Now trying to navigate to page - " + pageCounter);
            tool.clickUsingXPath("//a[@id='lnk_NAV_NEXT']/img");
            beresult = Common.isOfferTextOnPage(tool, subscriberBundleName);
            System.out.println("Found bundle? - " + beresult);
            pageCounter++;
        }

        tool.clickUsingXPath("//p[text()[normalize-space(.)='" + subscriberBundleName + "']]/../..//input[@value='Select']");

        // String temp[];

        /*
         * String str = tool.getPageSource();
         * 
         * temp = str.split(subscriberBundleName + " </[pP]>"); // works in IE
         * 
         * if (temp.length == 1) { // This is to cope with chrome
         * 
         * temp = str.split(subscriberBundleName + "\n"); str = temp[1]; temp =
         * str.split("select_cb_"); str = temp[1]; temp = str.split("\"");
         * System.out.println("Bundle ID is = " + temp[0]);
         * 
         * } else {
         * 
         * str = temp[1]; temp = str.split("select_cb_"); str = temp[1]; temp =
         * str.split(" "); System.out.println("Bundle ID is = " + temp[0]); }
         */
        return null;
    }
}
