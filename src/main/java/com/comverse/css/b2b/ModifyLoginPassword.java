/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ModifyLoginPasswordCommon;

public class ModifyLoginPassword extends ModifyLoginPasswordCommon {

    public ModifyLoginPassword(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public MyshapeBusiness clickLogout() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickLogout();
        return new MyshapeBusiness(tool, test, user);
    }
}
