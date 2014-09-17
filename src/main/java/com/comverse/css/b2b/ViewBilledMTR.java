package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ViewBilledMTRCommon;

public class ViewBilledMTR extends ViewBilledMTRCommon {

    public ViewBilledMTR(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ViewBilledMTRDetails clickFirstMTR() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickFirstMTR();
        return new ViewBilledMTRDetails(tool, test, user);
    }

    @Override
    public ViewInvoiceDetails clickBack() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickBack();
        return new ViewInvoiceDetails(tool, test, user);
    }
}
