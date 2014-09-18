package com.comverse.css.csr.cm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class CM0230_Cancel_case extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testCM0230_Cancel_case() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String accountLastName = Common.getLastNameOfPostPaidAccount();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastName);

            String caseId = accountDetails.doAddCase();

            ViewCase viewCase = accountDetails.clickLinkOfCaseID(caseId);
            EditCase editCase = viewCase.clickEditCase();
            editCase.clickCancelCase();
            editCase.enterReason("Problem Solved");
            editCase.clickOKToCancelOrClose();
            editCase.clickOK();
            Common.assertTextEquals(viewCase.getCaseStatus(), "Cancelled");
            Common.assertTextEquals(viewCase.getCaseJustificationStatus(), "Problem Solved");
            viewCase.clickNotesTab();
            Common.assertVerifyTrue(tool, viewCase.getNoteType().contains("Complaint"));
            Common.assertTextEquals(viewCase.getNoteDescription(), "Problem Solved");
            viewCase.clickBack();

            test.setResult("pass");

        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            verificationErrors.append(e.getMessage());
            throw e;
        }

    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
