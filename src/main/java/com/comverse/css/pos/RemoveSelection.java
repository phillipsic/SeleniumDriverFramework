package com.comverse.css.pos;

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
}
