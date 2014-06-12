package com.comverse.css.csr.obc;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class OBC0_Generate_outbound_communication_and_send extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testOBC0_Generate_outbound_communication_and_send() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            WorkSpace workSpace = new WorkSpace(tool, test, user);
            String accountLastName = Common.getLastNameRechargableAccount();

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.searchByAccountLastNameSinglePerson(accountLastName);
            // accountDetails.clickRefreshThisAccount();
            SendCommunication sendCommunication = accountDetails.clickSendOutBoundCommunication();

            sendCommunication.selectTemplateEventType("Order");
            sendCommunication.selectTemplateCaseType("Service Problem");
            sendCommunication.selectTemplateProblemArea("Service Out - Wired Services");
            sendCommunication.clickSearchTemplate();

            sendCommunication.selectAvailableCommunicationChannel("Printed Mail");
            sendCommunication.selectTemplateName("Basket-Basket_Summary-print.jrxml");

            sendCommunication.selectMessageFormat("html");
            sendCommunication.clickReviewCommunication();
            sendCommunication.clickClosePopUp();

            sendCommunication.selectMessageFormat("txt");
            sendCommunication.clickReviewCommunication();
            sendCommunication.clickClosePopUp();

            sendCommunication.selectMessageFormat("pdf");
            sendCommunication.clickContinue();

            OutboundCommunication outboundCommunication = sendCommunication.clickSendCommunication();
            assertTrue(outboundCommunication.getSendOBCMessage().matches("^[\\s\\S]*The outbound communication has been sent[\\s\\S]*$"));

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
