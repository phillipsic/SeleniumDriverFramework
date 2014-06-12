/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ConfirmNewSecretAnswerCommon;

public class ConfirmNewSecretAnswer extends ConfirmNewSecretAnswerCommon {

    public ConfirmNewSecretAnswer(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public ConfirmChange clickOK() throws Exception {

        super.clickOK();
        return new ConfirmChange(tool, test, user);
    }
}
