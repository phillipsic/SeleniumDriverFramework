package com.comverse.css.pos.bkm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerUser;

public class BKM0050_Save_the_current_basket_automatically extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerUser();
    }

    @Test
    public void testBKM0050_Save_the_current_basket_automatically() throws Exception {

        try {
            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);
            PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = myShapeChannel.loginToPOS(user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();

            enterIdentificationData.setCustomerTitle("Mrs.");
            enterIdentificationData.setCustomerFirstName("FN" + uniqueTimeStamp);
            enterIdentificationData.setCustomerLastName("LN" + uniqueTimeStamp);
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

            shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialUltraPostpaid.getOfferName());
            ConfigureBalance configureBalance = shopping.clickSelectOfferInPopUpWindowExpectingConfigureBalance();
            configureBalance.setSpendingLimit(po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET().getBalanceName(), po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET()
                    .getBalanceValue());
            MyBasket myBasket = configureBalance.clickContinueExpectingMyBasket();
            myBasket.assign3InventoriesFirstOffer(subscriber);

            Common.assertTextEquals("Owner", myBasket.getTypeRole());

            Common.assertVerifyTrue(tool, myBasket.getOfferName().matches(po_ResidentialUltraPostpaid.getOfferName() + "[\\s\\S]*$"));
            Common.assertTextEquals("1", myBasket.getQuantity());
            Common.assertTextEquals("$ 30.00 Monthly", myBasket.getRecurringCharge());
            Common.assertTextEquals("$ 22.00", myBasket.getUpfrontCharge());

            Common.assertTextEquals("55 Name of Street US ville  IA postcode United States", myBasket.getAddress());

            myShapeChannel = myBasket.clickLogout();
            myShapeChannel.clickHomePage();
            RestorePreviousBasket restorePreviousBasket = myShapeChannel.loginToChannelAsTelcoUserWithPreviousBasket();
            test.setBugId("CBS00154258");
            myBasket = restorePreviousBasket.clickRestoreSavedBasket();
            test.setBugId("NoBug");

            myBasket.assign3InventoriesFirstOffer(subscriber);

            Common.assertTextEquals("Owner", myBasket.getTypeRole());

            Common.assertVerifyTrue(tool, myBasket.getOfferName().matches(po_ResidentialUltraPostpaid.getOfferName() + "[\\s\\S]*$"));
            Common.assertTextEquals("1", myBasket.getQuantity());
            Common.assertTextEquals("$ 30.00 Monthly", myBasket.getRecurringCharge());
            Common.assertTextEquals("$ 22.00", myBasket.getUpfrontCharge());

            Common.assertTextEquals("55 Name of Street US ville  IA postcode United States", myBasket.getAddress());

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
