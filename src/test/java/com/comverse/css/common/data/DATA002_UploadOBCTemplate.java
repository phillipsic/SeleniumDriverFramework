package com.comverse.css.common.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.AddOutboundCommunicationTemplate;
import com.comverse.css.csr.HomePageBackOffice;
import com.comverse.css.csr.InventoryAdministration;
import com.comverse.css.csr.OutboundCommunicationTemplate;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.BOGAdmin;

public class BO0002_UploadOBCTemplate extends CSSTest {

    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new BOGAdmin();
    }

    @Test
    public void testBO0002_UploadOBCTemplate() throws Exception {

        try {
            launchCSSApplicationAndSSOLogin();

            HomePageBackOffice homePageBackOffice = new HomePageBackOffice(tool, test, user);
            InventoryAdministration inventoryAdministration = homePageBackOffice.clickBackOffice();
            OutboundCommunicationTemplate outboundCommunicationTemplate = inventoryAdministration.clickTemplateAdministration();

            // Add code here to search and confirm if the template already
            // exists
            outboundCommunicationTemplate.doAddTemplates();

            AddOutboundCommunicationTemplate addOutboundCommunicationTemplate = outboundCommunicationTemplate.clickAdd();

            addOutboundCommunicationTemplate.selectTemplate("OBCData/Case-Case_Creation_Report-email.jrxml");
            addOutboundCommunicationTemplate.selectLanguage("English");
            addOutboundCommunicationTemplate.selectChannel("Email");
            addOutboundCommunicationTemplate.selectEventType("Order");
            addOutboundCommunicationTemplate.selectCaseType("Service Problem");
            addOutboundCommunicationTemplate.selectProblemArea("Service Out - Wired Services");
            addOutboundCommunicationTemplate.setDescription("For BCT006");
            outboundCommunicationTemplate = addOutboundCommunicationTemplate.clickOK();

            outboundCommunicationTemplate.clickBack();

            addOutboundCommunicationTemplate = outboundCommunicationTemplate.clickAdd();

            addOutboundCommunicationTemplate.selectTemplate("OBCData/Basket-Basket_Summary-print.jrxml");
            addOutboundCommunicationTemplate.selectLanguage("English");
            addOutboundCommunicationTemplate.selectChannel("Printed Mail");
            addOutboundCommunicationTemplate.selectEventType("Order");
            addOutboundCommunicationTemplate.selectCaseType("Service Problem");
            addOutboundCommunicationTemplate.selectProblemArea("Service Out - Wired Services");
            addOutboundCommunicationTemplate.setDescription("For OBC0_Generate_outbound_communication_and_send");
            outboundCommunicationTemplate = addOutboundCommunicationTemplate.clickOK();

            outboundCommunicationTemplate.clickBack();

            addOutboundCommunicationTemplate.selectTemplate("OBCData/Case-Case_Creation_Report-email-FR.jrxml");
            addOutboundCommunicationTemplate.selectLanguage("French (Standard)");
            addOutboundCommunicationTemplate.selectChannel("Email");
            addOutboundCommunicationTemplate.selectEventType("Order");
            addOutboundCommunicationTemplate.selectCaseType("Service Problem");
            addOutboundCommunicationTemplate.selectProblemArea("Service Out - Wired Services");
            addOutboundCommunicationTemplate.setDescription("For OBC");
            outboundCommunicationTemplate = addOutboundCommunicationTemplate.clickOK();

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
