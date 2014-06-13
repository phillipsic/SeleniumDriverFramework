package com.comverse.css.b2c;

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

        tool.clickUsingID(tool, "mnu_REQUESTS");
        return new SearchOrders(tool, test, user);
    }

    public HomePage clickLogout() throws Exception {

        tool.clickUsingID(tool, "mnu_LOGOUT");
        return new HomePage(tool, test, user);
    }

    public SearchMember clickFamilyMemeber() throws Exception {

        tool.clickUsingID(tool, "mnu_MEMBERS");
        return new SearchMember(tool, test, user);
    }

    public SubscriberDetail clickDashbaord() throws Exception {

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.sleepForNumberOfSeconds(5);
        tool.clickUsingID(tool, "mnu_HOME");
        return new SubscriberDetail(tool, test, user);
    }

    public WorkSpace clickDashbaordWithNoSubscriber() throws Exception {

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.sleepForNumberOfSeconds(5);
        tool.clickUsingID(tool, "mnu_HOME");
        return new WorkSpace(tool, test, user);
    }

    public SearchCustomer clickSearchCustomer() throws Exception {

        tool.clickUsingID(tool, "mnu_SEARCH_CUSTOMER");
        return new SearchCustomer(tool, test, user);
    }

    public SearchMember clickMyInformation() throws Exception {

        tool.clickUsingID(tool, "mnu_CUST_INFO");
        return new SearchMember(tool, test, user);
    }

    public SearchOrders clickMyOrders() throws Exception {

        tool.clickUsingLinkText(tool, "My Orders");
        return new SearchOrders(tool, test, user);
    }

    public ListCases clickSupport() throws Exception {

        tool.clickUsingID(tool, "mnu_PROBLEMS");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ListCases(tool, test, user);
    }

    public SubscriberDetail clickMyAccount() throws Exception {

        tool.clickUsingLinkText(tool, "My Account");
        return new SubscriberDetail(tool, test, user);
    }

    public Shopping clickShopping() throws Exception {
        tool.clickUsingLinkText(tool, "Shopping");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new Shopping(tool, test, user);
    }
}
