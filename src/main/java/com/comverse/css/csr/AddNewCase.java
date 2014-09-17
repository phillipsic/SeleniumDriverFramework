/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.AddNewCaseCommon;

public class AddNewCase extends AddNewCaseCommon {

    public AddNewCase(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public AddCaseReview clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        super.clickContinue();
        return new AddCaseReview(tool, test, user);
    }
}
