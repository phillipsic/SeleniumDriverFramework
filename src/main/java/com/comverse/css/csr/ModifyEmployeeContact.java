/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ModifyEmployeeContactCommon;

public class ModifyEmployeeContact extends ModifyEmployeeContactCommon {

    public ModifyEmployeeContact(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ModifyEmployeeContactConfirmation clickOk() throws Exception {
        super.clickOk();
        return new ModifyEmployeeContactConfirmation(tool, test, user);
    }

}
