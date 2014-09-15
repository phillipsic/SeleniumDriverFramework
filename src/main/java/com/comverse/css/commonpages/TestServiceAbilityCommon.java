package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class TestServiceAbilityCommon extends CommonMenu {

    public TestServiceAbilityCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Test Service Ability";
        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void setUnitnumber(String unitNumber) throws Exception {
        
        tool.enterStringUsingId("unitNumber", unitNumber);
    }

    public void setCity(String city) throws Exception {
        
        tool.enterStringUsingId("home_city", city);
    }

    public void setZipCode(String zipcode) throws Exception {
        
        tool.enterStringUsingId("home_zip", zipcode);
    }

    public ShoppingCommon clickOK() throws Exception {
        tool.clickUsingXPath("//input[@value='OK']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ShoppingCommon(tool, test, user);
    }
}