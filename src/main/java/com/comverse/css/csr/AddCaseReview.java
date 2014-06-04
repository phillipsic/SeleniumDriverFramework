/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.AddCaseReviewCommon;

/**
 * 
 * @author iphilli
 */
public class AddCaseReview extends AddCaseReviewCommon {

    public AddCaseReview(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public AddCaseConfirmation clickCreateCase() throws Exception {

        super.clickCreateCase();
        return new AddCaseConfirmation(driver);
    }
}
