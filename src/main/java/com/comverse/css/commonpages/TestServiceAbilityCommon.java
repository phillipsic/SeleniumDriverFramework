package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class TestServiceAbilityCommon extends CommonMenu {

    public TestServiceAbilityCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Test Service Ability";
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setUnitnumber(String unitNumber) throws Exception {
        tool.driver.findElement(By.id("unitNumber")).clear();
        tool.driver.findElement(By.id("unitNumber")).sendKeys(unitNumber);
    }

    public void setCity(String city) throws Exception {
        tool.driver.findElement(By.id("home_city")).clear();
        tool.driver.findElement(By.id("home_city")).sendKeys(city);
    }

    public void setZipCode(String zipcode) throws Exception {
        tool.driver.findElement(By.id("home_zip")).clear();
        tool.driver.findElement(By.id("home_zip")).sendKeys(zipcode);
    }

    public ShoppingCommon clickOK() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ShoppingCommon(tool, test, user);
    }
}