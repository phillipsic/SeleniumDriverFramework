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

public class CaseUI004_TaskNote extends CaseUITest {

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
    public void testCaseUI004_TaskNote() throws Exception {

        try {
            launchCaseUIApplicationWithSSO();
            String noteType = "Resolution";
            String taskName = "CaseUI004_Task";
            String description = "testCaseUI004_TaskNote";

            CaseUIHomePage homePage = new CaseUIHomePage(tool, test, user);

            homePage.clickActivities();
            homePage.clickTasks();
            CaseUITasks tasks = new CaseUITasks(tool, test, user);
            tasks.clickNewTask();
            tasks.setTaskName(taskName);
            tasks.setTaskDescription(description);
            tasks.saveNewTask();
            Common.assertTextOnPage(tool, "Created By: " + user.getRealm() + ":" + user.getLogin());
            tasks.clickNotesTab();
            tasks.clickNewNote();
            tasks.selectNoteType(noteType);
            tasks.setNoteDescription(description);
            tasks.saveNewTask();
            tasks.clickViewListNote();
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
