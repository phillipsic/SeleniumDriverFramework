/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;
import com.comverse.css.commonpages.ModifyOfferParametersCommon;

public class ModifyOfferParameters extends ModifyOfferParametersCommon {

    public ModifyOfferParameters(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ModifyItemOfSubscriber clickModify() throws Exception {
        super.clickModify();
        return new ModifyItemOfSubscriber(driver);
    }

}
