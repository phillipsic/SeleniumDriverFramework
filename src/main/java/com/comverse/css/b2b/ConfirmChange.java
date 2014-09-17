/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ConfirmChangeCommon;

public class ConfirmChange extends ConfirmChangeCommon {

    public ConfirmChange(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public LoginInformation clickOK() throws Exception {
        super.clickOK();
        return new LoginInformation(tool, test, user);
    }
}
