package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class RequestsForCustomerCommon extends CommonMenu {
    static String expectedScreen = "Requests for Customer";

    public RequestsForCustomerCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void clickSearch() throws Exception {
        driver.findElement(By.xpath("(//input[@value='Search'])[3]")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
    }

    public OrderDetailsCommon clickOnOrderNumberLink(String orderNumber) throws Exception {
        driver.findElement(By.linkText(orderNumber)).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new OrderDetailsCommon(driver);
    }

    public void waitUntilFirstRequestCompletedOrFailed() throws Exception {

        int maxIterations = 90;
        int iterationCounter = 0;
        String requestStatus;

        while (iterationCounter < maxIterations) {

            this.clickSearch();
            requestStatus = this.getFirstRequestStatus();

            System.out.println(this.getClass().getSimpleName() + ": Iteration  " + iterationCounter + " of " + maxIterations + " Status:"
                               + requestStatus);

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
        String requestStatus = driver.findElement(By.xpath("//div[@id='requestsContainer']//tr/td[7]/div")).getText();
        return requestStatus;
    }

    public void clickToSubscriberDashboard() throws Exception {
        driver.findElement(By.cssSelector("div.navContextMain > a[title=\"Go to Subscriber Dashboard\"]")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
    }
    
    public void waitUntilFirstRequestCompletedOrFailedPOS() throws Exception {

        int maxIterations = 90;
        int iterationCounter = 0;
        String requestStatus;

        while (iterationCounter < maxIterations) {

            this.clickSearch();
            requestStatus = this.getFirstRequestStatus();

            System.out.println(this.getClass().getSimpleName() + ": Iteration  " + iterationCounter + " of " + maxIterations + " Status:"
                               + requestStatus);

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
