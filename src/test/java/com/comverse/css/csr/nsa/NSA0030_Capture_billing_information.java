package com.comverse.css.csr.nsa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.csr.*;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid15DiscountICB;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class NSA0030_Capture_billing_information extends CSSTest {

    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testNSA0030_Capture_billing_information() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();

            String uniqueTimeStamp = Common.generateTimeStamp();
            // Account account = new Account(uniqueTimeStamp);
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);
            String accountLastname = Common.getLastNameOfPostPaidAccount();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastname);
            PO_ResidentialUltraPostpaid15DiscountICB po_ResidentialUltraPostpaid15DiscountICB = new PO_ResidentialUltraPostpaid15DiscountICB();

            accountDetails.getAccountNumber();
            CustomerAcquisitionCustomerDataReview customerAcquisitionCustomerDataReview = accountDetails.clickNewConvergentSubscriberOnExistingAccount();

            UpdateAdministrativeAccountInformation updateAdministrativeAccountInformation = customerAcquisitionCustomerDataReview.clickBillingInformationEditButton();

            updateAdministrativeAccountInformation.setBillingExchangeRateClass("DIY - RateClass3");
            updateAdministrativeAccountInformation.setMarketCode("Employee");
            updateAdministrativeAccountInformation.setBillingTML("3.75");

            // EnterIdentificationData
            customerAcquisitionCustomerDataReview = updateAdministrativeAccountInformation.clickConfirm();

            Shopping shopping = customerAcquisitionCustomerDataReview.clickContinue();

            shopping.filterSubscriberBundlePrimaryOfferByName(po_ResidentialUltraPostpaid15DiscountICB.getOfferName());
            shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialUltraPostpaid15DiscountICB.getOfferName());
            ConfigureBalance configureBalance = shopping.clickSelectOfferInPopUpWindowExpectingConfigureBalance();
            configureBalance.setSpendingLimit(po_ResidentialUltraPostpaid15DiscountICB.getBAL_GPRS_WAP_INTERNET().getBalanceName(), po_ResidentialUltraPostpaid15DiscountICB
                    .getBAL_GPRS_WAP_INTERNET().getBalanceValue());
            MyBasket myBasket = configureBalance.clickContinueExpectingMyBasket();
            Common.assertTextOnPage(tool, po_ResidentialUltraPostpaid15DiscountICB.getOfferName());
            myBasket.assign3InventoriesFirstOffer(subscriber);
            CheckoutReview checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();
            Common.assertTextOnPage(tool, "Your order has been submitted.");
            String orderNumber = checkoutConfirmation.getOrderNumberFromPage();
            accountDetails = checkoutConfirmation.clickOkExpectingAccountDashboard();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.clickSearch();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();

            requestsForCustomer.clickOnOrderNumberLink(orderNumber);

            Common.assertTextOnPage(tool, po_ResidentialUltraPostpaid15DiscountICB.getOfferName());

            Common.assertTextOnPage(tool, "Market Code:Employee");
            Common.assertTextOnPage(tool, "TML Limit:3.75");
            Common.assertTextOnPage(tool, "Rate Class:DIY - RateClass3");

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
