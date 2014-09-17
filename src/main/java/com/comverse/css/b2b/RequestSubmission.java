/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.RequestSubmissionCommon;

public class RequestSubmission extends RequestSubmissionCommon {

    public RequestSubmission(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public AccountDetails clickOkModifyRequestGoTOAccountDashboard() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickOkModifyRequestGoTOAccountDashboard();
        return new AccountDetails(tool, test, user);
    }

    @Override
    public ContactInformation clickOkToSubmit() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickOkToSubmit();
        return new ContactInformation(tool, test, user);
    }

    @Override
    public ProfileInformation clickOkToSubmitRequest() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickOkToSubmitRequest();
        return new ProfileInformation(tool, test, user);
    }
}
