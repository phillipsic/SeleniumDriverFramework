package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class CustomerSearchResultCommon extends CommonMenu {

    public CustomerSearchResultCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Customer search result";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public AccountDetailsCommon clickPersonNameLink(String lastName) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingPartialLinkText(lastName);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public AccountDetailsCommon clickAccountLink(String accountNumber) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingPartialLinkText(accountNumber);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public AccountDetailsCommon clickFirstPersonLink() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingID("value_person_0_0");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public AccountDetailsCommon clickFirstAccountLink() throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingXPath("//td[3]/a");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public SubscriberDetailsCommon clickSubscriberLink(String MSISDN) throws Exception {  test.writeInLog(Common.getMethodName());

        tool.clickUsingPartialLinkText(MSISDN);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberDetailsCommon(tool, test, user);
    }
}
