package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class PersonMergeCommon extends CommonMenu {
    static String expectedScreen = "Person Merge";

    public PersonMergeCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setLastName(String LN) throws Exception {
        tool.driver.findElement(By.id("lastname")).clear();
        tool.driver.findElement(By.id("lastname")).sendKeys(LN);
    }

    public void clickPersonSearch() throws Exception {
        tool.driver.findElement(By.xpath("//input[@id='searchPerson']")).click();
    }

    public void clickSelect() throws Exception {
        Common.sleepForNumberOfSeconds(5);
        tool.driver.findElement(By.cssSelector("input[value='Select'][type='button']")).click();
    }

    public void clickOKFromMerge() throws Exception {
        tool.driver.findElement(By.xpath("(//input[@value='OK'])[2]")).click();
    }

}