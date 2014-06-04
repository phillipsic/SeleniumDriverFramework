/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author iphilli
 */
public class SearchRequests extends B2CMenu {

    public SearchRequests(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Search Requests";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public SearchOrders clickSearchOrders() throws Exception {

        driver.findElement(By.id("smnu_ORDER")).click();
        return new SearchOrders(driver);
    }

    public void clickSearch() throws Exception {
        driver.findElement(By.xpath("(//input[@value='Search'])")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
    }

    public void waitUntilFirstRequestCompletedOrFailed() throws Exception {

        int maxIterations = 90;
        int iterationCounter = 0;
        String requestStatus;

        while (iterationCounter < maxIterations) {

            this.expandSearchCriteria();
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
        String requestStatus = driver.findElement(By.xpath("//div[@id='requestsContainer']//tr[1]/td[6]/div")).getText();
        return requestStatus;
    }

    public void expandSearchCriteria() throws Exception {

        driver.findElement(By.id("searchCriteriaTrigger")).click();

    }
    
    public SubscriberDetail clickDashbaordMenu() throws Exception {

        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.sleepForNumberOfSeconds(5);
        driver.findElement(By.id("mnu_HOME")).click();
        return new SubscriberDetail(driver);
    }

}
