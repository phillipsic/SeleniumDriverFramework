package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ViewBilledRechargesCommon;

public class ViewBilledRecharges extends ViewBilledRechargesCommon {

    public ViewBilledRecharges(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ViewRechargeDetails clickFirstRecharge() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickFirstRecharge();
        return new ViewRechargeDetails(tool, test, user);
    }
}
