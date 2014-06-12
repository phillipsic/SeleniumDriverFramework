package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ViewUnbilledMTRDetailsCommon;

public class ViewUnbilledMTRDetails extends ViewUnbilledMTRDetailsCommon {

    public ViewUnbilledMTRDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ViewUnbilledMTR clickBack() throws Exception {
        super.clickBack();
        return new ViewUnbilledMTR(tool, test, user);
    }
}
