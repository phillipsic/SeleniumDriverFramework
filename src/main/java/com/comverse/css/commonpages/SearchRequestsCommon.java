/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

/**
 * 
 * @author iphilli
 */
public class SearchRequestsCommon extends CommonMenu {

    public SearchRequestsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Search RequestsView Requests";

        if (!expectedScreen.contains(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public SearchOrdersCommon clickSearchOrders() throws Exception {
        test.writeInLog(Common.getMethodName());

        tool.clickUsingID("smnu_ORDER");
        return new SearchOrdersCommon(tool, test, user);
    }

}
