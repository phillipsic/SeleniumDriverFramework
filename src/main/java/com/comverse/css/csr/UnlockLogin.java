/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.UnlockLoginCommon;

public class UnlockLogin extends UnlockLoginCommon {

    public UnlockLogin(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public UnlockDone clickConfirm() throws Exception {

        super.clickConfirm();
        return new UnlockDone(tool, test, user);
    }

    public String getNewPassword() throws Exception {

        String password = tool.getTextUsingXPath("//div[@id='mainContents']/div/div[2]/div/div/span");

        String temp[] = password.split(":");
        password = temp[1];
        System.out.println("Temporary password: " + password.trim());
        return password.trim();
    }

    @Override
    public LoginInformation clickOK() throws Exception {
        super.clickOK();
        return new LoginInformation(tool, test, user);
    }

}
