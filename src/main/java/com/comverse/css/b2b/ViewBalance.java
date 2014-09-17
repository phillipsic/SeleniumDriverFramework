/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ViewBalanceCommon;

public class ViewBalance extends ViewBalanceCommon {

    public ViewBalance(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public NonVoucherRecharge clickNonVoucherRechargeFreeAmount() throws Exception {
        super.clickNonVoucherRechargeFreeAmount();
        return new NonVoucherRecharge(tool, test, user);
    }
}
