package com.comverse.css.b2c.prod;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.css.data.SO.SO_2009MarchMadnessNews;
import com.comverse.css.data.SO.SO_2010WorldCupSoccerNews;
import com.comverse.data.apps.B2C;

public class PROD0400_Select_Subscriber_Offers extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testPROD0400_Select_Subscriber_Offers() throws Exception {
        try {
            launchCSSApplication();
            PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();
            SO_2010WorldCupSoccerNews so_2010WorldCupSoccerNews = new SO_2010WorldCupSoccerNews();
            SO_2009MarchMadnessNews so_2009MarchMadnessNews = new SO_2009MarchMadnessNews();
            String uniqueUserTimeStamp = Common.generateTimeStamp();

            HomePage homePage = new HomePage(driver);
            homePage.clickShoppingLink();

            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourPrimaryOffer chooseYourPrimaryOffer = shopping.clickGSMMobileLink();
            EnterYourSubscriptionDetails enterYourSubscriptionDetails = chooseYourPrimaryOffer.selectPrimaryOfferByNameWithoutDevice(po_ResidentialUltraPostpaid.getOfferName());
            enterYourSubscriptionDetails.enterDefaultIdentityAddressPhoneEmail(uniqueUserTimeStamp);

            SelectOffersForYourSubscriber selectOfferForYourSubscriber = enterYourSubscriptionDetails.clickOk();
            selectOfferForYourSubscriber.selectOffersForSubscriber(so_2010WorldCupSoccerNews.getOfferName());
            ConfigureOffers configureOffers = selectOfferForYourSubscriber.clickContinue();
            ConfigureBalance configureBalance = configureOffers.clickContinueExpectingConfigureBalance();
            configureBalance.configureBalance("GPRS WAP-INTERNET", "20");
            ChooseAccessories chooseAccessories = configureBalance.clickContinue();
            chooseAccessories.setQuantityForAccessory("CSS-PQA-Battery-Phone-ACC1", "1");
            MyBasket myBasket = chooseAccessories.clickContinue();
            Common.assertTextOnPage(driver, so_2010WorldCupSoccerNews.getOfferName());
            Common.assertTextOnPage(driver, po_ResidentialUltraPostpaid.getOfferName());
            ConfirmOffersSelection confirmOfferSelection = myBasket.clickModifyOnSO(so_2010WorldCupSoccerNews.getOfferName());
            confirmOfferSelection.enterVoiceMailSize("20");
            myBasket = confirmOfferSelection.clickConfirmOffer();
            RemoveSupplementaryOffer removeSupplementaryOffer = myBasket.clickRemoveOnSO(so_2010WorldCupSoccerNews.getOfferName());
            myBasket = removeSupplementaryOffer.ClickYes();
            Common.assertTextNotOnPage(driver, so_2010WorldCupSoccerNews.getOfferName());
            selectOfferForYourSubscriber = myBasket.clickAddSupplementaryOffers();
            selectOfferForYourSubscriber.selectOffersForSubscriber(so_2009MarchMadnessNews.getOfferName());
            configureOffers = selectOfferForYourSubscriber.clickContinue();
            configureBalance = configureOffers.clickContinueExpectingConfigureBalance();
            configureBalance.configureBalance("GPRS WAP-INTERNET", "20");
            configureBalance.configureBalance("Voice-Anytime", "50.0");
            myBasket = configureBalance.clickContinueExpectingMyBasket();
            Common.assertTextOnPage(driver, so_2009MarchMadnessNews.getOfferName());
            Common.assertTextOnPage(driver, po_ResidentialUltraPostpaid.getOfferName());
            TermsAndConditions termsAndConditions = myBasket.clickCheckOutExpectingTermsAndConditions();
            test.setBugId("CBS00163135");
            CheckoutRegister checkoutRegister = termsAndConditions.clickOkExpectingCheckoutRegister();
            test.setBugId("NoBug");
            SignUpUser signUpUser = checkoutRegister.selectSignMeUpAndClickContinue();
            CustomerDetails customerDetails = signUpUser.enterMandatoryFieldsOnlyAndClickSignMeUp(uniqueUserTimeStamp);
            CheckOutDeliveryAddress checkOutDeliveryAddress = customerDetails.clickOkExpectingCheckOutDeliveryAddress();
            CheckOutBillingAccountInformation checkOutBillingAccountInformation = checkOutDeliveryAddress.clickContinue();
            checkOutBillingAccountInformation.enterBankCode(uniqueUserTimeStamp);
            checkOutBillingAccountInformation.enterBankAccountNumber(uniqueUserTimeStamp);
            checkOutBillingAccountInformation.enterOwnerLastName("LN" + uniqueUserTimeStamp);
            checkOutBillingAccountInformation.clickContinueExpectingBillingManagement();

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
