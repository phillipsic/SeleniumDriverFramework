package com.comverse.sfa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.SFA;
import com.comverse.data.users.SALESUIUser;
import com.comverse.sfa.common.SFATest;

public class SFA002_Add_B2B_Lead extends SFATest {

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
    public void testSFA002_Add_B2B_Lead() throws Exception {
        try {

            launchSFAApplicationWithSSO();
            String orgName = Common.getOrganizationName();
            String b2bLeadName = "B2B Lead " + Common.generateTimeStamp();

            sfaHomePage homePage = new sfaHomePage(tool, test, user);
            sfaB2BLead b2bLead = homePage.clickNavigationB2BLead();

            // New B2B Lead
            b2bLead.clickNewB2BLead();
            b2bLead.setB2BLeadName(b2bLeadName);
            sfaOrganization organization = b2bLead.clickOrganization();
            b2bLead = organization.findAndSelectOrganizationForB2BLead(orgName);
            b2bLead.selectPriceList("IntCorp Standard B2B");
            b2bLead.saveB2BLead();

            // Add product to B2B Lead
            b2bLead.openProductList();
            sfaProduct product = b2bLead.addExistingProduct();
            b2bLead = product.selectProductForB2BLead("OneVoice Subscriber Bundle");
            b2bLead.saveB2BLead();

            // Search B2B Lead
            b2bLead = homePage.clickNavigationB2BLead();
            b2bLead.findAndOpenB2BLeadByName(b2bLeadName);

            Common.assertTextEquals(b2bLeadName, b2bLead.getB2BLeadName());
            Common.assertTextEquals("IntCorp Standard B2B", b2bLead.getPriceList());
            b2bLead.openProductList();
            Common.assertTextEquals("OneVoice Subscriber Bundle", b2bLead.getFirstProductName());

            Common.storeB2BLeadName("SFA_BCT_B2B_Lead", b2bLeadName, "BCT on " + application.getVersion() + ": Add B2B Lead");

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
