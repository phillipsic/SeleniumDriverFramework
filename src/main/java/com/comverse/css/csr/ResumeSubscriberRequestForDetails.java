package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ResumeSubscriberRequestForDetailsCommon;

public class ResumeSubscriberRequestForDetails extends ResumeSubscriberRequestForDetailsCommon {

    public ResumeSubscriberRequestForDetails(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ResumeSubscriberConfirmation clickContinue() throws Exception {
        super.clickContinue();
        return new ResumeSubscriberConfirmation(driver);
    }
}