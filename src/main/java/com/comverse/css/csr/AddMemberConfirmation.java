package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.AddMemberConfirmationCommon;

public class AddMemberConfirmation extends AddMemberConfirmationCommon {

    public AddMemberConfirmation(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public AddMember clickOk() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickOk();
        return new AddMember(tool, test, user);
    }
}
