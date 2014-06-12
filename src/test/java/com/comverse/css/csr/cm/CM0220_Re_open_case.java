package com.comverse.css.csr.cm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRUser;

public class CM0220_Re_open_case extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRUser();
    }

    @Test
    public void testCM0250_Re_open_case() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String accountLastName = Common.getLastNameOfPostPaidAccount();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastName);

            String caseId = accountDetails.doAddCase();

            ViewCase viewCase = accountDetails.clickLinkOfCaseID(caseId);
            EditCase editCase = viewCase.clickEditCase();
            editCase.clickSaveAndCloseCase();
            editCase.enterReason("Problem Solved");
            editCase.clickOKToCancelOrClose();
            editCase.clickOK();
            assertEquals(viewCase.getCaseStatus(), "Closed");
            assertEquals(viewCase.getCaseJustificationStatus(), "Problem Solved");
            viewCase.clickNotesTab();
            assertTrue(viewCase.getNoteType().contains("Type : Complaint"));
            assertEquals(viewCase.getNoteDescription(), "Problem Solved");
            viewCase.clickBack();
            accountDetails.clickLinkOfCaseID(caseId);
            viewCase.clickReopen();
            editCase.clickOK();
            assertEquals(viewCase.getCaseStatus(), "New");
            assertEquals(viewCase.getCaseJustificationStatus(), "New");
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