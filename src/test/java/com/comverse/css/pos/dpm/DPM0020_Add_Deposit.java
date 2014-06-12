package com.comverse.css.pos.dpm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.BAL.BAL_DefaultForRTB;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class DPM0020_Add_Deposit extends CSSTest {
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
    public void testDPM0020_Add_Deposit() throws Exception {
        try {
            BAL_DefaultForRTB bal_DefaultForRTB = new BAL_DefaultForRTB();
            launchCSSApplication();
            String accountLastname = Common.getBCTLastName();

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = myShapeChannel.loginToPOS(user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();

            AccountDetails accountDashboard = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastname);

            Common.assertTextOnPage(tool, "Status: New");

            AddDeposit addDeposit = accountDashboard.clickAddDeposit();
            addDeposit.setDepositType("General Deposit");
            addDeposit.setBalance(bal_DefaultForRTB.getBalanceName());
            addDeposit.setDepositAmount("10");
            addDeposit.selectPaymentMethod();
            AddDepositReviewAndConfirm addDepositReviewAndConfirm = addDeposit.clickContinue();

            addDepositReviewAndConfirm.clickConfirm();

            Common.assertTextOnPage(tool, "Deposit type: General Deposit");
            Common.assertTextOnPage(tool, "Balance: " + bal_DefaultForRTB.getBalanceName());
            Common.assertTextOnPage(tool, "Deposit amount: $ 10.00");
            Common.assertTextOnPage(tool, "Payment method: Cash");
            accountDashboard = addDepositReviewAndConfirm.clickOk();

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