package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ResumeSubscriberConfirmationCommon;

public class ResumeSubscriberConfirmation extends ResumeSubscriberConfirmationCommon {

    public ResumeSubscriberConfirmation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ResumeSubscriberResumeSuccessful clickConfirm() throws Exception {
        super.clickConfirm();
        return new ResumeSubscriberResumeSuccessful(tool, test, user);
    }
}