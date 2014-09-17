package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.RemoveSelectionCommon;

public class RemoveSelection extends RemoveSelectionCommon {

    public RemoveSelection(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public MyBasket clickYes() throws Exception {
        super.clickYes();
        return new MyBasket(tool, test, user);
    }

    @Override
    public RemoveLevel clickRemoveSelectionByYes() throws Exception {
        super.clickRemoveSelectionByYes();
        return new RemoveLevel(tool, test, user);
    }
}
