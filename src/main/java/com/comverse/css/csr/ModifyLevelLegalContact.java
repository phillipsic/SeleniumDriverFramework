/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ModifyLevelLegalContactCommon;

public class ModifyLevelLegalContact extends ModifyLevelLegalContactCommon {

    public ModifyLevelLegalContact(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public void setNewLevelName(String uniqueString) throws Exception {

        super.setNewLevelName(uniqueString);
    }

    @Override
    public void setNewLevelState(String uniqueState) throws Exception {

        super.setNewLevelState(uniqueState);
    }

    @Override
    public ModifyLevelLegalContact clickOk() throws Exception {

        super.clickOk();
        return new ModifyLevelLegalContact(tool, test, user);
    }

    @Override
    public ModifyLevelLegalContact clickOkAgain() throws Exception {

        super.clickOkAgain();
        return new ModifyLevelLegalContact(tool, test, user);
    }

    @Override
    public LevelLegalContact clickOkButton() throws Exception {

        super.clickOkButton();
        return new LevelLegalContact(tool, test, user);
    }
}
