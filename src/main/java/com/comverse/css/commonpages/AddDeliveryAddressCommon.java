/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddDeliveryAddressCommon extends CommonMenu {
    static String expectedScreen = "Add Delivery Address";

    public AddDeliveryAddressCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectCountry(String country) throws Exception {

        new Select(tool.searchUsingID(tool, "country")).selectByVisibleText(country);

    }

    public void setAddressLine1(String addressline1) throws Exception {

        tool.enterStringUsingId(tool, "address_line_1", addressline1);

    }

    public void setAddressLine2(String addressline2) throws Exception {

        tool.enterStringUsingId(tool, "address_line_2", addressline2);

    }

    public void setAddressLine3(String addressline3) throws Exception {

        tool.enterStringUsingId(tool, "address_line_3", addressline3);

    }

    public void setAddressLine4(String addressline4) throws Exception {

        tool.enterStringUsingId(tool, "address_line_4", addressline4);

    }

    public void setZipCode(String zipcode) throws Exception {

        tool.enterStringUsingId(tool, "zip_code", zipcode);

    }

    public void setCity(String city) throws Exception {

        tool.enterStringUsingId(tool, "city", city);

    }

    public void enterDefaultDeliveryAddress(String uniqueTimeStamp) throws Exception {

        this.selectCountry("France");
        this.setAddressLine1("AL1-" + uniqueTimeStamp);
        this.setAddressLine2("AL2-" + uniqueTimeStamp);
        this.setAddressLine3("AL3-" + uniqueTimeStamp);
        this.setAddressLine4("AL4-" + uniqueTimeStamp);
        this.setZipCode("zip");
        this.setCity("City");

    }

    public DeliveryAddressesCommon clickOk() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new DeliveryAddressesCommon(tool, test, user);
    }
}
