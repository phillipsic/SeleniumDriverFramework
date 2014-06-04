package com.comverse.css.csr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.RequestsForCustomerCommon;

public class RequestsForCustomer extends RequestsForCustomerCommon {

    public RequestsForCustomer(WebDriver driver) throws Exception {
        super(driver);
    }

    @Override
    public String getFirstRequestStatus() throws Exception {
        String requestStatus = driver.findElement(By.xpath("//div[@id='requestsContainer']//tr[1]/td[7]/div")).getText();
        return requestStatus;
    }

    @Override
    public AccountDetails clickAccounts() throws Exception {
        super.clickAccounts();
        return new AccountDetails(driver);
    }

    @Override
    public OrderDetails clickOnOrderNumberLink(String orderNumber) throws Exception {

        super.clickOnOrderNumberLink(orderNumber);
        return new OrderDetails(driver);
    }
}
