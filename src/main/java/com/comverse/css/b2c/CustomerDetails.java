package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class CustomerDetails extends B2CMenu {

    public CustomerDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Customer Details";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public CheckOutBillingAccountInformation clickOk() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingName("prospectok");
        return new CheckOutBillingAccountInformation(tool, test, user);
    }

    public CheckOutDeliveryAddress clickOkExpectingCheckOutDeliveryAddress() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingName("prospectok");
        return new CheckOutDeliveryAddress(tool, test, user);
    }

    public CheckOutDeliveryAddress clickOkWithDevices() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingName("prospectok");
        return new CheckOutDeliveryAddress(tool, test, user);
    }

    public ModifyCustomerDetails clickModify() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingName("modifyprospectinfo");
        return new ModifyCustomerDetails(tool, test, user);
    }
}
