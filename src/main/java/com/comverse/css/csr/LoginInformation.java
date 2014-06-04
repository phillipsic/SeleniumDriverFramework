/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.LoginInformationCommon;
import com.comverse.sec.ComverseOneSingleSignOn;

public class LoginInformation extends LoginInformationCommon {

    public LoginInformation(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public ChangeRoles clickChangeRoles() throws Exception {

        super.clickChangeRoles();
        return new ChangeRoles(driver);
    }

    @Override
    public ComverseOneSingleSignOn clickLogoutExpectingSSO() throws Exception {

        super.clickLogoutExpectingSSO();
        return new ComverseOneSingleSignOn(driver);
    }

    @Override
    public ChangePassword clickChangePassword() throws Exception {

        super.clickChangePassword();
        return new ChangePassword(driver);
    }

    @Override
    public ChangeSecretAnswer clickChangeYourSecretAnswer() throws Exception {

        super.clickChangeYourSecretAnswer();
        return new ChangeSecretAnswer(driver);
    }

    @Override
    public LockLogin clickLockLogin() throws Exception {

        super.clickLockLogin();
        return new LockLogin(driver);
    }

    @Override
    public UnlockLogin clickUnLockLogin() throws Exception {

        super.clickUnLockLogin();
        return new UnlockLogin(driver);
    }

    @Override
    public RegisterLogin clickSetLogin() throws Exception {

        super.clickSetLogin();
        return new RegisterLogin(driver);
    }

    @Override
    public ConfirmChangePassword clickChangePasswordOnFirstLogin() throws Exception {

        super.clickChangePasswordOnFirstLogin();
        return new ConfirmChangePassword(driver);
    }

    @Override
    public DeactivateLogin clickDeactivateLogin() throws Exception {

        super.clickDeactivateLogin();
        return new DeactivateLogin(driver);
    }

    @Override
    public ActivateLogin clickActivateLogin() throws Exception {

        super.clickActivateLogin();
        return new ActivateLogin(driver);
    }

    @Override
    public ModifyLoginPassword clickChangePasswordOfAnotherUser() throws Exception {
        super.clickChangePasswordOfAnotherUser();
        return new ModifyLoginPassword(driver);
    }
}
