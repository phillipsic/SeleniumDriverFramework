package com.comverse.css.b2b.bkm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2b.*;
import com.comverse.css.common.*;
import com.comverse.css.data.PO.PO_BusinessBasicConverged;
import com.comverse.css.data.PO.PO_BusinessUltraPostpaid;
import com.comverse.data.apps.B2B;
import com.comverse.data.users.B2BAdmin;

public class BKM0040_Change_primary_offer_of_a_selection extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2B();
        user = new B2BAdmin();
    }

    @Test
    public void testBKM0040_Change_primary_offer_of_a_selection() throws Exception {

        try {
            PO_BusinessUltraPostpaid po_BusinessUltraPostpaid = new PO_BusinessUltraPostpaid();
            PO_BusinessBasicConverged po_BusinessBasicConverged = new PO_BusinessBasicConverged();

            String uniqueTimeStamp = Common.generateTimeStamp();
            new Subscriber(uniqueTimeStamp);

            launchCSSApplication();

            MyshapeBusiness loginPage = new MyshapeBusiness(tool, test, user);
            WorkSpace workSpace = loginPage.loginToB2B(user);

            AccountDetails accountDetails = workSpace.clickAccount();
            CustomerAcquisitionCustomerDataReview customerAcquisitionCustomerDataReview = accountDetails.clickNewConvergentSubscriberOnExistingAccount();
            Shopping shopping = customerAcquisitionCustomerDataReview.clickContinue();

            shopping.clickSubscriberBundlePrimaryOfferName(po_BusinessUltraPostpaid.getOfferName());
            MyBasket myBasket = shopping.clickSelectOfferInPopUpWindow();

            Common.assertTextOnPage(tool, po_BusinessUltraPostpaid.getOfferName());
            Common.assertTextOnPage(tool, po_BusinessUltraPostpaid.getNRC());
            Common.assertTextOnPage(tool, po_BusinessUltraPostpaid.getRC());

            shopping = myBasket.changePrimaryOffer();

            shopping.clickSubscriberBundlePrimaryOfferName(po_BusinessBasicConverged.getOfferName());
            myBasket = shopping.clickSelectOfferInPopUpWindow();

            Common.assertTextNotOnPage(tool, po_BusinessUltraPostpaid.getOfferName());
            Common.assertTextNotOnPage(tool, po_BusinessUltraPostpaid.getNRC());
            Common.assertTextNotOnPage(tool, po_BusinessUltraPostpaid.getRC());

            Common.assertTextOnPage(tool, po_BusinessBasicConverged.getOfferName());
            Common.assertTextOnPage(tool, po_BusinessBasicConverged.getNRC());
            Common.assertTextOnPage(tool, po_BusinessBasicConverged.getRC());

            test.setResult("pass");

        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            verificationErrors.append(e.getMessage());
            throw e;
        }
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
