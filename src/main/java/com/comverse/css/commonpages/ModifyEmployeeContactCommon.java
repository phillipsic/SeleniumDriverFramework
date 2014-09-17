/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.*/
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ModifyEmployeeContactCommon extends CommonMenu {

    public ModifyEmployeeContactCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Change Contact Information";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    /*
     * public void addEmployeeInfo() throws Exception {
     * test.writeInLog(Common.getMethodName());
     * 
     * String firstName="manoj"; ModifyContactInformationCommon
     * modifyContactInfo; modifyContactInfo = new
     * ModifyContactInformationCommon(tool, test, user); firstName =
     * modifyContactInfo.getFirstName(); System.out.println(firstName);
     * 
     * }
     */

    public String getFirstName() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        return tool.getAttributeUsingId("first_name", "value");
    }

    public String getLastName() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        return tool.getAttributeUsingId("last_name", "value");
    }

    public String getAddressLineOne() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        return tool.getAttributeUsingId("address_line_1", "value");
    }

    public String getAddressLineTwo() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        return tool.getAttributeUsingId("address_line_2", "value");
    }

    public String getAddressLineThree() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        return tool.getAttributeUsingId("address_line_3", "value");
    }

    public String getAddressLineFour() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        return tool.getAttributeUsingId("address_line_4", "value");
    }

    public String getZipCode() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        return tool.getAttributeUsingId("home_zip", "value");
    }

    public String getCity() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        return tool.getAttributeUsingId("home_city", "value");
    }

    public String getEmail() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        return tool.getAttributeUsingId("email", "value");
    }

    public String getPhoneNumber() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        return tool.getAttributeUsingId("home_phone", "value");
    }

    public String getFaxNumber() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        return tool.getAttributeUsingId("fax", "value");
    }

    public void enterFirstName(String FN) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("first_name", FN);
    }

    public void enterLastName(String lastName) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("last_name", lastName);

    }

    public void enterEmail(String eMail) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("email", eMail);
    }

    public void enterPhoneNumber(String phoneNumber) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("home_phone", phoneNumber);
    }

    public void enterFaxNumber(String faxNumber) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("fax", faxNumber);
    }

    public void enterAddressLineOne(String addressLineOne) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("address_line_1", addressLineOne);
    }

    public void enterPostCode(String postCode) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("home_zip", postCode);
    }

    public void enterCity(String city) throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.enterStringUsingId("home_city", city);
    }

    public ModifyEmployeeContactConfirmationCommon clickOk() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='OK']");
        return new ModifyEmployeeContactConfirmationCommon(tool, test, user);
    }
}
