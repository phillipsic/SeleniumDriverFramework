package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class RegisterPrepaymentCommon extends CommonMenu {
    static String expectedScreen = "Register Prepayment";

    public RegisterPrepaymentCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void enterAmount(String amount) throws Exception {

        
        tool.enterStringUsingId(tool, "amount", amount);
    }

    public void selectPaymentMethod(String paymentMethod) throws Exception {

        // tool.driver.findElement(By.id(paymentmethod)).click();
        tool.driver.findElement(By.xpath("//input[@value='" + paymentMethod + "']")).click();

    }

    public RegisterPrepaymentCommon clickContinue() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new RegisterPrepaymentCommon(tool, test, user);
    }

    public void enterCardNumber(String cardNumber) throws Exception {
        
        tool.enterStringUsingId(tool, "cardNumber", cardNumber);
    }

    public void enterCardExpDate(String expirationDate) throws Exception {
        
        tool.enterStringUsingId(tool, "cardExpirationDate", expirationDate);
    }

    public void enterCardHolderLastName(String lastName) throws Exception {
        
        tool.enterStringUsingId(tool, "cardHolderName", lastName);
    }

    public void enterCardHolderFirstName(String firstName) throws Exception {
        
        tool.enterStringUsingId(tool, "cardHolderFName", firstName);
    }

    public void enterCardSecretCode(String secretCode) throws Exception {
        
        tool.enterStringUsingId(tool, "cardSecretCode", secretCode);
    }

    public RegisterPrepaymentConfirmCommon clickConfirm() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RegisterPrepaymentConfirmCommon(tool, test, user);
    }

    public void enterZipPostalCode(String postalCode) throws Exception {
        
        tool.enterStringUsingId(tool, "cardZipPostCode", postalCode);
    }
}
