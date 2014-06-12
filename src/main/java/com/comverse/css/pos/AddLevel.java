package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.AddLevelCommon;

public class AddLevel extends AddLevelCommon {

    public AddLevel(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ViewHierarchy clickOk() throws Exception {

        super.clickOk();
        return new ViewHierarchy(tool, test, user);
    }
}
