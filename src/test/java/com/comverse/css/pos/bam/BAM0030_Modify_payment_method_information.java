package com.comverse.css.pos.bam;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class BAM0030_Modify_payment_method_information extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @Test
    public void testBAM0030_View_and_manage_account() throws Exception {

        try {
            launchCSSApplication();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            workSpace.doResitdentialNCAResidentialUltraPostpaidPOS();

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            CustomerSearchResult customerSearch = manageAccount.searchByAccountLastNameMultiplePersons(workSpace.getAccount().getBillingLastNameProperty());

            AccountDetails accountDetails = customerSearch.clickPersonNameLink(workSpace.getPerson().getPersonLastNameProperty());
            ModifyPaymentInformation modifyPaymentInformation = accountDetails.clickModifyPaymentMethod();

            modifyPaymentInformation.setPaymentMethodDirectDebit();
            modifyPaymentInformation.setBankCode(workSpace.getAccount().getBillingBankCodeProperty());
            modifyPaymentInformation.setBankAgencyCode(workSpace.getAccount().getBillingBankAgencyCodeProperty());
            modifyPaymentInformation.setBankAccountNumber(workSpace.getAccount().getBillingBankAccountNumberProperty());
            ModifyPaymentMethod modifyPaymentMethod = modifyPaymentInformation.clickModifyPaymentButton();
            accountDetails = modifyPaymentMethod.clickOk();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
            accountDetails = requestsForCustomer.clickAccounts();
            accountDetails.clickRefreshThisAccount();
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
