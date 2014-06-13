package com.comverse.css.commonpages;

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

        new Select(tool.searchUsingID(tool, "home_state")).selectByVisibleText(levelState);
    }

    public void setLevelZipCode(String zipCode) throws Exception {

        
        tool.enterStringUsingId(tool, "home_zip", zipCode);
    }

    public void setLevelName(String levelName) throws Exception {

        
        tool.enterStringUsingId(tool, "company_name", levelName);
    }

    public AddLevelConfirmationCommon clickOk() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='OK']");
        return new AddLevelConfirmationCommon(tool, test, user);
    }
}
