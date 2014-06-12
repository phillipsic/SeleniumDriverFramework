package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ViewBilledRechargesCommon;

public class ViewBilledRecharges extends ViewBilledRechargesCommon {

    public ViewBilledRecharges(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ViewRechargeDetails clickFirstRecharge() throws Exception {

        super.clickFirstRecharge();
        return new ViewRechargeDetails(tool, test, user);
    }
}
