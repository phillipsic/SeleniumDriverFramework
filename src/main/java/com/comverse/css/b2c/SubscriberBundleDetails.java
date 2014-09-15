package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class SubscriberBundleDetails extends B2CMenu {

    public SubscriberBundleDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Subscriber Bundle Details";

         if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public void clickTermsAndConditionsTab() throws Exception {
        tool.clickUsingXPath("//em[contains(text(),'Terms And Conditions')]");

    }

    public ChooseYourPrimaryOfferInThisAccountBundle clickReturnToList() throws Exception {
        tool.clickUsingCssSelector("input[type='submit'][value='Return to List']");
        return new ChooseYourPrimaryOfferInThisAccountBundle(tool, test, user);
    }
}
