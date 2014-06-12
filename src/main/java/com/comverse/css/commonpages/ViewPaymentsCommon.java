package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ViewPaymentsCommon extends CommonMenu {

    public ViewPaymentsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "View Payments";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public void enterFromDate(String fromDate) throws Exception {

        tool.driver.findElement(By.id("startDate")).clear();
        tool.driver.findElement(By.id("startDate")).sendKeys(fromDate);

    }

    public ViewPaymentsCommon clickSearch() throws Exception {

        tool.driver.findElement(By.xpath("(//input[@value='Search'])[3]")).click();
        return new ViewPaymentsCommon(tool, test, user);
    }
}
