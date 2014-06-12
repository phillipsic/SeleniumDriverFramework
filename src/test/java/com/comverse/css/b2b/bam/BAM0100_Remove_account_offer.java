package com.comverse.css.b2b.bam;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2b.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.AO.AO_BonusPointAccountOffer;
import com.comverse.data.apps.B2B;
import com.comverse.data.users.B2BAdmin;

public class BAM0100_Remove_account_offer extends CSSTest {
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
    public void testBAM0100_Remove_account_offer() throws Exception {

        try {
            // AO_ResidentialSNRegionAccountOffer
            // ao_ResidentialSNRegionAccountOffer = new
            // AO_ResidentialSNRegionAccountOffer();
            AO_BonusPointAccountOffer ao_BonusPointAccountOffer = new AO_BonusPointAccountOffer();
            launchCSSApplication();

            MyshapeBusiness loginPage = new MyshapeBusiness(tool, test, user);
            WorkSpace workSpace = loginPage.loginToB2B(user);

            AccountDetails accountDetails = workSpace.clickAccount();

            SelectOffersForYourAccount selectOffersForYourAccount = accountDetails.clickAddNewAccountOffer();
            selectOffersForYourAccount.selectAccountOfferByName(ao_BonusPointAccountOffer.getNewOfferName());
            MyBasket myBasket = selectOffersForYourAccount.clickContinueNoConfiguration();
            CheckoutReview checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();

            accountDetails = checkoutConfirmation.clickAccounts();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilBizFirstRequestCompletedOrFailed();

            Common.sleepForNumberOfSeconds(30);
            accountDetails = requestsForCustomer.clickAccounts();

            accountDetails.clickLinkOfOfferName(ao_BonusPointAccountOffer.getNewOfferName());
            accountDetails.clickCloseOfferDetailsBox();

            RemoveOffer removeOffer = accountDetails.clickRemoveAccountOffer(ao_BonusPointAccountOffer.getNewOfferName());
            OfferCancellation offerCancellation = removeOffer.clickYes();
            accountDetails = offerCancellation.clickOk();

            requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilBizFirstRequestCompletedOrFailed();

            Common.sleepForNumberOfSeconds(30);
            accountDetails = requestsForCustomer.clickAccounts();

            // Common.assertTextOnPage(tool,
            // "No offer or bundle on the account!");
            Common.assertTextNotOnPage(tool, ao_BonusPointAccountOffer.getNewOfferName());

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
