package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ViewBilledMTRDetailsCommon;

public class ViewBilledMTRDetails extends ViewBilledMTRDetailsCommon {

    public ViewBilledMTRDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ViewBilledMTR clickBack() throws Exception {

        super.clickBack();
        return new ViewBilledMTR(tool, test, user);
    }
}
