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
import com.comverse.data.users.TelcoRetailerUser;

public class EBP0100_Register_prepayment_Credit_Card extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerUser();
    }

    @Test
    public void testEBP0100_Register_prepayment() throws Exception {
        try {
            launchCSSApplication();
            String accountLastName = Common.getLastNameOfPostPaidAccount();
            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);

            WorkSpace workSpace = myShapeChannel.loginToPOS(user);

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();

            CustomerSearchResult customerSearch = manageAccount.searchByAccountLastNameMultiplePersons(accountLastName);

            AccountDetails accountDetails = customerSearch.clickFirstAccountLink();

            RegisterPrepayment registerPrepayment = accountDetails.clickRegisterPrepayment();
            registerPrepayment.enterAmount("11");
            registerPrepayment.selectPaymentMethod("PAYMENT_TYPE_NEW_PROFILE-CREDIT_CARD");

            registerPrepayment.clickContinue();
            Common.assertTextOnPage(tool, "11");

            registerPrepayment.enterCardNumber("4111111111111111");
            registerPrepayment.enterCardExpDate("04/2015");
            registerPrepayment.enterCardHolderLastName("CSS_PQALN");
            registerPrepayment.enterCardHolderFirstName("CSS_PQAFN");
            registerPrepayment.enterCardSecretCode("123");
            registerPrepayment.enterZipPostalCode("12345");

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
