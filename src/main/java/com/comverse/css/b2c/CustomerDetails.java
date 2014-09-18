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
            test.writeInLogFile("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLogFile(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public CheckOutBillingAccountInformation clickOk() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingName("prospectok");
        Common.waitForEndOfWaitingPage(tool, Common.getMethodName());
        return new CheckOutBillingAccountInformation(tool, test, user);
    }

    public CheckOutDeliveryAddress clickOkExpectingCheckOutDeliveryAddress() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingName("prospectok");
        Common.waitForEndOfWaitingPage(tool, Common.getMethodName());
        return new CheckOutDeliveryAddress(tool, test, user);
    }

    public CheckOutDeliveryAddress clickOkWithDevices() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingName("prospectok");
        Common.waitForEndOfWaitingPage(tool, Common.getMethodName());
        return new CheckOutDeliveryAddress(tool, test, user);
    }

    public ModifyCustomerDetails clickModify() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingName("modifyprospectinfo");
        Common.waitForEndOfWaitingPage(tool, Common.getMethodName());
        return new ModifyCustomerDetails(tool, test, user);
    }
}
