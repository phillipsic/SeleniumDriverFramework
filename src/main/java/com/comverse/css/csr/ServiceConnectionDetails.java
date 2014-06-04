package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ServiceConnectionDetailsCommon;

public class ServiceConnectionDetails extends ServiceConnectionDetailsCommon {

    public ServiceConnectionDetails(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public MyBasket clickOk() throws Exception {

        super.clickOk();
        return new MyBasket(driver);
    }
}
