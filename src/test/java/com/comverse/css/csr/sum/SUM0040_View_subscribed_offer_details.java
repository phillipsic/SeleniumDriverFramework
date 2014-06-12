package com.comverse.css.csr.sum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.commonpages.AccountDetailsCommon;
import com.comverse.css.commonpages.IdentifyCustomerCommon;
import com.comverse.css.commonpages.SubscriberDetailsCommon;
import com.comverse.css.csr.WorkSpace;
import com.comverse.css.data.SO.SO_PromotionOneFreeVoiceMinuteForEvery4minutesOffnetFor30days;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRUser;

public class SUM0040_View_subscribed_offer_details extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRUser();
    }

    @Test
    public void testSUM0040_View_subscribed_offer_details() throws Exception {
        try {
            SO_PromotionOneFreeVoiceMinuteForEvery4minutesOffnetFor30days so_PromotionOneFreeVoiceMinuteForEvery4minutesOffnetFor30days = new SO_PromotionOneFreeVoiceMinuteForEvery4minutesOffnetFor30days();
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCAResidentialBasicPrepaidBundleCSR();

            IdentifyCustomerCommon identifyCustomer = workSpace.gotoManageAccount();

            AccountDetailsCommon accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetailsCommon subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            subscriberDashboard.clickImageOfPromotionalOfferName(so_PromotionOneFreeVoiceMinuteForEvery4minutesOffnetFor30days.getOfferName());

            Common.assertTextOnPage(tool, so_PromotionOneFreeVoiceMinuteForEvery4minutesOffnetFor30days.getOfferName());

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
