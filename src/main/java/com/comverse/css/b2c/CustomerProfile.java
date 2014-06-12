package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class CustomerProfile extends B2CMenu {

    public CustomerProfile(AutomationTool tool, Test test, User user) {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Customer Profile";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ModifyProfileInformation clickModify() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Modify']")).click();
        return new ModifyProfileInformation(tool, test, user);
    }

}
