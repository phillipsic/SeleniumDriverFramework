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

public class EBP0100_Register_prepayment extends CSSTest {
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
    public void testEBP0100_Register_prepayment() throws Exception {
        try {
            launchCSSApplication();
            String accountLastName = Common.getLastNameOfPostPaidAccount();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();

            CustomerSearchResult customerSearch = manageAccount.searchByAccountLastNameMultiplePersons(accountLastName);

            AccountDetails accountDetails = customerSearch.clickFirstAccountLink();

            RegisterPrepayment registerPrepayment = accountDetails.clickRegisterPrepayment();
            registerPrepayment.enterAmount("11");
            registerPrepayment.selectPaymentMethod("PAYMENT_TYPE_NO_PROFILE-CASH");

            registerPrepayment.clickContinue();
            Common.assertTextOnPage(tool, "11");

            RegisterPrepaymentConfirm registerPrepaymentConfirm = registerPrepayment.clickConfirm();
            Common.assertTextOnPage(tool, "Prepayment has been successfully registered.");
            Common.assertTextOnPage(tool, "11.00");
            Common.assertTextOnPage(tool, "Cash");

            accountDetails = registerPrepaymentConfirm.clickBackToAccount();

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