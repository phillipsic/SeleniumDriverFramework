package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class UnlockSubscriberRequestForDetailsCommon extends CommonMenu {
    static String expectedScreen = "Unlock subscriber - Request for details";

    public UnlockSubscriberRequestForDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickCheckBoxUnlockNow() throws Exception {

        tool.driver.findElement(By.id("propertyNow")).click();

    }

    public void setReason(String reason) throws Exception {

        new Select(tool.driver.findElement(By.id("reason"))).selectByVisibleText(reason);
    }

    public void setAnnotation(String annotation) throws Exception {

        tool.driver.findElement(By.id("annotation")).clear();
        tool.driver.findElement(By.id("annotation")).sendKeys(annotation);
    }

    public UnlockSubscriberConfirmationCommon clickContinue() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new UnlockSubscriberConfirmationCommon(tool, test, user);
    }
}
