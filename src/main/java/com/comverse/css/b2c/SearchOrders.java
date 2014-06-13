/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SearchOrders extends B2CMenu {

    public SearchOrders(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Search Orders";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickSearch() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Search']")).click();

    }

    public SubscriberDetail clickAccounts() throws Exception {

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.driver.findElement(By.id("mnu_ACCOUNTS")).click();
        return new SubscriberDetail(tool, test, user);
    }

    public SubscriberDetail clickDashboard() throws Exception {

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.driver.findElement(By.id("mnu_HOME")).click();
        return new SubscriberDetail(tool, test, user);
    }

    public SearchRequests clickSearchRequests() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Search']")).click();
        return new SearchRequests(tool, test, user);
    }

    public String getOrderStatus() throws Exception {

        String orderStatus = tool.driver.findElement(By.xpath("//table[@id='orderList']/tbody/tr/td[5]")).getText();
        return orderStatus;
    }

    public String getOrderStatusWithOrderNumber(String orderNumber) throws Exception {

        String orderStatus = tool.driver.findElement(By.xpath("//a[contains(text(),'" + orderNumber + "')]/../../td[5]")).getText();
        return orderStatus;
    }

    public String getOrderNumber() throws Exception {

        String orderNumber = tool.driver.findElement(By.xpath("//table[@id='orderList']/tbody/tr/td[4]")).getText();
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) throws Exception {
        
        tool.enterStringUsingId(tool, "orderNb", orderNumber);
    }

    public void setFromDate(String date) throws Exception {
        
        tool.enterStringUsingId(tool, "startDate", date);
    }

    public void setToDate(String date) throws Exception {
        
        tool.enterStringUsingId(tool, "endDate", date);
    }

    public String getOrderDate() throws Exception {

        String orderDate = tool.driver.findElement(By.xpath("//table[@id='orderList']/tbody/tr/td[1]")).getText();
        return orderDate;
    }

    public void setOrderStatus(String orderStatus) throws Exception {
        new Select(tool.searchUsingID(tool, "orderStatus")).selectByVisibleText(orderStatus);
    }

    public OrderDetails clickOrderNumber(String orderNumber) throws Exception {
        tool.driver.findElement(By.linkText(orderNumber)).click();
        return new OrderDetails(tool, test, user);
    }

    public void waitUntilOrderCompletedOrFailed() throws Exception {

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

        tool.driver.findElement(By.id("smnu_VIEW")).click();
        return new SearchRequests(tool, test, user);
    }
}
