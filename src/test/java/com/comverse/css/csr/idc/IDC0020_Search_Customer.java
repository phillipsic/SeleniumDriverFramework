package com.comverse.css.csr.idc;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.IdentifyCustomer;
import com.comverse.css.csr.WorkSpace;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;


public class IDC0020_Search_Customer extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testIDC0020_Search_Customer() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCAResidentialUltraPostpaidCSR();

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();

            // Search by Billing account reference id
            identifyCustomer.gotoAccountDashboardUsingAccountID(workSpace.getAccount().getBillingAccountIDProperty());
            Common.assertTextOnPage(tool, workSpace.getAccount().getBillingAccountIDProperty());
            identifyCustomer.clickHome();
            identifyCustomer.gotoManageAccount();

            // Search by First name
            identifyCustomer.searchByAccountFirstNameMultiplePersons(workSpace.getAccount().getBillingFirstNameProperty());
            Common.assertTextOnPage(tool, workSpace.getAccount().getBillingFirstNameProperty());
            identifyCustomer.clickHome();
            identifyCustomer.gotoManageAccount();

            // Search by Last name
            identifyCustomer.searchByAccountLastNameMultiplePersons(workSpace.getAccount().getBillingLastNameProperty());
            Common.assertTextOnPage(tool, workSpace.getAccount().getBillingLastNameProperty());
            identifyCustomer.clickHome();
            identifyCustomer.gotoManageAccount();

            // Search by Company name
            identifyCustomer.searchByCompanyNameMultiplePersons("*");
            Common.assertTextOnPage(tool, "customers found");

            test.setResult("pass");

        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            // e.printStackTrace();
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
