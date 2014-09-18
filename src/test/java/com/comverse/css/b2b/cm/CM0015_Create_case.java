package com.comverse.css.b2b.cm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2b.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2B;
import com.comverse.data.users.B2BAdmin;

public class CM0015_Create_case extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2B();
        user = new B2BAdmin();
    }

    @Test
    public void testCM0015_Create_case() throws Exception {
        try {
            launchCSSApplication();

            MyshapeBusiness loginPage = new MyshapeBusiness(tool, test, user);
            WorkSpace workSpace = loginPage.loginToB2B(user);

            AccountDetails accountDashboard = workSpace.clickAccount();

            AddNewCase addNewCase = accountDashboard.addNewCase();
            addNewCase.selectCaseType("Service Problem");
            addNewCase.selectCaseProblemArea("Poor Quality - Wired Services");
            addNewCase.enterCaseDescription("This was created by automated test PBM61_Create_case_b2b.");
            AddCaseReview addCaseReview = addNewCase.clickContinue();

            AddCaseConfirmation addCaseConfirmation = addCaseReview.clickCreateCase();

            Common.assertVerifyTrue(tool, addCaseConfirmation.getConfirmationMessage().matches("^[\\s\\S]*Your case has been successfully created with the reference[\\s\\S]*$"));
            String caseId = addCaseConfirmation.getCaseID();
            accountDashboard = addCaseConfirmation.clickOk();
            ViewCase viewCase = accountDashboard.clickLinkOfCaseID(caseId);

            Common.assertVerifyTrue(tool, viewCase.getCaseType().matches("^[\\s\\S]*Service Problem[\\s\\S]*$"));
            Common.assertVerifyTrue(tool, viewCase.getCaseProblemArea().matches("^[\\s\\S]*Poor Quality - Wired Services[\\s\\S]*$"));
            Common.assertVerifyTrue(tool, viewCase.getCaseDescription().matches("^[\\s\\S]*This was created by automated test PBM61_Create_case_b2b.[\\s\\S]*$"));

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