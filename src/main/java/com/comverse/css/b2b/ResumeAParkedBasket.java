package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ResumeAParkedBasketCommon;

public class ResumeAParkedBasket extends ResumeAParkedBasketCommon {

    public ResumeAParkedBasket(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public DeleteBasketConfirm deleteParkedBasket(String basketName) throws Exception {  test.writeInLog(Common.getMethodName());

        super.deleteParkedBasket(basketName);
        return new DeleteBasketConfirm(tool, test, user);
    }

    @Override
    public ResumeBasketConfirm resumeParkedBasket(String value) throws Exception {  test.writeInLog(Common.getMethodName());

        super.resumeParkedBasket(value);
        return new ResumeBasketConfirm(tool, test, user);
    }
}
