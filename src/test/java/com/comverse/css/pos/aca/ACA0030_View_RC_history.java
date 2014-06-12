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
public class ACA0030_View_RC_history extends CSSTest {
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
    public void testACA0030_View_RC_history() throws Exception {

        try {
            launchCSSApplication();
            String accountNumberWithRC = preparation.readPropertyFromAccountPropertyFile("Invoice.RC");

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = myShapeChannel.loginToPOS(user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountID(accountNumberWithRC);
            ViewInvoices viewInvocies = accountDetails.clickBillsAndPayments();
            ViewTransactionHistory viewTransactionHistory = viewInvocies.clickTransactionHistory();
            ViewRCHistory viewRCHistory = viewTransactionHistory.clickonRCHistory();
            viewRCHistory.enterToDateTodayFromDateMinus10();
            viewRCHistory.clickSearch();
            Common.assertTextOnPage(tool, "RC history found");
            viewRCHistory.ViewRCTermDetails();

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
