/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.LevelLegalContactCommon;

public class LevelLegalContact extends LevelLegalContactCommon {

    public LevelLegalContact(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ViewHierarchy clickBack() throws Exception {

        super.clickBack();
        return new ViewHierarchy(tool, test, user);
    }

    @Override
    public ModifyLevelLegalContact clickModifyLevelLegalContact() throws Exception {

        super.clickModifyLevelLegalContact();
        return new ModifyLevelLegalContact(tool, test, user);
    }
}
