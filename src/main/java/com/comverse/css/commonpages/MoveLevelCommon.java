package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class MoveLevelCommon extends CommonMenu {

    public MoveLevelCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Move Level";

        if (!expectedScreen.equals(tool.getTitle(tool))) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public MoveLevelCommon clickSelectByLevelName(String weeklyLevelName) throws Exception {
        tool.clickUsingXPath(tool, "//tr[td[contains(text(),'" + weeklyLevelName + "')]]/td//a[contains(text(), 'Select')]");

        return new MoveLevelCommon(tool, test, user);
    }

    @Override
    public ViewHierarchyCommon clickHierarchy() throws Exception {
        tool.clickUsingID(tool, "mnu_HIERARCHY");

        return new ViewHierarchyCommon(tool, test, user);
    }

    public MoveLevelCommon levelNameWithOutSelectLink(String weeklyLevelName) throws Exception {
        if (tool.searchListUsingXPath(tool, "//tr[td[contains(text(),'" + weeklyLevelName + "')]]/td//a[contains(text(), 'Select')]").size() > 0) {
            throw new IllegalStateException("Expecting:No Select Link but got: Select Link");
        } else {
            System.out.println("Value of Unique code is KK");
            return new MoveLevelCommon(tool, test, user);
        }
    }

    public MoveLevelStatusCommon clickSelectForLevelName(String weeklyLevelName) throws Exception {
        tool.clickUsingXPath(tool, "//tr[td[contains(text(),'" + weeklyLevelName + "')]]/td//a[contains(text(), 'Select')]");

        return new MoveLevelStatusCommon(tool, test, user);
    }

    public MoveLevelCommon findSelectByLevelname(String weeklyLevelName) throws Exception {
        if (tool.searchListUsingXPath(tool, "//tr[td[contains(text(),'" + weeklyLevelName + "')]]/td//a[contains(text(), 'Select')]").size() > 0) {
            throw new IllegalStateException("Expecting:No Select Link but got: Select Link");
        } else {
            System.out.println("Value of Unique code is KK");
            return new MoveLevelCommon(tool, test, user);
        }
    }
}
