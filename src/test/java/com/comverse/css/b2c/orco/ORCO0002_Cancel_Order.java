package com.comverse.css.b2c.orco;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.SB.SB_DIY10_10SuperBundle;
import com.comverse.data.apps.B2C;

public class ORCO0002_Cancel_Order extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testORCO0002_Cancel_Order() throws Exception {

        try {
            SB_DIY10_10SuperBundle sb_DIY10_10SuperBundle = new SB_DIY10_10SuperBundle();
            launchCSSApplication();

            String uniqueTimeStamp = Common.generateTimeStamp();

            HomePage homePage = new HomePage(tool, test, user);
            homePage.clickShoppingLink();

            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourPrimaryOfferInThisAccountBundle chooseYourPrimaryOfferInThisAccountBundle = shopping.clickFamilyPackLink();

            ConfirmAccountBundleChoice confirmAccountBundleChoice = chooseYourPrimaryOfferInThisAccountBundle.selectPrimaryOfferByNameWithoutDevice(sb_DIY10_10SuperBundle
                    .getOfferName());

            SelectOffersForYourAccount selectOffersForYourAccount = confirmAccountBundleChoice.clickOk();

            EnterYourSubscriptionDetails enterYourSubscriptionDetails = selectOffersForYourAccount.clickContinue();

            enterYourSubscriptionDetails.enterDefaultIdentityAddressPhoneEmail(uniqueTimeStamp);
            SelectOffersForYourSubscriber SelectOffersForYourSubscriber = enterYourSubscriptionDetails.clickOk();

            ConfigureOffers configureOffers = SelectOffersForYourSubscriber.clickContinue();
            ConfigureBalance configureBalance = configureOffers.clickContinueExpectingConfigureBalance();
            configureBalance.configureBalance(sb_DIY10_10SuperBundle.getBAL_SOURCE_Monetary().getBalanceName(), sb_DIY10_10SuperBundle.getBAL_SOURCE_Monetary().getBalanceValue());
            ChooseAccessories chooseAccessories = configureBalance.clickContinue();
            ConfigureServiceConnectionDetails configureServiceConnectionDetails = chooseAccessories.clickContinueExpectingConnectionServiceDetails();
            configureServiceConnectionDetails.setServiceConnectionEmail("email@comverse.com");
            MyBasket myBasket = configureServiceConnectionDetails.clickContinue();
            TermsAndConditions termsAndConditions = myBasket.clickCheckOutWithDevices();
            test.setBugId("CBS00163135");
            CheckoutRegister checkoutRegister = termsAndConditions.clickOk();
            test.setBugId("NoBug");
            myBasket = checkoutRegister.clickCancel();

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
