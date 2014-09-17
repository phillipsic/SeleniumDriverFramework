package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.LoginInformationCommon;
import com.comverse.sec.ComverseOneSingleSignOn;

public class LoginInformation extends LoginInformationCommon {

    public LoginInformation(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
    }

    @Override
    public ChangeRoles clickChangeRoles() throws Exception {
        super.clickChangeRoles();
        return new ChangeRoles(tool, test, user);
    }

    @Override
    public ComverseOneSingleSignOn clickLogoutExpectingSSO() throws Exception {
        super.clickLogoutExpectingSSO();
        return new ComverseOneSingleSignOn(tool, test, user);
    }

    @Override
    public ChangePassword clickChangePassword() throws Exception {
        super.clickChangePassword();
        return new ChangePassword(tool, test, user);
    }

    @Override
    public ChangeSecretAnswer clickChangeYourSecretAnswer() throws Exception {
        super.clickChangeYourSecretAnswer();
        return new ChangeSecretAnswer(tool, test, user);
    }

    @Override
    public LockLogin clickLockLogin() throws Exception {
        super.clickLockLogin();
        return new LockLogin(tool, test, user);
    }

    @Override
    public UnlockLogin clickUnLockLogin() throws Exception {
        super.clickUnLockLogin();
        return new UnlockLogin(tool, test, user);
    }

    @Override
    public ConfirmChangePassword clickChangePasswordOnFirstLogin() throws Exception {
        super.clickChangePasswordOnFirstLogin();
        return new ConfirmChangePassword(tool, test, user);
    }

    @Override
    public DeactivateLogin clickDeactivateLogin() throws Exception {
        super.clickDeactivateLogin();
        return new DeactivateLogin(tool, test, user);
    }

    @Override
    public ActivateLogin clickActivateLogin() throws Exception {
        super.clickActivateLogin();
        return new ActivateLogin(tool, test, user);
    }

    @Override
    public ModifyLoginPassword clickChangePasswordOfAnotherUser() throws Exception {
        super.clickChangePasswordOfAnotherUser();
        return new ModifyLoginPassword(tool, test, user);
    }

    @Override
    public RegisterLogin clickSetLogin() throws Exception {
        super.clickSetLogin();
        return new RegisterLogin(tool, test, user);
    }

    @Override
    public ChangeSecretAnswer clickChangeYourSecretQuestionAndAnswer() throws Exception {
        super.clickChangeYourSecretQuestionAndAnswer();
        return new ChangeSecretAnswer(tool, test, user);
    }
}
