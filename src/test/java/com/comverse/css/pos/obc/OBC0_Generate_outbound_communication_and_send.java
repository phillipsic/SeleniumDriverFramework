package com.comverse.css.pos.obc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class OBC0_Generate_outbound_communication_and_send extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @Test
    public void testOBC0_Generate_outbound_communication_and_send() throws Exception {
        try {
            launchCSSApplication();

            String accountLastName = Common.getLastNameRechargableAccount();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

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

            Common.assertVerifyTrue(tool, outboundCommunication.getSendOBCMessage().matches("^[\\s\\S]*The outbound communication has been sent[\\s\\S]*$"));

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
