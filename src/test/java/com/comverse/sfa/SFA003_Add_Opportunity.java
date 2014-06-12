package com.comverse.sfa;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.SFA;
import com.comverse.data.users.SALESUIUser;
import com.comverse.sfa.common.SFATest;

public class SFA003_Add_Opportunity extends SFATest {

    private StringBuffer verificationErrors = new StringBuffer();
    Prep preparation;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new SFA();
        user = new SALESUIUser();
    }

    @Test
    public void testSFA003_Add_Opportunity() throws Exception {
        try {
            launchSFAApplicationWithSSO();
            String orgName = Common.getOrganizationName();
            String opportunityName = "Opportunity " + Common.generateTimeStamp();

            sfaHomePage homePage = new sfaHomePage(tool, test, user);
            sfaOpportunity opportunity = homePage.clickNavigationOpportunity();

            // New Opportunity
            opportunity.clickNewOpportunity();
            opportunity.setOpportunityName(opportunityName);
            opportunity.selectSalesProcess("Standard Sale");
            opportunity.selectPriority("High");
            sfaOrganization organization = opportunity.clickOrganization();
            opportunity = organization.findAndSelectOrganizationForOpportunity(orgName);
            opportunity.selectCurrency("United States/Dollar");
            opportunity.selectPriceList("IntCorp Standard B2B");
            opportunity.saveOpportunity();

            // Add Product to Opportunity
            opportunity.openProductList();
            sfaProduct product = opportunity.addExistingProduct();
            opportunity = product.selectProductForOpportunity("OneVoice Subscriber Bundle");
            opportunity.saveOpportunity();

            // Search Opportunity
            opportunity = homePage.clickNavigationOpportunity();
            opportunity.findAndOpenOpportunityByName(opportunityName);

            assertEquals(opportunityName, opportunity.getOpportunityName());
            assertEquals("IntCorp Standard B2B", opportunity.getPriceList());
            opportunity.openSalesProcess();
            assertEquals("Qualified", opportunity.getCurrentSalesStage());
            assertEquals("Confirm Customer Needs and Timelines", opportunity.getFirstTaskName());
            opportunity.openProductList();
            assertEquals("OneVoice Subscriber Bundle", opportunity.getFirstProductName());

            Common.storeOpportunityName("SFA_BCT_Opportunity", opportunityName, "BCT on " + application.getVersion() + ": Add Opporunity");

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