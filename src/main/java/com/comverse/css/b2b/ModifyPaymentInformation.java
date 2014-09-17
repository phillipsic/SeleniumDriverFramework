/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ModifyPaymentInformationCommon;

public class ModifyPaymentInformation extends ModifyPaymentInformationCommon {

    public ModifyPaymentInformation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ModifyPaymentMethod clickModifyPaymentButton() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickModifyPaymentButton();
        return new ModifyPaymentMethod(tool, test, user);
    }
}
