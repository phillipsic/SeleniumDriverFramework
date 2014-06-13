package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class RequestsForCustomerCommon extends CommonMenu {
    static String expectedScreen = "Requests for Customer";

    public RequestsForCustomerCommon(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickSearch() throws Exception {
        tool.clickUsingXPath(tool, "(//input[@value='Search'])[3]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public OrderDetailsCommon clickOnOrderNumberLink(String orderNumber) throws Exception {
        tool.clickUsingLinkText(tool, orderNumber);
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new OrderDetailsCommon(tool, test, user);
    }

    public void waitUntilFirstRequestCompletedOrFailed() throws Exception {

        int maxIterations = 90;
        int iterationCounter = 0;
        String requestStatus;

        while (iterationCounter < maxIterations) {

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
        String requestStatus = tool.driver.findElement(By.xpath("//div[@id='requestsContainer']//tr/td[7]/div")).getText();
        return requestStatus;
    }

    public void clickToSubscriberDashboard() throws Exception {
        tool.clickUsingCssSelector(tool, "div.navContextMain > a[title=\"Go to Subscriber Dashboard\"]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public void waitUntilFirstRequestCompletedOrFailedPOS() throws Exception {

        int maxIterations = 90;
        int iterationCounter = 0;
        String requestStatus;

        while (iterationCounter < maxIterations) {

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

}
