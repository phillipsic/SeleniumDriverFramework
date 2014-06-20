package com.comverse.css.csr.rbm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.csr.*;
import com.comverse.css.data.AB.AB_ResidentialEnhanceFamilyAccountBundle;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class RBM0020_Configure_shadow_balances extends CSSTest {
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
    public void testRBM0020_Configure_shadow_balances() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);

            AB_ResidentialEnhanceFamilyAccountBundle ab_AccountBundle = new AB_ResidentialEnhanceFamilyAccountBundle();
            String balanceNightWeekendName = ab_AccountBundle.getBAL_VoiceNightWeekendShared().getBalanceName();
            String balanceNightWeekendValue = ab_AccountBundle.getBAL_VoiceNightWeekendShared().getBalanceValue();
            String balanceAnytimeName = ab_AccountBundle.getBAL_VoiceAnytimeShared().getBalanceName();
            String balanceAnytimeValue = ab_AccountBundle.getBAL_VoiceAnytimeShared().getBalanceValue();

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

            String acctBalanceNightWeekendName = tool.getAttributeUsingId(balanceNightWeekendName + "_target", "value");
            String acctBalanceAnytimeName = tool.getAttributeUsingId(balanceAnytimeName + "_target", "value");
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
            String accountID = enterIdentificationData.getAccount().getBillingAccountIDProperty();
            workSpace.clickHome();

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();

            AccountDetails accountDetails = identifyCustomer.gotoAccountDashboardUsingAccountID(accountID);

            ViewBalance viewBalance = accountDetails.clickViewBalancesAndRecharge();

            Common.assertTextOnPage(tool, acctBalanceAnytimeName);
            Common.assertTextOnPage(tool, acctBalanceNightWeekendName);
            accountDetails = viewBalance.clickBackToAccountDashboard();

            SubscriberDetails subscriberDetails = accountDetails.selectSubscriberByMSISDN(secondSubscriberMSISDN);
            viewBalance = subscriberDetails.viewBalanceAndRecharge();

            BalanceDetails balanceDetails = viewBalance.viewBalanceDetails(balanceNightWeekendName);

            Common.assertTextOnPage(tool, acctBalanceNightWeekendName);
            Common.assertTextOnPage(tool, "Next limit");
            Common.assertTextOnPage(tool, Common.formatToHHmmss(balanceNightWeekendValue));
            Common.assertTextOnPage(tool, "Use account units from");
            Common.assertTextOnPage(tool, acctBalanceNightWeekendName);
            viewBalance = balanceDetails.clickGoToListOfBalances();

            balanceDetails = viewBalance.viewBalanceDetails(balanceAnytimeName);

            Common.assertTextOnPage(tool, acctBalanceAnytimeName);
            Common.assertTextOnPage(tool, "Next limit");
            Common.assertTextOnPage(tool, Common.formatToHHmmss(balanceAnytimeValue));
            Common.assertTextOnPage(tool, "Use account units from");
            Common.assertTextOnPage(tool, acctBalanceAnytimeName);

            Common.storeLastNameAndAccountNumberPostpaidAccount(enterIdentificationData.getAccount().getBillingLastNameProperty(), accountID, "Created by "
                    + this.getClass().getSimpleName());

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
