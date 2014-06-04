package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ResumeAParkedBasketCommon;

public class ResumeAParkedBasket extends ResumeAParkedBasketCommon {

    public ResumeAParkedBasket(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public DeleteBasketConfirm deleteParkedBasket(String basketName) throws Exception {

        super.deleteParkedBasket(basketName);
        return new DeleteBasketConfirm(driver);
    }

    @Override
    public ResumeBasketConfirm resumeParkedBasket(String value) throws Exception {

        super.resumeParkedBasket(value);
        return new ResumeBasketConfirm(driver);
    }
}
