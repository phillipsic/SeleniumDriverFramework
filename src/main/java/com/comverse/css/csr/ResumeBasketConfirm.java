/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ResumeBasketConfirmCommon;

/**
 * 
 * @author iphilli
 */
public class ResumeBasketConfirm extends ResumeBasketConfirmCommon {

    public ResumeBasketConfirm(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public MyBasket clickOk() throws Exception {

        super.clickOk();
        return new MyBasket(driver);
    }
}
