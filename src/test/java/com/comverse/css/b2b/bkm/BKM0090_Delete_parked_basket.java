package com.comverse.css.b2b.bkm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2b.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2B;
import com.comverse.data.users.B2BAdmin;

public class BKM0090_Delete_parked_basket extends CSSTest {
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
    public void testBKM0090_Delete_parked_basket() throws Exception {

        try {
            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();
            // Subscriber subscriber = new Subscriber(uniqueTimeStamp);
            String PRIMARY_OFFER = "Business - Marketing Offer";

            MyshapeBusiness loginPage = new MyshapeBusiness(tool, test, user);
            WorkSpace workSpace = loginPage.loginToB2B(user);

            AccountDetails accountDetails = workSpace.clickAccount();
            CustomerAcquisitionCustomerDataReview customerAcquisitionCustomerDataReview = accountDetails.clickNewConvergentSubscriberOnExistingAccount();
            Shopping shopping = customerAcquisitionCustomerDataReview.clickContinue();

            shopping.clickSubscriberBundlePrimaryOfferName(PRIMARY_OFFER);
            MyBasket myBasket = shopping.clickSelectOfferInPopUpWindow();
            // myBasket.assign3InventoriesFirstOffer(subscriber);

            myBasket.clickCartIcon();
            ParkTheCurrentBasket parkTheCurrentBasket = myBasket.clickParkBasket();

            parkTheCurrentBasket.enterBasketID(uniqueTimeStamp);
            parkTheCurrentBasket.clickOk();
            Common.assertTextOnPage(tool, "The basket has been parked successfully .");

            workSpace = parkTheCurrentBasket.clickOkExpectingWorkSpace();
            ResumeAParkedBasket resumeAParkedBasket = workSpace.clickViewParkedBaskets();

            DeleteBasketConfirm deleteBasketConfirm = resumeAParkedBasket.deleteParkedBasket(uniqueTimeStamp);
            resumeAParkedBasket = deleteBasketConfirm.clickOk();
            Common.assertTextNotOnPage(tool, uniqueTimeStamp);

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
