/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.AddCaseReviewCommon;

public class AddCaseReview extends AddCaseReviewCommon {

    public AddCaseReview(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public AddCaseConfirmation clickCreateCase() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickCreateCase();
        return new AddCaseConfirmation(tool, test, user);

    }
}
