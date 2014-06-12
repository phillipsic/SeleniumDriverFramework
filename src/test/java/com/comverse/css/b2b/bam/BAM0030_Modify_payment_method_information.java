package com.comverse.css.b2b.bam;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2b.*;
import com.comverse.css.common.*;
import com.comverse.data.apps.B2B;
import com.comverse.data.users.B2BAdmin;

public class BAM0030_Modify_payment_method_information extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2B();
        user = new B2BAdmin();
    }

    @Test
    public void testBAM0030_View_and_manage_account() throws Exception {

        try {
            launchCSSApplication();

            String uniqueTimeStamp = Common.generateTimeStamp();
            Account account = new Account(uniqueTimeStamp);

            MyshapeBusiness loginPage = new MyshapeBusiness(tool, test, user);
            WorkSpace workSpace = loginPage.loginToB2B(user);
            workSpace.setAccount(account);
            AccountDetails accountDetails = workSpace.clickAccount();

            ModifyPaymentInformation modifyPaymentInformation = accountDetails.clickModifyPaymentMethod();

            modifyPaymentInformation.setPaymentMethodDirectDebit();
            modifyPaymentInformation.setBankCode(workSpace.getAccount().getBillingBankCodeProperty());
            modifyPaymentInformation.setBankAgencyCode(workSpace.getAccount().getBillingBankAgencyCodeProperty());
            modifyPaymentInformation.setBankAccountNumber(workSpace.getAccount().getBillingBankAccountNumberProperty());
            modifyPaymentInformation.setOwnerlastName(workSpace.getAccount().getBillingLastNameProperty());
            ModifyPaymentMethod modifyPaymentMethod = modifyPaymentInformation.clickModifyPaymentButton();
            accountDetails = modifyPaymentMethod.clickOk();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilBizFirstRequestCompletedOrFailed();
            accountDetails = requestsForCustomer.clickAccounts();
            // accountDetails.clickRefreshThisAccount();
            modifyPaymentInformation = accountDetails.clickModifyPaymentMethod();

            assertEquals(workSpace.getAccount().getBillingBankCodeProperty(), modifyPaymentInformation.getBankCode());
            assertEquals(workSpace.getAccount().getBillingBankAgencyCodeProperty(), modifyPaymentInformation.getBankAgencyCode());
            assertEquals(workSpace.getAccount().getBillingBankAccountNumberProperty(), modifyPaymentInformation.getBankAccountNumber());

            test.setResult("pass");

        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            verificationErrors.append(e.getMessage());
            throw e;
        }

    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
