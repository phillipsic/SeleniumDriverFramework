package com.comverse.css.pos.nca;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.data.PO.PO_BusinessUltraPostpaid;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerUser;

/**
 * 
 * In order to be able to provide Business customers in Channel, execute the
 * following queries in CID DB:
 * 
 * INSERT INTO AVL_APP_ORG_TYPE (app_id, use_case_code, org_type_id) VALUES
 * ('3','NCA','19'); commit;
 * 
 * UPDATE VERSIONS SET ITEM_TIMESTAMP = ITEM_TIMESTAMP + 1/86400 WHERE ITEM_CODE
 * = 'REFERENCE_DATA'; commit;
 * 
 */
public class NCA0010_New_Customer_Business_POS extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerUser();
    }

    @Test
    public void testNCA0010_New_Customer_Business_POS() throws Exception {
        try {
            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = myShapeChannel.loginToPOS(user);

            PO_BusinessUltraPostpaid po_BusinessUltraPostpaid = new PO_BusinessUltraPostpaid();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);
            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentBusinessCustomer();

            Common.assertTextOnPage(tool, "Create Empty Account");
            assertFalse(Common.isCheckBoxSelected(tool, "empAccChkbox"));
            enterIdentificationData.enterBusinessAccountIdentificationData();
            Shopping shopping = enterIdentificationData.clickContinue();

            Common.assertTextOnPage(tool, po_BusinessUltraPostpaid.getOfferName());
            shopping.clickSubscriberBundlePrimaryOfferName(po_BusinessUltraPostpaid.getOfferName());
            MyBasket myBasket = shopping.clickSelectOfferInPopUpWindow();

            Common.assertTextOnPage(tool, "Some selections need their service connection to be reconfigured. " + "Please reconfigure the items that are highlighted below.");
            myBasket.assign3InventoriesFirstOffer(subscriber);

            Common.assertTextNotOnPage(tool, "Some selections need their service connection to be reconfigured.");
            CheckoutReview checkoutReview = myBasket.clickCheckOut();

            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();

            Common.assertTextOnPage(tool, "Your order has been submitted.");
            String orderNumber = checkoutConfirmation.getNCAOrderNumberFromPage();
            workSpace = checkoutConfirmation.clickOk();

            SearchRequests searchReuests = workSpace.clickRequests();
            SearchOrders searchOrders = searchReuests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailed(orderNumber);

            Common.storeLastNamePostpaidAccount(enterIdentificationData.getAccount().getBillingLastNameProperty(), "Created by " + this.getClass().getSimpleName());

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