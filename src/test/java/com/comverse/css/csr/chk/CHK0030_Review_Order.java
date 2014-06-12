package com.comverse.css.csr.chk;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.csr.*;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class CHK0030_Review_Order extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testCHK0030_Review_Order() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();

            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);

            WorkSpace workSpace = new WorkSpace(tool, test, user);

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

            shopping.filterSubscriberBundlePrimaryOfferByName(po_ResidentialUltraPostpaid.getOfferName());
            shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialUltraPostpaid.getOfferName());
            ConfigureBalance configureBalance = shopping.clickSelectOfferInPopUpWindowExpectingConfigureBalance();
            configureBalance.setSpendingLimit(po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET().getBalanceName(), po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET()
                    .getBalanceValue());
            MyBasket myBasket = configureBalance.clickContinueExpectingMyBasket();

            shopping = myBasket.clickContinueShopping();
            shopping.clickHandsetsTab();

            myBasket = shopping.selectHandset("CSS-PQA-DataDevice-SmartPhones-DEV3");
            myBasket.assign3InventoriesFirstOffer(subscriber);

            myBasket.clickAcceptTermsAndConditions();
            CheckoutDeliveryAddress checkoutDeliveryAddress = myBasket.clickCheckOutWithGoods();
            checkoutDeliveryAddress.clickNextPage();

            Common.assertTextOnPage(tool, po_ResidentialUltraPostpaid.getOfferName());
            Common.assertTextOnPage(tool, "CSS-PQA-DataDevice-SmartPhones-DEV3");
            Common.assertTextOnPage(tool, "Title: Mrs.");
            Common.assertTextOnPage(tool, "First Name: FN" + uniqueTimeStamp);
            Common.assertTextOnPage(tool, "Last Name: LN" + uniqueTimeStamp);
            Common.assertTextOnPage(tool, "Gender:Female");
            Common.assertTextOnPage(tool, "Phone Number0123456");
            Common.assertTextOnPage(tool, "Fax Number6543210");
            Common.assertTextOnPage(tool, "Address Line 1: 55 Name of Street");
            Common.assertTextOnPage(tool, "ZIP/Post Code postcode");
            Common.assertTextOnPage(tool, "City US ville");
            Common.assertTextOnPage(tool, "State/Region Iowa");
            Common.assertTextOnPage(tool, "Country United States");

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
