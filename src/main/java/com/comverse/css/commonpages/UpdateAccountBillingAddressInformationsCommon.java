/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class UpdateAccountBillingAddressInformationsCommon extends CommonMenu {

    public UpdateAccountBillingAddressInformationsCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Update account billing address informations";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public EnterIdentificationDataCommon clickConfirm() throws Exception {

        tool.clickUsingXPath("//input[@value='Confirm']");
        return new EnterIdentificationDataCommon(tool, test, user);
    }

    public void setAddress1(String Address1) throws Exception {

        tool.enterStringUsingId("address_line_1", Address1);
    }

    public void setAddress2(String setAddress2) throws Exception {

        tool.enterStringUsingId("address_line_2", setAddress2);
    }

    public void setAddress3(String Address3) throws Exception {

        tool.enterStringUsingId("address_line_3", Address3);
    }

    public void setAddress4(String Address4) throws Exception {

        tool.enterStringUsingId("address_line_4", Address4);
    }

    public void setHomeZip(String HomeZip) throws Exception {

        tool.enterStringUsingId("home_zip", HomeZip);
    }

    public void setHomeCity(String HomeCity) throws Exception {

        tool.enterStringUsingId("home_city", HomeCity);
    }

    public void setHomeCountry(String HomeCountry) throws Exception {

        tool.selectVisibleTextByID("home_country", HomeCountry);
    }
    
     public CustomerAcquisitionCustomerDataReviewCommon clickContinue() throws Exception {

        tool.clickUsingXPath("//input[@value='Continue >']");
        return new CustomerAcquisitionCustomerDataReviewCommon(tool, test, user);
    }

}
