package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class CompareDevices extends B2CMenu {

    public CompareDevices(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Compare Devices";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ChooseYourHandset clickReturnToList() throws Exception {
        tool.clickUsingCssSelector(tool, "input[type='submit'][value='Return to List']");
        return new ChooseYourHandset(tool, test, user);
    }

    public String getDevice1() throws Exception {
        return tool.getTextUsingXPath(tool, "//table[@class='listTable']//th[1]");
    }

    public String getDevice2() throws Exception {
        return tool.getTextUsingXPath(tool, "//table[@class='listTable']//th[2]");
    }

}
