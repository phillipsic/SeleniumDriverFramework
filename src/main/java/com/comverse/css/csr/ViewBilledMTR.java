package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ViewBilledMTRCommon;

public class ViewBilledMTR extends ViewBilledMTRCommon {

    public ViewBilledMTR(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ViewBilledMTRDetails clickFirstMTR() throws Exception {
        super.clickFirstMTR();
        return new ViewBilledMTRDetails(tool, test, user);
    }

    @Override
    public ViewInvoiceDetails clickBack() throws Exception {
        super.clickBack();
        return new ViewInvoiceDetails(tool, test, user);
    }
}
