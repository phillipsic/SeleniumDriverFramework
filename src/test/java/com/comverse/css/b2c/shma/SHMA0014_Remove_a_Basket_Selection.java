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

public class SHMA0014_Remove_a_Basket_Selection extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testSHMA0014_Remove_a_Basket_Selection() throws Exception {
        try {
            PO_DIYInteractiveTVOfferforAll po_DIYInteractiveTVOfferforAll = new PO_DIYInteractiveTVOfferforAll();
            // PO_DIYeExtendedInteractionTVPrimeOfferVIPOnly po_DIYExtTVPO = new
            // PO_DIYeExtendedInteractionTVPrimeOfferVIPOnly();
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

            MyBasket myBasket = configureServiceConnectionDetails.clickContinue();

            // Verification of added PO & SO .

            Common.assertTextOnPage(driver, po_DIYInteractiveTVOfferforAll.getOfferName());
            Common.assertTextOnPage(driver, so_DIYeCountDownExtra.getOfferName());

            // Removing added SO from Basket.

            RemoveSupplementaryOffer removeSO = myBasket.clickRemoveOnSO(so_DIYeCountDownExtra.getOfferName());
            Common.assertTextOnPage(driver, "Are you sure you want to remove supplementary offer " + so_DIYeCountDownExtra.getOfferName() + "?");
            myBasket = removeSO.ClickYes();

            // Verification of non-existence of SO in Basket.

            Common.assertTextNotOnPage(driver, so_DIYeCountDownExtra.getOfferName());

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
