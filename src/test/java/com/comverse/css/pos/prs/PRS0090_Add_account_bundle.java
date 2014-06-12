package com.comverse.css.pos.prs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.data.AB.AB_ResidentialEnhanceFamilyAccountBundle;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class PRS0090_Add_account_bundle extends CSSTest {
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
    public void testPRS0090_Add_account_bundle() throws Exception {

        try {
            launchCSSApplication();
            AB_ResidentialEnhanceFamilyAccountBundle ab_ResidentialEnhanceFamilyAccountBundle = new AB_ResidentialEnhanceFamilyAccountBundle();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            enterIdentificationData.enterDefaultIdentificationData();
            Shopping shopping = enterIdentificationData.clickContinue();
            shopping.clickAccountBundlesTab();
            ConfigureBalance configureBalance = shopping.subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureBalance(
                    ab_ResidentialEnhanceFamilyAccountBundle.getOfferName(), null, null);

            configureBalance.setSpendingLimit(ab_ResidentialEnhanceFamilyAccountBundle.getBAL_VoiceNightWeekendShared().getBalanceName(), ab_ResidentialEnhanceFamilyAccountBundle
                    .getBAL_VoiceNightWeekendShared().getBalanceValue());
            ConfigureContractDetails configureContractDetails = configureBalance.clickContinueExpectingConfigureContractDetails();

            configureContractDetails.setSpendingLimit(ab_ResidentialEnhanceFamilyAccountBundle.getBAL_VoiceNightWeekendShared().getBalanceName(),
                    ab_ResidentialEnhanceFamilyAccountBundle.getBAL_VoiceNightWeekendShared().getBalanceValue());
            configureContractDetails.setSpendingLimit(ab_ResidentialEnhanceFamilyAccountBundle.getBAL_VoiceAnytimeShared().getBalanceName(),
                    ab_ResidentialEnhanceFamilyAccountBundle.getBAL_VoiceAnytimeShared().getBalanceValue());
            configureContractDetails.setSpendingLimit(ab_ResidentialEnhanceFamilyAccountBundle.getBAL_GPRS_WAP_INTERNET().getBalanceName(),
                    ab_ResidentialEnhanceFamilyAccountBundle.getBAL_GPRS_WAP_INTERNET().getBalanceValue());
            MyBasket myBasket = configureContractDetails.clickContinue();
            myBasket.assign3InventoriesFirstOffer(subscriber);
            myBasket.assign3InventoriesSecondOffer(subscriber);
            CheckoutReview checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();

            String orderNumber = checkoutConfirmation.getNCAOrderNumberFromPage();
            workSpace = checkoutConfirmation.clickOk();
            SearchRequests searchRequests = workSpace.clickRequests();
            SearchOrders searchOrders = searchRequests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailed(orderNumber);
            Common.storeLastNamePostpaidAccount(enterIdentificationData.getAccount().getBillingLastNameProperty(), "Created by -" + this.getClass().getSimpleName());
            searchOrders.clickHomeMenu();
            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();
            identifyCustomer.searchByPersonLastNameSinglePerson(enterIdentificationData.getPerson().getPersonLastNameProperty());

            Common.assertTextOnPage(tool, ab_ResidentialEnhanceFamilyAccountBundle.getOfferName());

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