package com.comverse.css.b2c.shma;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.PO.PO_DIYInteractiveTVOfferforAll;
import com.comverse.css.data.SO.SO_DIYeCountdownExtra;
import com.comverse.data.apps.B2C;

public class SHMA0001_Capture_Service_Connection_details extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testSHMA0001_Capture_Service_Connection_details() throws Exception {
        try {
            PO_DIYInteractiveTVOfferforAll po_DIYInteractiveTVOfferforAll = new PO_DIYInteractiveTVOfferforAll();
            // AO_GenerallyAvailableAccountlevelWithSharedBalances
            // ao_GenerallyAvailableAccountlevelWithSharedBalances = new
            // AO_GenerallyAvailableAccountlevelWithSharedBalances();
            SO_DIYeCountdownExtra so_DIYeCountDownExtra = new SO_DIYeCountdownExtra();
            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();

            HomePage homePage = new HomePage(driver);
            homePage.clickShoppingLink();
            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourPrimaryOfferInThisAccountBundle chooseYourPrimaryOfferInThisAccountBundle = shopping.clickFamilyPackLink();
            ChooseYourPrimaryOffer chooseYourPrimaryOffer = chooseYourPrimaryOfferInThisAccountBundle.clickSwitchToBrowsePrimaryOffers();

            EnterYourSubscriptionDetails enterYourSubscriptionDetails = chooseYourPrimaryOffer.selectPrimaryOfferByNameWithoutDevice(po_DIYInteractiveTVOfferforAll.getOfferName());

            enterYourSubscriptionDetails.enterDefaultIdentityAddressPhoneEmail(uniqueTimeStamp);
            SelectOffersForYourSubscriber selectOffersForYourSubscriber = enterYourSubscriptionDetails.clickOk();
            selectOffersForYourSubscriber.selectOffersForSubscriber(so_DIYeCountDownExtra.getOfferName());

            ConfigureOffers configureOffers = selectOffersForYourSubscriber.clickContinue();
            ChooseAccessories chooseAccessories = configureOffers.clickContinue();
            ConfigureServiceConnectionDetails configureServiceConnectionDetails = chooseAccessories.clickContinueExpectingConnectionServiceDetails();

            // configureBalance.configureBalance(sb_ResidentialBasicPrepaidBundle.getBAL_VoiceNightWeekendShared().getBalanceName(),
            // sb_ResidentialBasicPrepaidBundle
            // .getBAL_VoiceNightWeekendShared().getBalanceValue());

            MyBasket myBasket = configureServiceConnectionDetails.clickContinue();
            Common.assertTextOnPage(driver, po_DIYInteractiveTVOfferforAll.getOfferName());
            TermsAndConditions termsAndConditions = myBasket.clickCheckOutExpectingTermsAndConditions();

            CheckoutRegister checkoutRegister = termsAndConditions.clickOkExpectingCheckoutRegister();
            checkoutRegister.selectSignMeUp();
            SignUpUser signUpUser = checkoutRegister.clickContinue();
            CustomerDetails customerDetails = signUpUser.enterMandatoryFieldsOnlyAndClickSignMeUp(uniqueTimeStamp);

            CheckOutBillingAccountInformation checkOutBillingAccountInformation = customerDetails.clickOk();
            checkOutBillingAccountInformation.clickCheckRadioButton();
            BillingManagement billingManagement = checkOutBillingAccountInformation.clickContinueExpectingBillingManagement();
            CheckoutReview checkoutReview = billingManagement.clickContinue();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickContinue();
            String orderNumber = checkoutConfirmation.getOrderNumberFromPage();
            SearchOrders searchOrders = checkoutConfirmation.clickOk();
            Common.assertTextOnPage(driver, "Your order has been submitted.");
            Common.assertTextOnPage(driver, orderNumber);
            // searchOrders.clickRequests();
            // bugId = "CBS00165217";
            searchOrders.waitUntilOrderCompletedOrFailedWithOrderNumber(orderNumber);

            // SubscriberDetail subscriberDetail =
            // searchOrders.clickDashbaord();

            // ViewBalances viewBalances =
            // subscriberDetail.clickSharedBalances();

            // configureBalance = viewBalances.clickConfigure();

            // configureBalance.setSpendingLimit("360");
            // configureBalance.selectTargetAccount("Voice-Anytime");
            // configureBalance.clickConfigureBalance();

            // bugId = "NoBug";
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