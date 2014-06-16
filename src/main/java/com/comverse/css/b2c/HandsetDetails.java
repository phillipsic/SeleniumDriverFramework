package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class HandsetDetails extends B2CMenu {

    public HandsetDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Handset Details";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle(tool))) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MyBasket clickBuyOutRight() throws Exception {
        tool.clickUsingCssSelector(tool, "input[type='submit'][value='Buy Outright']");
        return new MyBasket(tool, test, user);
    }

    public void clickTermsAndConditionsTab() throws Exception {
        tool.clickUsingXPath(tool, " .//em[contains(.,'Terms and Conditions')]");

    }

    public ChooseYourHandset clickReturnToList() throws Exception {
        tool.clickUsingCssSelector(tool, "input[type='submit'][value='Return to List']");
        return new ChooseYourHandset(tool, test, user);
    }
}
