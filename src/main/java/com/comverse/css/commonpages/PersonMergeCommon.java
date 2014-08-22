package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class PersonMergeCommon extends CommonMenu {

    static String expectedScreen = "Person Merge";

    public PersonMergeCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setLastName(String LN) throws Exception {

        tool.enterStringUsingId("lastname", LN);
    }

    public void clickPersonSearch() throws Exception {
        tool.clickUsingXPath("//input[@id='searchPerson']");
    }

    public void clickSelect() throws Exception {
        Common.sleepForNumberOfSeconds(5);
        tool.clickUsingCssSelector("input[value='Select'][type='button']");

    }

    public PersonManagementCommon clickOKFromMerge() throws Exception {
        tool.clickUsingXPath("(//input[@value='OK'])[2]");
        return new PersonManagementCommon(tool, test, user);
    }

}
