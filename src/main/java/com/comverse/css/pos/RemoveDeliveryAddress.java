/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.RemoveDeliveryAddressCommon;

public class RemoveDeliveryAddress extends RemoveDeliveryAddressCommon {

    public RemoveDeliveryAddress(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public DeliveryAddresses clickOk() throws Exception {

        super.clickOk();
        return new DeliveryAddresses(tool, test, user);
    }
}
