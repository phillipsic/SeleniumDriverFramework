package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class PersonMergeCommon extends CommonMenu {
    static String expectedScreen = "Person Merge";

    public PersonMergeCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setLastName(String LN) throws Exception {
        
        tool.enterStringUsingId(tool, "lastname", LN);
    }

    public void clickPersonSearch() throws Exception {
        tool.clickUsingXPath(tool, "//input[@id='searchPerson']");
    }

    public void clickSelect() throws Exception {
        Common.sleepForNumberOfSeconds(5);
        tool.clickUsingCssSelector(tool, "input[value='Select'][type='button']");
    }

    public void clickOKFromMerge() throws Exception {
        tool.clickUsingXPath(tool, "(//input[@value='OK'])[2]");
    }

}