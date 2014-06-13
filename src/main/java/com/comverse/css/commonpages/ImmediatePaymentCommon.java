/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ImmediatePaymentCommon extends CommonMenu {

    public ImmediatePaymentCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Immediate Payment";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setCardNumber(String value) throws Exception {

        
        tool.enterStringUsingId(tool, "cardNumber", value);
    }

    public void setExpirationDate(String value) throws Exception {

        
        tool.enterStringUsingId(tool, "cardExpirationDate", value);
    }

    public void setCardHolderLastName(String value) throws Exception {

        
        tool.enterStringUsingId(tool, "cardHolderName", value);
    }

    public void setCardHolderFirstName(String value) throws Exception {

        
        tool.enterStringUsingId(tool, "cardHolderFName", value);
    }

    public void setCardSecretCode(String value) throws Exception {

        
        tool.enterStringUsingId(tool, "cardSecretCode", value);
    }

    public CheckoutConfirmationCommon clickContinue() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Continue']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CheckoutConfirmationCommon(tool, test, user);
    }

    public void checkForExistingCreditCardDetailsAndClickNew() throws Exception {

        String existingCreditCard;

        existingCreditCard = this.isCreditCardNew();

        if (existingCreditCard.equals("New")) {
            this.clickCreditCardNew();
        }

    }

    public String isCreditCardNew() throws Exception {

        String creditCard = tool.driver.findElement(By.xpath(".//*/div[3]/form/fieldset[1]/div/div/div[2]/span")).getText();
        System.out.println("Text is:" + creditCard);
        return creditCard;

    }

    public void clickCreditCardNew() throws Exception {

        tool.clickUsingXPath(tool, "//fieldset/div/div/div/input[@value= 'CREDIT_CARD']");
    }

}
