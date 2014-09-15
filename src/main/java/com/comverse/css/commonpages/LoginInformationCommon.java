package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class LoginInformationCommon extends CommonMenu {

    public LoginInformationCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Login Information";

        if (!expectedScreen.equals(tool.getTitle())) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public String getCurrentRoleFromPage() throws Exception {
        test.writeInLog(Common.getMethodName());
        return tool.getTextUsingXPath("//div[@id='mainContents']/div[2]/div/table/tbody/tr/td").replace(",", "");
    }

    public ChangePasswordCommon clickChangePassword() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("youcan_CHANGE_PASSWORD");
        return new ChangePasswordCommon(tool, test, user);
    }

    public ModifyLoginPasswordCommon clickChangePasswordOfAnotherUser() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("youcan_CHANGE_PASSWORD");
        return new ModifyLoginPasswordCommon(tool, test, user);
    }

    public ChangeSecretAnswerCommon clickChangeYourSecretAnswer() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("youcan_CHANGE_SECRET_QUESTION");
        return new ChangeSecretAnswerCommon(tool, test, user);
    }

    public ConfirmChangePasswordCommon clickChangePasswordOnFirstLogin() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("youcan_CHANGE_PASSWORD_ON_FIRST_LOGIN");

        return new ConfirmChangePasswordCommon(tool, test, user);
    }

    public LockLoginCommon clickLockLogin() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("youcan_LOCK_LOGIN");
        return new LockLoginCommon(tool, test, user);
    }

    public UnlockLoginCommon clickUnLockLogin() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("youcan_UNLOCK_LOGIN");
        return new UnlockLoginCommon(tool, test, user);
    }

    public DeactivateLoginCommon clickDeactivateLogin() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("youcan_DISABLE_LOGIN");
        return new DeactivateLoginCommon(tool, test, user);
    }

    public ActivateLoginCommon clickActivateLogin() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("youcan_ENABLE_LOGIN");
        return new ActivateLoginCommon(tool, test, user);
    }

    public RegisterLoginCommon clickSetLogin() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("youcan_REGISTER_LOGIN");
        return new RegisterLoginCommon(tool, test, user);
    }

    public String getTempPasswordFromPage() throws Exception {
        test.writeInLog(Common.getMethodName());

        String password = tool.getTextUsingXPath("//*[@id=\"mainContents\"]/div/div[2]/div/div/span");

        String temp[] = password.split(":");
        password = temp[1];
        System.out.println("Temporary password: " + password.trim());
        return password.trim();
    }

    public ChangeRolesCommon clickChangeRoles() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("youcan_CHANGE_ROLES");
        return new ChangeRolesCommon(tool, test, user);
    }

    public ChangeSecretAnswerCommon clickChangeYourSecretQuestionAndAnswer() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("youcan_CHANGE_SECRET_QUESTION");
        return new ChangeSecretAnswerCommon(tool, test, user);
    }
}
