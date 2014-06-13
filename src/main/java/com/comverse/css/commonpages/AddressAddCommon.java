package com.comverse.css.commonpages;

import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddressAddCommon extends CommonMenu {
    static String expectedScreen = "Address Add";

    public AddressAddCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void setStreetName(String streetname) throws Exception {

        
        tool.enterStringUsingId(tool, "streetName", streetname);

    }

    public void setCity(String city) throws Exception {

        
        tool.enterStringUsingId(tool, "city", city);

    }

    public void setZipCode(String zipcode) throws Exception {

        
        tool.enterStringUsingId(tool, "postalCode", zipcode);

    }

    public void selectCountry(String country) throws Exception {

        new Select(tool.searchUsingID(tool, "countryCode")).selectByVisibleText(country);

    }

    public AddressAdministrationCommon clickOK() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Ok']");

        return new AddressAdministrationCommon(tool, test, user);
    }
}
