package com.comverse.css.csr.nsa;

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

public class NSA0020_Review_existing_account extends CSSTest {
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
    public void testNSA0020_Review_existing_account() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();

            Common.generateTimeStamp();
            String accountLastname = Common.getLastNameOfPostPaidAccount();

            WorkSpace workSpace = new WorkSpace(tool, test, user);
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
