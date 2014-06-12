/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.RechargeSubscriberCommon;

public class RechargeSubscriber extends RechargeSubscriberCommon {

    public RechargeSubscriber(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public ViewBalance clickViewBalances() throws Exception {
        super.clickViewBalances();
        return new ViewBalance(tool, test, user);
    }
}
