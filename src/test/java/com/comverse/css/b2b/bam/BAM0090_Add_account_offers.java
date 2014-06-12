package com.comverse.css.b2b.bam;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2b.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.AO.AO_ResidentialSNRegionAccountOffer;
import com.comverse.data.apps.B2B;
import com.comverse.data.users.B2BAdmin;

public class BAM0090_Add_account_offers extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2B();
        user = new B2BAdmin();
    }

    @Test
    public void testBAM0090_Add_account_offers() throws Exception {

        try {
            AO_ResidentialSNRegionAccountOffer ao_ResidentialSNRegionAccountOffer = new AO_ResidentialSNRegionAccountOffer();
            launchCSSApplication();

            MyshapeBusiness loginPage = new MyshapeBusiness(tool, test, user);
            WorkSpace workSpace = loginPage.loginToB2B(user);

            AccountDetails accountDetails = workSpace.clickAccount();

            SelectOffersForYourAccount selectOffersForYourAccount = accountDetails.clickAddNewAccountOffer();
            selectOffersForYourAccount.selectAccountOfferByName(ao_ResidentialSNRegionAccountOffer.getOfferName());
            MyBasket myBasket = selectOffersForYourAccount.clickContinueNoConfiguration();
            CheckoutReview checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();

            accountDetails = checkoutConfirmation.clickAccounts();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilBizFirstRequestCompletedOrFailed();

            Common.sleepForNumberOfSeconds(30);
            accountDetails = requestsForCustomer.clickAccounts();

            accountDetails.clickLinkOfOfferName(ao_ResidentialSNRegionAccountOffer.getOfferName());

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
