package com.comverse.css.pos;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.AddressAdministrationCommon;

public class AddressAdministration extends AddressAdministrationCommon {

    public AddressAdministration(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Address Administration";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public AddressAdd clickAdd() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Add']")).click();

        return new AddressAdd(tool, test, user);
    }
}
