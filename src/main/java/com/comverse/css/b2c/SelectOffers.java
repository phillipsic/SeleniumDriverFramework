package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class SelectOffers extends B2CMenu {
    public SelectOffers(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Select offers for your Subscriber";

        if (!expectedScreen.equals(tool.getTitle(tool))) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public ConfigureOffers selectOfferByNameAndContinue(String offerName) throws Exception {
        // System.out.println("//div[contains(text(),'"+ offerName +
        // "')]/..//..//input");
        tool.clickUsingXPath(tool, "//div[contains(text(),'" + offerName + "')]/..//..//input");
        // System.out.println("//div[contains(text(),'"+ offerName +
        // "')]/..//..//input");
        tool.clickUsingXPath(tool, "//input[@name='continue_button']");
        return new ConfigureOffers(tool, test, user);

    }

    public AddSO selectOfferByNameAndContinueExpectingAddSO(String offerName) throws Exception {
        System.out.println("//div[contains(text(),'" + offerName + "')]/..//..//input");
        tool.clickUsingXPath(tool, "//div[contains(text(),'" + offerName + "')]/..//..//input");
        System.out.println("//div[contains(text(),'" + offerName + "')]/..//..//input");
        tool.clickUsingXPath(tool, "//input[@name='continue_button']");
        return new AddSO(tool, test, user);

    }

}
