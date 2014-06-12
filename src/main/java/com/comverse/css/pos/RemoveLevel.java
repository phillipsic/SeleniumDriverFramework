/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.RemoveLevelCommon;

public class RemoveLevel extends RemoveLevelCommon {

    public RemoveLevel(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public RemoveLevel clickOkToRemoveLevel() throws Exception {

        super.clickOkToRemoveLevel();
        return new RemoveLevel(tool, test, user);
    }

    @Override
    public ViewHierarchy clickOkToConfirm() throws Exception {

        super.clickOkToConfirm();
        return new ViewHierarchy(tool, test, user);
    }

}
