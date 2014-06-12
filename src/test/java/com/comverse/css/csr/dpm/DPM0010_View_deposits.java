package com.comverse.css.csr.dpm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.css.data.BAL.BAL_TelephonyItem;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class DPM0010_View_deposits extends CSSTest {
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
    public void testDPM0010_View_deposits() throws Exception {
        try {
            BAL_TelephonyItem bal_TelephonyItem = new BAL_TelephonyItem();
            launchCSSApplicationAndSSOLogin();
            String accountLastname = Common.getBCTLastName();

            WorkSpace workSpace = new WorkSpace(tool, test, user);
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

            addDepositReviewAndConfirm.clickConfirm();

            accountDeposits = addDepositReviewAndConfirm.clickOkToViewDeposits();
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