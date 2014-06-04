/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.AddSubLevelSelectLevelTypeCommon;

/**
 * 
 * @author Vikram Sharma
 */

public class AddSubLevelSelectLevelType extends AddSubLevelSelectLevelTypeCommon {

    public AddSubLevelSelectLevelType(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public AddSubLevelLegalAddress clickOk() throws Exception {

        super.clickOk();
        return new AddSubLevelLegalAddress(driver);
    }

}
