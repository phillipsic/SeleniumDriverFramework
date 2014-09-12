/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class CheckoutRegister extends B2CMenu {

    public CheckoutRegister(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Checkout Register";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("Expecting: " + expectedScreen + " , but got: " + currentScreen);
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        test.writeInLog(this.getClass().getSimpleName());
    }

    public SignUpUser selectSignMeUpAndClickContinue() throws Exception {
        test.writeInLog(this.getClass().getSimpleName());
        this.selectSignMeUp();
        SignUpUser signUp = this.clickContinue();
        return signUp;
    }

    public CheckOutBillingAccountInformation enterRegisteredLoginDetailsAndClickContinue(String loginName, String password) throws Exception {

        this.setRegisteredLogin(loginName);
        this.setPassword(password);
        this.clickContinueExpectingCheckoutBillingAccountInformation();
        return new CheckOutBillingAccountInformation(tool, test, user);
    }

    public void selectSignMeUp() throws Exception {

        tool.clickUsingID("sign_up_anonymous");
    }

    public void setRegisteredLogin(String login) throws Exception {

        tool.enterStringUsingId("login", login);
    }

    public void setPassword(String password) throws Exception {

        tool.enterStringUsingId("password", password);
    }

    public SignUpUser clickContinue() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        return new SignUpUser(tool, test, user);
    }

    public MyBasket clickCancel() throws Exception {

        tool.clickUsingName("cancel");
        return new MyBasket(tool, test, user);
    }

    public CheckOutBillingAccountInformation clickContinueExpectingCheckoutBillingAccountInformation() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        return new CheckOutBillingAccountInformation(tool, test, user);
    }
}
