package com.comverse.css.pos.nca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.data.AB.AB_DIYSuperPack;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerUser;

public class NCA0010_New_Customer_Account_Bundle_POS extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerUser();
    }

    @Test
    public void testNCA0010_New_Customer_Account_Bundle_POS() throws Exception {
        try {
            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);
            AB_DIYSuperPack ab_DIYSuperPack = new AB_DIYSuperPack();

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = myShapeChannel.loginToPOS(user);
            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();

            enterIdentificationData.enterDefaultIdentificationData();
            Shopping shopping = enterIdentificationData.clickContinue();
            shopping.clickAccountBundlesTab();

            Common.assertTextOnPage(tool, ab_DIYSuperPack.getOfferName());
            ConfigureContractDetails configureContractDetails = shopping.subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureContract(
                    ab_DIYSuperPack.getOfferName(), null, ab_DIYSuperPack.getSB_ResidentialUltraPostpaidBundle().getOfferName());

            configureContractDetails.setSpendingLimit(ab_DIYSuperPack.getBAL_VoiceNightWeekendShared().getBalanceName(), ab_DIYSuperPack.getBAL_VoiceNightWeekendShared()
                    .getBalanceValue());
            configureContractDetails.setSpendingLimit(ab_DIYSuperPack.getBAL_VoiceAnytimeShared().getBalanceName(), ab_DIYSuperPack.getBAL_VoiceAnytimeShared().getBalanceValue());
            configureContractDetails.setSpendingLimit(ab_DIYSuperPack.getBAL_GPRS_WAP_INTERNET().getBalanceName(), ab_DIYSuperPack.getBAL_GPRS_WAP_INTERNET().getBalanceValue());
            MyBasket myBasket = configureContractDetails.clickContinue();

            myBasket.assign3InventoriesFirstOffer(subscriber);

            myBasket.clickAcceptTermsAndConditions();
            CheckoutReview checkoutReview = myBasket.clickCheckOut();

            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();

            String orderNumber = checkoutConfirmation.getNCAOrderNumberFromPage();
            workSpace = checkoutConfirmation.clickOk();

            SearchRequests searchRequests = workSpace.clickRequests();

            SearchOrders searchOrders = searchRequests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailed(orderNumber);

            Common.storeLastNamePostpaidAccount(enterIdentificationData.getAccount().getBillingLastNameProperty(), "Created by " + this.getClass().getSimpleName());

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
