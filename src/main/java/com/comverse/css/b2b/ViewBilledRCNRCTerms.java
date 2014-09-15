package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ViewBilledRCNRCTermsCommon;

public class ViewBilledRCNRCTerms extends ViewBilledRCNRCTermsCommon {

    public ViewBilledRCNRCTerms(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ViewBilledRCNRCTermDetails clickFirstRCTerm() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickFirstRCTerm();
        return new ViewBilledRCNRCTermDetails(tool, test, user);
    }

    @Override
    public ViewInvoiceDetails clickBack() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickBack();
        return new ViewInvoiceDetails(tool, test, user);
    }
}
