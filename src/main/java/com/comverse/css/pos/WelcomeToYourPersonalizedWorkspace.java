package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.CommonMenu;

public class WelcomeToYourPersonalizedWorkspace extends CommonMenu {

    public WelcomeToYourPersonalizedWorkspace(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Welcome to Your Personalized Workspace";

        if (!expectedScreen.equals(tool.getTitle(tool))) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SearchRetailer clickManageRetailer() throws Exception {
        tool.clickUsingID(tool, "mnu_MANAGE_RETAILER");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SearchRetailer(tool, test, user);

    }

    public String getHomePageWelcomeMessage() throws Exception {

        return tool.getTextUsingXPath(tool, "/html/body/h1");
    }

    public ViewHierarchy clickManageTelco() throws Exception {
        tool.clickUsingID(tool, "mnu_TELCO");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewHierarchy(tool, test, user);
    }
}
