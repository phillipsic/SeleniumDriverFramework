package com.comverse.css.pos.bkm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.SB.SB_ResidentialBasicPrepaidBundle;
import com.comverse.css.data.SB.SB_ResidentialUltraPostpaidBundle;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class BKM0040_Change_primary_offer_of_a_selection extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @Test
    public void testBKM0040_Change_primary_offer_of_a_selection() throws Exception {

        try {
            launchCSSApplication();
            String uniqueString = Common.generateTimeStamp();
            SB_ResidentialBasicPrepaidBundle sb_ResidentialBasicPrepaidBundle = new SB_ResidentialBasicPrepaidBundle();
            SB_ResidentialUltraPostpaidBundle sb_ResidentialUltraPostpaidBundle = new SB_ResidentialUltraPostpaidBundle();

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = myShapeChannel.loginToPOS(user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();

            enterIdentificationData.setCustomerTitle("Mrs.");
            enterIdentificationData.setCustomerFirstName("FN" + uniqueString);
            enterIdentificationData.setCustomerLastName("LN" + uniqueString);
            enterIdentificationData.setGender("female");
            enterIdentificationData.setEmailAddress("email@address.com");
            enterIdentificationData.setPhoneNumber("0123456");
            enterIdentificationData.setFaxNumber("6543210");

            enterIdentificationData.enterCustomerPostCode("postcode");
            enterIdentificationData.enterCustomerCity("US ville");
            enterIdentificationData.enterCustomerHomeCountry("United States");
            enterIdentificationData.enterCustomerHomeState("Iowa");

            enterIdentificationData.setCustomerStreetNumber("55");
            enterIdentificationData.setCustomerStreetName("Name of Street");
            enterIdentificationData.clickCopyFromCustomerAddressButton();
            enterIdentificationData.clickPaymentMethodCheck();

            Shopping shopping = enterIdentificationData.clickContinue();

            shopping.clickSubscriberBundlePrimaryOfferName(sb_ResidentialBasicPrepaidBundle.getOfferName());

            MyBasket myBasket = shopping.clickSelectOfferInPopUpWindow();

            Common.assertTextOnPage(tool, sb_ResidentialBasicPrepaidBundle.getOfferName());

            shopping = myBasket.changePrimaryOffer();
            shopping.filterSubscriberBundlePrimaryOfferByName(sb_ResidentialUltraPostpaidBundle.getOfferName());
            shopping.clickSubscriberBundlePrimaryOfferName(sb_ResidentialUltraPostpaidBundle.getOfferName());

            ConfigureContractDetails configureContractDetails = shopping.clickSelectOfferInPopUpWindowExpectingConfigureContract();
            configureContractDetails.setSpendingLimit(sb_ResidentialUltraPostpaidBundle.getPO_ResidentialUltraPostpaid().getBAL_GPRS_WAP_INTERNET().getBalanceName(),
                    sb_ResidentialUltraPostpaidBundle.getPO_ResidentialUltraPostpaid().getBAL_GPRS_WAP_INTERNET().getBalanceValue());

            myBasket = configureContractDetails.clickContinue();

            Common.assertTextNotOnPage(tool, sb_ResidentialBasicPrepaidBundle.getOfferName());
            Common.assertTextOnPage(tool, sb_ResidentialUltraPostpaidBundle.getOfferName());

            test.setResult("pass");

        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            verificationErrors.append(e.getMessage());
            throw e;
        }
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}