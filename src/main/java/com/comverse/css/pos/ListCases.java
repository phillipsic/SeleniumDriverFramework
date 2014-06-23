/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ListCasesCommon;

public class ListCases extends ListCasesCommon {

    public ListCases(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public ViewCase clickLinkOfCaseID(String caseID) throws Exception {
        super.clickLinkOfCaseID(caseID);
        return new ViewCase(tool, test, user);
    }

}
