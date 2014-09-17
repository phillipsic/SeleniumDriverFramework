/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

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

}
