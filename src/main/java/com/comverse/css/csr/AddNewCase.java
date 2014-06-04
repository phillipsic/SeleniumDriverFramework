/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.AddNewCaseCommon;

/**
 * 
 * @author iphilli
 */
public class AddNewCase extends AddNewCaseCommon {

    public AddNewCase(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public AddCaseReview clickContinue() throws Exception {

        super.clickContinue();
        return new AddCaseReview(driver);
    }
}
