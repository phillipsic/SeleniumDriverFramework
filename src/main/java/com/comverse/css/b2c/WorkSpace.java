package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class WorkSpace extends B2CMenu {

    public WorkSpace(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Welcome to Your Personalized Workspace";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
        System.out.println(">>" + currentScreen);
    }

    public String getWelcomeMessage() throws Exception {

        return tool.driver.findElement(By.xpath("//div[@id='headerLogoutContainer']/ul/li")).getText();
    }

    public String getMyLinesText() throws Exception {

        return tool.driver.findElement(By.cssSelector("div.dashboardLineName")).getText();
    }

    public PrimaryOfferDetails clickOnOfferLink(String offerNamer) throws Exception {

        tool.driver.findElement(By.linkText(offerNamer)).click();
        return new PrimaryOfferDetails(tool, test, user);
    }

}
