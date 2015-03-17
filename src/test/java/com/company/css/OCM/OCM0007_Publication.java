package com.company.css.OCM;

import com.company.css.OCM.LoginPage;
import com.company.css.OCM.OCMApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.framework.app.common.CSSTest;
import com.framework.app.common.Common;
import com.framework.app.common.Prep;
import com.company.data.apps.OCM;
import com.company.data.users.OCMPub;

public class OCM0007_Publication extends CSSTest {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new OCM();
        user = new OCMPub();
    }

    @Test
    public void testOCM0007_Publication() throws Exception {

        launchOCMApplicationAndGetBuildNumber();
        LoginPage loginPage = new LoginPage(tool, test, user);
        OCMApplication ocmApplication = loginPage.loginToOCM(user);

        ocmApplication.clickMenuNewPublication(application);

        tool.clickUsingXPath("(//input[@name='mainPanel:edit:fields:CatalogPublication'])[2]");
        tool.clickUsingXPath("(//input[@name='mainPanel:edit:fields:ContentPublication'])[2]");

        tool.clickUsingID("mainPanel:edit:buttons:publish");

        Common.assertTextOnPage(tool, "The publication request has been successfully created");

        test.setResult("pass");
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
