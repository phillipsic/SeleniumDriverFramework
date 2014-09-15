package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ImmediatePayment extends B2CMenu {

    public ImmediatePayment(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Immediate Payment";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public void enterCardNumber(String cardNumber) throws Exception {
        
        tool.enterStringUsingId("cardNumber", cardNumber);
    }

    public void enterCardExpDate(String expirationDate) throws Exception {
        
        tool.enterStringUsingId("cardExpirationDate", expirationDate);
    }

    public void enterCardHolderLastName(String lastName) throws Exception {
        
        tool.enterStringUsingId("cardHolderName", lastName);
    }

    public void enterCardHolderFirstName(String firstName) throws Exception {
        
        tool.enterStringUsingId("cardHolderFName", firstName);
    }

    public void enterCardSecretCode(String secretCode) throws Exception {
        
        tool.enterStringUsingId("cardSecretCode", secretCode);
    }

    public CheckoutConfirmation clickContinue() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CheckoutConfirmation(tool, test, user);
    }
}
