package com.google.search;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.company.css.b2c.*;
import com.framework.common.AlreadyRunException;
import com.framework.app.common.Test;
import com.framework.app.common.Common;
import com.framework.app.common.Prep;
import com.company.css.data.PO.PO_ResidentialBasicPrepaid;
import com.company.data.apps.Google;

public class CHK001_GoogleSearch extends Test {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new Google();
    }

    @Test
    public void testACCS0000_CreateExistingAccount() throws Exception {

        try {
            PO_ResidentialBasicPrepaid po_ResidentialBasicPrepaid = new PO_ResidentialBasicPrepaid();
            launchApplication();

            String uniqueTimeStamp = Common.generateTimeStamp();

            HomePage homePage = new HomePage(tool, test, user);
            homePage.clickShoppingLink();

            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourPrimaryOffer chooseYourPrimaryOffer = shopping.clickGSMMobileLink();

            EnterYourSubscriptionDetails enterYourSubscriptionDetails = chooseYourPrimaryOffer.selectPrimaryOfferByNameWithoutDevice(po_ResidentialBasicPrepaid.getOfferName());

            enterYourSubscriptionDetails.enterDefaultIdentityAddressPhoneEmail(uniqueTimeStamp);
            SelectOffersForYourSubscriber SelectOffersForYourSubscriber = enterYourSubscriptionDetails.clickOk();

            ConfigureOffers configureOffers = SelectOffersForYourSubscriber.clickContinue();
            ChooseAccessories chooseAccessories = configureOffers.clickContinue();
            MyBasket myBasket = chooseAccessories.clickContinue();
            CheckoutRegister checkoutRegister = myBasket.clickCheckOut();
            SignUpUser signUpUser = checkoutRegister.selectSignMeUpAndClickContinue();

            signUpUser.enterAddressLineOne("Address Line One");
            signUpUser.enterLogin(uniqueTimeStamp);
            signUpUser.enterPassword("0123456");
            signUpUser.enterConfirmPassword("0123456");
            signUpUser.selectSecretQuestion("When did you kiss for the first time?");
            signUpUser.enterSecretAnswer("20 Nov 2012");

            CustomerDetails customerDetails = signUpUser.clickSignMeUp();
            CheckOutBillingAccountInformation checkOutBillingAccountInformation = customerDetails.clickOk();
            CheckoutReview checkoutReview = checkOutBillingAccountInformation.clickContinue();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickContinue();
            SearchOrders searchOrders = checkoutConfirmation.clickOk();
            searchOrders.clickRequests();

            searchOrders.waitUntilOrderCompletedOrFailed();
            Common.storeB2CLoginDetailsAndLastName("LN" + uniqueTimeStamp, uniqueTimeStamp, "0123456", "ACCS0000_CreateExistingAccount");

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
