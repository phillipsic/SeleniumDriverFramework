package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ViewUnbilledRCTermDetailsCommon;

public class ViewUnbilledRCTermDetails extends ViewUnbilledRCTermDetailsCommon {

    public ViewUnbilledRCTermDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ViewUnbilledRCNRC clickBack() throws Exception {

        super.clickBack();
        return new ViewUnbilledRCNRC(tool, test, user);
    }
}
