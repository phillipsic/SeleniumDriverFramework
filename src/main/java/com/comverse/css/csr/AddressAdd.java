package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.AddressAddCommon;

public class AddressAdd extends AddressAddCommon {

    public AddressAdd(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Address Add";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }

    }

    @Override
	public void setStreetName(String streetname) throws Exception {

        
        tool.enterStringUsingId("add_streetName", streetname);

    }

    @Override
	public void setCity(String city) throws Exception {

        
        tool.enterStringUsingId("add_city", city);

    }

    @Override
	public void setZipCode(String zipcode) throws Exception {

        
        tool.enterStringUsingId("add_postalCode", zipcode);

    }

    @Override
	public void selectCountry(String country) throws Exception {

        tool.selectVisibleTextByID("add_countryCode", country);

    }

    @Override
	public AddressAdministration clickOK() throws Exception {

        tool.clickUsingXPath("//input[@value='Ok']");

        return new AddressAdministration(tool, test, user);
    }
}
