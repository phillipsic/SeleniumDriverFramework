/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ModifyDeliveryAddressCommon extends CommonMenu {

    public ModifyDeliveryAddressCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Modify Delivery Address";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void selectCountry(String country) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.selectVisibleTextByID("country", country);

    }

    public void selectState(String state) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.selectVisibleTextByID("state_region", state);

    }

    public void setAddressLine1(String addressline1) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("address_line_1", addressline1);

    }

    public void setAddressLine2(String addressline2) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("address_line_2", addressline2);

    }

    public void setAddressLine3(String addressline3) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("address_line_3", addressline3);

    }

    public void setAddressLine4(String addressline4) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("address_line_4", addressline4);

    }

    public void setZipCode(String zipcode) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("zip_code", zipcode);

    }

    public void setCity(String city) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("city", city);

    }

    public ModifyDeliveryAddressConfirmationCommon clickOk() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='OK']");
        return new ModifyDeliveryAddressConfirmationCommon(tool, test, user);
    }
}
