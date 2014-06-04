package com.comverse.css.bct;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class BCT006_Send_outbound_communication_for_a_account_CSR extends CSSTest {

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testBCT006_Send_outbound_communication_for_a_account_CSR() throws Exception {
        launchCSSApplicationAndSSOLogin();
        String accountLastName = Common.getLastNameRechargableAccount();
        WorkSpace workSpace = new WorkSpace(driver);

        IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
        AccountDetails accountDetails = manageAccount.searchByAccountLastNameSinglePerson(accountLastName);
        accountDetails.clickRefreshThisAccount();
        SendCommunication sendCommunication = accountDetails.clickSendOutBoundCommunication();

        sendCommunication.selectTemplateEventType("Order");
        sendCommunication.selectTemplateCaseType("Service Problem");
        sendCommunication.selectTemplateProblemArea("Service Out - Wired Services");
        sendCommunication.clickSearchTemplate();

        sendCommunication.selectAvailableCommunicationChannel("Email");
        sendCommunication.selectTemplateName("Case-Case_Creation_Report-email.jrxml");
        sendCommunication.clickContinue();

        sendCommunication.enterEmailTo("email@email.com");

        OutboundCommunication outboundCommunication = sendCommunication.clickSendCommunication();
        assertTrue(outboundCommunication.getSendOBCMessage().matches("^[\\s\\S]*The outbound communication has been sent[\\s\\S]*$"));

        test.setResult("pass");
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
