package com.comverse.css.csr.puk;

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

public class PUK0010_Get_PUK extends CSSTest {
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
    public void testPUK0010_Get_PUK() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();

            String accountLastname = Common.getLastNameOfPostPaidAccount();

            WorkSpace workSpace = new WorkSpace(tool, test, user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastname);
            String accountNumber = accountDetails.getAccountNumber();
            preparation.enablePUK(accountNumber);
            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            subscriberDashboard.clickRefreshThisSubscriber();
            UnlockPINWithPUK puk = subscriberDashboard.clickGetPUK();
            Common.assertTextOnPage(tool, "007");
            puk.clickOK();

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
