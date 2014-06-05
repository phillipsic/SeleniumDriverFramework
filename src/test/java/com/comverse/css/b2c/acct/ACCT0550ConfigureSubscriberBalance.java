package com.comverse.css.b2c.acct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.SB.SB_ResidentialBasicPrepaidBundle;
import com.comverse.data.apps.B2C;

public class ACCT0550ConfigureSubscriberBalance extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testACCT0550ConfigureSubscriberBalance() throws Exception {
        try {
            SB_ResidentialBasicPrepaidBundle sb_ResidentialBasicPrepaidBundle = new SB_ResidentialBasicPrepaidBundle();
            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();

            HomePage homePage = new HomePage(driver);
            homePage.clickShoppingLink();
            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourPrimaryOfferInThisAccountBundle chooseYourPrimaryOfferInThisAccountBundle = shopping.clickFamilyPackLink();

            ConfirmAccountBundleChoice confirmAccountBundleChoice = chooseYourPrimaryOfferInThisAccountBundle.selectPrimaryOfferInBundleByName(sb_ResidentialBasicPrepaidBundle
                    .getOfferName());

            SelectOffersForYourAccount selectOffersForYourAccount = confirmAccountBundleChoice.clickOk();
            EnterYourSubscriptionDetails enterYourSubscriptionDetails = selectOffersForYourAccount.clickContinue();
            enterYourSubscriptionDetails.enterDefaultIdentityAddressPhoneEmail(uniqueTimeStamp);
            SelectOffersForYourSubscriber selectOffersForYourSubscriber = enterYourSubscriptionDetails.clickOk();
            ConfigureOffers configureOffers = selectOffersForYourSubscriber.clickContinue();

            ConfigureBalance configureBalance = configureOffers.clickContinueExpectingConfigureBalance();
            configureBalance.configureBalance(sb_ResidentialBasicPrepaidBundle.getBAL_VoiceNightWeekendShared().getBalanceName(), sb_ResidentialBasicPrepaidBundle
                    .getBAL_VoiceNightWeekendShared().getBalanceValue());
            ChooseAccessories chooseAccessories = configureBalance.clickContinue();
            MyBasket myBasket = chooseAccessories.clickContinue();
            TermsAndConditions termsAndConditions = myBasket.clickCheckOutExpectingTermsAndConditions();

            CheckoutRegister checkoutRegister = termsAndConditions.clickOkExpectingCheckoutRegister();
            checkoutRegister.selectSignMeUp();
            SignUpUser signUpUser = checkoutRegister.clickContinue();
            CustomerDetails customerDetails = signUpUser.enterMandatoryFieldsOnlyAndClickSignMeUp(uniqueTimeStamp);

            CheckOutBillingAccountInformation checkOutBillingAccountInformation = customerDetails.clickOk();
            checkOutBillingAccountInformation.clickCheckRadioButton();

            CheckoutReview checkoutReview = checkOutBillingAccountInformation.clickContinue();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickContinue();

            SearchOrders searchOrders = checkoutConfirmation.clickOk();
            searchOrders.clickRequests();

            searchOrders.waitUntilOrderCompletedOrFailed();

            SubscriberDetail subscriberDetail = searchOrders.clickDashbaord();

            ViewBalances viewBalances = subscriberDetail.clickBalances();

            configureBalance = viewBalances.clickConfigure();

            configureBalance.setSpendingLimit("360");
            configureBalance.selectTargetAccount("Voice-Anytime");
            ConfigureBalanceReview configureBalanceReview = configureBalance.clickConfigureBalance();
            ConfigureBalanceConfirm configureBalanceConfirm = configureBalanceReview.clickConfirm();
            Common.assertTextOnPage(driver, "Your request to configure balance has been processed successfully");
            // Common.assertTextOnPage(driver, "Night and Weekend Minutes");
            Common.assertTextOnPage(driver, "Voice-Anytime");
            viewBalances = configureBalanceConfirm.clickBack();

            // More validation steps to be added.
            // test.setResult("pass");
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
