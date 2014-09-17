package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.DeleteBasketConfirmCommon;

public class DeleteBasketConfirm extends DeleteBasketConfirmCommon {

    public DeleteBasketConfirm(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public ResumeAParkedBasket clickOk() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickOk();
        return new ResumeAParkedBasket(tool, test, user);
    }
}
