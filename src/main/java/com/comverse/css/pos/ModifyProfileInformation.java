/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ModifyProfileInformationCommon;

public class ModifyProfileInformation extends ModifyProfileInformationCommon {

    public ModifyProfileInformation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public void setTimeZone(String timeZone) throws Exception {

        super.setTimeZone(timeZone);
    }

    @Override
    public ModifyProfileInformationConfirmation clickOkToModify() throws Exception {

        super.clickOkToModify();
        return new ModifyProfileInformationConfirmation(tool, test, user);
    }

}
