/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.NewMemberLegalAddressCommon;

public class NewMemberLegalAddress extends NewMemberLegalAddressCommon {

    public NewMemberLegalAddress(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public Login clickContinue() throws Exception {
        super.clickContinue();
        return new Login(tool, test, user);
    }
}
