package com.comverse.caseui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.caseui.common.CaseUITest;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.CASEUI;
import com.comverse.data.users.CASEUIUser;

public class CaseUI002_CloseCase extends CaseUITest {

    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CASEUI();
        user = new CASEUIUser();
    }

    @Test
    public void testCaseUI002_CloseCase() throws Exception {

        try {
            launchCaseUIApplicationWithSSO();
            String caseType = "Self-Service Problem";
            String problemArea = "Forgot Password";
            String description = "CaseUI002_CloseCase";
            String accountLastname = Common.getLastNameOfPostPaidAccount();

            CaseUIHomePage homePage = new CaseUIHomePage(tool, test, user);
            String mainWindow = Common.getCurrentWindowHandle(tool);

            homePage.clickCaseManagement();
            homePage.clickCases();
            CaseUICases cases = new CaseUICases(tool, test, user);
            cases.clickNewCase();
            cases.clickSearchAccount(mainWindow);
            cases.clickSearch(accountLastname);
            cases.selectFirstAccount(mainWindow);
            cases.selectCaseType(caseType);
            cases.selectProblemArea(problemArea);
            cases.setCaseDescription(description);
            cases.saveNewCase();
            String caseID = cases.getCaseID();
            Common.assertTextOnPage(tool, "Created By: " + user.getRealm() + ":" + user.getLogin());
            Common.assertTextOnPage(tool, "Create Account Case");
            Common.assertTextOnPage(tool, caseType);
            Common.assertTextOnPage(tool, problemArea);
            Common.assertTextOnPage(tool, caseID);

            cases.changeCaseStatusToClose();
            cases.changeJustificationStatusToProblemSolved();
            cases.saveNewCase();
            Common.assertTextOnPage(tool, "Close Account Case");

            test.setResult("pass");

        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            verificationErrors.append(e.getMessage());
            throw e;
        }

    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
