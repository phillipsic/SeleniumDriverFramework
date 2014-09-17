package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.WorkSpaceCommon;

public class WorkSpace extends WorkSpaceCommon {

    public WorkSpace(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "Welcome to Your Workspace";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public AccountDetails clickAccount() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("mnu_ACCOUNTS");
        return new AccountDetails(tool, test, user);
    }

    public ListCases clickCustomerCare() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingID("mnu_PROBLEMS");
        return new ListCases(tool, test, user);
    }

    public ViewHierarchy clickUserManagement() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingID("mnu_HIERARCHY");
        return new ViewHierarchy(tool, test, user);
    }

    public ContactInformation clickUsersName() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingID("GLOBAL.MEMBER_CONTEXT");
        return new ContactInformation(tool, test, user);
    }

    public ResumeAParkedBasket clickViewParkedBaskets() throws Exception {
        test.writeInLogFile(Common.getMethodName());

        tool.clickUsingLinkText("View Parked Baskets");
        return new ResumeAParkedBasket(tool, test, user);
    }

    @Override
    public ResumeAParkedBasket clickBasket() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        super.clickBasket();
        return new ResumeAParkedBasket(tool, test, user);
    }

    public ManageAccount clickManageAccount() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingLinkText("Manage Account");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ManageAccount(tool, test, user);
    }
}
