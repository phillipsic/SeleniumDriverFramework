package com.comverse.css.pos.dpm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.BAL.BAL_TelephonyItem;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class DPM0010_View_deposits extends CSSTest {

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
    public void testDPM0010_View_deposits() throws Exception {
        try {
            BAL_TelephonyItem bal_TelephonyItem = new BAL_TelephonyItem();
            launchCSSApplication();
            String accountLastname = Common.getBCTLastName();

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = myShapeChannel.loginToPOS(user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();

            AccountDetails accountDashboard = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastname);

            Common.assertTextOnPage(tool, "Status: New");

            AccountDeposits accountDeposits = accountDashboard.clickViewDeposits();

            AddDeposit addDeposit = accountDeposits.clickAdd();

            addDeposit.setDepositType("Billable Deposit");
            addDeposit.setBalance(bal_TelephonyItem.getBalanceName());
            addDeposit.setDepositAmount("5");
            addDeposit.selectPaymentMethod();
            AddDepositReviewAndConfirm addDepositReviewAndConfirm = addDeposit.clickContinue();
            String dateReveived = addDepositReviewAndConfirm.getDateReveived();
            addDepositReviewAndConfirm.clickConfirm();

           // Common.assertTextOnPage(tool, dateReveived);
            //Grab date and time to check later.
            accountDeposits = addDepositReviewAndConfirm.clickOkToViewDeposits();
            Common.assertTextOnPage(tool, dateReveived);
            Common.assertTextOnPage(tool, "5");
            Common.assertTextOnPage(tool, bal_TelephonyItem.getBalanceName());
            Common.assertTextOnPage(tool, "Billable Deposit");
            accountDashboard = accountDeposits.clickBack();

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
