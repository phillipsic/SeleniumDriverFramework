package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class MoveLevelCommon extends CommonMenu {

    public MoveLevelCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "Move Level";

        if (!expectedScreen.equals(tool.getTitle())) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }

    }

    public MoveLevelCommon clickSelectByLevelName(String weeklyLevelName) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//tr[td[contains(text(),'" + weeklyLevelName + "')]]/td//a[contains(text(), 'Select')]");

        return new MoveLevelCommon(tool, test, user);
    }

    @Override
    public ViewHierarchyCommon clickHierarchy() throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingID("mnu_HIERARCHY");

        return new ViewHierarchyCommon(tool, test, user);
    }

    public MoveLevelCommon levelNameWithOutSelectLink(String weeklyLevelName) throws Exception {  test.writeInLog(Common.getMethodName());
        if (tool.searchListUsingXPath("//tr[td[contains(text(),'" + weeklyLevelName + "')]]/td//a[contains(text(), 'Select')]").size() > 0) {
            throw new IllegalStateException("Expecting:No Select Link but got: Select Link");
        } else {
            System.out.println("Value of Unique code is KK");
            return new MoveLevelCommon(tool, test, user);
        }
    }

    public MoveLevelStatusCommon clickSelectForLevelName(String weeklyLevelName) throws Exception {  test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//tr[td[contains(text(),'" + weeklyLevelName + "')]]/td//a[contains(text(), 'Select')]");

        return new MoveLevelStatusCommon(tool, test, user);
    }

    public MoveLevelCommon findSelectByLevelname(String weeklyLevelName) throws Exception {  test.writeInLog(Common.getMethodName());
        if (tool.searchListUsingXPath("//tr[td[contains(text(),'" + weeklyLevelName + "')]]/td//a[contains(text(), 'Select')]").size() > 0) {
            throw new IllegalStateException("Expecting:No Select Link but got: Select Link");
        } else {
            System.out.println("Value of Unique code is KK");
            return new MoveLevelCommon(tool, test, user);
        }
    }
}
