package com.comverse.css.b2b.bkm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2b.*;
import com.comverse.css.common.*;
import com.comverse.css.data.PO.PO_BusinessUltraPostpaid;
import com.comverse.data.apps.B2B;
import com.comverse.data.users.B2BAdmin;

public class BKM0010_View_and_manage_basket extends CSSTest {
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
    public void testBKM0010_View_and_manage_basket() throws Exception {

        try {
            PO_BusinessUltraPostpaid po_BusinessUltraPostpaid = new PO_BusinessUltraPostpaid();
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

            myBasket.clickCartIcon();
            myBasket.clickViewBasket();

            // assertEquals("Owner", myBasket.getTypeRole());

            assertTrue(myBasket.getOfferName().matches(po_BusinessUltraPostpaid.getOfferName() + "[\\s\\S]*$"));
            assertEquals("1", myBasket.getQuantity());
            assertEquals("$ " + po_BusinessUltraPostpaid.getRC() + " Monthly", myBasket.getRecurringCharge());
            assertEquals("$ " + po_BusinessUltraPostpaid.getNRC(), myBasket.getUpfrontCharge());

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