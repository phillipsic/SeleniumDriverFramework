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

public class BKM0080_Resume_a_parked_basket extends CSSTest {
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
    public void testBKM0080_Resume_a_parked_basket() throws Exception {

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

            myBasket.clickCartIcon();
            ParkTheCurrentBasket parkTheCurrentBasket = myBasket.clickParkBasket();

            parkTheCurrentBasket.enterBasketID(uniqueTimeStamp);
            parkTheCurrentBasket.clickOk();
            Common.assertTextOnPage(tool, "The basket has been parked successfully");

            parkTheCurrentBasket.goToHome();

            ResumeAParkedBasket resumeAParkedBasket = workSpace.clickViewParkedBaskets();

            ResumeBasketConfirm resumeBasketConfirm = resumeAParkedBasket.resumeParkedBasket(uniqueTimeStamp);
            myBasket = resumeBasketConfirm.clickOk();

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
