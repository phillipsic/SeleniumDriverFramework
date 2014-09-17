/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ContactInformationCommon;

public class ContactInformation extends ContactInformationCommon {

    public ContactInformation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public LoginInformation clickViewLoginInformationLink() throws Exception {
        super.clickViewLoginInformationLink();
        return new LoginInformation(tool, test, user);
    }

    @Override
    public MoveMember clickMoveMember() throws Exception {
        super.clickMoveMember();
        return new MoveMember(tool, test, user);
    }

    @Override
    public ModifyEmployeeContact clickModifyContact() throws Exception {
        super.clickModifyContact();
        return new ModifyEmployeeContact(tool, test, user);
    }

    @Override
    public ContactInformation clickUserInformation() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        super.clickUserInformation();
        return new ContactInformation(tool, test, user);
    }
}
