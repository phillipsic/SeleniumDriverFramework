package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ResumeAParkedBasketCommon extends CommonMenu {

    public ResumeAParkedBasketCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Resume a Parked Basket";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getMessage() throws Exception {

        return tool.driver.findElement(By.xpath("//span")).getText();
    }

    public ResumeBasketConfirmCommon resumeParkedBasket(String value) throws Exception {

        tool.driver.findElement(By.linkText(value)).click();
        return new ResumeBasketConfirmCommon(tool, test, user);
    }

    public DeleteBasketConfirmCommon deleteParkedBasket(String basketName) throws Exception {
        //
        // String pageSource = tool.driver.getPageSource();
        // String temp[];
        // String basketID;
        //
        // temp = pageSource.split(basketName);
        // temp = temp[1].split("id=");
        // temp = temp[1].split("type=");
        // basketID = Common.cleanStringOfIllegalChars(temp[0]);
        // basketID = Common.removeHTMLTags(basketID);
        //
        // tool.driver.findElement(By.id(basketID)).click();
        //
        // tool.driver.findElement(By.xpath("//input[@td='checkbox']")).click();
        //
        tool.driver.findElement(By.xpath("//td[contains(.,'" + basketName + "')]/../td[2]/span/input")).click();

        tool.driver.findElement(By.xpath("//input[@value='Delete']")).click();
        return new DeleteBasketConfirmCommon(tool, test, user);
    }
}
