package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddLoginCommon extends CommonMenu {
    static String expectedScreen = "Add Login";

    public AddLoginCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public PersonManagementCommon clickContinue() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new PersonManagementCommon(tool, test, user);
    }

    public void setLogin(String value) throws Exception {
        
        tool.enterStringUsingId(tool, "login", value);
    }

    public void setPassword(String value) throws Exception {
        
        tool.enterStringUsingId(tool, "password", value);
    }

    public void setConfirmPassword(String value) throws Exception {
        
        tool.enterStringUsingId(tool, "confirmPassword", value);
    }
}
