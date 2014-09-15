package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class RegisterPrepaymentCommon extends CommonMenu {
    static String expectedScreen = "Register Prepayment";

    public RegisterPrepaymentCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void enterAmount(String amount) throws Exception {

        
        tool.enterStringUsingId("amount", amount);
    }

    public void selectPaymentMethod(String paymentMethod) throws Exception {

        // tool.clickUsingID(paymentmethod);
        tool.clickUsingXPath("//input[@value='" + paymentMethod + "']");

    }

    public RegisterPrepaymentCommon clickContinue() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue']");
        return new RegisterPrepaymentCommon(tool, test, user);
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

    public RegisterPrepaymentConfirmCommon clickConfirm() throws Exception {

        tool.clickUsingXPath("//input[@value='Confirm']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RegisterPrepaymentConfirmCommon(tool, test, user);
    }

    public void enterZipPostalCode(String postalCode) throws Exception {
        
        tool.enterStringUsingId("cardZipPostCode", postalCode);
    }
}
