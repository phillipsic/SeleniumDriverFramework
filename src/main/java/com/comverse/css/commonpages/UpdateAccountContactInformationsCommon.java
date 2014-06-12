package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class UpdateAccountContactInformationsCommon extends CommonMenu {

    public UpdateAccountContactInformationsCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Update account contact informations";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public String getLastName() throws Exception {

        return tool.driver.findElement(By.id("last_name")).getAttribute("value");
    }

    public String getFirstName() throws Exception {

        return tool.driver.findElement(By.xpath("first_name")).getAttribute("value");
    }

    public String getTitle() throws Exception {

        return tool.driver.findElement(By.xpath("titleString")).getAttribute("value");
    }
}
