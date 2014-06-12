package com.comverse.css.bct;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.OCM.LoginPage;
import com.comverse.css.OCM.OCMApplication;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.OCM;
import com.comverse.data.users.OCMPub;

public class BCT007_Propagation extends CSSTest {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new OCM();
        user = new OCMPub();
    }

    @Test
    public void testBCT007_Propagation() throws Exception {
        launchOCMApplicationAndGetBuildNumber();
        LoginPage loginPage = new LoginPage(tool, test, user);
        OCMApplication oCMApplication = loginPage.loginToOCM(user);

        oCMApplication.clickMenuPublicationsManagePublications(application);
        oCMApplication.clickLatestPropagationResult();

        oCMApplication.getDateOfPropagationFromDetailsPage();

        assertEquals(oCMApplication.getTodaysDateInFormat("MMM d, yyyy"), oCMApplication.getDateOfPropagationFromDetailsPage());
        assertEquals("Succeeded", oCMApplication.getStatusOfPropagationFromDetailsPage());

        test.setResult("pass");
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
