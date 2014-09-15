/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.LoginInformationCommon;
import com.comverse.sec.ComverseOneSingleSignOn;

public class LoginInformation extends LoginInformationCommon {

    public LoginInformation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ChangeRoles clickChangeRoles() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickChangeRoles();
        return new ChangeRoles(tool, test, user);
    }

    @Override
    public ComverseOneSingleSignOn clickLogoutExpectingSSO() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickLogoutExpectingSSO();
        return new ComverseOneSingleSignOn(tool, test, user);
    }

    @Override
    public ChangePassword clickChangePassword() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickChangePassword();
        return new ChangePassword(tool, test, user);
    }

    @Override
    public ChangeSecretAnswer clickChangeYourSecretAnswer() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickChangeYourSecretAnswer();
        return new ChangeSecretAnswer(tool, test, user);
    }

    @Override
    public LockLogin clickLockLogin() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickLockLogin();
        return new LockLogin(tool, test, user);
    }

    @Override
    public UnlockLogin clickUnLockLogin() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickUnLockLogin();
        return new UnlockLogin(tool, test, user);
    }

    @Override
    public RegisterLogin clickSetLogin() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickSetLogin();
        return new RegisterLogin(tool, test, user);
    }

    @Override
    public ConfirmChangePassword clickChangePasswordOnFirstLogin() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickChangePasswordOnFirstLogin();
        return new ConfirmChangePassword(tool, test, user);
    }

    @Override
    public DeactivateLogin clickDeactivateLogin() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickDeactivateLogin();
        return new DeactivateLogin(tool, test, user);
    }

    @Override
    public ActivateLogin clickActivateLogin() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickActivateLogin();
        return new ActivateLogin(tool, test, user);
    }

    @Override
    public ModifyLoginPassword clickChangePasswordOfAnotherUser() throws Exception {  test.writeInLog(Common.getMethodName());
        super.clickChangePasswordOfAnotherUser();
        return new ModifyLoginPassword(tool, test, user);
    }
}
