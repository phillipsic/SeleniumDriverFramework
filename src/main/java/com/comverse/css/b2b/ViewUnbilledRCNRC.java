package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ViewUnbilledRCNRCCommon;

public class ViewUnbilledRCNRC extends ViewUnbilledRCNRCCommon {

    public ViewUnbilledRCNRC(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ViewUnbilledRCTermDetails clickFirstRCTerm() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickFirstRCTerm();
        return new ViewUnbilledRCTermDetails(tool, test, user);
    }

    @Override
    public UnbilledTransaction clickBack() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickBack();
        return new UnbilledTransaction(tool, test, user);
    }
}
