package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ViewBilledUsageCommon;

public class ViewBilledUsage extends ViewBilledUsageCommon {

    public ViewBilledUsage(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ViewBilledUsage clickSearch() throws Exception {
        super.clickSearch();
        return new ViewBilledUsage(tool, test, user);
    }

    @Override
    public ViewBilledUsageDetails clickFirstUsage() throws Exception {
        super.clickFirstUsage();
        return new ViewBilledUsageDetails(tool, test, user);
    }

    @Override
    public ViewInvoiceDetails clickBack() throws Exception {
        super.clickBack();
        return new ViewInvoiceDetails(tool, test, user);
    }
}
