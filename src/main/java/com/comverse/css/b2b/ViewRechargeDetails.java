package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ViewRechargeDetailsCommon;

public class ViewRechargeDetails extends ViewRechargeDetailsCommon {

    public ViewRechargeDetails(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public ViewUnbilledRecharge clickBack() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickBack();
        return new ViewUnbilledRecharge(tool, test, user);
    }
}
