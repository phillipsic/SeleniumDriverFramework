/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.RequestSubmissionCommon;

/**
 * 
 * @author Vikram Sharma
 */
public class RequestSubmission extends RequestSubmissionCommon {

    public RequestSubmission(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public AccountDetails clickOkModifyRequestGoTOAccountDashboard() throws Exception {

        super.clickOkModifyRequestGoTOAccountDashboard();
        return new AccountDetails(driver);
    }

    @Override
    public ViewHierarchy clickOk() throws Exception {

        super.clickOk();
        return new ViewHierarchy(driver);
    }
}
