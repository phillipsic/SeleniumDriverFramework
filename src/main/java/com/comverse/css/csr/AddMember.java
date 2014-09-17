package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.AddMemberCommon;

public class AddMember extends AddMemberCommon {

    public AddMember(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ViewHierarchy clickOk() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickOk();
        return new ViewHierarchy(tool, test, user);
    }
}
