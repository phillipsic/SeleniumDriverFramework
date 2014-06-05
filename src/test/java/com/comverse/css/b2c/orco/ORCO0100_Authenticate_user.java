package com.comverse.css.b2c.orco;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.PO.PO_ResidentialBasicPrepaid;
import com.comverse.data.apps.B2C;

public class ORCO0100_Authenticate_user extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testORCO0100_Authenticate_user() throws Exception {

        try {
            PO_ResidentialBasicPrepaid po_ResidentialBasicPrepaid = new PO_ResidentialBasicPrepaid();
            launchCSSApplication();

            String userName = Common.getB2CLoginName();
            String password = Common.getB2CPassword();

            HomePage homePage = new HomePage(driver);
            homePage.clickShoppingLink();

            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourPrimaryOffer chooseYourPrimaryOffer = shopping.clickGSMMobileLink();

            EnterYourSubscriptionDetails enterYourSubscriptionDetails = chooseYourPrimaryOffer.selectPrimaryOfferByNameWithoutDevice(po_ResidentialBasicPrepaid.getOfferName());

            enterYourSubscriptionDetails.enterDefaultIdentityAddressPhoneEmail(userName);
            SelectOffersForYourSubscriber SelectOffersForYourSubscriber = enterYourSubscriptionDetails.clickOk();

            ConfigureOffers configureOffers = SelectOffersForYourSubscriber.clickContinue();
            ChooseAccessories chooseAccessories = configureOffers.clickContinue();
            MyBasket myBasket = chooseAccessories.clickContinue();
            CheckoutRegister checkoutRegister = myBasket.clickCheckOut();
            // SignUpUser signUpUser =
            // checkoutRegister.selectSignMeUpAndClickContinue();

            CheckOutBillingAccountInformation checkOutBillingAccountInformation = checkoutRegister.enterRegisteredLoginDetailsAndClickContinue(userName, password);

            CheckoutReview checkoutReview = checkOutBillingAccountInformation.clickContinue();

            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickContinue();

            String orderNumber = checkoutConfirmation.getOrderNumberFromPage();
            // SearchOrders searchOrders = checkoutConfirmation.clickOk(); //
            // Goes to shopping page??
            SubscriberDetail SubscriberDetail = checkoutConfirmation.clickMyAccount();

            SearchOrders searchOrders = SubscriberDetail.clickMyOrders();

            test.setBugId("CBS00163932");
            searchOrders.waitUntilOrderCompletedOrFailedWithOrderNumber(orderNumber);
            test.setBugId("NoBug");

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
