package com.comverse.css.b2b;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ParkTheCurrentBasketCommon;

public class ParkTheCurrentBasket extends ParkTheCurrentBasketCommon {

    public ParkTheCurrentBasket(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Park the Current Basket";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    @Override
    public ResumeAParkedBasket clickBasket() throws Exception {
        super.clickBasket();
        return new ResumeAParkedBasket(tool, test, user);
    }

    public WorkSpace goToHome() throws Exception {
        tool.driver.findElement(By.id("mnu_HOME")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new WorkSpace(tool, test, user);
    }

    public WorkSpace clickOkExpectingWorkSpace() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new WorkSpace(tool, test, user);
    }
}