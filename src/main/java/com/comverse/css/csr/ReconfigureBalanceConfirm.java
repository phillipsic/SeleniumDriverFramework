package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ReconfigureBalanceConfirmCommon;

public class ReconfigureBalanceConfirm extends ReconfigureBalanceConfirmCommon {

    public ReconfigureBalanceConfirm(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ViewBalance clickBack() throws Exception {
        super.clickBack();
        return new ViewBalance(tool, test, user);
    }

}
