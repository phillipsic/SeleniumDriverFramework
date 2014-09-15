/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SearchOrders extends B2CMenu {

    public SearchOrders(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Search Orders";

         if (!expectedScreen.equals(tool.getTitle())) {
            test.writeInLog("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
        test.writeInLog(" >>> Page Now loaded: " + expectedScreen + " <<<");
    }

    public void clickSearch() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Search']");

    }

    public SubscriberDetail clickAccounts() throws Exception {
        test.writeInLog(Common.getMethodName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.clickUsingID("mnu_ACCOUNTS");
        return new SubscriberDetail(tool, test, user);
    }

    public SubscriberDetail clickDashboard() throws Exception {
        test.writeInLog(Common.getMethodName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.clickUsingID("mnu_HOME");
        return new SubscriberDetail(tool, test, user);
    }

    public SearchRequests clickSearchRequests() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingXPath("//input[@value='Search']");
        return new SearchRequests(tool, test, user);
    }

    public String getOrderStatus() throws Exception {
        test.writeInLog(Common.getMethodName());
        String orderStatus = tool.getTextUsingXPath("//table[@id='orderList']/tbody/tr/td[5]");
        return orderStatus;
    }

    public String getOrderStatusWithOrderNumber(String orderNumber) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + orderNumber + ")");
        String orderStatus = tool.getTextUsingXPath("//a[contains(text(),'" + orderNumber + "')]/../../td[5]");
        return orderStatus;
    }

    public String getOrderNumber() throws Exception {
        test.writeInLog(Common.getMethodName());
        String orderNumber = tool.getTextUsingXPath("//table[@id='orderList']/tbody/tr/td[4]");
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + orderNumber + ")");
        tool.enterStringUsingId("orderNb", orderNumber);
    }

    public void setFromDate(String date) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + date + ")");
        tool.enterStringUsingId("startDate", date);
    }

    public void setToDate(String date) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + date + ")");
        tool.enterStringUsingId("endDate", date);
    }

    public String getOrderDate() throws Exception {
        test.writeInLog(Common.getMethodName());
        String orderDate = tool.getTextUsingXPath("//table[@id='orderList']/tbody/tr/td[1]");
        return orderDate;
    }

    public void setOrderStatus(String orderStatus) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + orderStatus + ")");
        tool.selectVisibleTextByID("orderStatus", orderStatus);
    }

    public OrderDetails clickOrderNumber(String orderNumber) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + orderNumber + ")");
        tool.clickUsingLinkText(orderNumber);
        return new OrderDetails(tool, test, user);
    }

    public void waitUntilOrderCompletedOrFailed() throws Exception {
        test.writeInLog(Common.getMethodName());
        int maxIterations = 120;
        int iterationCounter = 0;
        String orderStatus;

        while (iterationCounter < maxIterations) {

            this.clickSearch();
            orderStatus = this.getOrderStatus();

            System.out.println(this.getClass().getSimpleName() + ": Iteration  " + iterationCounter + " of " + maxIterations + " Status:" + orderStatus);

            if (orderStatus.equals("Complete")) {

                System.out.println("Order Complete");
                break;
            }

            if (orderStatus.equalsIgnoreCase("failed") || orderStatus.equalsIgnoreCase("Cancelled")) {

                throw new IllegalStateException("Order failed with status " + orderStatus);
            }

            iterationCounter++;
        }

        if (iterationCounter >= maxIterations) {
            throw new IllegalStateException("Order failed with status " + this.getOrderStatus());
        }
    }

    public void waitUntilOrderCompletedOrFailedWithOrderNumber(String orderNumber) throws Exception {
        test.writeInLog(Common.getMethodName() + " using data (" + orderNumber + ")");
        int maxIterations = 120;
        int iterationCounter = 0;
        String orderStatus;

        while (iterationCounter < maxIterations) {

            this.clickSearch();
            orderStatus = this.getOrderStatusWithOrderNumber(orderNumber);

            System.out.println(this.getClass().getSimpleName() + ": Iteration  " + iterationCounter + " of " + maxIterations + " Status:" + orderStatus);

            if (orderStatus.equals("Complete")) {

                System.out.println("Order Complete");
                break;
            }

            if (orderStatus.equalsIgnoreCase("failed") || orderStatus.equalsIgnoreCase("Cancelled")) {

                throw new IllegalStateException("Order failed with status " + orderStatus);
            }

            iterationCounter++;
        }

        if (iterationCounter >= maxIterations) {
            throw new IllegalStateException("Order failed with status " + this.getOrderStatus());
        }
    }

    public SearchRequests goToSearchRequests() throws Exception {
        test.writeInLog(Common.getMethodName());
        tool.clickUsingID("smnu_VIEW");
        return new SearchRequests(tool, test, user);
    }
}
