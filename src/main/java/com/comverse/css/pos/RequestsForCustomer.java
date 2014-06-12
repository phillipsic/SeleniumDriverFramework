/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.RequestsForCustomerCommon;

public class RequestsForCustomer extends RequestsForCustomerCommon {

    public RequestsForCustomer(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public AccountDetails clickAccounts() throws Exception {
        super.clickAccounts();
        return new AccountDetails(tool, test, user);
    }

    @Override
    public String getFirstRequestStatus() throws Exception {

        String requestStatus = tool.driver.findElement(By.xpath("//div[6]/table/tbody[2]/tr/td[6]/div")).getText();
        return requestStatus;
    }

    @Override
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
}
