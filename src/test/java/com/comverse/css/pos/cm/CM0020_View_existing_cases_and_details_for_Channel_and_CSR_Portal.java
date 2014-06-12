package com.comverse.css.pos.cm;

import static org.junit.Assert.assertTrue;

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

public class CM0020_View_existing_cases_and_details_for_Channel_and_CSR_Portal extends CSSTest {
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
    public void testCM0020_View_existing_cases_and_details_for_Channel_and_CSR_Portal() throws Exception {

        try {
            launchCSSApplication();
            String accountLastName = Common.getLastNameOfPostPaidAccount();
            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastName);

            String caseId = accountDetails.doAddCase();

            ViewCase viewCase = accountDetails.clickLinkOfCaseID(caseId);
            Common.assertTextOnPage(tool, caseId);
            assertTrue(viewCase.getCaseType().matches("^[\\s\\S]*General Request[\\s\\S]*$"));
            assertTrue(viewCase.getCaseStatus().matches("^[\\s\\S]*New[\\s\\S]*$"));
            assertTrue(viewCase.getCaseProblemArea().matches("^[\\s\\S]*Need Credit Limit Increased[\\s\\S]*$"));
            assertTrue(viewCase.getCaseDescription().matches("^[\\s\\S]*This was created by automated test.[\\s\\S]*$"));

            viewCase.clickNotesTab();
            assertTrue(viewCase.getNoteType().matches("^[\\s\\S]*Task Note[\\s\\S]*$"));
            assertTrue(viewCase.getNoteDescription().matches("^[\\s\\S]*Note - Task to do[\\s\\S]*$"));

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
