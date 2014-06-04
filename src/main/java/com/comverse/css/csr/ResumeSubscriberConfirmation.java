package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ResumeSubscriberConfirmationCommon;

public class ResumeSubscriberConfirmation extends ResumeSubscriberConfirmationCommon {

    public ResumeSubscriberConfirmation(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ResumeSubscriberResumeSuccessful clickConfirm() throws Exception {
        super.clickConfirm();
        return new ResumeSubscriberResumeSuccessful(driver);
    }
}