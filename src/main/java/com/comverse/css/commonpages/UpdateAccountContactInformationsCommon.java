package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class UpdateAccountContactInformationsCommon extends CommonMenu {

    public UpdateAccountContactInformationsCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Update account contact informations";

        if (!expectedScreen.equals(tool.getTitle())) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getLastName() throws Exception {
        return tool.getAttributeUsingId("last_name", "value");
    }

    public String getFirstName() throws Exception {
        return tool.getAttributeUsingXpath("first_name", "value");
    }

    public String getTitle() throws Exception {
        return tool.getAttributeUsingXpath("titleString", "value");
    }

    public void setTitle(String TitleName) throws Exception {

        tool.enterStringUsingId("titleString", TitleName);
    }

    public void setFirstName(String FirstName) throws Exception {

        tool.enterStringUsingId("first_name", FirstName);
    }

    public void setLastName(String LastName) throws Exception {

        tool.enterStringUsingId("last_name", LastName);
    }

    public void setGender(String Gender) throws Exception {

        tool.clickUsingID(Gender);

    }

    public void setEmail(String Email) throws Exception {

        tool.enterStringUsingId("email", Email);
    }

    public void setHomePhone(String HomePhone) throws Exception {

        tool.enterStringUsingId("home_phone", HomePhone);
    }

    public void setFax(String Fax) throws Exception {

        tool.enterStringUsingId("fax", Fax);
    }
}
