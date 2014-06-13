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

public class MoveLevelCommon extends CommonMenu {

    private List<WebElement> WebElementfound;

    public MoveLevelCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Move Level";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public MoveLevelCommon clickSelectByLevelName(String weeklyLevelName) throws Exception {

        tool.clickUsingXPath(tool, "//tr[td[contains(text(),'" + weeklyLevelName + "')]]/td//a[contains(text(), 'Select')]");

        return new MoveLevelCommon(tool, test, user);
    }

    @Override
    public ViewHierarchyCommon clickHierarchy() throws Exception {

        /*
         * tool.clickUsingLinkText(tool, "Select");
         */
        tool.driver.findElement(By.id("mnu_HIERARCHY")).click();

        return new ViewHierarchyCommon(tool, test, user);

    }

    public MoveLevelCommon levelNameWithOutSelectLink(String weeklyLevelName) throws Exception {

        // tool.driver.findElement(By.xpath("//tr[td[contains(text(),'" +
        // weeklyLevelName + "')]]"));

        WebElementfound = tool.driver.findElements(By.xpath("//tr[td[contains(text(),'" + weeklyLevelName + "')]]/td//a[contains(text(), 'Select')]"));

        if (WebElementfound.size() > 0) {

            throw new IllegalStateException("Expecting:No Select Link but got: Select Link");

        } else {
            System.out.println("Value of Unique code is KK");
            return new MoveLevelCommon(tool, test, user);

        }

    }

    public MoveLevelStatusCommon clickSelectForLevelName(String weeklyLevelName) throws Exception {

        tool.clickUsingXPath(tool, "//tr[td[contains(text(),'" + weeklyLevelName + "')]]/td//a[contains(text(), 'Select')]");

        return new MoveLevelStatusCommon(tool, test, user);
    }

    public MoveLevelCommon findSelectByLevelname(String weeklyLevelName) throws Exception {

        // tool.driver.findElement(By.xpath("//tr[td[contains(text(),'" +
        // weeklyLevelName + "')]]"));

        WebElementfound = tool.driver.findElements(By.xpath("//tr[td[contains(text(),'" + weeklyLevelName + "')]]/td//a[contains(text(), 'Select')]"));

        if (WebElementfound.size() > 0) {

            throw new IllegalStateException("Expecting:No Select Link but got: Select Link");

        } else {
            System.out.println("Value of Unique code is KK");
            return new MoveLevelCommon(tool, test, user);

        }

    }
}
