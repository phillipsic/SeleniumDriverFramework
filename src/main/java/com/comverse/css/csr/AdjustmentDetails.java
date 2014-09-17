package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.AdjustmentDetailsCommon;

public class AdjustmentDetails extends AdjustmentDetailsCommon {

    public AdjustmentDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ViewUnbilledAdjustment clickBack() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickBack();
        return new ViewUnbilledAdjustment(tool, test, user);
    }
}
