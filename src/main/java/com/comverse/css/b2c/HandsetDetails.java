package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class HandsetDetails extends B2CMenu {

    public HandsetDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Handset Details";

         if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public MyBasket clickBuyOutRight() throws Exception {
        tool.clickUsingCssSelector("input[type='submit'][value='Buy Outright']");
        return new MyBasket(tool, test, user);
    }

    public void clickTermsAndConditionsTab() throws Exception {
        tool.clickUsingXPath(" .//em[contains(.,'Terms and Conditions')]");

    }

    public ChooseYourHandset clickReturnToList() throws Exception {
        tool.clickUsingCssSelector("input[type='submit'][value='Return to List']");
        return new ChooseYourHandset(tool, test, user);
    }
}
