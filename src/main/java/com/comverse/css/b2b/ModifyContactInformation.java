/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ModifyContactInformationCommon;

public class ModifyContactInformation extends ModifyContactInformationCommon {

    public ModifyContactInformation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ModifyContactInformationConfirmation clickOk() throws Exception {  test.writeInLog(Common.getMethodName());
        super.clickOk();
        return new ModifyContactInformationConfirmation(tool, test, user);
    }

    @Override
    public void setLevelName(String uniqueString) throws Exception {  test.writeInLog(Common.getMethodName());

        super.setLevelName(uniqueString);
    }

    @Override
    public void setLevelState(String uniqueState) throws Exception {  test.writeInLog(Common.getMethodName());

        super.setLevelState(uniqueState);
    }
}
