/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ProfileInformationCommon;

public class ProfileInformation extends ProfileInformationCommon {

    public ProfileInformation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ViewHierarchy clickHierarchy() throws Exception {  test.writeInLog(Common.getMethodName());
        super.clickHierarchy();
        return new ViewHierarchy(tool, test, user);
    }

}
