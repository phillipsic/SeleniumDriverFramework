package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class WorkSpace extends B2CMenu {

    public WorkSpace(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Welcome to Your Personalized Workspace";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        System.out.println(">>" + currentScreen);
    }

    public String getWelcomeMessage() throws Exception {

        return tool.getTextUsingXPath("//div[@id='headerLogoutContainer']/ul/li");
    }

    public String getMyLinesText() throws Exception {

        return tool.getTextUsingCssSelector("div.dashboardLineName");
    }

    public PrimaryOfferDetails clickOnOfferLink(String offerNamer) throws Exception {

        tool.clickUsingLinkText(offerNamer);
        return new PrimaryOfferDetails(tool, test, user);
    }

}
