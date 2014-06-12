package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ListCasesCommon extends CommonMenu {

    static String expectedScreen = "List Cases";

    public ListCasesCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting:" + expectedScreen + ", but got: " + currentScreen);
        }
    }

    public ListCasesCommon clickSearch() throws Exception {

        tool.driver.findElement(By.xpath("(//input[@value='Search'])[3]")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ListCasesCommon(tool, test, user);
    }

    public ViewCaseCommon clickFirstCase() throws Exception {

        tool.driver.findElement(By.xpath("//fieldset/div/table/tbody[2]/tr/td/div/a")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewCaseCommon(tool, test, user);
    }
}
