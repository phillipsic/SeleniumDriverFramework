package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.RestorePreviousBasketCommon;

public class RestorePreviousBasket extends RestorePreviousBasketCommon {

    public RestorePreviousBasket(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public MyBasket clickRestoreSavedBasket() throws Exception {

        super.clickRestoreSavedBasket();
        return new MyBasket(tool, test, user);
    }
}
