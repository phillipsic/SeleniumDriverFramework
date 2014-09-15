package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddMemberCommon extends CommonMenu {
    static String expectedScreen = "Add Member";

    public AddMemberCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public String getTempPasswordFromPage() throws Exception {  test.writeInLog(Common.getMethodName());

        String password = tool.getTextUsingXPath("//*[@id=\"mainContents\"]/div/div[2]/div/div/span");

        String temp[] = password.split(":");
        password = temp[1];
        System.out.println("Temporary password: " + password.trim());
        return password.trim();

    }

    public ViewHierarchyCommon clickOk() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//input[@value='OK']");

        return new ViewHierarchyCommon(tool, test, user);
    }
}
