/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.AddSubLevelSelectLevelTypeCommon;

public class AddSubLevelSelectLevelType extends AddSubLevelSelectLevelTypeCommon {

    public AddSubLevelSelectLevelType(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public AddSubLevelLegalAddress clickOk() throws Exception {

        super.clickOk();
        return new AddSubLevelLegalAddress(tool, test, user);
    }
}