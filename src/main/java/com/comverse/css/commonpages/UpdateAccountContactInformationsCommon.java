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
}
