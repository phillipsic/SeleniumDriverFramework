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

public class ORCO0110_Confirm_Customer_Details extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testORCO0110_Confirm_Customer_Details() throws Exception {

        try {
            PO_ResidentialBasicPrepaid po_ResidentialBasicPrepaid = new PO_ResidentialBasicPrepaid();
            launchCSSApplication();

            String uniqueTimeStamp = Common.generateTimeStamp();

            HomePage homePage = new HomePage(driver);
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
            signUpUser.enterFirstName("FN" + uniqueTimeStamp);
            signUpUser.enterLastName("LN" + uniqueTimeStamp);
            signUpUser.enterAddressLineOne("Address Line One");
            signUpUser.enterZipCode("12345");
            signUpUser.enterCity("City1");
            signUpUser.selectState("Alabama");
            signUpUser.enterEmailAddress("email@comverse.com");
            signUpUser.enterLogin(uniqueTimeStamp);
            signUpUser.enterPassword("0123456");
            signUpUser.enterConfirmPassword("0123456");
            signUpUser.selectSecretQuestion("When did you kiss for the first time?");
            signUpUser.enterSecretAnswer("20 Nov 2012");
            signUpUser.enterDateOfBirth("12/12/1975");
            signUpUser.enterNationalId(uniqueTimeStamp);
            CustomerDetails customerDetails = signUpUser.clickSignMeUp();

            Common.assertTextOnPage(driver, "FN" + uniqueTimeStamp);
            Common.assertTextOnPage(driver, "LN" + uniqueTimeStamp);

            Common.assertTextOnPage(driver, "Address Line One");
            Common.assertTextOnPage(driver, "12345");
            Common.assertTextOnPage(driver, "City1");
            Common.assertTextOnPage(driver, "Alabama");
            Common.assertTextOnPage(driver, "email@comverse.com");

            customerDetails.clickOk();

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
