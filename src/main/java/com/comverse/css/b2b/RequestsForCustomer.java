package com.comverse.css.b2b;

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
        tool.clickUsingID(tool, "mnu_ACCOUNTS");
        return new AccountDetails(tool, test, user);
    }

    public void waitUntilBizFirstRequestCompletedOrFailed() throws Exception {

        int maxIterations = 90;
        int iterationCounter = 0;
        String requestStatus;

        while (iterationCounter < maxIterations) {

            this.clickSearch();
            requestStatus = this.getBizFirstRequestStatus();

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

    public String getBizFirstRequestStatus() throws Exception {

        String requestStatus = tool.getTextUsingXPath(tool, "//div[5]/table/tbody[2]/tr/td[6]/div");
        return requestStatus;
    }

    @Override
    public OrderDetails clickOnOrderNumberLink(String orderNumber) throws Exception {

        super.clickOnOrderNumberLink(orderNumber);
        return new OrderDetails(tool, test, user);
    }
}
