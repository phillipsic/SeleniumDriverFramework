package com.comverse.css.csr.rbm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.csr.*;
import com.comverse.css.data.AB.AB_ResidentialEnhanceFamilyAccountBundle;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRUser;

public class RBM0030_Display_balances extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRUser();
    }

    @Test
    public void testRBM0030_Display_balances() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);

            AB_ResidentialEnhanceFamilyAccountBundle ab_AccountBundle = new AB_ResidentialEnhanceFamilyAccountBundle();
            String balanceNightWeekendName = ab_AccountBundle.getBAL_VoiceNightWeekendShared().getBalanceName();
            String balanceNightWeekendValue = ab_AccountBundle.getBAL_VoiceNightWeekendShared().getBalanceValue();
            String balanceAnytimeName = ab_AccountBundle.getBAL_VoiceAnytimeShared().getBalanceName();
            String balanceAnytimeValue = ab_AccountBundle.getBAL_VoiceAnytimeShared().getBalanceValue();

            PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();

            WorkSpace workSpace = new WorkSpace(tool, test, user);
            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();

            enterIdentificationData.enterDefaultIdentificationData();
            Shopping shopping = enterIdentificationData.clickContinue();

            shopping.clickAccountBundlesTab();
            ConfigureBalance configureBalance = shopping.subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureBalance(ab_AccountBundle.getOfferName(), null,
                    null);

            configureBalance.setSpendingLimit(balanceNightWeekendName, balanceNightWeekendValue);
            ConfigureContractDetails configureContractDetails = configureBalance.clickContinueExpectingConfigureContractDetails();

            configureContractDetails.setSpendingLimit(balanceNightWeekendName, balanceNightWeekendValue);
            configureContractDetails.setSpendingLimit(balanceAnytimeName, balanceAnytimeValue);
            configureContractDetails.setSpendingLimit(ab_AccountBundle.getBAL_GPRS_WAP_INTERNET().getBalanceName(), ab_AccountBundle.getBAL_GPRS_WAP_INTERNET().getBalanceValue());

            MyBasket myBasket = configureContractDetails.clickContinue();

            myBasket.assign3InventoriesFirstOffer(subscriber);
            myBasket.assign3InventoriesSecondOffer(subscriber);
            String secondSubscriberMSISDN = subscriber.getSubscriberMSISDNProperty();
            CheckoutReview checkoutReview = myBasket.clickCheckOut();

            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();
            String orderNumber = checkoutConfirmation.getNCAOrderNumberFromPage();
            workSpace = checkoutConfirmation.clickOk();

            SearchRequests searchRequests = workSpace.clickRequests();

            SearchOrders searchOrders = searchRequests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailedWithGetAccountID(orderNumber, enterIdentificationData.getAccount());
            workSpace.clickHome();

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();

            SubscriberDetails subscriberDetails = identifyCustomer.searchBySubscriberMSISDN(secondSubscriberMSISDN);

            subscriberDetails.viewBalanceAndRecharge();

            // Balances table
            tool.isElementPresentByID("listBalances");
            Common.assertTextOnPage(tool, ab_AccountBundle.getBAL_GPRS_WAP_INTERNET().getBalanceName());
            // Shadow balances table
            tool.isElementPresentByID("listShadowBalances");
            Common.assertTextOnPage(tool, balanceAnytimeName);
            Common.assertTextOnPage(tool, Common.formatToHHmmss(balanceAnytimeValue));
            Common.assertTextOnPage(tool, balanceNightWeekendName);
            Common.assertTextOnPage(tool, Common.formatToHHmmss(balanceNightWeekendValue));
            // Balances limits table
            tool.isElementPresentByID("listLimits");
            Common.assertTextOnPage(tool, po_ResidentialUltraPostpaid.getBAL_CORE_BALANCE().getBalanceName());
            Common.assertTextOnPage(tool, po_ResidentialUltraPostpaid.getBAL_InternationalRoaming().getBalanceName());
            Common.assertTextOnPage(tool, "This value will be applied to your next bill cycle");

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
