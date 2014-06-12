package com.comverse.css.csr.prs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.csr.*;
import com.comverse.css.data.AB.AB_ResidentialEnhanceFamilyAccountBundle;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class PRS0095_Add_account_bundle_for_existing_account extends CSSTest {
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
    public void testPRS0095_Add_account_bundle_for_existing_account() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            AB_ResidentialEnhanceFamilyAccountBundle ab_ResidentialEnhanceFamilyAccountBundle = new AB_ResidentialEnhanceFamilyAccountBundle();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCAResidentialBasicPrepaidBundleCSR();

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();
            AccountDetails accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SwapBundle swapBundle = accountDetails.clickUpgrade();
            swapBundle.clickToAccountBundle(ab_ResidentialEnhanceFamilyAccountBundle.getOfferName());
            swapBundle.clickAdditionalParticipants();
            AccountBundleDistributionConfiguration accountBundleDistributionConfiguration = swapBundle.clickContinue();
            // accountBundleDistributionConfiguration.clickSBSelectiveOffers();

            ConfigureContractDetails configureContractDetails = accountBundleDistributionConfiguration.clickContinue();

            configureContractDetails.setSpendingLimit(ab_ResidentialEnhanceFamilyAccountBundle.getBAL_VoiceNightWeekendShared().getBalanceName(),
                    ab_ResidentialEnhanceFamilyAccountBundle.getBAL_VoiceNightWeekendShared().getBalanceValue());
            configureContractDetails.setSpendingLimit(ab_ResidentialEnhanceFamilyAccountBundle.getBAL_VoiceAnytimeShared().getBalanceName(),
                    ab_ResidentialEnhanceFamilyAccountBundle.getBAL_VoiceAnytimeShared().getBalanceValue());
            configureContractDetails.setSpendingLimit(ab_ResidentialEnhanceFamilyAccountBundle.getBAL_GPRS_WAP_INTERNET().getBalanceName(),
                    ab_ResidentialEnhanceFamilyAccountBundle.getBAL_GPRS_WAP_INTERNET().getBalanceValue());

            ConfigureBalance configureBalance = configureContractDetails.clickContinueExpectingConfigureBalance();

            MyBasket myBasket = configureBalance.clickContinueExpectingMyBasket();

            myBasket.assign3InventoriesFirstOffer(subscriber);
            CheckoutReview checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();
            Common.assertTextOnPage(tool, "Your order has been submitted.");
            accountDetails = checkoutConfirmation.clickOkExpectingAccountDashboard();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.clickSearch();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
            accountDetails = requestsForCustomer.clickAccounts();
            accountDetails.clickRefreshThisAccount();

            Common.assertTextOnPage(tool, ab_ResidentialEnhanceFamilyAccountBundle.getOfferName());

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
