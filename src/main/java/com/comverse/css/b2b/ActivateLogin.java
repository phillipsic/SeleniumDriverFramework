/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ActivateLoginCommon;

public class ActivateLogin extends ActivateLoginCommon {

    public ActivateLogin(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    public UnlockDone clickConfirm() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='Confirm']");
        return new UnlockDone(tool, test, user);
    }

}
