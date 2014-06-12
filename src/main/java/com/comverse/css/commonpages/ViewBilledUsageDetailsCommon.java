package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ViewBilledUsageDetailsCommon extends CommonMenu {

    public ViewBilledUsageDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "View Billed Usage Details";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public ViewBilledUsageCommon clickBack() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Back']")).click();
        return new ViewBilledUsageCommon(tool, test, user);
    }
}
