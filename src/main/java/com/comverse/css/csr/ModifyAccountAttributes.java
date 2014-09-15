/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ModifyAccountAttributesCommon;

public class ModifyAccountAttributes extends ModifyAccountAttributesCommon {

    public ModifyAccountAttributes(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public RequestSubmission clickModifyAttributes() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickModifyAttributes();
        return new RequestSubmission(tool, test, user);
    }
}
