/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.MoveMemberCommon;

public class MoveMember extends MoveMemberCommon {

    public MoveMember(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public MoveMember clickSelectByLevelName(String levelName) throws Exception {
        super.clickSelectByLevelName(levelName);
        return new MoveMember(tool, test, user);
    }

    @Override
    public MoveMember findSelectByLevelName(String levelName) throws Exception {
        super.findSelectByLevelName(levelName);
        return new MoveMember(tool, test, user);
    }

    @Override
    public ContactInformation clickOk() throws Exception {
        super.clickOk();
        return new ContactInformation(tool, test, user);
    }

}
