package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ChangePasswordCommon extends CommonMenu {

    public ChangePasswordCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Change Password";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setYourPassword(String password) throws Exception {

        
        tool.enterStringUsingId(tool, "oldPassword", password);
    }

    public void setNewPassword(String password) throws Exception {

        
        tool.enterStringUsingId(tool, "newPassword", password);
    }

    public void setConfirmNewPassword(String password) throws Exception {

        
        tool.enterStringUsingId(tool, "confirmPassword", password);
    }

    public ModifyLoginPasswordCommon clickChange() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Change']")).click();
        return new ModifyLoginPasswordCommon(tool, test, user);
    }
}
