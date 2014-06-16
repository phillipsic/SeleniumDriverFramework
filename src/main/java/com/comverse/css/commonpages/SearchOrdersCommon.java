/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Account;
import com.comverse.css.common.Common;

public class SearchOrdersCommon extends CommonMenu {
    static String expectedScreen = "Search Orders";

    public SearchOrdersCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle(tool))) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickSearch() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Search']");

    }

    public WorkSpaceCommon clickHomeMenu() throws Exception {
        tool.clickUsingID(tool, "mnu_HOME");
        return new WorkSpaceCommon(tool, test, user);
    }

    public SearchRequestsCommon clickSearchRequests() throws Exception {
        tool.clickUsingXPath(tool, "//input[@value='Search']");
        return new SearchRequestsCommon(tool, test, user);
    }

    public void setOrderNumber(String orderNumber) throws Exception {
        
        tool.enterStringUsingId(tool, "orderNb", orderNumber);
    }

    public String getOrderStatus1() throws Exception {
        String orderStatus = tool.getTextUsingXPath(tool, "//table[@id='orderList']/tbody/tr/td[5]");
        return orderStatus;
    }

    public String getOrderStatus2() throws Exception {
        String orderStatus = tool.getTextUsingXPath(tool, "//table[@id='orderList']/tbody/tr/td[4]");
        return orderStatus;
    }

    public void setOrderStatusToAll() throws Exception {
        new Select(tool.searchUsingID(tool, "orderStatus")).selectByVisibleText("All");
    }

    public void waitUntilOrderCompletedOrFailed(String orderNumber) throws Exception {

        int maxIterations = 120;
        int iterationCounter = 0;
        String orderStatus1;
        String orderStatus2;

        while (iterationCounter < maxIterations) {

            this.setOrderNumber(orderNumber);
            this.clickSearch();
            orderStatus1 = this.getOrderStatus1();
            orderStatus2 = this.getOrderStatus2();

            System.out.println(this.getClass().getSimpleName() + ": Iteration  " + iterationCounter + " of " + maxIterations + " Status:" + orderStatus1);

            if (orderStatus1.equals("Complete") || orderStatus2.equals("Completed")) {
                System.out.println("Order Complete");
                break;
            }

            if (orderStatus1.equalsIgnoreCase("failed") || orderStatus1.equalsIgnoreCase("Cancelled")) {

                throw new IllegalStateException("Order failed with status " + orderStatus1);
            }

            iterationCounter++;
        }

        if (iterationCounter >= maxIterations) {
            throw new IllegalStateException("Order failed with status " + this.getOrderStatus1());
        }

    }

    public void waitUntilOrderCompletedOrFailedWithGetAccountID(String orderNumber, Account account) throws Exception {

        int maxIterations = 120;
        int iterationCounter = 0;
        String orderStatus;

        while (iterationCounter < maxIterations) {

            this.setOrderNumber(orderNumber);
            this.clickSearch();
            orderStatus = this.getOrderStatus1();

            System.out.println(this.getClass().getSimpleName() + ": Iteration  " + iterationCounter + " of " + maxIterations + " Status:" + orderStatus);

            if (orderStatus.equals("Complete")) {
                System.out.println("Order Complete");
                SearchOrdersCommon serviceOrdersCommon = new SearchOrdersCommon(tool, test, user);
                ServiceOrderDetailsCommon serviceOrderDetailsCommon = serviceOrdersCommon.clickViewDetails();
                serviceOrderDetailsCommon.getAccountID(account);
                break;
            }

            if (orderStatus.equalsIgnoreCase("failed") || orderStatus.equalsIgnoreCase("Cancelled")) {

                throw new IllegalStateException("Order failed with status " + orderStatus);
            }

            iterationCounter++;
        }

        if (iterationCounter >= maxIterations) {
            throw new IllegalStateException("Order failed with status " + this.getOrderStatus1());
        }

    }

    public ServiceOrderDetailsCommon clickViewDetails() throws Exception {
        tool.clickUsingLinkText(tool, "View Details");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ServiceOrderDetailsCommon(tool, test, user);
    }

}
