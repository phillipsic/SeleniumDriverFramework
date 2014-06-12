package com.comverse.css.pos.nsa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid15DiscountICB;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class NSA0010_New_subscriber_for_an_existing_customer extends CSSTest {
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
    public void testNSA0010_New_subscriber_for_an_existing_customer() throws Exception {

        try {
            launchCSSApplication();

            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);
            String accountLastname = Common.getLastNameOfPostPaidAccount();
            PO_ResidentialUltraPostpaid15DiscountICB po_ResidentialUltraPostpaid15DiscountICB = new PO_ResidentialUltraPostpaid15DiscountICB();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastname);

            accountDetails.getAccountNumber();

            CustomerAcquisitionCustomerDataReview customerAcquisitionCustomerDataReview = accountDetails.clickNewConvergentSubscriberOnExistingAccount();
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
