/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ModifyPaymentMethodCommon;

public class ModifyPaymentMethod extends ModifyPaymentMethodCommon {

    public ModifyPaymentMethod(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public AccountDetails clickOk() throws Exception {
        super.clickOk();
        return new AccountDetails(tool, test, user);
    }
}
