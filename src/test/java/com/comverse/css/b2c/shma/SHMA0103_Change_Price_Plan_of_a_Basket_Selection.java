package com.comverse.css.b2c.shma;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.PO.PO_ResidentialBasicPrepaid;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.css.data.SO.SO_ResdientialSMSMMSPack;
import com.comverse.data.apps.B2C;

public class SHMA0103_Change_Price_Plan_of_a_Basket_Selection extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testSHMA0103_Change_Price_Plan_of_a_Basket_Selection() throws Exception {
        try {
            PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();
            PO_ResidentialBasicPrepaid po_ResidentialBasicPrepaid = new PO_ResidentialBasicPrepaid();
            // SO_DIYeCountdownExtra so_DIYeCountDownExtra = new
            // SO_DIYeCountdownExtra();
            SO_ResdientialSMSMMSPack so_ResidentialSMSMMSPack = new SO_ResdientialSMSMMSPack();
            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();

            HomePage homePage = new HomePage(tool, test, user);
            homePage.clickShoppingLink();
            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourPrimaryOffer chooseYourPrimaryOffer = shopping.clickGSMMobileLink();
            // ChooseYourPrimaryOffer chooseYourPrimaryOffer =
            // chooseYourPrimaryOfferInThisAccountBundle.clickSwitchToBrowsePrimaryOffers();
            ChooseYourDevice chooseYourDevice = chooseYourPrimaryOffer.selectPrimaryOfferByNameWithDevice(po_ResidentialUltraPostpaid.getOfferName());
            EnterYourSubscriptionDetails enterYourSubscriptionDetails = chooseYourDevice.clickNoThanks();

            enterYourSubscriptionDetails.enterDefaultIdentityAddressPhoneEmail(uniqueTimeStamp);
            SelectOffersForYourSubscriber selectOffersForYourSubscriber = enterYourSubscriptionDetails.clickOk();

            ConfigureOffers configureOffers = selectOffersForYourSubscriber.clickContinue();
            ConfigureBalance configureBalance = configureOffers.clickContinueExpectingConfigureBalance();
            configureBalance.setSpendingLimit(po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET().getBalanceName(), "120");
            ChooseAccessories chooseAccessories = configureBalance.clickContinue();

            MyBasket myBasket = chooseAccessories.clickContinue();

            // Verification of added PO & SO .

            Common.assertTextOnPage(tool, po_ResidentialUltraPostpaid.getOfferName());
            // Common.assertTextOnPage(tool,
            // so_DIYeCountDownExtra.getOfferName());
            // Changing added PO
            chooseYourPrimaryOffer = myBasket.clickChangePO();
            enterYourSubscriptionDetails = chooseYourPrimaryOffer.selectPrimaryOfferByNameWithoutDevice(po_ResidentialBasicPrepaid.getOfferName());

            selectOffersForYourSubscriber = enterYourSubscriptionDetails.clickOk();
            selectOffersForYourSubscriber.selectOffersForSubscriber(so_ResidentialSMSMMSPack.getOfferName());
            configureOffers = selectOffersForYourSubscriber.clickContinue();
            myBasket = configureOffers.clickContinueExpectingMyBasket();

            // Checking of new added offer and removal of earlier offer.

            Common.assertTextOnPage(tool, po_ResidentialBasicPrepaid.getOfferName());
            Common.assertTextOnPage(tool, so_ResidentialSMSMMSPack.getOfferName());
            Common.assertTextNotOnPage(tool, po_ResidentialUltraPostpaid.getOfferName());
            // Common.assertTextNotOnPage(tool,
            // so_DIYeCountDownExtra.getOfferName());

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
