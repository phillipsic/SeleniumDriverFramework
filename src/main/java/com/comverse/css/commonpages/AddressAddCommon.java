package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddressAddCommon extends CommonMenu {
    static String expectedScreen = "Address Add";

    public AddressAddCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }

    }

    public void setStreetName(String streetname) throws Exception {

        
        tool.enterStringUsingId("streetName", streetname);

    }

    public void setCity(String city) throws Exception {

        
        tool.enterStringUsingId("city", city);

    }

    public void setZipCode(String zipcode) throws Exception {

        
        tool.enterStringUsingId("postalCode", zipcode);

    }

    public void selectCountry(String country) throws Exception {

        tool.selectVisibleTextByID("countryCode", country);

    }

    public AddressAdministrationCommon clickOK() throws Exception {

        tool.clickUsingXPath("//input[@value='Ok']");

        return new AddressAdministrationCommon(tool, test, user);
    }
}
