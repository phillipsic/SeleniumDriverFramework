package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class CustomerDetails extends B2CMenu {

    public CustomerDetails(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Customer Details";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public CheckOutBillingAccountInformation clickOk() throws Exception {

        tool.clickUsingName(tool, "prospectok");
        return new CheckOutBillingAccountInformation(tool, test, user);
    }

    public CheckOutDeliveryAddress clickOkExpectingCheckOutDeliveryAddress() throws Exception {

        tool.clickUsingName(tool, "prospectok");
        return new CheckOutDeliveryAddress(tool, test, user);
    }

    public CheckOutDeliveryAddress clickOkWithDevices() throws Exception {

        tool.clickUsingName(tool, "prospectok");
        return new CheckOutDeliveryAddress(tool, test, user);
    }

    public ModifyCustomerDetails clickModify() throws Exception {

        tool.clickUsingName(tool, "modifyprospectinfo");
        return new ModifyCustomerDetails(tool, test, user);
    }
}
