package com.comverse.css.csr.ofu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.AccountDetails;
import com.comverse.css.csr.IdentifyCustomer;
import com.comverse.css.csr.RequestsForCustomer;
import com.comverse.css.csr.WorkSpace;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class OFU0010_Search_orders extends CSSTest {
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
    public void testOFU0010_Search_orders() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String accountLastName = Common.getBCTLastName();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastName);
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();

            requestsForCustomer.clickSearch();
            Common.assertTextOnPage(tool, "Submitted On");
            Common.assertTextOnPage(tool, "Submitter");
            Common.assertTextOnPage(tool, "Customer");
            Common.assertTextOnPage(tool, "Request Type");
            Common.assertTextOnPage(tool, "Impacted item");
            Common.assertTextOnPage(tool, "Request Object");
            Common.assertTextOnPage(tool, "Status");
            Common.assertTextOnPage(tool, "Modified On");
            Common.assertTextOnPage(tool, "Order Ref.");

            Common.assertTextOnPage(tool, "Create order");
            Common.assertTextOnPage(tool, accountLastName);

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
