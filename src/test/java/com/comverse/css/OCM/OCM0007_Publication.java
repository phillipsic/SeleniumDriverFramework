package com.comverse.css.OCM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.OCM;
import com.comverse.data.users.OCMPub;

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

        tool.clickUsingXPath(tool, "(//input[@name='mainPanel:edit:fields:CatalogPublication'])[2]");
        tool.clickUsingXPath(tool, "(//input[@name='mainPanel:edit:fields:ContentPublication'])[2]");

        tool.driver.findElement(By.id("mainPanel:edit:buttons:publish")).click();

        Common.assertTextOnPage(tool, "The publication request has been successfully created");

        test.setResult("pass");
    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
