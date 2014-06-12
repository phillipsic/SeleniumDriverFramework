package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddressAdministrationCommon extends CommonMenu {
    static String expectedScreen = "Address Administration";

    public AddressAdministrationCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public AddressAddCommon clickAdd() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Add']")).click();

        return new AddressAddCommon(tool, test, user);
    }
}
