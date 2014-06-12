/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
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
    public ViewHierarchy clickBack() throws Exception {

        super.clickBack();
        return new ViewHierarchy(tool, test, user);
    }

    @Override
    public ModifyContactInformation clickModifyContactInformation() throws Exception {
        super.clickModifyContactInformation();
        return new ModifyContactInformation(tool, test, user);
    }
}
