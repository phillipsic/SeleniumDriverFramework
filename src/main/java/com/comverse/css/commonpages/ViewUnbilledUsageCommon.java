package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ViewUnbilledUsageCommon extends CommonMenu {

    public ViewUnbilledUsageCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "View unbilled usage";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public void enterToDate(String toDate) throws Exception {

        
        tool.enterStringUsingId(tool, "toDate", toDate);

    }

    public void enterFromDate(String fromDate) throws Exception {

        
        tool.enterStringUsingId(tool, "fromDate", fromDate);

    }

    public ViewUnbilledUsageCommon clickSearch() throws Exception {

        tool.clickUsingXPath(tool, "(//input[@value='Search'])[3]");
        return new ViewUnbilledUsageCommon(tool, test, user);
    }

    public ViewUnbilledUsageDetailsCommon clickFirstUsage() throws Exception {

        tool.driver.findElement(By.id("usageDetails")).click();
        return new ViewUnbilledUsageDetailsCommon(tool, test, user);
    }

    public UnbilledTransactionCommon clickBack() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Back']");
        return new UnbilledTransactionCommon(tool, test, user);
    }
}
