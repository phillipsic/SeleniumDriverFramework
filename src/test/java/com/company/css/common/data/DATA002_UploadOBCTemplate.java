package com.company.css.common.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.framework.common.AlreadyRunException;
import com.framework.app.common.CSSTest;
import com.framework.app.common.Common;
import com.framework.app.common.Prep;
import com.company.css.csr.AddOutboundCommunicationTemplate;
import com.company.css.csr.HomePageBackOffice;
import com.company.css.csr.InventoryAdministration;
import com.company.css.csr.OutboundCommunicationTemplate;
import com.company.data.apps.CSR;
import com.company.data.users.BOGAdmin;

public class DATA002_UploadOBCTemplate extends CSSTest {

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
    public void testDATA002_UploadOBCTemplate() throws Exception {

        try {
            launchCSSApplicationAndSSOLogin();

            HomePageBackOffice homePageBackOffice = new HomePageBackOffice(tool, test, user);
            InventoryAdministration inventoryAdministration = homePageBackOffice.clickBackOffice();
            OutboundCommunicationTemplate outboundCommunicationTemplate = inventoryAdministration.clickTemplateAdministration();

            // Need to search and confirm if the template already exists

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

            addOutboundCommunicationTemplate = outboundCommunicationTemplate.clickAdd();
            addOutboundCommunicationTemplate.selectTemplate("OBCData/Case-Case_Creation_Report-email-FR.jrxml");
            addOutboundCommunicationTemplate.selectLanguage("French (Standard)");
            addOutboundCommunicationTemplate.selectChannel("Email");
            addOutboundCommunicationTemplate.selectEventType("Order");
            addOutboundCommunicationTemplate.selectCaseType("Service Problem");
            addOutboundCommunicationTemplate.selectProblemArea("Service Out - Wired Services");
            addOutboundCommunicationTemplate.setDescription("For OBC");
            outboundCommunicationTemplate = addOutboundCommunicationTemplate.clickOK();

            Common.assertTextOnPage(tool, "Case-Case_Creation_Report-email.jrxml");
            Common.assertTextOnPage(tool, "Basket-Basket_Summary-print.jrxml");
            Common.assertTextOnPage(tool, "Case-Case_Creation_Report-email-FR.jrxml");

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
