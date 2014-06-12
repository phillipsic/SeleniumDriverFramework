package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.AddLevelConfirmationCommon;

public class AddLevelConfirmation extends AddLevelConfirmationCommon {

    public AddLevelConfirmation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public AddLevel clickOk() throws Exception {

        super.clickOk();
        return new AddLevel(tool, test, user);
    }
}
