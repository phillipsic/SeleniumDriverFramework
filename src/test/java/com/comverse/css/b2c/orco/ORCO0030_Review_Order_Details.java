package com.comverse.css.b2c.orco;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.Offer;
import com.comverse.css.data.SB.SB_DIY10_10SuperBundle;
import com.comverse.data.apps.B2C;

public class ORCO0030_Review_Order_Details extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testORCO0030_Review_Order_Details() throws Exception {

        try {
            SB_DIY10_10SuperBundle sb_DIY10_10SuperBundle = new SB_DIY10_10SuperBundle();

            launchCSSApplication();

            String uniqueTimeStamp = Common.generateTimeStamp();

            HomePage homePage = new HomePage(tool, test, user);
            homePage.clickShoppingLink();

            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourPrimaryOffer chooseYourPrimaryOffer = shopping.clickNetworkTVLink();

            EnterYourSubscriptionDetails enterYourSubscriptionDetails = chooseYourPrimaryOffer.selectSubscriberBundleByNameWithoutDevice(sb_DIY10_10SuperBundle.getOfferName(),
                    sb_DIY10_10SuperBundle.getPO_DIYInteractiveTVOfferforAll().getOfferName());

            enterYourSubscriptionDetails.enterDefaultIdentityAddressPhoneEmail(uniqueTimeStamp);
            SelectOffersForYourSubscriber selectOffersForYourSubscriber = enterYourSubscriptionDetails.clickOk();

            ConfigureOffers configureOffers = selectOffersForYourSubscriber.clickContinue();
            // ConfigureBalance configureBalance =
            // configureOffers.clickContinueExpectingConfigureBalance();
            // configureBalance.configureBalance(sb_DIY10_10SuperBundle.getBAL_SOURCE_Monetary().getBalanceName(),
            // sb_DIY10_10SuperBundle.getBAL_SOURCE_Monetary().getBalanceValue());
            ChooseAccessories chooseAccessories = configureOffers.clickContinue();
            ConfigureServiceConnectionDetails configureServiceConnectionDetails = chooseAccessories.clickContinueExpectingConnectionServiceDetails();
            configureServiceConnectionDetails.setServiceConnectionEmail(((Offer) sb_DIY10_10SuperBundle.getPO_DIYInteractiveTVOfferforAll()).getOfferEmail());
            MyBasket myBasket = configureServiceConnectionDetails.clickContinue();

            TermsAndConditions termsAndConditions = myBasket.clickCheckOutExpectingTermsAndConditions();
            Common.assertTextOnPage(tool, sb_DIY10_10SuperBundle.getOfferTermsAndConditions());
            Common.assertTextOnPage(tool, ((Offer) sb_DIY10_10SuperBundle.getPO_DIYInteractiveTVOfferforAll()).getOfferTermsAndConditions());
            test.setBugId("CBS00163135");
            CheckoutRegister checkoutRegister = termsAndConditions.clickOk();
            test.setBugId("NoBug");
            SignUpUser signUpUser = checkoutRegister.selectSignMeUpAndClickContinue();

            signUpUser.enterAddressLineOne("Address Line One");
            signUpUser.enterLogin(uniqueTimeStamp);
            signUpUser.enterPassword("0123456");
            signUpUser.enterConfirmPassword("0123456");
            signUpUser.selectSecretQuestion("When did you kiss for the first time?");
            signUpUser.enterSecretAnswer("20 Nov 2012");

            CustomerDetails customerDetails = signUpUser.clickSignMeUp();
            CheckOutBillingAccountInformation checkOutBillingAccountInformation = customerDetails.clickOk();
            checkOutBillingAccountInformation.enterBankAccountNumber(uniqueTimeStamp);
            checkOutBillingAccountInformation.enterBankCode("111");
            checkOutBillingAccountInformation.enterOwnerLastName("LName");
            checkOutBillingAccountInformation.clickContinueExpectingBillingManagement();
            Common.assertTextOnPage(tool, sb_DIY10_10SuperBundle.getOfferName());
            Common.assertTextOnPage(tool, sb_DIY10_10SuperBundle.getPO_DIYInteractiveTVOfferforAll().getOfferName());
            // Common.assertTextOnPage(tool,
            // sb_DIY10_10SuperBundle.getSO_DIYAdditionalTVServices4U().getOfferName());
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
