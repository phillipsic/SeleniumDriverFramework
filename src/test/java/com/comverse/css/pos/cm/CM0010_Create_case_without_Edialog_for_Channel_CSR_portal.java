package com.comverse.css.pos.cm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class CM0010_Create_case_without_Edialog_for_Channel_CSR_portal extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @Test
    public void testCM0010_Create_case_without_Edialog_for_Channel_CSR_portal() throws Exception {

        try {
            launchCSSApplication();
            String accountLastName = Common.getLastNameOfPostPaidAccount();
            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastName);

            AddNewCase addNewCase = accountDetails.addNewCase();

            addNewCase.selectCaseType("General Request");
            addNewCase.selectCaseProblemArea("Need Credit Limit Increased");
            addNewCase.enterCaseDescription("This was created by automated test PBM61.");
            addNewCase.selectNoteType("Task Note");
            addNewCase.enterNoteDescription("Note - Task to do");
            AddCaseReview addCaseReview = addNewCase.clickContinue();

            AddCaseConfirmation addCaseConfirmation = addCaseReview.clickCreateCase();

            Common.assertVerifyTrue(tool, addCaseConfirmation.getConfirmationMessage().matches("^[\\s\\S]*Your case has been successfully created with the reference[\\s\\S]*$"));

            String caseId = addCaseConfirmation.getCaseID();
            accountDetails = addCaseConfirmation.clickOk();
            ViewCase viewCase = accountDetails.clickLinkOfCaseID(caseId);

            Common.assertVerifyTrue(tool, viewCase.getCaseType().matches("^[\\s\\S]*General Request[\\s\\S]*$"));
            Common.assertVerifyTrue(tool, viewCase.getCaseProblemArea().matches("^[\\s\\S]*Need Credit Limit Increased[\\s\\S]*$"));
            Common.assertVerifyTrue(tool, viewCase.getCaseDescription().matches("^[\\s\\S]*This was created by automated test PBM61.[\\s\\S]*$"));

            viewCase.clickNotesTab();

            Common.assertVerifyTrue(tool, viewCase.getNoteType().matches("^[\\s\\S]*Task Note[\\s\\S]*$"));
            Common.assertVerifyTrue(tool, viewCase.getNoteDescription().matches("^[\\s\\S]*Note - Task to do[\\s\\S]*$"));

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
