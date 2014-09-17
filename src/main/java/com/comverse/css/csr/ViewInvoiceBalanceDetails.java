package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ViewInvoiceBalanceDetailsCommon;

public class ViewInvoiceBalanceDetails extends ViewInvoiceBalanceDetailsCommon {

    public ViewInvoiceBalanceDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ViewInvoiceDetails clickBack() throws Exception {
        super.clickBack();
        return new ViewInvoiceDetails(tool, test, user);
    }
}
