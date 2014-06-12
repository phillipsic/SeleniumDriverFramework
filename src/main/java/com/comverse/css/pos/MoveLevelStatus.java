/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.MoveLevelStatusCommon;

public class MoveLevelStatus extends MoveLevelStatusCommon {

    public MoveLevelStatus(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ViewHierarchy clickHierarchy() throws Exception {

        super.clickHierarchy();
        return new ViewHierarchy(tool, test, user);
    }
}
