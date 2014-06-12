package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddLevelContactInformationCommon extends CommonMenu {
    static String expectedScreen = "Add Level - Contact Information";

    public AddLevelContactInformationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setLevelState(String levelState) throws Exception {

        new Select(tool.driver.findElement(By.id("home_state"))).selectByVisibleText(levelState);
    }

    public void setLevelZipCode(String zipCode) throws Exception {

        tool.driver.findElement(By.id("home_zip")).clear();
        tool.driver.findElement(By.id("home_zip")).sendKeys(zipCode);
    }

    public void setLevelName(String levelName) throws Exception {

        tool.driver.findElement(By.id("company_name")).clear();
        tool.driver.findElement(By.id("company_name")).sendKeys(levelName);
    }

    public AddLevelConfirmationCommon clickOk() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new AddLevelConfirmationCommon(tool, test, user);
    }
}
