/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.PersonManagementCommon;

public class PersonManagement extends PersonManagementCommon {

    public PersonManagement(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public AddLogin clickActionsAddLoginForPerson(String personLastName) throws Exception {

        super.clickActionsAddLoginForPerson(personLastName);
        return new AddLogin(tool, test, user);
    }

    @Override
    public PersonMerge clickPersonMerge() throws Exception {
        super.clickPersonMerge();
        return new PersonMerge(tool, test, user);
    }
}
