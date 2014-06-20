package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.RemoveBasketCommon;

public class RemoveBasket extends RemoveBasketCommon {

    public RemoveBasket(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    public AccountDetails clickYes() throws Exception {

        tool.clickUsingXPath("//form[@id='form_YES']/div/input");
        return new AccountDetails(tool, test, user);
    }
}
