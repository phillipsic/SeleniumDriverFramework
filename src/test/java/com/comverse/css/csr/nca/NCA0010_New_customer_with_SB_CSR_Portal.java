package com.comverse.css.csr.nca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.csr.*;
import com.comverse.css.data.SB.SB_ResidentialUltraPostpaidBundle;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class NCA0010_New_customer_with_SB_CSR_Portal extends CSSTest {
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
    public void testNCA0010_New_customer_with_SB_CSR_Portal() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            SB_ResidentialUltraPostpaidBundle sb_ResidentialUltraPostpaidBundle = new SB_ResidentialUltraPostpaidBundle();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();

            enterIdentificationData.enterDefaultIdentificationData();
            Shopping shopping = enterIdentificationData.clickContinue();

            shopping.filterSubscriberBundlePrimaryOfferByName(sb_ResidentialUltraPostpaidBundle.getOfferName());
            shopping.clickSubscriberBundlePrimaryOfferName(sb_ResidentialUltraPostpaidBundle.getOfferName());
            ConfigureContractDetails configureContractDetails = shopping.clickSelectOfferInPopUpWindowExpectingConfigureContract();

            configureContractDetails.setSpendingLimit(sb_ResidentialUltraPostpaidBundle.getPO_ResidentialUltraPostpaid().getBAL_GPRS_WAP_INTERNET().getBalanceName(),
                    sb_ResidentialUltraPostpaidBundle.getPO_ResidentialUltraPostpaid().getBAL_GPRS_WAP_INTERNET().getBalanceValue());
            MyBasket myBasket = configureContractDetails.clickContinue();
            myBasket.assign3InventoriesFirstOffer(subscriber);

            CheckoutReview checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();

            String orderNumber = checkoutConfirmation.getOrderNumberFromPage();
            workSpace = checkoutConfirmation.clickOk();
            SearchRequests searchRequests = workSpace.clickRequests();
            SearchOrders searchOrders = searchRequests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailedWithGetAccountID(orderNumber, enterIdentificationData.getAccount());

            Common.storeLastNamePostpaidAccount(enterIdentificationData.getAccount().getBillingLastNameProperty(), "Created by -" + this.getClass().getSimpleName());

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
