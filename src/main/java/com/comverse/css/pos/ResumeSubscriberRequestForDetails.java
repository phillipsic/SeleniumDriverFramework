package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ResumeSubscriberRequestForDetailsCommon;

public class ResumeSubscriberRequestForDetails extends ResumeSubscriberRequestForDetailsCommon {

    public ResumeSubscriberRequestForDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ResumeSubscriberConfirmation clickContinue() throws Exception {
        super.clickContinue();
        return new ResumeSubscriberConfirmation(tool, test, user);
    }
}