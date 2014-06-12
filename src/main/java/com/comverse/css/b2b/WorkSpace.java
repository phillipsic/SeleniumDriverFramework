package com.comverse.css.b2b;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.WorkSpaceCommon;

public class WorkSpace extends WorkSpaceCommon {

    public WorkSpace(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Welcome to Your Workspace";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AccountDetails clickAccount() throws Exception {
        tool.driver.findElement(By.id("mnu_ACCOUNTS")).click();
        return new AccountDetails(tool, test, user);
    }

    public ListCases clickCustomerCare() throws Exception {
        tool.driver.findElement(By.id("mnu_PROBLEMS")).click();
        return new ListCases(tool, test, user);
    }

    public ViewHierarchy clickUserManagement() throws Exception {

        tool.driver.findElement(By.id("mnu_HIERARCHY")).click();
        return new ViewHierarchy(tool, test, user);
    }

    public ContactInformation clickUsersName() throws Exception {

        tool.driver.findElement(By.id("GLOBAL.MEMBER_CONTEXT")).click();
        return new ContactInformation(tool, test, user);
    }

    public ResumeAParkedBasket clickViewParkedBaskets() throws Exception {

        tool.driver.findElement(By.linkText("View Parked Baskets")).click();
        return new ResumeAParkedBasket(tool, test, user);
    }

    @Override
    public ResumeAParkedBasket clickBasket() throws Exception {
        super.clickBasket();
        return new ResumeAParkedBasket(tool, test, user);
    }

    public ManageAccount clickManageAccount() throws Exception {
        tool.driver.findElement(By.linkText("Manage Account")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ManageAccount(tool, test, user);
    }
}
