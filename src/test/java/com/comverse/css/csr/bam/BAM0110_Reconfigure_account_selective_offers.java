package com.comverse.css.csr.bam;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.csr.*;
import com.comverse.css.data.AB.AB_DIYSuperPack;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRUser;

public class BAM0110_Reconfigure_account_selective_offers extends CSSTest {
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
    public void testBAM0110_Reconfigure_account_selective_offers() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);
            AB_DIYSuperPack ab_DIYSuperPack = new AB_DIYSuperPack();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();

            enterIdentificationData.enterDefaultIdentificationData();

            Shopping shopping = enterIdentificationData.clickContinue();
            shopping.clickAccountBundlesTab();

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

            String orderNumber = checkoutConfirmation.getOrderNumberFromPage();
            workSpace = checkoutConfirmation.clickOk();
            SearchRequests searchRequests = workSpace.clickRequests();
            SearchOrders searchOrders = searchRequests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailedWithGetAccountID(orderNumber, enterIdentificationData.getAccount());

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
