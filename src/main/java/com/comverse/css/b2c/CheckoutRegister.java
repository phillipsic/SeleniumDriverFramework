/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class CheckoutRegister extends B2CMenu {

    public CheckoutRegister(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Checkout Register";

         if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLogFile("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLogFile(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public SignUpUser selectSignMeUpAndClickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        this.selectSignMeUp();
        SignUpUser signUp = this.clickContinue();
        return signUp;
    }

    public CheckOutBillingAccountInformation enterRegisteredLoginDetailsAndClickContinue(String loginName, String password) throws Exception {
        test.writeInLogFile(Common.getMethodName());
        this.setRegisteredLogin(loginName);
        this.setPassword(password);
        this.clickContinueExpectingCheckoutBillingAccountInformation();
        return new CheckOutBillingAccountInformation(tool, test, user);
    }

    public void selectSignMeUp() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("sign_up_anonymous");
    }

    public void setRegisteredLogin(String login) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + login + ")");
        tool.enterStringUsingId("login", login);
    }

    public void setPassword(String password) throws Exception {
        test.writeInLogFile(Common.getMethodName() + " using data (" + password + ")");
        tool.enterStringUsingId("password", password);
    }

    public SignUpUser clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Continue >']");
        return new SignUpUser(tool, test, user);
    }

    public MyBasket clickCancel() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingName("cancel");
        return new MyBasket(tool, test, user);
    }

    public CheckOutBillingAccountInformation clickContinueExpectingCheckoutBillingAccountInformation() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Continue >']");
        return new CheckOutBillingAccountInformation(tool, test, user);
    }
}
