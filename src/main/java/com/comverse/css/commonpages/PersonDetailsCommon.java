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

        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }

    }

    public void clickUpdate() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingID("submitButton");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public void selectTitle(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.selectVisibleTextByID("title", value);
    }

    public void setFirstName(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        
        tool.enterStringUsingId("firstName", value);
    }

    public void setLastName(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        
        tool.enterStringUsingId("lastName", value);
    }

    public void setGender(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        if (value == "female") {
            tool.clickUsingXPath("(//input[@name='gender'])[2]");
        } else {
            tool.clickUsingXPath("//input[@name='gender']");
        }
    }

    public void setNationality(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.selectVisibleTextByID("nationality", value);
    }

    public void setLanguage(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.selectVisibleTextByID("language", value);
    }

    public void setEmailAddress(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        
        tool.enterStringUsingId("email", value);
    }

    public void setPhoneNumber(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        
        tool.enterStringUsingId("phone", value);
    }

    public void setMobileNumber(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        
        tool.enterStringUsingId("mobile", value);
    }

    public void setFaxNumber(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        
        tool.enterStringUsingId("fax", value);
    }

    public void setNationalID(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        
        tool.enterStringUsingId("nationalid", value);
    }

    public void setDateOfBirth(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        
        tool.enterStringUsingId("dateOfBirth", value);
    }

    public void setAddressLine1(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        
        tool.enterStringUsingId("address1", value);
    }

    public void setPostCode(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        
        tool.enterStringUsingId("zipcode", value);
    }

    public void setCity(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        
        tool.enterStringUsingId("city", value);
    }

    public void selectHomeCountry(String value) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.selectVisibleTextByID("country", value);
    }

}
