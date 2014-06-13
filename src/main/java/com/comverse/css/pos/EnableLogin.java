/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.EnableLoginCommon;

public class EnableLogin extends EnableLoginCommon {

    public EnableLogin(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public LoginInformation clickOk() throws Exception {
        super.clickOk();
        return new LoginInformation(tool, test, user);
    }

    public String getNewPassword() throws Exception {

        String password = tool.getTextUsingXPath(tool, "//div[@id='mainContents']/div/div[2]/div/div/span");

        String temp[] = password.split(":");
        password = temp[1];
        System.out.println("Temporary password: " + password.trim());
        return password.trim();
    }
}
