/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ContactInformationCommon;

public class ContactInformation extends ContactInformationCommon {

    public ContactInformation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();

        // Check that we're on the right page.
        if (!"Contact Information".equals(currentScreen)) {

            throw new IllegalStateException("Expecting: Contact Information, but got: " + currentScreen);
        }
    }

    @Override
    public String getFirstName() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        return super.getFirstName();
    }

    @Override
    public String getLastName() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        return super.getLastName();
    }

    @Override
    public ViewHierarchy clickBack() throws Exception {
        super.clickBack();
        return new ViewHierarchy(tool, test, user);
    }

    @Override
    public LoginInformation clickViewLoginInformationLink() throws Exception {
        super.clickViewLoginInformationLink();
        return new LoginInformation(tool, test, user);
    }

    public ViewHierarchy clickUserManagement() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingID("mnu_HIERARCHY");
        return new ViewHierarchy(tool, test, user);
    }
}
