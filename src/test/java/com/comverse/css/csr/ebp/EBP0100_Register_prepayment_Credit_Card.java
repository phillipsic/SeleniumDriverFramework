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
import com.comverse.data.users.CSRAdmin;

public class EBP0100_Register_prepayment_Credit_Card extends CSSTest {
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
    public void testEBP0100_Register_prepayment_Credit_Card() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String personLastName = Common.getPersonLastName();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();

            AccountDetails accountDetails = manageAccount.searchByAccountLastNameSinglePerson(personLastName);

            RegisterPrepayment registerPrepayment = accountDetails.clickRegisterPrepayment();
            registerPrepayment.enterAmount("11");
            registerPrepayment.selectPaymentMethod("PAYMENT_TYPE_NEW_PROFILE-CREDIT_CARD");

            registerPrepayment.clickContinue();
            Common.assertTextOnPage(tool, "11");

            registerPrepayment.enterCardNumber("4111111111111111");
            registerPrepayment.enterCardExpDate("12/2017");
            registerPrepayment.enterCardHolderLastName("LN");
            registerPrepayment.enterCardHolderFirstName("FN");
            registerPrepayment.enterCardSecretCode("123");
            registerPrepayment.enterZipPostalCode("12345678");

            RegisterPrepaymentConfirm registerPrepaymentConfirm = registerPrepayment.clickConfirm();
            Common.assertTextOnPage(tool, "Prepayment has been successfully registered.");
            Common.assertTextOnPage(tool, "11.00");
            Common.assertTextOnPage(tool, "Credit Card");

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
