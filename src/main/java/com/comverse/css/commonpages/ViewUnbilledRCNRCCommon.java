package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ViewUnbilledRCNRCCommon extends CommonMenu {

    public ViewUnbilledRCNRCCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "View Unbilled RC/NRC";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public ViewUnbilledRCTermDetailsCommon clickFirstRCTerm() throws Exception {

        tool.driver.findElement(By.xpath("//fieldset/div[4]/div/table/tbody[2]/tr/td/div/a")).click();
        return new ViewUnbilledRCTermDetailsCommon(tool, test, user);
    }

    public ViewUnbilledNRCTermDetailsCommon clickFirstNRCTerm() throws Exception {

        tool.driver.findElement(By.xpath("//div[2]/div/table/tbody[2]/tr/td/div/a")).click();
        return new ViewUnbilledNRCTermDetailsCommon(tool, test, user);
    }

    public UnbilledTransactionCommon clickBack() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Back']")).click();
        return new UnbilledTransactionCommon(tool, test, user);
    }
}
