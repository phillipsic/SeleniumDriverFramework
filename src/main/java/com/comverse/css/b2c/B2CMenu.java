package com.comverse.css.b2c;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Main;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class B2CMenu extends Main {

    public B2CMenu(AutomationTool tool, Test test, User user) {
        this.tool = tool;
        this.test = test;
        this.user = user;

    }

    public SearchOrders clickRequests() throws Exception {

        tool.driver.findElement(By.id("mnu_REQUESTS")).click();
        return new SearchOrders(tool, test, user);
    }

    public HomePage clickLogout() throws Exception {

        tool.driver.findElement(By.id("mnu_LOGOUT")).click();
        return new HomePage(tool, test, user);
    }

    public SearchMember clickFamilyMemeber() throws Exception {

        tool.driver.findElement(By.id("mnu_MEMBERS")).click();
        return new SearchMember(tool, test, user);
    }

    public SubscriberDetail clickDashbaord() throws Exception {

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.sleepForNumberOfSeconds(5);
        tool.driver.findElement(By.id("mnu_HOME")).click();
        return new SubscriberDetail(tool, test, user);
    }

    public WorkSpace clickDashbaordWithNoSubscriber() throws Exception {

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.sleepForNumberOfSeconds(5);
        tool.driver.findElement(By.id("mnu_HOME")).click();
        return new WorkSpace(tool, test, user);
    }

    public SearchCustomer clickSearchCustomer() throws Exception {

        tool.driver.findElement(By.id("mnu_SEARCH_CUSTOMER")).click();
        return new SearchCustomer(tool, test, user);
    }

    public SearchMember clickMyInformation() throws Exception {

        tool.driver.findElement(By.id("mnu_CUST_INFO")).click();
        return new SearchMember(tool, test, user);
    }

    public SearchOrders clickMyOrders() throws Exception {

        tool.driver.findElement(By.linkText("My Orders")).click();
        return new SearchOrders(tool, test, user);
    }

    public ListCases clickSupport() throws Exception {

        tool.driver.findElement(By.id("mnu_PROBLEMS")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ListCases(tool, test, user);
    }

    public SubscriberDetail clickMyAccount() throws Exception {

        tool.driver.findElement(By.linkText("My Account")).click();
        return new SubscriberDetail(tool, test, user);
    }

    public Shopping clickShopping() throws Exception {
        tool.driver.findElement(By.linkText("Shopping")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new Shopping(tool, test, user);
    }
}
