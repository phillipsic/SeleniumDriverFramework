/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.sfa;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.ADMIN;
import com.comverse.data.users.SALESUIUser;
import com.comverse.sfa.common.SFATest;

public class SFA004_Import_B2C_Lead extends SFATest {

    private StringBuffer verificationErrors = new StringBuffer();
    Prep preparation;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new ADMIN();
        user = new SALESUIUser();
    }

    @Test
    public void testImportB2CLead() throws Exception {

        try {
            launchAdminUIWithSSO();

            uploadLeadFileToCrmManaged("SFAData/SFA004_new_prospect_lead.csv");
            String b2cLeadName = "SFA004 Prospect Lead"; // Lead name is defined
                                                         // in import lead file

            sfaHomePage homePage = new sfaHomePage(tool, test, user);
            sfaAdminJobList jobList = homePage.clickNavigationJobList();

            // Create New Job
            jobList.clickNewJob();
            String jobName = "Import B2C Lead";
            jobList.setJobName(jobName);
            jobList.selectJobType("ImportJob");
            jobList.selectImportMap("cone_lead_import_map");
            jobList.selectFileEncoding("UTF8");
            jobList.setImportFile("SFA004_new_prospect_lead.csv");
            jobList.setRejectDir("reject");
            jobList.selectFileHasHeader();
            jobList.saveJob();

            // Run the import job
            jobList.selectJobByName(jobName);
            jobList.runJob();
            jobList.refreshJobList();

            // Delete the import job after run
            jobList.selectJobByName(jobName);
            jobList.deleteJob();

            // Access Sales UI
            launchSFAApplicationWithExistingSSOSession();
            homePage = new sfaHomePage(tool, test, user);
            sfaB2CLead b2cLead = homePage.clickNavigationB2CLead();
            b2cLead.findAndOpenB2CLeadByNameAndCreatedDate(b2cLeadName, "Today");

            assertEquals(b2cLeadName, b2cLead.getB2CLeadName());
            assertEquals("VIP New Customer", b2cLead.getB2CLeadType());
            assertEquals("1", b2cLead.getNewProspectFlag());
            assertEquals("Low", b2cLead.getPriority());
            assertEquals("Qualified", b2cLead.getStatus());
            b2cLead.openOfferList();
            assertEquals("125", b2cLead.getFirstOfferId());
            assertEquals("Basic Black Voice", b2cLead.getFirstOfferName());

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
