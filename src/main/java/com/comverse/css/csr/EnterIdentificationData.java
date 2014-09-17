/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.EnterIdentificationDataCommon;

public class EnterIdentificationData extends EnterIdentificationDataCommon {

    public EnterIdentificationData(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public Shopping clickContinue() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        super.clickContinue();
        return new Shopping(tool, test, user);
    }

    @Override
    public SearchAddress clickSearchAddress() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        super.clickSearchAddress();
        return new SearchAddress(tool, test, user);
    }

}
