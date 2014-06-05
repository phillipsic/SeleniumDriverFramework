package com.comverse.css.b2c.shma;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.ACC.ACC_CSSPQABatteryPhoneACC1;
import com.comverse.css.data.ACC.ACC_CSSPQABatteryPhoneACC2;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.css.data.SO.SO_DIYeCountdownExtra;
import com.comverse.data.apps.B2C;

public class SHMA0100_Change_Accessories_Related_to_a_Basket_Selection extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testSHMA0100_Change_Accessories_Related_to_a_Basket_Selection() throws Exception {
        try {
            PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();
            ACC_CSSPQABatteryPhoneACC1 accBatteryPhone1 = new ACC_CSSPQABatteryPhoneACC1();
            ACC_CSSPQABatteryPhoneACC2 accBatteryPhone2 = new ACC_CSSPQABatteryPhoneACC2();
            SO_DIYeCountdownExtra so_DIYeCountDownExtra = new SO_DIYeCountdownExtra();
            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();
            double poNRC = Double.parseDouble(po_ResidentialUltraPostpaid.getNRC());

            HomePage homePage = new HomePage(driver);
            homePage.clickShoppingLink();
            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourPrimaryOffer chooseYourPrimaryOffer = shopping.clickGSMMobileLink();
            // ChooseYourPrimaryOffer chooseYourPrimaryOffer =
            // chooseYourPrimaryOfferInThisAccountBundle.clickSwitchToBrowsePrimaryOffers();
            ChooseYourDevice chooseYourDevice = chooseYourPrimaryOffer.selectPrimaryOfferByNameWithDevice(po_ResidentialUltraPostpaid.getOfferName());
            EnterYourSubscriptionDetails enterYourSubscriptionDetails = chooseYourDevice.clickNoThanks();

            enterYourSubscriptionDetails.enterDefaultIdentityAddressPhoneEmail(uniqueTimeStamp);
            SelectOffersForYourSubscriber selectOffersForYourSubscriber = enterYourSubscriptionDetails.clickOk();
            selectOffersForYourSubscriber.selectOffersForSubscriber(so_DIYeCountDownExtra.getOfferName());

            ConfigureOffers configureOffers = selectOffersForYourSubscriber.clickContinue();
            ConfigureBalance configureBalance = configureOffers.clickContinueExpectingConfigureBalance();
            configureBalance.setSpendingLimit("120");
            ChooseAccessories chooseAccessories = configureBalance.clickContinue();
            int accessory1Quantity = 1;
            chooseAccessories.setQuantityForAccessory(accBatteryPhone1.getAccessoryName(), String.valueOf(accessory1Quantity));
            double accessory1TotalPrice = Double.parseDouble(accBatteryPhone1.getAccessoryPriceinDollar()) * accessory1Quantity;
            MyBasket myBasket = chooseAccessories.clickContinue();

            // Verification of added PO & Accessory with total price .

            Common.assertTextOnPage(driver, po_ResidentialUltraPostpaid.getOfferName());
            Common.assertTextOnPage(driver, String.valueOf(poNRC));
            Common.assertTextOnPage(driver, accBatteryPhone1.getAccessoryName());
            Common.assertTextOnPage(driver, String.valueOf(accessory1TotalPrice));
            Common.assertTextOnPage(driver, String.valueOf(poNRC + accessory1TotalPrice));

            // Adding accessory.
            chooseAccessories = myBasket.clickAddAccessory();

            // set the no. of accessories required.
            int accessory2Quantity = 2;
            accessory1Quantity = 0;

            chooseAccessories.setQuantityForAccessory(accBatteryPhone2.getAccessoryName(), String.valueOf(accessory2Quantity));
            chooseAccessories.setQuantityForAccessory(accBatteryPhone1.getAccessoryName(), String.valueOf(accessory1Quantity));
            double accessory2TotalPrice = Double.parseDouble(accBatteryPhone2.getAccessoryPriceinDollar()) * accessory2Quantity;
            accessory1TotalPrice = Double.parseDouble(accBatteryPhone1.getAccessoryPriceinDollar()) * accessory1Quantity;
            myBasket = chooseAccessories.clickContinue();

            // Verification of added PO & Accessory with total price .

            Common.assertTextNotOnPage(driver, accBatteryPhone1.getAccessoryName());
            Common.assertTextOnPage(driver, accBatteryPhone2.getAccessoryName());

            Common.assertTextOnPage(driver, String.valueOf(accessory2TotalPrice));

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
