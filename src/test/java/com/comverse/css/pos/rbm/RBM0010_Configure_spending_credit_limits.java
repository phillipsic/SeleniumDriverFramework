package com.comverse.css.pos.rbm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class RBM0010_Configure_spending_credit_limits extends CSSTest {
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
    public void testRBM0010_Configure_spending_credit_limits() throws Exception {

        try {
            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);
            PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = myShapeChannel.loginToPOS(user);
            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();

            enterIdentificationData.enterDefaultIdentificationData();
            Shopping shopping = enterIdentificationData.clickContinue();

            shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialUltraPostpaid.getOfferName());
            ConfigureBalance configureBalance = shopping.clickSelectOfferInPopUpWindowExpectingConfigureBalance();

           // tool.clickUsingXPath("//input[@type='checkbox' and contains(@onclick, 'CORE BALANCE_limit')]");
            //configureBalance.setSpendingLimit(po_ResidentialUltraPostpaid.getBAL_CORE_BALANCE().getBalanceName(), po_ResidentialUltraPostpaid.getBAL_CORE_BALANCE()
             //       .getBalanceValue());
            configureBalance.setSpendingLimit(po_ResidentialUltraPostpaid.getBAL_InternationalRoaming().getBalanceName(), po_ResidentialUltraPostpaid.getBAL_InternationalRoaming()
                    .getBalanceValue());
            configureBalance.setSpendingLimit(po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET().getBalanceName(), po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET()
                    .getBalanceValue());
            MyBasket myBasket = configureBalance.clickContinueExpectingMyBasket();

            myBasket.assign3InventoriesFirstOffer(subscriber);
            String subscriberMSISDN = subscriber.getSubscriberMSISDNProperty();
            CheckoutReview checkoutReview = myBasket.clickCheckOut();

            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();

            String orderNumber = checkoutConfirmation.getNCAOrderNumberFromPage();
            workSpace = checkoutConfirmation.clickOk();

            SearchRequests searchRequests = workSpace.clickRequests();

            SearchOrders searchOrders = searchRequests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailed(orderNumber);

            workSpace = searchOrders.clickHomeMenu();

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();

            SubscriberDetails subscriberDetails = manageAccount.searchBySubscriberMSISDN(subscriberMSISDN);

            ViewBalance viewBalance = subscriberDetails.viewBalanceAndRecharge();

            BalanceDetails balanceDetails = viewBalance.viewBalanceDetails(po_ResidentialUltraPostpaid.getBAL_CORE_BALANCE().getBalanceName());
            Common.assertTextOnPage(tool, po_ResidentialUltraPostpaid.getBAL_CORE_BALANCE().getBalanceName());
            Common.assertTextOnPage(tool, "Unlimited");
            viewBalance = balanceDetails.clickGoToListOfBalances();

            balanceDetails = viewBalance.viewBalanceDetails(po_ResidentialUltraPostpaid.getBAL_InternationalRoaming().getBalanceName());
            Common.assertTextOnPage(tool, po_ResidentialUltraPostpaid.getBAL_InternationalRoaming().getBalanceName());
            Common.assertTextOnPage(tool, "$ " + po_ResidentialUltraPostpaid.getBAL_InternationalRoaming().getBalanceValue() + ".00");
            viewBalance = balanceDetails.clickGoToListOfBalances();

            Common.storeLastNameAndAccountNumberPostpaidAccount(enterIdentificationData.getAccount().getBillingLastNameProperty(), enterIdentificationData.getAccount()
                    .getBillingAccountIDProperty(), "Created by " + this.getClass().getSimpleName());

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
