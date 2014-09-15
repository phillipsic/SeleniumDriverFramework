/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.DeliveryAddressesCommon;

public class DeliveryAddresses extends DeliveryAddressesCommon {

    public DeliveryAddresses(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public AddDeliveryAddress clickAdd() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickAdd();
        return new AddDeliveryAddress(tool, test, user);
    }

    @Override
    public ModifyDeliveryAddress clickModify() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickModify();
        return new ModifyDeliveryAddress(tool, test, user);
    }

    @Override
    public RemoveDeliveryAddress clickRemove() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickRemove();
        return new RemoveDeliveryAddress(tool, test, user);
    }

    @Override
    public DeliveryAddresses searchWithWildCard(String wildcard) throws Exception {  test.writeInLog(Common.getMethodName());
        super.searchWithWildCard(wildcard);
        return new DeliveryAddresses(tool, test, user);
    }
}
