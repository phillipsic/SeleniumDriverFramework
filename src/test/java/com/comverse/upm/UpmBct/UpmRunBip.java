package com.comverse.upm.UpmBct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.UPM;
import com.comverse.data.users.SECAdmin;
import com.comverse.upm.common.UPMTest;
import com.comverse.upm.upmPages.UpmHomePage;
import com.comverse.upm.upmPages.UpmLoginPage;
import com.comverse.upm.upmPages.UpmProcessPage;

public class UpmRunBip extends UPMTest {

    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new UPM();
        user = new SECAdmin();
    }

    @Test
    public void testUPMRunBip() throws Exception {
        try {

            launchUPMApplication();
            UpmLoginPage upmLoginPage = new UpmLoginPage(tool, test, user);
            UpmHomePage upmHomePage = upmLoginPage.successfulsecAdminLogin();
            UpmProcessPage upmProcessPage = upmHomePage.clickProcess();
            upmProcessPage.clickWorkflow();
            upmProcessPage.selectWorkflowType("CBS Batch Process");
            upmProcessPage.clickCreateTemplate();
            upmProcessPage.enterTemplateName("Selenium_Auto_BIP");
            upmProcessPage.enterTemplateDescription("For Cust1");
            upmProcessPage.selectProcess("BIP");

            upmProcessPage.selectNodeType("billing:app");
            upmProcessPage.selectQuery("AccountNumber");
            upmProcessPage.enterQueryValue("9414");
            upmProcessPage.enterTaskName("bip001");
            upmProcessPage.selectTaskMode("Production");
            upmProcessPage.selectServerId("CUST2");
            upmProcessPage.clickRun();
            Common.assertTextOnPage(tool, "Job Created Successfully. Job ID:");

            // //Go to History tab and click Refresh until last created workflow
            // is Completed
            upmProcessPage.clickCancel();
            upmProcessPage.clickHistory();
            upmProcessPage.selectWorkflowType("CBS Batch Process");

            // upmProcessPage.getWorkflowState();
            // //If does not complete in default # of iterations, test will fail
            // Validate.validateLastWorkflowCompleted(DefaultStateCheckIterations);
            //
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
