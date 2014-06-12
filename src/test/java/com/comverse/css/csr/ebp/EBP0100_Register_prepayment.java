package com.comverse.css.csr.ebp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRUser;

public class EBP0100_Register_prepayment extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRUser();
    }

    @Test
    public void testEBP0100_Register_prepayment() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String personLastName = Common.getPersonLastName();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();

            AccountDetails accountDetails = manageAccount.searchByAccountLastNameSinglePerson(personLastName);

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
