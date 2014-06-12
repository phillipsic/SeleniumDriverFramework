package com.comverse.css.pos.aca;

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

/**
 * 
 * @author Vikram Sharma
 */
public class ACA0020_View_MTR_history extends CSSTest {
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
    public void testACA0020_View_MTR_history() throws Exception {

        try {
            launchCSSApplication();

            String accountNumberWithMTR = preparation.readPropertyFromAccountPropertyFile("Invoice.MTR");

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = myShapeChannel.loginToPOS(user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountID(accountNumberWithMTR);
            ViewInvoices viewInvocies = accountDetails.clickBillsAndPayments();
            ViewTransactionHistory viewTransactionHistory = viewInvocies.clickTransactionHistory();
            ViewMTRHistory viewMTRHistory = viewTransactionHistory.clickonMTRHistory();
            viewMTRHistory.enterToDateTodayFromDateMinus10();
            viewMTRHistory.clickSearch();
            Common.assertTextOnPage(tool, "MTR history found");
            viewMTRHistory.ViewMTRDetails();
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
