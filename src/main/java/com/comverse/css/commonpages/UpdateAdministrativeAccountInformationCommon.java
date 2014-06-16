/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class UpdateAdministrativeAccountInformationCommon extends CommonMenu {

    public UpdateAdministrativeAccountInformationCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Update administrative account information";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle(tool))) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public EnterIdentificationDataCommon clickConfirm() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Continue']");
        return new EnterIdentificationDataCommon(tool, test, user);
    }

    public void setBillingBillDispatchMethod(String SocialSecurityNumber) throws Exception {

        tool.enterStringUsingId(tool, "p-param-L4:91310", SocialSecurityNumber);
    }

    public void setBillingBillFormatOption(String PurchaseOrder) throws Exception {

        tool.enterStringUsingId(tool, "p-param-L4:91300", PurchaseOrder);
    }

    public void setBillingExchangeRateClass(String SalesCode) throws Exception {

        tool.enterStringUsingId(tool, "p-param-L4:91380", SalesCode);
    }

    public void setBillingTML(String BillingTML) throws Exception {

        tool.clickUsingID(tool, "p-param-L4:81270" + BillingTML);
    }

    public void setBillingVIPCode(String SICCode) throws Exception {

        tool.enterStringUsingId(tool, "p-param-L4:80080", SICCode);
    }

    public void setBillingBillPeriod(String SICCode) throws Exception {

        tool.enterStringUsingId(tool, "p-param-L4:81010", SICCode);
    }

}
