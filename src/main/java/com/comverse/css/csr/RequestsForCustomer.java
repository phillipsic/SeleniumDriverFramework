package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.RequestsForCustomerCommon;

public class RequestsForCustomer extends RequestsForCustomerCommon {

    public RequestsForCustomer(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public String getFirstRequestStatus() throws Exception {
        String requestStatus = tool.getTextUsingXPath("//div[@id='requestsContainer']//tr[1]/td[7]/div");
        return requestStatus;
    }

    @Override
    public AccountDetails clickAccounts() throws Exception {
        super.clickAccounts();
        return new AccountDetails(tool, test, user);
    }

    @Override
    public OrderDetails clickOnOrderNumberLink(String orderNumber) throws Exception {
        super.clickOnOrderNumberLink(orderNumber);
        return new OrderDetails(tool, test, user);
    }
}
