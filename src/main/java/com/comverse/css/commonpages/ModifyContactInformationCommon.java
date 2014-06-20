/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ModifyContactInformationCommon extends CommonMenu {

    public ModifyContactInformationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "Modify Contact Information";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getFirstName() throws Exception {

        return tool.getAttributeUsingId("first_name", "value");
    }

    public String getLastName() throws Exception {

        return tool.getAttributeUsingId("last_name", "value");
    }

    public String getAddressLineOne() throws Exception {

        return tool.getAttributeUsingId("address_line_1", "value");
    }

    public String getAddressLineTwo() throws Exception {

        return tool.getAttributeUsingId("address_line_2", "value");
    }

    public String getAddressLineThree() throws Exception {

        return tool.getAttributeUsingId("address_line_3", "value");
    }

    public String getAddressLineFour() throws Exception {

        return tool.getAttributeUsingId("address_line_4", "value");
    }

    public String getZipCode() throws Exception {

        return tool.getAttributeUsingId("home_zip", "value");
    }

    public String getCity() throws Exception {

        return tool.getAttributeUsingId("home_city", "value");
    }

    public String getState() throws Exception {
        return tool.getSelectedTextByID("home_state");
    }

    public String getEmail() throws Exception {

        return tool.getAttributeUsingId("email", "value");
    }

    public String getPhoneNumber() throws Exception {
        return tool.getAttributeUsingId("home_phone", "value");
    }

    public String getFaxNumber() throws Exception {
        return tool.getAttributeUsingId("fax", "value");
    }

    public String getDayPhone() throws Exception {
        return tool.getAttributeUsingId("home_phone", "value");
    }

    public String getEveningPhone() throws Exception {
        return tool.getAttributeUsingId("work_phone", "value");
    }

    public void enterFirstName(String FN) throws Exception {

        tool.enterStringUsingId("first_name", FN);
    }

    public void enterLastName(String lastName) throws Exception {

        tool.enterStringUsingId("last_name", lastName);

    }

    public void enterDayPhone(String dayPhone) throws Exception {

        tool.enterStringUsingId("home_phone", dayPhone);

    }

    public void enterEveningPhone(String eveningPhone) throws Exception {

        tool.enterStringUsingId("work_phone", eveningPhone);

    }

    public void enterEmail(String eMail) throws Exception {

        tool.enterStringUsingId("email", eMail);
    }

    public void enterPhoneNumber(String phoneNumber) throws Exception {

        tool.enterStringUsingId("home_phone", phoneNumber);
    }

    public void enterFaxNumber(String faxNumber) throws Exception {

        tool.enterStringUsingId("fax", faxNumber);
    }

    public void enterAddressLineOne(String addressLineOne) throws Exception {

        tool.enterStringUsingId("address_line_1", addressLineOne);
    }

    public void enterPostCode(String postCode) throws Exception {

        tool.enterStringUsingId("home_zip", postCode);
    }

    public void enterCity(String city) throws Exception {

        tool.enterStringUsingId("home_city", city);
    }

    public void enterState(String state) throws Exception {
        tool.selectVisibleTextByID("home_state", state);

    }

    public void enterCountry(String country) throws Exception {
        tool.selectVisibleTextByID("home_country", country);
    }

    public ModifyContactInformationConfirmationCommon clickOk() throws Exception {
        tool.clickUsingXPath("//input[@value='OK']");
        return new ModifyContactInformationConfirmationCommon(tool, test, user);
    }

    public void setLevelName(String uniqueString) throws Exception {

        tool.enterStringUsingId("company_name", uniqueString);
    }

    public void setLevelState(String uniqueState) throws Exception {

        tool.selectVisibleTextByID("home_state", uniqueState);
    }
}
