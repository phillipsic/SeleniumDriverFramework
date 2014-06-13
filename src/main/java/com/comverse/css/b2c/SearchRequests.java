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

    public SearchRequests(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Search Requests";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SearchOrders clickSearchOrders() throws Exception {

        tool.clickUsingID(tool, "smnu_ORDER");
        return new SearchOrders(tool, test, user);
    }

    public void clickSearch() throws Exception {
        tool.clickUsingXPath(tool, "(//input[@value='Search'])");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public void waitUntilFirstRequestCompletedOrFailed() throws Exception {

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
        String requestStatus = tool.getTextUsingXPath(tool, "//div[@id='requestsContainer']//tr[1]/td[6]/div");
        return requestStatus;
    }

    public void expandSearchCriteria() throws Exception {

        tool.clickUsingID(tool, "searchCriteriaTrigger");

    }

    public SubscriberDetail clickDashbaordMenu() throws Exception {

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.sleepForNumberOfSeconds(5);
        tool.clickUsingID(tool, "mnu_HOME");
        return new SubscriberDetail(tool, test, user);
    }

}
