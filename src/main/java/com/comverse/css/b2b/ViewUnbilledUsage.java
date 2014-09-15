package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ViewUnbilledUsageCommon;

public class ViewUnbilledUsage extends ViewUnbilledUsageCommon {

    public ViewUnbilledUsage(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ViewUnbilledUsage clickSearch() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickSearch();
        return new ViewUnbilledUsage(tool, test, user);
    }

    @Override
    public ViewUnbilledUsageDetails clickFirstUsage() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickFirstUsage();
        return new ViewUnbilledUsageDetails(tool, test, user);
    }

    @Override
    public UnbilledTransaction clickBack() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickBack();
        return new UnbilledTransaction(tool, test, user);
    }
}
