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
        String currentScreen = tool.getTitle();
        String expectedScreen = "Update administrative account information";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public CustomerAcquisitionCustomerDataReviewCommon clickConfirm() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        return new CustomerAcquisitionCustomerDataReviewCommon(tool, test, user);
    }

    public void setBillingBillDispatchMethod(String SocialSecurityNumber) throws Exception {

        tool.enterStringUsingId("p-param-L4:91310", SocialSecurityNumber);
    }

    public void setBillingBillFormatOption(String PurchaseOrder) throws Exception {

        tool.enterStringUsingId("p-param-L4:91300", PurchaseOrder);
    }

    public void setBillingExchangeRateClass(String rateClass) throws Exception {

        tool.selectVisibleTextByID("p-param-L4:91520", rateClass);
    }

    public void setRateClass(String rateClass) throws Exception {

        tool.enterStringUsingId("p-param-L4:91520", rateClass);
    }

    public void setBillingTML(String BillingTML) throws Exception {

        tool.enterStringUsingId("p-param-L4:81280", BillingTML);
    }

    public void setBillingVIPCode(String SICCode) throws Exception {

        tool.enterStringUsingId("p-param-L4:80080", SICCode);
    }

    public void setBillingBillPeriod(String SICCode) throws Exception {

        tool.enterStringUsingId("p-param-L4:81010", SICCode);
    }

    public void setMarketCode(String marketCode) throws Exception {

        tool.selectVisibleTextByID("p-param-L4:80060", marketCode);
    }

}
