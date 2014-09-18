package com.comverse.css.b2b.bam;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2b.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2B;
import com.comverse.data.users.B2BAdmin;

public class BAM0020_Modify_billing_contact extends CSSTest {

    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2B();
        user = new B2BAdmin();
    }

    @Test
    public void testBAM0020_Modify_billing_contact() throws Exception {

        try {
            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();

            MyshapeBusiness myshapeBusiness = new MyshapeBusiness(tool, test, user);

            WorkSpace workSpace = myshapeBusiness.loginToB2B(user);

            AccountDetails accountDetails = workSpace.clickAccount();

            ModifyContactInformation modifyContactInformation = accountDetails.clickModifyBillingContact();

            modifyContactInformation.enterFirstName("fn" + uniqueTimeStamp);
            modifyContactInformation.enterLastName("ln" + uniqueTimeStamp);
            modifyContactInformation.enterEmail("email-" + uniqueTimeStamp + "@email.com");
            modifyContactInformation.enterPhoneNumber("pn" + uniqueTimeStamp);
            modifyContactInformation.enterFaxNumber("fxn" + uniqueTimeStamp);
            modifyContactInformation.enterCountry("United States");
            modifyContactInformation.enterState("Florida");
            modifyContactInformation.enterPostCode("pc" + uniqueTimeStamp);
            modifyContactInformation.enterCity("ct" + uniqueTimeStamp);
            modifyContactInformation.enterAddressLineOne("ad1-" + uniqueTimeStamp);

            ModifyContactInformationConfirmation modifyContactInformationConfirmation = modifyContactInformation.clickOk();

            test.setBugId("CBS00169186");
            RequestSubmission requestSubmission = modifyContactInformationConfirmation.clickOk();
            test.setBugId("NoBug");
            accountDetails = requestSubmission.clickOkModifyRequestGoTOAccountDashboard();

            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilBizFirstRequestCompletedOrFailed();

            accountDetails = requestsForCustomer.clickAccounts();

            modifyContactInformation = accountDetails.clickModifyBillingContact();
            Common.assertTextEquals("fn" + uniqueTimeStamp, modifyContactInformation.getFirstName());
            Common.assertTextEquals("ln" + uniqueTimeStamp, modifyContactInformation.getLastName());
            Common.assertTextEquals("email-" + uniqueTimeStamp + "@email.com", modifyContactInformation.getEmail());
            Common.assertTextEquals("pn" + uniqueTimeStamp, modifyContactInformation.getPhoneNumber());
            Common.assertTextEquals("fxn" + uniqueTimeStamp, modifyContactInformation.getFaxNumber());
            Common.assertTextEquals("Florida", modifyContactInformation.getState());
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
