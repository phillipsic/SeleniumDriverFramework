/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ModifyLoginPasswordCommon;

public class ModifyLoginPassword extends ModifyLoginPasswordCommon {

    public ModifyLoginPassword(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public MyShapeChannel clickLogout() throws Exception {

        super.clickLogout();
        return new MyShapeChannel(tool, test, user);
    }

    @Override
	public void clickOk() throws Exception {
        super.clickOk();

    }

    public UnlockLogin clickOkToModifyPassword() throws Exception {
        super.clickOk();
        return new UnlockLogin(tool, test, user);
    }

    public EnableLogin clickOkToEnableLogin() throws Exception {
        super.clickOk();
        return new EnableLogin(tool, test, user);
    }

}
