package com.company.mercurytours.pages;

import com.framework.app.common.Common;
import com.framework.common.AutomationTool;
import com.framework.common.TestDetails;
import com.framework.common.User;

/**
 *
 * @author Ian Phillips
 */
public class RegisterMercuryTours extends MercuryToursMenu {

    public RegisterMercuryTours(AutomationTool tool, TestDetails test, User user) throws Exception {
        super(tool, test, user);

        String expectedScreen = "Register: Mercury Tours";
        Common.assertCorrectPageTitle(tool, expectedScreen);
        test.writeInLogFile(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public void enterFirstName(String value) throws Exception {
        test.writeInLogFile(Common.getMethodName() + value);
        tool.enterStringUsingName("firstName", value);
    }

    public void enterLastName(String value) throws Exception {
        test.writeInLogFile(Common.getMethodName() + value);
        tool.enterStringUsingName("lastName", value);
    }

    public void enterUserName(String login) throws Exception {
        test.writeInLogFile(Common.getMethodName() + login);
        tool.enterStringUsingId("email", login);
    }

    public void enterPassword(String password) throws Exception {
        test.writeInLogFile(Common.getMethodName() + password);
        tool.enterStringUsingName("password", password);
    }

    public void enterConfirmPassword(String password) throws Exception {
        test.writeInLogFile(Common.getMethodName() + password);
        tool.enterStringUsingName("confirmPassword", password);
    }

    public void clickSubmit() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingName("register");
    }

    public SignOnMercuryTours clickSignIn() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingLinkText("sign-in");
        return new SignOnMercuryTours(tool, test, user);
    }
}
