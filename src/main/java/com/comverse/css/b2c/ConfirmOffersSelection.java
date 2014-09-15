package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ConfirmOffersSelection extends B2CMenu {

    public ConfirmOffersSelection(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Confirm Offers Selection";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public MyBasket clickConfirmOffer() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Confirm Offer Personalization']");
        return new MyBasket(tool, test, user);
    }

    public void enterVoiceMailSize(String voiceMailSize) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + voiceMailSize + ")");
        tool.enterStringUsingXPath("//label[contains(text(),'Voice Mail Size')]/../input", voiceMailSize);
    }

}
