/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.AddSubLevelLegalAddressCommon;

/**
 * 
 * @author Vikram Sharma
 */
public class AddSubLevelLegalAddress extends AddSubLevelLegalAddressCommon {

    public AddSubLevelLegalAddress(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public RequestSubmission clickOk() throws Exception {

        super.clickOk();
        return new RequestSubmission(driver);
    }

    @Override
    public void setLevelName(String levelName) throws Exception {

        super.setLevelName(levelName);
    }

    @Override
    public void setLevelState(String levelState) throws Exception {

        super.setLevelState(levelState);

    }
}
