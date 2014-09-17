package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ListCasesCommon;

public class ListCases extends ListCasesCommon {

    public ListCases(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ViewCase clickFirstCase() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickFirstCase();
        return new ViewCase(tool, test, user);
    }
}
