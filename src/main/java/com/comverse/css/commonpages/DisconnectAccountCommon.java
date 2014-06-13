package com.comverse.css.commonpages;

import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class DisconnectAccountCommon extends CommonMenu {
    static String expectedScreen = "Disconnect account";

    public DisconnectAccountCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickCheckBoxUnlockNow() throws Exception {

        tool.clickUsingID(tool, "propertyNow");

    }

    public void setReason(String reason) throws Exception {

        new Select(tool.searchUsingID(tool, "reason")).selectByVisibleText(reason);
    }

    public void setAnnotation(String annotation) throws Exception {

        
        tool.enterStringUsingId(tool, "annotation", annotation);
    }

    public DisconnectAccountCommon clickContinue() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Continue']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new DisconnectAccountCommon(tool, test, user);
    }

    public DisconnectAccountCommon clickContinueOnImpacts() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Continue']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new DisconnectAccountCommon(tool, test, user);
    }

    public AccountDetailsCommon clickOk() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new AccountDetailsCommon(tool, test, user);
    }
}
