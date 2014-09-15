package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class PrimaryOfferDetailsCommon extends CommonMenu {

    public PrimaryOfferDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Primary Offer Details";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void clickRPOCompatiblePrimaryOffersTab() throws Exception {
        tool.clickUsingXPath("//em[contains(text(),'Compatible Offers')]");
    }

    public void clickRPOTermsandConditionsTab() throws Exception {
        tool.clickUsingXPath("//em[contains(text(),'Terms And Conditions')]");
    }
}
