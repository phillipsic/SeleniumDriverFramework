/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SearchRequests extends B2CMenu {

    public SearchRequests(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Search Requests";

        if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public SearchOrders clickSearchOrders() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingID("smnu_ORDER");
        return new SearchOrders(tool, test, user);
    }

    public void clickSearch() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("(//input[@value='Search'])");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public void waitUntilFirstRequestCompletedOrFailed() throws Exception {
        test.writeInLog(Common.getMethodName());
        int maxIterations = 90;
        int iterationCounter = 0;
        String requestStatus;

        while (iterationCounter < maxIterations) {

            this.expandSearchCriteria();
            this.clickSearch();
            requestStatus = this.getFirstRequestStatus();

            System.out.println(this.getClass().getSimpleName() + ": Iteration  " + iterationCounter + " of " + maxIterations + " Status:" + requestStatus);

            if (requestStatus.equals("Done")) {

                System.out.println("Request Done");
                break;
            }

            if (requestStatus.equalsIgnoreCase("failed") || requestStatus.equalsIgnoreCase("Cancelled")) {

                throw new IllegalStateException("Request failed with status " + requestStatus);
            }

            iterationCounter++;
        }

        if (iterationCounter >= maxIterations) {
            throw new IllegalStateException("Request failed with status " + this.getFirstRequestStatus());
        }
    }

    public String getFirstRequestStatus() throws Exception {
        test.writeInLog(Common.getMethodName());
        String requestStatus = tool.getTextUsingXPath("//div[@id='requestsContainer']//tr[1]/td[6]/div");
        return requestStatus;
    }

    public void expandSearchCriteria() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingID("searchCriteriaTrigger");

    }

    public SubscriberDetail clickDashbaordMenu() throws Exception {
        test.writeInLog(Common.getMethodName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.sleepForNumberOfSeconds(5);
        tool.clickUsingID("mnu_HOME");
        return new SubscriberDetail(tool, test, user);
    }

}
