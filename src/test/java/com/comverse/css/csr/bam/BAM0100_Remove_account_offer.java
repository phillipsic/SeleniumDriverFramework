package com.comverse.css.csr.bam;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.css.data.AO.AO_ResidentialSNRegionAccountOffer;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class BAM0100_Remove_account_offer extends CSSTest {
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
    public void testBAM0100_Remove_account_offer() throws Exception {
        try {
            AO_ResidentialSNRegionAccountOffer ao_ResidentialSNRegionAccountOffer = new AO_ResidentialSNRegionAccountOffer();
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCAResidentialUltraPostpaidCSR();

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(workSpace.getAccount().getBillingLastNameProperty());

            SelectOffersForYourAccount selectOffersForYourAccount = accountDetails.clickAddNewAccountOffer();
            selectOffersForYourAccount.selectAccountOfferByName(ao_ResidentialSNRegionAccountOffer.getOfferName());
            MyBasket myBasket = selectOffersForYourAccount.clickContinueNoConfiguration();
            CheckoutReview checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();

            accountDetails = checkoutConfirmation.clickAccounts();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();

            accountDetails = requestsForCustomer.clickAccounts();
            accountDetails.clickLinkOfOfferName(ao_ResidentialSNRegionAccountOffer.getOfferName());
            accountDetails.clickCloseOfferDetailsBox();
            RemoveOffer removeOffer = accountDetails.clickRemoveFirstAccountOffer();
            OfferCancellation offerCancellation = removeOffer.clickYes();
            accountDetails = offerCancellation.clickOk();
            requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();

            accountDetails = requestsForCustomer.clickAccounts();
            accountDetails.clickRefreshThisAccount();
            Common.assertTextOnPage(tool, "No offer or bundle on the account!");

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
