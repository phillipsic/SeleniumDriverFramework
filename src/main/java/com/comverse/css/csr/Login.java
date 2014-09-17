/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.LoginCommon;

public class Login extends LoginCommon {

    public Login(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public AddMemberConfirmation clickContinue() throws Exception {  test.writeInLogFile(Common.getMethodName());
        super.clickContinue();
        return new AddMemberConfirmation(tool, test, user);
    }

    @Override
    public AddMemberConfirmation clickCreateLoginLater() throws Exception {  test.writeInLogFile(Common.getMethodName());
        super.clickCreateLoginLater();
        return new AddMemberConfirmation(tool, test, user);
    }

    public void enterLogin(String login) throws Exception {  test.writeInLogFile(Common.getMethodName());
        
        tool.enterStringUsingId("login", login);
    }

    public RegisterLogin clickOk() throws Exception {  test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='OK']");
        return new RegisterLogin(tool, test, user);
    }

    public AddMemberConfirmation clickSubmit() throws Exception {  test.writeInLogFile(Common.getMethodName());
        tool.clickUsingCssSelector("input.submit");
        return new AddMemberConfirmation(tool, test, user);
    }

    public void setRoles(String roles) throws Exception {  test.writeInLogFile(Common.getMethodName());
        tool.selectVisibleTextByID("roles", roles);
    }
}
