package com.comverse.css.pos.idc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.IdentifyCustomer;
import com.comverse.css.pos.MyShapeChannel;
import com.comverse.css.pos.WorkSpace;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class IDC0020_Search_Customer extends CSSTest {
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
    public void testIDC0020_Search_Customer() throws Exception {

        try {
            launchCSSApplication();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            workSpace.doResitdentialNCAResidentialUltraPostpaidPOS();

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();

            // Search by First name
            identifyCustomer.searchByAccountFirstNameMultiplePersons(workSpace.getAccount().getBillingFirstNameProperty());
            Common.assertTextOnPage(tool, workSpace.getAccount().getBillingFirstNameProperty());
            String accountId = identifyCustomer.getAccountId(workSpace.getAccount().getBillingFirstNameProperty());
            workSpace.getAccount().setBillingAccountIDProperty(accountId);
            identifyCustomer.clickHome();
            identifyCustomer.gotoManageAccount();

            // Search by Billing account reference id
            identifyCustomer.gotoAccountDashboardUsingAccountID(workSpace.getAccount().getBillingAccountIDProperty());
            Common.assertTextOnPage(tool, workSpace.getAccount().getBillingAccountIDProperty());
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