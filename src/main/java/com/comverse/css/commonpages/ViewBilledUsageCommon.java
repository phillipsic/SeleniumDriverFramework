package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ViewBilledUsageCommon extends CommonMenu {

    public ViewBilledUsageCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "View Billed Usage";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public void enterFromDate(String fromDate) throws Exception {

        
        tool.enterStringUsingId(tool, "fromDate", fromDate);

    }

    public ViewBilledUsageCommon clickSearch() throws Exception {

        tool.clickUsingXPath(tool, "(//input[@value='Search'])[3]");
        return new ViewBilledUsageCommon(tool, test, user);
    }

    public ViewBilledUsageDetailsCommon clickFirstUsage() throws Exception {

        tool.driver.findElement(By.id("invoiceUsageDetails")).click();
        return new ViewBilledUsageDetailsCommon(tool, test, user);
    }

    public ViewInvoiceDetailsCommon clickBack() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Back']");
        return new ViewInvoiceDetailsCommon(tool, test, user);
    }
}
