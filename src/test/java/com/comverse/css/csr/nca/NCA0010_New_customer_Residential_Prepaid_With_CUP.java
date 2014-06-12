package com.comverse.css.csr.nca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.csr.*;
import com.comverse.css.data.PO.PO_ResidentialBasicPrepaid;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class NCA0010_New_customer_Residential_Prepaid_With_CUP extends CSSTest {
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
    public void testNCA0010_New_customer_Residential_Prepaid_With_CUP() throws Exception {
        try {
            PO_ResidentialBasicPrepaid po_ResidentialBasicPrepaid = new PO_ResidentialBasicPrepaid();
            launchCSSApplicationAndSSOLogin();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();

            enterIdentificationData.enterDefaultIdentificationData();

            Shopping shopping = enterIdentificationData.clickContinue();

            shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialBasicPrepaid.getOfferName());
            MyBasket myBasket = shopping.clickSelectOfferInPopUpWindow();

            myBasket.addConsumerUserPersonOrdering();
            myBasket.assign3InventoriesFirstOffer(subscriber);

            CheckoutReview checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();

            String orderNumber = checkoutConfirmation.getOrderNumberFromPage();
            workSpace = checkoutConfirmation.clickOk();
            SearchRequests searchRequests = workSpace.clickRequests();
            SearchOrders searchOrders = searchRequests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailedWithGetAccountID(orderNumber, enterIdentificationData.getAccount());
            workSpace = searchOrders.clickHomeMenu();
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            CustomerSearchResult customerSearchResult = manageAccount.searchByAccountLastNameMultiplePersons(enterIdentificationData.getAccount().getBillingLastNameProperty());
            AccountDetails AccountDetailsCommon = customerSearchResult.clickPersonNameLink(enterIdentificationData.getPerson().getPersonLastNameProperty());
            String accountNumber = AccountDetailsCommon.getAccountNumber();
            Common.storeLastNameAndAccountNumberPrepaidAccount(enterIdentificationData.getAccount().getBillingLastNameProperty(), accountNumber, "Created by "
                    + this.getClass().getSimpleName());
            Common.storeSubscriberMSISDN(subscriber.getSubscriberMSISDNProperty(), "Created by " + this.getClass().getSimpleName());

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
