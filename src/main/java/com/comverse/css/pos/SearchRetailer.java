package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.CommonMenu;

public class SearchRetailer extends CommonMenu {

    public SearchRetailer(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Search Retailer";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void setDealerName(String dealerName) throws Exception {

        
        tool.enterStringUsingId("p-L1:2-L3:1480", dealerName);
    }

    public void clickSearchDealerName() throws Exception {

        tool.clickUsingXPath("//input[@value='Search']");

    }

    public ViewHierarchy clickDealerLink(String dealerName) throws Exception {

        tool.clickUsingLinkText(dealerName);
        Common.waitForEndOfWaitingPage(tool, Common.getMethodName());

        return new ViewHierarchy(tool, test, user);
    }

}
