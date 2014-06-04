package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.DeleteBasketConfirmCommon;

public class DeleteBasketConfirm extends DeleteBasketConfirmCommon {

    public DeleteBasketConfirm(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public ResumeAParkedBasket clickOk() throws Exception {

        super.clickOk();
        return new ResumeAParkedBasket(driver);
    }
}
