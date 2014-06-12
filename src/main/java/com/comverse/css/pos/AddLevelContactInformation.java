package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.AddLevelContactInformationCommon;

public class AddLevelContactInformation extends AddLevelContactInformationCommon {

    public AddLevelContactInformation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public AddLevelConfirmation clickOk() throws Exception {

        super.clickOk();
        return new AddLevelConfirmation(tool, test, user);
    }

    public void setLevelName(String levelName) throws Exception {

        super.setLevelName(levelName);
    }

    public void setLevelState(String levelState) throws Exception {

        super.setLevelState(levelState);
    }
}
