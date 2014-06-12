package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ViewBilledRechargesCommon extends CommonMenu {

    public ViewBilledRechargesCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "View billed recharges";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public ViewRechargeDetailsCommon clickFirstRecharge() throws Exception {

        tool.driver.findElement(By.xpath("//fieldset/div/table/tbody[2]/tr/td/div/a")).click();
        return new ViewRechargeDetailsCommon(tool, test, user);
    }

    public ViewInvoiceDetailsCommon clickBack() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Back']")).click();
        return new ViewInvoiceDetailsCommon(tool, test, user);
    }
}
