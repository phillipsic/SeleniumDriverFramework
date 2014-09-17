/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ModifyDeliveryAddressCommon;

public class ModifyDeliveryAddress extends ModifyDeliveryAddressCommon {

    public ModifyDeliveryAddress(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ModifyDeliveryAddressConfirmation clickOk() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        super.clickOk();
        return new ModifyDeliveryAddressConfirmation(tool, test, user);
    }
}
