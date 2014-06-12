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
public class ACA0040_View_NRC_history extends CSSTest {
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
    public void testACA0040_View_NRC_history() throws Exception {

        try {

            launchCSSApplication();
            String accountNumberWithNRC = preparation.readPropertyFromAccountPropertyFile("Invoice.RC");

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = myShapeChannel.loginToPOS(user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountID(accountNumberWithNRC);
            ViewInvoices viewInvocies = accountDetails.clickBillsAndPayments();
            ViewTransactionHistory viewTransactionHistory = viewInvocies.clickTransactionHistory();
            ViewNRCHistory viewNRCHistory = viewTransactionHistory.clickonNRCHistory();
            viewNRCHistory.enterToDateTodayFromDateMinus10();
            viewNRCHistory.clickSearch();
            Common.assertTextOnPage(tool, "NRC history found");
            viewNRCHistory.ViewNRCTermDetails();

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
