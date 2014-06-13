package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class FraudlockSubscriberRequestForDetailsCommon extends CommonMenu {
    static String expectedScreen = "Fraud lock subscriber - Request for details";

    public FraudlockSubscriberRequestForDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickCheckBoxFraudlockNow() throws Exception {

        if (!Common.isCheckBoxSelected(tool, "propertyNow"))
            tool.driver.findElement(By.id("propertyNow")).click();

    }

    public void setReason(String reason) throws Exception {

        new Select(tool.searchUsingID(tool, "reason")).selectByVisibleText(reason);
    }

    public void setAnnotation(String annotation) throws Exception {

        
        tool.enterStringUsingId(tool, "annotation", annotation);
    }

    public FraudlockSubscriberConfirmationCommon clickContinue() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Continue']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new FraudlockSubscriberConfirmationCommon(tool, test, user);
    }
}
