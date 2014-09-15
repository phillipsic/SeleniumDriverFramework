package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class SelectOffers extends B2CMenu {
    public SelectOffers(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Select offers for your Subscriber";

         if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public ConfigureOffers selectOfferByNameAndContinue(String offerName) throws Exception {
        // System.out.println("//div[contains(text(),'"+ offerName +
        // "')]/..//..//input");
        tool.clickUsingXPath("//div[contains(text(),'" + offerName + "')]/..//..//input");
        // System.out.println("//div[contains(text(),'"+ offerName +
        // "')]/..//..//input");
        tool.clickUsingXPath("//input[@name='continue_button']");
        return new ConfigureOffers(tool, test, user);

    }

    public AddSupplementaryOffers selectOfferByNameAndContinueExpectingAddSO(String offerName) throws Exception {
        System.out.println("//div[contains(text(),'" + offerName + "')]/..//..//input");
        tool.clickUsingXPath("//div[contains(text(),'" + offerName + "')]/..//..//input");
        System.out.println("//div[contains(text(),'" + offerName + "')]/..//..//input");
        tool.clickUsingXPath("//input[@name='continue_button']");
        return new AddSupplementaryOffers(tool, test, user);

    }

}
