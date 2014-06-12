package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ViewBilledRCNRCTermDetailsCommon;

public class ViewBilledRCNRCTermDetails extends ViewBilledRCNRCTermDetailsCommon {

    public ViewBilledRCNRCTermDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ViewBilledRCNRCTerms clickBack() throws Exception {

        super.clickBack();
        return new ViewBilledRCNRCTerms(tool, test, user);
    }
}
