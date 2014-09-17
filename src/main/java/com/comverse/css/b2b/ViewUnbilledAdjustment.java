package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ViewUnbilledAdjustmentCommon;

public class ViewUnbilledAdjustment extends ViewUnbilledAdjustmentCommon {

    public ViewUnbilledAdjustment(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public AdjustmentDetails clickFirstAdjustment() throws Exception {
        super.clickFirstAdjustment();
        return new AdjustmentDetails(tool, test, user);
    }

    @Override
    public UnbilledTransaction clickBack() throws Exception {
        super.clickBack();
        return new UnbilledTransaction(tool, test, user);
    }
}
