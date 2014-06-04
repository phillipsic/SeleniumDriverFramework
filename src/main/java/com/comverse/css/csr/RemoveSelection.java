package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.RemoveSelectionCommon;

/**
 * 
 * @author iphilli
 */
public class RemoveSelection extends RemoveSelectionCommon {

    public RemoveSelection(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public MyBasket clickYes() throws Exception {

        super.clickYes();
        return new MyBasket(driver);
    }

    @Override
    public RemoveLevel clickRemoveSelectionByYes() throws Exception {

        super.clickRemoveSelectionByYes();
        return new RemoveLevel(driver);
    }
}
