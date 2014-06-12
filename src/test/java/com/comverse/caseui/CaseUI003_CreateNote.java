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

public class CaseUI003_CreateNote extends CaseUITest {

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
    public void testCaseUI003_CreateNote() throws Exception {

        try {
            launchCaseUIApplicationWithSSO();
            String caseType = "Self-Service Problem";
            String problemArea = "Forgot Password";
            String noteType = "Resolution";
            String description = "testCaseUI003_CreateNote";
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
            cases.saveNewCase();
            cases.getCaseID();
            Common.assertTextOnPage(tool, "Created By: " + user.getRealm() + ":" + user.getLogin());
            Common.assertTextOnPage(tool, "Create Account Case");

            cases.clickNotesTab();
            cases.clickNewNote();
            cases.selectNoteType(noteType);
            cases.setNoteDescription(description);
            cases.saveNewCase();
            cases.clickViewListNote();
            Common.assertTextOnPage(tool, noteType);
            Common.assertTextOnPage(tool, description);

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
