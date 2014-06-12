package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ResumeSubscriberResumeSuccessfulCommon;

public class ResumeSubscriberResumeSuccessful extends ResumeSubscriberResumeSuccessfulCommon {

    public ResumeSubscriberResumeSuccessful(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public SubscriberDetails clickOK() throws Exception {
        super.clickOK();
        return new SubscriberDetails(tool, test, user);
    }
}