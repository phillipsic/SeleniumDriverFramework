/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ModifyLoginPasswordCommon;

public class ModifyLoginPassword extends ModifyLoginPasswordCommon {

    public ModifyLoginPassword(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public MyshapeCSRPortal clickLogout() throws Exception {

        super.clickLogout();
        return new MyshapeCSRPortal(tool, test, user);
    }

    public UnlockLogin clickOkToModifyPassword() throws Exception {
        super.clickOk();
        return new UnlockLogin(tool, test, user);
    }

    @Override
    public String getNewPassword() throws Exception {

        String password = super.getNewPassword();
        return password.trim();
    }
}
