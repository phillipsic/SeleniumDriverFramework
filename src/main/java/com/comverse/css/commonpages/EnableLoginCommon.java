package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class EnableLoginCommon extends CommonMenu {

    public EnableLoginCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();

        if (!"Enable Login".equals(currentScreen)) {

            throw new IllegalStateException("Expecting: Enable Login, but got: " + currentScreen);
        }
    }

    public LoginInformationCommon clickOk() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new LoginInformationCommon(tool, test, user);
    }
}
