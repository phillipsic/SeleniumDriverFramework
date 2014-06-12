package com.comverse.css.csr.nca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.csr.*;
import com.comverse.css.data.AB.AB_DIYSuperPack;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class NCA0010_New_customer_with_AB_CSR_Portal extends CSSTest {
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
    public void testNCA0010_New_customer_with_AB_CSR_Portal() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            AB_DIYSuperPack ab_DIYSuperPack = new AB_DIYSuperPack();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();

            enterIdentificationData.setCustomerTitle("Mrs.");
            enterIdentificationData.setCustomerFirstName(uniqueTimeStamp);
            enterIdentificationData.setCustomerLastName(uniqueTimeStamp);
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
            shopping.clickAccountBundlesTab();

            ConfigureContractDetails configureContractDetails = shopping.subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingConfigureContract(
                    ab_DIYSuperPack.getOfferName(), null, ab_DIYSuperPack.getSB_ResidentialUltraPostpaidBundle().getOfferName());

            configureContractDetails.setSpendingLimit(ab_DIYSuperPack.getBAL_VoiceNightWeekendShared().getBalanceName(), ab_DIYSuperPack.getBAL_VoiceNightWeekendShared()
                    .getBalanceValue());
            configureContractDetails.setSpendingLimit(ab_DIYSuperPack.getBAL_VoiceAnytimeShared().getBalanceName(), ab_DIYSuperPack.getBAL_VoiceAnytimeShared().getBalanceValue());
            configureContractDetails.setSpendingLimit(ab_DIYSuperPack.getBAL_GPRS_WAP_INTERNET().getBalanceName(), ab_DIYSuperPack.getBAL_GPRS_WAP_INTERNET().getBalanceValue());

            test.setBugId("CBS00156508");
            MyBasket myBasket = configureContractDetails.clickContinue();
            test.setBugId("NoBug");

            myBasket.assign3InventoriesFirstOffer(subscriber);

            myBasket.clickAcceptTermsAndConditions();
            CheckoutReview checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();

            String orderNumber = checkoutConfirmation.getOrderNumberFromPage();
            workSpace = checkoutConfirmation.clickOk();
            SearchRequests searchRequests = workSpace.clickRequests();
            SearchOrders searchOrders = searchRequests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailed(orderNumber);

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
