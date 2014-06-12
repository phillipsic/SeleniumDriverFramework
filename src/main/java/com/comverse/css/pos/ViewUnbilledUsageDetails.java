package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ViewUnbilledUsageDetailsCommon;

public class ViewUnbilledUsageDetails extends ViewUnbilledUsageDetailsCommon {

    public ViewUnbilledUsageDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ViewUnbilledUsage clickBack() throws Exception {

        super.clickBack();
        return new ViewUnbilledUsage(tool, test, user);
    }

}