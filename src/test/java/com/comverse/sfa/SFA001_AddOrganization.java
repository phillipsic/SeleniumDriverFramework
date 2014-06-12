package com.comverse.sfa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.SFA;
import com.comverse.data.users.SALESUIUser;
import com.comverse.sfa.common.SFATest;

public class SFA001_AddOrganization extends SFATest {

    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new SFA();
        user = new SALESUIUser();
    }

    @Test
    public void testAddOrganization() throws Exception {

        try {
            launchSFAApplicationWithSSO();

            String timeStamp = Common.generateTimeStamp();
            String orgName = "Org" + timeStamp;
            String contactFN = "FN" + timeStamp;
            String contactLN = "LN" + timeStamp;

            sfaHomePage homePage = new sfaHomePage(tool, test, user);
            sfaOrganization organization = homePage.clickNavigationOrganization();

            // new organization
            organization.clickNewOrganization();
            organization.selectResellerId("Reseller 0");
            organization.setOrganizationName(orgName);
            organization.selectStatus("Active");
            organization.selectCustomerCategory("Prospect");
            organization.clickSaveOrganization();

            // Add Primary Contact
            String mainWindow = Common.getCurrentWindowHandle(tool);
            sfaContact contact = organization.clickNewContact(mainWindow);
            String contactWindow = Common.getCurrentWindowHandle(tool);
            contact.setFirstNameLastnameForContact(contactFN, contactLN, mainWindow, contactWindow);
            Common.switchToThisWindow(tool, contactWindow);
            contact.clickSaveContact();
            Common.switchToThisWindow(tool, mainWindow);
            organization.checkPrimaryContact();
            organization.clickSaveOrganization();

            // search organization
            organization = homePage.clickNavigationOrganization();
            organization.findOrganization(orgName);

            // check organization attributes
            assertTrue(organization.getOrganizationName().matches(orgName));
            assertEquals("Reseller 0", organization.getResellerId());
            assertEquals("Active", organization.getStatus());
            assertEquals("Prospect", organization.getCustomerCategory());

            Common.storeOrganizationName(orgName, "BCT on " + application.getVersion() + ": Add organization and primary contact");

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
