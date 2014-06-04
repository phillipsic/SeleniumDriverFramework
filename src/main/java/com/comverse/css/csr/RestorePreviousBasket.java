package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.RestorePreviousBasketCommon;

public class RestorePreviousBasket extends RestorePreviousBasketCommon {

    public RestorePreviousBasket(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public MyBasket clickRestoreSavedBasket() throws Exception {

        super.clickRestoreSavedBasket();
        return new MyBasket(driver);
    }
}
