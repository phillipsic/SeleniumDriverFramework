/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SearchAddressCommon extends CommonMenu {

    public SearchAddressCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "Search Address";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void setCountry(String country) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.selectVisibleTextByID("home_country", country);

    }

    public void setStreetName(String streetname) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("streetName", streetname);

    }

    public void setCity(String city) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("home_city", city);

    }

    public void setZipCode(String zipcode) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("home_zip", zipcode);

    }

    public SearchAddressCommon clickOk() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='OK']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SearchAddressCommon(tool, test, user);
    }

    public EnterIdentificationDataCommon clickSelectAddress() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Select']");
        return new EnterIdentificationDataCommon(tool, test, user);
    }

}
