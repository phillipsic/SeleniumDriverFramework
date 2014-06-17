/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.LoginCommon;

public class Login extends LoginCommon {

    public Login(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public AddMemberConfirmation clickContinue() throws Exception {
        super.clickContinue();
        return new AddMemberConfirmation(tool, test, user);
    }

    @Override
    public AddMemberConfirmation clickCreateLoginLater() throws Exception {
        super.clickCreateLoginLater();
        return new AddMemberConfirmation(tool, test, user);
    }

    public void enterLogin(String login) throws Exception {
        
        tool.enterStringUsingId(tool, "login", login);
    }

    public RegisterLogin clickOk() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new RegisterLogin(tool, test, user);
    }

    public AddMemberConfirmation clickSubmit() throws Exception {
        tool.clickUsingCssSelector(tool, "input.submit");
        return new AddMemberConfirmation(tool, test, user);
    }

    public void setRoles(String roles) throws Exception {
        tool.selectVisibleTextByID(tool, "roles", roles);
    }
}
