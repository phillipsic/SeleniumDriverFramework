package com.comverse.css.pos.nca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.data.PO.PO_ResidentialBasicPrepaid;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class NCA0010_New_Customer_Residential_Prepaid_with_CUP_POS extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @Test
    public void testNCA0010_New_Customer_Residential_Prepaid_with_CUP_POS() throws Exception {
        try {
            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);
            PO_ResidentialBasicPrepaid po_ResidentialBasicPrepaid = new PO_ResidentialBasicPrepaid();

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = myShapeChannel.loginToPOS(user);
            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();

            enterIdentificationData.enterDefaultIdentificationData();
            Shopping shopping = enterIdentificationData.clickContinue();

            Common.assertTextOnPage(tool, po_ResidentialBasicPrepaid.getOfferName());
            shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialBasicPrepaid.getOfferName());
            MyBasket myBasket = shopping.clickSelectOfferInPopUpWindow();

            myBasket.addConsumerUserPersonOrdering();
            myBasket.assign3InventoriesFirstOffer(subscriber);
            CheckoutReview checkoutReview = myBasket.clickCheckOut();

            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();
            String orderNumber = checkoutConfirmation.getNCAOrderNumberFromPage();

            workSpace = checkoutConfirmation.clickOk();
            SearchRequests searchRequests = workSpace.clickRequests();

            SearchOrders searchOrders = searchRequests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailed(orderNumber);
            workSpace = searchOrders.clickHomeMenu();

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();

            CustomerSearchResult customerSearchResult = identifyCustomer.searchByAccountLastNameMultiplePersons(enterIdentificationData.getAccount().getBillingLastNameProperty());
            AccountDetails accountDetails = customerSearchResult.clickPersonNameLink(enterIdentificationData.getPerson().getPersonLastNameProperty());
            String accountNumber = accountDetails.getAccountNumber();

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
