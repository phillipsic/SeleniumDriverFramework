package com.comverse.css.pos;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.CommonMenu;

public class WelcomeToYourPersonalizedWorkspace extends CommonMenu {

    public WelcomeToYourPersonalizedWorkspace(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Welcome to Your Personalized Workspace";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SearchRetailer clickManageRetailer() throws Exception {
        tool.driver.findElement(By.id("mnu_MANAGE_RETAILER")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SearchRetailer(tool, test, user);

    }

    public String getHomePageWelcomeMessage() throws Exception {

        return tool.driver.findElement(By.xpath("/html/body/h1")).getText();
    }

    public ViewHierarchy clickManageTelco() throws Exception {
        tool.driver.findElement(By.id("mnu_TELCO")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewHierarchy(tool, test, user);
    }
}
