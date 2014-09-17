/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ModifyContactInformationCommon;

public class ModifyContactInformation extends ModifyContactInformationCommon {

    public ModifyContactInformation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ModifyContactInformationConfirmation clickOk() throws Exception {
        super.clickOk();
        return new ModifyContactInformationConfirmation(tool, test, user);
    }
}
