/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ChangeLoginPasswordCommon;

public class ChangeLoginPassword extends ChangeLoginPasswordCommon {

    public ChangeLoginPassword(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public MyshapeCSRPortal clickLogout() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        super.clickLogout();
        return new MyshapeCSRPortal(tool, test, user);
    }
}
