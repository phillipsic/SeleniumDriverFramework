package com.comverse.css.pos.nsa;

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

public class NSA0020_Review_existing_account extends CSSTest {
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
    public void testNSA0020_Review_existing_account() throws Exception {

        try {
            launchCSSApplication();

            Common.generateTimeStamp();
            String accountLastname = Common.getLastNameOfPostPaidAccount();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails AccountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastname);

            AccountDetails.getAccountNumber();
            CustomerAcquisitionCustomerDataReview customerAcquisitionCustomerDataReview = AccountDetails.clickNewConvergentSubscriberOnExistingAccount();

            Common.assertTextOnPage(tool, "Please review the following customer data is correct");
            UpdateAccountContactInformations updateAccountContactInformations = customerAcquisitionCustomerDataReview.clickEditCustomerIdentityAndContact();

            Common.assertTextEquals((accountLastname), updateAccountContactInformations.getLastName());

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
