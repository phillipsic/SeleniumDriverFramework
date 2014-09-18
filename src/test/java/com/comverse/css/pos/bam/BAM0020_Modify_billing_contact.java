package com.comverse.css.pos.bam;

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

public class BAM0020_Modify_billing_contact extends CSSTest {

    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @Test
    public void testBAM0020_Modify_billing_contact() throws Exception {

        try {
            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();
            String accountLastName = Common.getLastNameOfPostPaidAccount();
            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);

            WorkSpace workSpace = myShapeChannel.loginToPOS(user);

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();

            CustomerSearchResult customerSearch = manageAccount.searchByAccountLastNameMultiplePersons(accountLastName);

            AccountDetails accountDetails = customerSearch.clickFirstAccountLink();

            ModifyContactInformation modifyContactInformation = accountDetails.clickModifyBillingContact();

            modifyContactInformation.enterFirstName("fn" + uniqueTimeStamp);
            // modifyContactInformation.enterLastName("ln" + uniqueTimeStamp);
            modifyContactInformation.enterEmail("email-" + uniqueTimeStamp + "@email.com");
            modifyContactInformation.enterPhoneNumber("pn" + uniqueTimeStamp);
            modifyContactInformation.enterFaxNumber("fxn" + uniqueTimeStamp);
            modifyContactInformation.enterPostCode("pc" + uniqueTimeStamp);
            modifyContactInformation.enterCity("ct" + uniqueTimeStamp);
            modifyContactInformation.enterAddressLineOne("ad1-" + uniqueTimeStamp);

            ModifyContactInformationConfirmation modifyContactInformationConfirmation = modifyContactInformation.clickOk();

            test.setBugId("CBS00169186");
            RequestSubmission requestSubmission = modifyContactInformationConfirmation.clickOk();
            test.setBugId("NoBug");

            accountDetails = requestSubmission.clickOkModifyRequestGoTOAccountDashboard();
            accountDetails.clickRefreshThisAccount();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();

            accountDetails = requestsForCustomer.clickAccounts();
            accountDetails.clickRefreshThisAccount();
            modifyContactInformation = accountDetails.clickModifyBillingContact();
            Common.assertTextEquals("fn" + uniqueTimeStamp, modifyContactInformation.getFirstName());
            // Common.assertTextEquals("ln" + uniqueTimeStamp,
            // modifyContactInformation.getLastName());
            Common.assertTextEquals("email-" + uniqueTimeStamp + "@email.com", modifyContactInformation.getEmail());
            Common.assertTextEquals("pn" + uniqueTimeStamp, modifyContactInformation.getPhoneNumber());
            Common.assertTextEquals("fxn" + uniqueTimeStamp, modifyContactInformation.getFaxNumber());
            Common.assertTextEquals("pc" + uniqueTimeStamp, modifyContactInformation.getZipCode());
            Common.assertTextEquals("ct" + uniqueTimeStamp, modifyContactInformation.getCity());
            Common.assertTextEquals("ad1-" + uniqueTimeStamp, modifyContactInformation.getAddressLineOne());

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
