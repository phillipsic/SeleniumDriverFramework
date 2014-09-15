/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ImmediatePaymentCommon extends CommonMenu {

    public ImmediatePaymentCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Immediate Payment";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void setCardNumber(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.enterStringUsingId("cardNumber", value);
    }

    public void setEmail(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.enterStringUsingId("cardEmail", value);
    }

    public void setAddress(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.enterStringUsingId("cardAddresLine1", value);
    }

    public void setExpirationDate(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.enterStringUsingId("cardExpirationDate", value);
    }

    public void setCardHolderLastName(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.enterStringUsingId("cardHolderName", value);
    }

    public void setCardHolderFirstName(String value) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("cardHolderFName", value);
    }

    public void setCardSecretCode(String value) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.enterStringUsingId("cardSecretCode", value);
    }

    public CheckoutConfirmationCommon clickContinue() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Continue']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CheckoutConfirmationCommon(tool, test, user);
    }

    public void checkForExistingCreditCardDetailsAndClickNew() throws Exception {  test.writeInLog(Common.getMethodName());

        boolean existingCreditCard;

        existingCreditCard = this.isCreditCardNew();

        if (existingCreditCard) {
            this.clickCreditCardNew();
        }

    }

    public boolean isCreditCardNew() throws Exception {  test.writeInLog(Common.getMethodName());

        boolean creditCardExists = Common.isTextOnPage(tool, "************1111");
        //String creditCard = tool.getTextUsingXPath(".//*/div[3]/form/fieldset[1]/div/div/div[2]/span");
        System.out.println("Existing Credit Card:" + creditCardExists);
        return creditCardExists;

    }

    public void clickCreditCardNew() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//fieldset/div/div/div/input[@value= 'CREDIT_CARD']");
    }

}
