package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class CustomerSearchResultCommon extends CommonMenu {

    public CustomerSearchResultCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Customer search result";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AccountDetailsCommon clickPersonNameLink(String lastName) throws Exception {

        tool.clickUsingPartialLinkText(tool, lastName);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public AccountDetailsCommon clickAccountLink(String accountNumber) throws Exception {

        tool.clickUsingPartialLinkText(tool, accountNumber);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public AccountDetailsCommon clickFirstPersonLink() throws Exception {

        tool.driver.findElement(By.id("value_person_0_0")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public AccountDetailsCommon clickFirstAccountLink() throws Exception {

        tool.clickUsingXPath(tool, "//td[3]/a");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDetailsCommon(tool, test, user);
    }

    public SubscriberDetailsCommon clickSubscriberLink(String MSISDN) throws Exception {

        tool.clickUsingPartialLinkText(tool, MSISDN);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberDetailsCommon(tool, test, user);
    }
}
