package com.comverse.css.csr.cm;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.AccountDetails;
import com.comverse.css.csr.IdentifyCustomer;
import com.comverse.css.csr.ViewCase;
import com.comverse.css.csr.WorkSpace;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class CM0020_View_existing_cases_and_details_for_Channel_and_CSR_Portal extends CSSTest {
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
    public void testCM0020_View_existing_cases_and_details_for_Channel_and_CSR_Portal() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String accountLastName = Common.getLastNameOfPostPaidAccount();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastName);

            String caseId = accountDetails.doAddCase();

            ViewCase viewCase = accountDetails.clickLinkOfCaseID(caseId);
            Common.assertTextOnPage(tool, caseId);
            Common.assertTextEquals(viewCase.getCaseType(), "General Request");
            Common.assertTextEquals(viewCase.getCaseStatus(), "New");
            Common.assertTextEquals(viewCase.getCaseProblemArea(), "Need Credit Limit Increased");
            Common.assertTextEquals(viewCase.getCaseDescription(), "This was created by automated test.");

            viewCase.clickNotesTab();
            assertTrue(viewCase.getNoteType().contains("Task Note"));
            Common.assertTextEquals(viewCase.getNoteDescription(), "Note - Task to do");

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
