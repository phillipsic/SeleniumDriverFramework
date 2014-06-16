package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ViewCase extends B2CMenu {

    public ViewCase(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "View Case";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getCategory() throws Exception {

        String caseID = tool.getTextUsingXPath(tool, "//tr[7]/td/span[2]");

        return caseID;
    }

    public String getSubCategory() throws Exception {

        String caseID = tool.getTextUsingXPath(tool, "//tr[7]/td/span[2]");

        return caseID;
    }

    public String getDescription() throws Exception {

        String caseID = tool.getTextUsingXPath(tool, "//tr[7]/td/span[2]");

        return caseID;
    }

    public String getSubscriber() throws Exception {
        String caseID = tool.getTextUsingXPath(tool, "//tr[7]/td/span[2]");

        return caseID;
    }
}
