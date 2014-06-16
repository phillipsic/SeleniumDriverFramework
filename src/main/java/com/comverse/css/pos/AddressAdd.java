package com.comverse.css.pos;

import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.AddressAddCommon;

public class AddressAdd extends AddressAddCommon {

    public AddressAdd(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Address Add";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    @Override
	public void setStreetName(String streetname) throws Exception {

        
        tool.enterStringUsingId(tool, "streetName", streetname);

    }

    @Override
	public void setCity(String city) throws Exception {

        
        tool.enterStringUsingId(tool, "city", city);

    }

    @Override
	public void setZipCode(String zipcode) throws Exception {

        
        tool.enterStringUsingId(tool, "postalCode", zipcode);

    }

    @Override
	public void selectCountry(String country) throws Exception {

        new Select(tool.searchUsingID(tool, "countryCode")).selectByVisibleText(country);

    }

    @Override
	public AddressAdministration clickOK() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Ok']");

        return new AddressAdministration(tool, test, user);
    }
}
