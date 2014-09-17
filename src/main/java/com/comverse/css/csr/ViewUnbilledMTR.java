package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ViewUnbilledMTRCommon;

public class ViewUnbilledMTR extends ViewUnbilledMTRCommon {

    public ViewUnbilledMTR(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ViewUnbilledMTRDetails clickFirstMTR() throws Exception {
        super.clickFirstMTR();
        return new ViewUnbilledMTRDetails(tool, test, user);
    }

    @Override
    public UnbilledTransaction clickBack() throws Exception {
        super.clickBack();
        return new UnbilledTransaction(tool, test, user);
    }
}
