/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ChangeSecretAnswerCommon;

public class ChangeSecretAnswer extends ChangeSecretAnswerCommon {

    public ChangeSecretAnswer(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public ConfirmNewSecretAnswer clickChangeSecretAnswer() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickChangeSecretAnswer();
        return new ConfirmNewSecretAnswer(tool, test, user);
    }
}
