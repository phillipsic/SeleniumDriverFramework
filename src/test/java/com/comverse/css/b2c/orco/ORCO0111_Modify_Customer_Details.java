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

public class ORCO0111_Modify_Customer_Details extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testORCO0111_Modify_Customer_Details() throws Exception {

        try {
            PO_ResidentialBasicPrepaid po_ResidentialBasicPrepaid = new PO_ResidentialBasicPrepaid();
            launchCSSApplication();

            String uniqueTimeStamp = Common.generateTimeStamp();

            HomePage homePage = new HomePage(tool, test, user);
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
            CustomerDetails customerDetails = signUpUser.enterMandatoryFieldsOnlyAndClickSignMeUp(uniqueTimeStamp);
            Common.assertTextOnPage(tool, "FN" + uniqueTimeStamp);
            Common.assertTextOnPage(tool, "LN" + uniqueTimeStamp);

            Common.assertTextOnPage(tool, "If your customer details are not correct, you can still modify them.");
            ModifyCustomerDetails modifyCustomerDetails = customerDetails.clickModify();
            modifyCustomerDetails.enterAddressLineOne("ModAddrLine1");
            modifyCustomerDetails.enterAddressLineTwo("ModAddrLine2");
            modifyCustomerDetails.enterAddressLineThree("ModAddrLine3");
            modifyCustomerDetails.enterAddressLineFour("ModAddrLine4");
            modifyCustomerDetails.enterCity("ModCity");
            modifyCustomerDetails.enterEmailAddress("ModEmail@comverse.com");

            modifyCustomerDetails.enterDateOfBirth("01/01/1982");
            modifyCustomerDetails.enterNationalId("ABCD1234");

            modifyCustomerDetails.clickConfirm();

            test.setBugId("CBS00160146");
            Common.assertTextOnPage(tool, "ModAddrLine1");
            test.setBugId("NoBug");
            Common.assertTextOnPage(tool, "ModAddrLine2");
            Common.assertTextOnPage(tool, "ModAddrLine3");
            Common.assertTextOnPage(tool, "ModAddrLine4");
            Common.assertTextOnPage(tool, "ModCity");
            Common.assertTextOnPage(tool, "ModEmail@comverse.com");
            Common.assertTextOnPage(tool, "01/01/1982");
            Common.assertTextOnPage(tool, "ABCD1234");
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
