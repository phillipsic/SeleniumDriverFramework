package com.comverse.css.csr.prs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.css.data.AB.AB_ResidentialEnhanceFamilyAccountBundle;
import com.comverse.css.data.AO.AO_GenerallyAvailableAccountlevelWithSharedBalances;
import com.comverse.css.data.SO.SO_OneVoiceData;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class PRS0120_View_service_details extends CSSTest {
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
    public void testPRS0120_View_service_details() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            AB_ResidentialEnhanceFamilyAccountBundle ab_ResidentialEnhanceFamilyAccountBundle = new AB_ResidentialEnhanceFamilyAccountBundle();
            SO_OneVoiceData so_OneVoiceData = new SO_OneVoiceData();
            AO_GenerallyAvailableAccountlevelWithSharedBalances ao_GenerallyAvailableAccountlevelWithSharedBalances = new AO_GenerallyAvailableAccountlevelWithSharedBalances();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

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
            SelectOffersForYourSubscriber selectOffersForYourSubscriber = myBasket.clickChangeSO();
            // SupplementaryOfferDetails supplementaryOfferDetails =
            // selectOffersForYourSubscriber.clickOfferDetail(so_OneVoiceData.getOfferName());
            selectOffersForYourSubscriber.clickOfferDetailOnPopUp(so_OneVoiceData.getOfferName());
            Common.assertTextOnPage(tool, so_OneVoiceData.getOfferName());
            Common.assertTextOnPage(tool, "15.00 Monthly");
            Common.assertTextOnPage(tool, so_OneVoiceData.getOfferNetworkType());

            selectOffersForYourSubscriber.clickClose();
            selectOffersForYourSubscriber.clickCartIcon();
            myBasket = selectOffersForYourSubscriber.clickViewBasket();

            // supplementaryOfferDetails.clickCartIcon();
            // myBasket = supplementaryOfferDetails.clickViewBasket();

            SelectOffersForYourAccount selectOffersForYourAccount = myBasket.clickAddAO();
            selectOffersForYourAccount.clickOfferDetailAndPopUp(ao_GenerallyAvailableAccountlevelWithSharedBalances.getOfferName());
            Common.assertTextOnPage(tool, ao_GenerallyAvailableAccountlevelWithSharedBalances.getOfferName());
            Common.assertTextOnPage(tool, "$ 30.00 Yearly");
            Common.assertTextOnPage(tool, "$ 10.00");
            Common.assertTextOnPage(tool, ao_GenerallyAvailableAccountlevelWithSharedBalances.getOfferNetworkType());

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
