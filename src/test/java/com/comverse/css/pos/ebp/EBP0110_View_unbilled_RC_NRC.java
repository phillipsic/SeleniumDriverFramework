package com.comverse.css.pos.ebp;

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

public class EBP0110_View_unbilled_RC_NRC extends CSSTest {
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
    public void testEBP0110_View_unbilled_RC_NRC() throws Exception {

        try {
            launchCSSApplication();

            String accountNumber = preparation.readPropertyFromAccountPropertyFile("Unbilled.RC_NRC");

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails AccountDetails = manageAccount.gotoAccountDashboardUsingAccountID(accountNumber);
            ViewInvoices viewInvoices = AccountDetails.clickBillsAndPayments();
            UnbilledTransaction unbilledTransaction = viewInvoices.clickUnbilledTransacations();
            ViewUnbilledRCNRC viewUnbilledRCNRC = unbilledTransaction.clickUnbilledRCNRC();

            Common.assertTextOnPage(tool, "Unbilled RC/NRC terms");
            Common.assertTextOnPage(tool, "Non recurring charges for this account:");
            Common.assertTextOnPage(tool, "Recurring charges for this account:");

            ViewUnbilledRCTermDetails viewUnbilledRCTermDetails = viewUnbilledRCNRC.clickFirstRCTerm();
            Common.assertTextOnPage(tool, "Unbilled RC term details");
            Common.assertTextOnPage(tool, "Impacted Balances");
            viewUnbilledRCNRC = viewUnbilledRCTermDetails.clickBack();

            viewUnbilledRCNRC.clickFirstNRCTerm();
            Common.assertTextOnPage(tool, "Unbilled NRC term details");
            Common.assertTextOnPage(tool, "Impacted Balances");
            viewUnbilledRCNRC = viewUnbilledRCTermDetails.clickBack();

            unbilledTransaction = viewUnbilledRCNRC.clickBack();
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