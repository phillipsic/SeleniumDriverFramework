/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.AddSubLevelLegalAddressCommon;

public class AddSubLevelLegalAddress extends AddSubLevelLegalAddressCommon {

    public AddSubLevelLegalAddress(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public RequestSubmission clickOk() throws Exception {

        super.clickOk();
        return new RequestSubmission(tool, test, user);
    }

    @Override
    public void setLevelName(String levelName) throws Exception {

        super.setLevelName(levelName);
    }

    @Override
    public void setLevelState(String levelState) throws Exception {

        super.setLevelState(levelState);

    }
}
