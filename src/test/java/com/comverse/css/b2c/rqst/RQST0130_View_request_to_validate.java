package com.comverse.css.b2c.rqst;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.data.apps.B2C;

public class RQST0130_View_request_to_validate extends CSSTest {

    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testRQST0130_View_request_to_validate() throws Exception {

        try {
            launchCSSApplication();
            PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();
            String uniqueTimeStamp = Common.generateTimeStamp();

            String cup_login = Common.getCUPB2CLogin();
            String cup_password = Common.getCUPB2CPassword(cup_login);

            String cop_login = Common.getCOPB2CLogin();
            String cop_password = Common.getCOPB2CPassword(cop_login);

            HomePage homePage = new HomePage(tool, test, user);

            homePage.enterUsername(cop_login);
            homePage.enterPassword(cop_password);

            SubscriberDetail subscriberDetail = homePage.clickLogIn();

            SearchMember searchMember = subscriberDetail.clickMyInformationTab();

            CustomerProfile customerProfile = searchMember.clickChangeProfile();
            ModifyProfileInformation modifyProfileInformation = customerProfile.clickModify();

            modifyProfileInformation.selectApprovalSequencing("Yes");
            ConfirmModifyProfileInformation confirmModifyProfileInformation = modifyProfileInformation.clickOK();

            confirmModifyProfileInformation.clickOK();

            confirmModifyProfileInformation.clickLogout();

            homePage.clickHomePage();
            homePage.enterUsername(cup_login);
            homePage.enterPassword(cup_password);

            System.out.print(cup_login + "/" + cup_password);

            WorkSpace workSpace = homePage.clickLogInWithCUP();

            Common.assertTextOnPage(tool, "Welcome");

            Shopping shopping = workSpace.clickShopping();

            ChooseYourPrimaryOffer chooseYourPrimaryOffer = shopping.clickGSMMobileLink();

            EnterYourSubscriptionDetails enterYourSubscriptionDetails = chooseYourPrimaryOffer.selectPrimaryOfferByNameWithoutDevice(po_ResidentialUltraPostpaid.getOfferName());

            enterYourSubscriptionDetails.enterDefaultIdentityAddressPhoneEmail(uniqueTimeStamp);
            SelectOffersForYourSubscriber SelectOffersForYourSubscriber = enterYourSubscriptionDetails.clickOk();

            ConfigureOffers configureOffers = SelectOffersForYourSubscriber.clickContinue();
            ConfigureBalance configureBalance = configureOffers.clickContinueExpectingConfigureBalance();
            configureBalance.configureBalance(po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET().getBalanceName(), po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET()
                    .getBalanceValue());
            ChooseAccessories chooseAccessories = configureBalance.clickContinue();

            MyBasket myBasket = chooseAccessories.clickContinue();
            CheckOutBillingAccountInformation checkOutBillingAccountInformation = myBasket.clickCheckOutExpectingCheckOutBillingAccountInformation();
            // checkOutBillingAccountInformation.clickCheckRadioButton();
            BillingManagement billingManagement = checkOutBillingAccountInformation.clickContinueExpectingBillingManagement();

            CheckoutReview checkoutReview = billingManagement.clickContinue();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickContinue();
            checkoutConfirmation.clickOkExpectingShopping();

            shopping.clickLogout();
            homePage.clickHomePage();

            homePage.enterUsername(cop_login);
            homePage.enterPassword(cop_password);
            System.out.print(cop_login + "/" + cop_password);
            subscriberDetail = homePage.clickLogIn();
            subscriberDetail.clickMyOrdersTab();

            Common.assertTextOnPage(tool, "To Be Validated");

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
