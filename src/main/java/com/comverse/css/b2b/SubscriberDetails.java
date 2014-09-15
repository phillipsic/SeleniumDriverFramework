/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.SubscriberDetailsCommon;

public class SubscriberDetails extends SubscriberDetailsCommon {

    public SubscriberDetails(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public ViewBalance viewBalanceAndRecharge() throws Exception {  test.writeInLog(Common.getMethodName());

        super.viewBalanceAndRecharge();

        return new ViewBalance(tool, test, user);
    }
}
