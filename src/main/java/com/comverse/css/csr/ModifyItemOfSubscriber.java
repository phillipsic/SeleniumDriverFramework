/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;
import com.comverse.css.commonpages.ModifyItemOfSubscriberCommon;

public class ModifyItemOfSubscriber extends ModifyItemOfSubscriberCommon {

    public ModifyItemOfSubscriber(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ModifyItem clickConfirm() throws Exception {
        super.clickConfirm();
        return new ModifyItem(driver);
    }
}
