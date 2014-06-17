/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class PersonDetailsCommon extends CommonMenu {
    static String expectedScreen = "Account Details";

    public PersonDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle(tool);

        if (!expectedScreen.equals(tool.getTitle(tool))) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void clickUpdate() throws Exception {
        tool.clickUsingID(tool, "submitButton");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public void selectTitle(String value) throws Exception {
        tool.selectVisibleTextByID(tool, "title", value);
    }

    public void setFirstName(String value) throws Exception {
        
        tool.enterStringUsingId(tool, "firstName", value);
    }

    public void setLastName(String value) throws Exception {
        
        tool.enterStringUsingId(tool, "lastName", value);
    }

    public void setGender(String value) throws Exception {
        if (value == "female") {
            tool.clickUsingXPath(tool, "(//input[@name='gender'])[2]");
        } else {
            tool.clickUsingXPath(tool, "//input[@name='gender']");
        }
    }

    public void setNationality(String value) throws Exception {
        tool.selectVisibleTextByID(tool, "nationality", value);
    }

    public void setLanguage(String value) throws Exception {
        tool.selectVisibleTextByID(tool, "language", value);
    }

    public void setEmailAddress(String value) throws Exception {
        
        tool.enterStringUsingId(tool, "email", value);
    }

    public void setPhoneNumber(String value) throws Exception {
        
        tool.enterStringUsingId(tool, "phone", value);
    }

    public void setMobileNumber(String value) throws Exception {
        
        tool.enterStringUsingId(tool, "mobile", value);
    }

    public void setFaxNumber(String value) throws Exception {
        
        tool.enterStringUsingId(tool, "fax", value);
    }

    public void setNationalID(String value) throws Exception {
        
        tool.enterStringUsingId(tool, "nationalid", value);
    }

    public void setDateOfBirth(String value) throws Exception {
        
        tool.enterStringUsingId(tool, "dateOfBirth", value);
    }

    public void setAddressLine1(String value) throws Exception {
        
        tool.enterStringUsingId(tool, "address1", value);
    }

    public void setPostCode(String value) throws Exception {
        
        tool.enterStringUsingId(tool, "zipcode", value);
    }

    public void setCity(String value) throws Exception {
        
        tool.enterStringUsingId(tool, "city", value);
    }

    public void selectHomeCountry(String value) throws Exception {
        tool.selectVisibleTextByID(tool, "country", value);
    }

}
