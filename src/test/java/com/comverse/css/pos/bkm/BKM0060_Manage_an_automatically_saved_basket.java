package com.comverse.css.pos.bkm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class BKM0060_Manage_an_automatically_saved_basket extends CSSTest {
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
    public void testBKM0060_Manage_an_automatically_saved_basket() throws Exception {

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

            ServiceConnectionDetails serviceConnectionDetails = myBasket.clickFirstActionsIcon();

            serviceConnectionDetails.clickSetIMSIInventory(subscriber);
            serviceConnectionDetails.clickSetSIMInventory(subscriber);
            serviceConnectionDetails.clickSetMSISDNInventory(subscriber);
            myBasket = serviceConnectionDetails.clickOk();

            assertEquals("Owner", myBasket.getTypeRole());

            assertTrue(myBasket.getOfferName().matches(po_ResidentialUltraPostpaid.getOfferName() + "[\\s\\S]*$"));
            assertEquals("1", myBasket.getQuantity());
            assertEquals("$ 30.00 Monthly", myBasket.getRecurringCharge());
            assertEquals("$ 22.00", myBasket.getUpfrontCharge());

            assertEquals("55 Name of Street US ville  IA postcode United States", myBasket.getAddress());

            myShapeChannel = myBasket.clickLogout();
            myShapeChannel.clickHomePage();
            RestorePreviousBasket restorePreviousBasket = myShapeChannel.loginToChannelAsTelcoAdminWithPreviousBasket();
          
            myBasket = restorePreviousBasket.clickRestoreSavedBasket();
         
            myBasket.assign3InventoriesFirstOffer(subscriber);

            assertEquals("Owner", myBasket.getTypeRole());

            assertTrue(myBasket.getOfferName().matches(po_ResidentialUltraPostpaid.getOfferName() + "[\\s\\S]*$"));
            assertEquals("1", myBasket.getQuantity());
            assertEquals("$ 30.00 Monthly", myBasket.getRecurringCharge());
            assertEquals("$ 22.00", myBasket.getUpfrontCharge());

            assertEquals("55 Name of Street US ville  IA postcode United States", myBasket.getAddress());

            myBasket.clickBasket();
            

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
