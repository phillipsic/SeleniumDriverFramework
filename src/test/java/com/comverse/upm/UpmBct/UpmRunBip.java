package com.comverse.upm.UpmBct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
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
            // processPage.selectTemplateWorkflowType(workflowType);
            // //Check whether Auto_BIP template exists; if not create by
            // invoking createJnlTemplate class
            // templateExists=Utils.checkTemplate(templateName);
            //
            // //Proceed to create new template only if it does not already
            // exist
            // if (!(templateExists))
            // {
            // if (accountNo == null) {accountNo="100";}
            //
            // Utils.upm_create_template(templateName,moduleName,nodeType,serverId);
            // }
            //
            // //Run template
            // Utils.runTemplate(templateName,accountNo);
            
            //Job Created Successfully. Job ID:1601:WPDS. then click Cancel. 
            //
            // //Go to History tab and click Refresh until last created workflow
            // is Completed
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
