package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class AddMemberCommon extends CommonMenu {
    static String expectedScreen = "Add Member";

    public AddMemberCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getTempPasswordFromPage() throws Exception {

        String password = tool.driver.findElement(By.xpath("//*[@id=\"mainContents\"]/div/div[2]/div/div/span")).getText();

        String temp[] = password.split(":");
        password = temp[1];
        System.out.println("Temporary password: " + password.trim());
        return password.trim();

    }

    public ViewHierarchyCommon clickOk() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='OK']")).click();

        return new ViewHierarchyCommon(tool, test, user);
    }
}
