/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

/**
 * 
 * @author mkumar
 */
public class MoveMemberCommon extends CommonMenu {
    private List<WebElement> WebElementfound;

    public MoveMemberCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Move Member";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MoveMemberCommon clickSelectByLevelName(String levelName) throws Exception {

        tool.clickUsingXPath(tool, "//tr[td[contains(text(),'" + levelName + "')]]/td//a[contains(text(), 'Select')]");

        // tool.driver.findElement(By.xpath("//tr[td/a[contains(text(),'Select')]]/td[contains(text(),'"
        // + levelname + "')]"));
        return new MoveMemberCommon(tool, test, user);
    }

    public MoveMemberCommon findSelectByLevelName(String levelName) throws Exception {

        WebElementfound = tool.driver.findElements(By.xpath("//tr[td[contains(text(),'" + levelName + "')]]/td//a[contains(text(), 'Select')]"));

        if (WebElementfound.size() > 0) {

            throw new IllegalStateException("Expecting:No Select Link but got: Select Link");

        } else {
            System.out.println("Value of Unique code is MK");
            return new MoveMemberCommon(tool, test, user);

        }

        // tool.driver.findElement(By.xpath("//tr[td/a[contains(text(),'Select')]]/td[contains(text(),'"
        // + levelname + "')]"));

    }

    public ContactInformationCommon clickOk() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new ContactInformationCommon(tool, test, user);
    }
}
