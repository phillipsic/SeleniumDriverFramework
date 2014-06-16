package com.comverse.css.b2c.acct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2C;

public class ACCT0550Contract_Set_spending_limit_on_monetary_shadow_balance extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testACCT0550Contract_Set_spending_limit_on_monetary_shadow_balance() throws Exception {
        try {
            launchCSSApplication();

            String uniqueUserTimeStamp = Common.generateTimeStamp();

            HomePage homePage = new HomePage(tool, test, user);
            homePage.clickShoppingLink();

            Shopping shopping = homePage.selectAccountSegmentAll();

            ChooseYourPrimaryOfferInThisAccountBundle chooseYourPrimaryOfferInThisAccountBundle = shopping.clickFamilyPackLink();
            ConfirmAccountBundleChoice confirmAccountBundleChoice = chooseYourPrimaryOfferInThisAccountBundle
                    .selectPrimaryOfferInBundleByName("Residential - Basic Prepaid Bundle");

            SelectOffersForYourAccount selectOffersForYourAccount = confirmAccountBundleChoice.clickOk();
            EnterYourSubscriptionDetails enterYourSubscriptionDetails = selectOffersForYourAccount.clickContinue();

            enterYourSubscriptionDetails.enterDefaultIdentityAddressPhoneEmail(uniqueUserTimeStamp);
            SelectOffersForYourSubscriber selectOfferForYourSubscriber = enterYourSubscriptionDetails.clickOk();
            ConfigureOffers configureOffers = selectOfferForYourSubscriber.clickContinue();
            ConfigureBalance configureBalance = configureOffers.clickContinueExpectingConfigureBalance();
            configureBalance.configureBalance("Voice Night/Weekend Shared", "50");
            ChooseAccessories chooseAccessories = configureBalance.clickContinue();
            MyBasket myBasket = chooseAccessories.clickContinue();
            TermsAndConditions termsAndConditions = myBasket.clickCheckOutExpectingTermsAndConditions();

            CheckoutRegister checkoutRegister = termsAndConditions.clickOkExpectingCheckoutRegister();

            SignUpUser signUpUser = checkoutRegister.selectSignMeUpAndClickContinue();
            CustomerDetails customerDetails = signUpUser.enterMandatoryFieldsOnlyAndClickSignMeUp(uniqueUserTimeStamp);

            CheckOutBillingAccountInformation checkOutBillingAccountInformation = customerDetails.clickOk();
            checkOutBillingAccountInformation.enterBankCode(uniqueUserTimeStamp);
            checkOutBillingAccountInformation.enterBankAccountNumber(uniqueUserTimeStamp);
            checkOutBillingAccountInformation.enterOwnerLastName("LN" + uniqueUserTimeStamp);

            CheckoutReview checkOutReview = checkOutBillingAccountInformation.clickContinue();
            CheckoutConfirmation checkOutConfirmation = checkOutReview.clickContinue();
            SearchOrders searchOrders = checkOutConfirmation.clickOk();
            searchOrders.clickRequests();

            searchOrders.waitUntilOrderCompletedOrFailed();

            SubscriberDetail subscriberDetail = searchOrders.clickDashbaord();

            Common.assertTextOnPage(tool, "DIY - Super-Pack");
            ViewBalances viewBalances = subscriberDetail.clickBalances();

            Common.assertTextOnPage(tool, "Units used from account balance");
            configureBalance = viewBalances.clickConfigure();
            configureBalance.setSpendingLimit("limitName", "120");
            configureBalance.selectTargetAccount("Night and Weekend Minutes");
            ConfigureBalanceReview configureBalanceReview = configureBalance.clickConfigureBalance();
            configureBalanceReview.clickConfirm();
            Common.assertTextOnPage(tool, "Your request to configure balance has been processed successfully");
            viewBalances = configureBalanceReview.clickBack();
            Common.assertTextNotOnPage(tool, "Unlimited");

            // More validation steps to be added.
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
