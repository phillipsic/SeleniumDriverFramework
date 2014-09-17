package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.RemoveSelectionCommon;

public class RemoveSelection extends RemoveSelectionCommon {

    public RemoveSelection(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public MyBasket clickYes() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickYes();
        return new MyBasket(tool, test, user);
    }

    @Override
    public RemoveLevel clickRemoveSelectionByYes() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickRemoveSelectionByYes();
        return new RemoveLevel(tool, test, user);
    }
}
