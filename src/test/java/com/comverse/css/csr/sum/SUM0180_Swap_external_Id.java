package com.comverse.css.csr.sum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.commonpages.*;
import com.comverse.css.csr.WorkSpace;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class SUM0180_Swap_external_Id extends CSSTest {
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
    public void testSUM0180_Swap_external_Id() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCAResidentialBasicPrepaidBundleCSR();

            IdentifyCustomerCommon identifyCustomer = workSpace.gotoManageAccount();

            AccountDetailsCommon accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetailsCommon subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            SubscriberIdentifiersSwapCommon subscriberIdentifiersSwap = subscriberDashboard.clickSubscriberIdentifiersSwap();
            ConfigureServiceConnectionDetailsCommon configureServiceConnectionDetails = subscriberIdentifiersSwap.clickSwapMSISDNInventory();
            SwapSubscriberExternalIdConfirmationCommon swapSubscriberExternalIdConfirmation = configureServiceConnectionDetails
                    .clickContinueExpectingSwapSubscriberExternalIdConfirmation();
            swapSubscriberExternalIdConfirmation.setNewMSISDNInventory(workSpace.subscriber);
            SubscriberExternalIDSwapDoneCommon subscriberExternalIDSwapDone = swapSubscriberExternalIdConfirmation.clickContinue();
            subscriberExternalIDSwapDone.clickOK();
            subscriberDashboard.clickAccountIDFromNavigationPanel();
            RequestsForCustomerCommon requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
            requestsForCustomer.clickToSubscriberDashboard();

            Common.assertTextOnPage(tool, workSpace.subscriber.getSubscriberMSISDNProperty());

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
