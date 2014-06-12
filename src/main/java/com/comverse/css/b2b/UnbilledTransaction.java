package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.UnbilledTransactionCommon;

public class UnbilledTransaction extends UnbilledTransactionCommon {

    public UnbilledTransaction(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ViewUnbilledMTR clickUnbilledMTR() throws Exception {

        super.clickUnbilledMTR();
        return new ViewUnbilledMTR(tool, test, user);
    }

    @Override
    public ViewUnbilledRecharge clickUnbilledRecharge() throws Exception {

        super.clickUnbilledRecharge();
        return new ViewUnbilledRecharge(tool, test, user);
    }

    @Override
    public ViewUnbilledUsage clickUnbilledUsage() throws Exception {

        super.clickUnbilledUsage();
        return new ViewUnbilledUsage(tool, test, user);
    }

    @Override
    public ViewUnbilledRCNRC clickUnbilledRCNRC() throws Exception {

        super.clickUnbilledRCNRC();
        return new ViewUnbilledRCNRC(tool, test, user);
    }

    @Override
    public ViewUnbilledAdjustment clickUnbilledAdjustment() throws Exception {

        super.clickUnbilledAdjustment();
        return new ViewUnbilledAdjustment(tool, test, user);
    }
}
