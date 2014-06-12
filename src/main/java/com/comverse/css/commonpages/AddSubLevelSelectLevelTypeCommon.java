package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddSubLevelSelectLevelTypeCommon extends CommonMenu {
    static String expectedScreen = "Add Sub Level - Select Level Type";

    public AddSubLevelSelectLevelTypeCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public AddSubLevelLegalAddressCommon clickOk() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new AddSubLevelLegalAddressCommon(tool, test, user);
    }
}
