package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class WorkSpace extends B2CMenu {

    public WorkSpace(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Welcome to Your Personalized Workspace";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public String getWelcomeMessage() throws Exception {
        test.writeInLog(Common.getMethodName());
        return tool.getTextUsingXPath("//div[@id='headerLogoutContainer']/ul/li");
    }

    public String getMyLinesText() throws Exception {
        test.writeInLog(Common.getMethodName());
        return tool.getTextUsingCssSelector("div.dashboardLineName");
    }

    public PrimaryOfferDetails clickOnOfferLink(String offerNamer) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + offerNamer + ")");
        tool.clickUsingLinkText(offerNamer);
        return new PrimaryOfferDetails(tool, test, user);
    }

}
