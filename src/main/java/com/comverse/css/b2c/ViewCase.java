package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ViewCase extends B2CMenu {

    public ViewCase(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "View Case";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getCategory() throws Exception {

        String caseID = tool.driver.findElement(By.xpath("//tr[7]/td/span[2]")).getText();

        return caseID;
    }

    public String getSubCategory() throws Exception {

        String caseID = tool.driver.findElement(By.xpath("//tr[7]/td/span[2]")).getText();

        return caseID;
    }

    public String getDescription() throws Exception {

        String caseID = tool.driver.findElement(By.xpath("//tr[7]/td/span[2]")).getText();

        return caseID;
    }

    public String getSubscriber() throws Exception {
        String caseID = tool.driver.findElement(By.xpath("//tr[7]/td/span[2]")).getText();

        return caseID;
    }
}
