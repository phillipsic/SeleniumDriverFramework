package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class SubscriberBundleDetails extends B2CMenu {

    public SubscriberBundleDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Subscriber Bundle Details";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickTermsAndConditionsTab() throws Exception {
        tool.clickUsingXPath(tool, "//em[contains(text(),'Terms And Conditions')]");

    }

    public ChooseYourPrimaryOfferInThisAccountBundle clickReturnToList() throws Exception {
        tool.clickUsingCssSelector(tool, "input[type='submit'][value='Return to List']");
        return new ChooseYourPrimaryOfferInThisAccountBundle(tool, test, user);
    }
}
