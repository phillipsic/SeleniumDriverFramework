package com.comverse.css.csr.sum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.css.data.SO.SO_2010WorldCupSoccerNews;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class SUM0155_Modify_subscriber_offers extends CSSTest {
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
    public void testSUM0155_Modify_subscriber_offers() throws Exception {
        try {
            SO_2010WorldCupSoccerNews so_2010WorldCupSoccerNews = new SO_2010WorldCupSoccerNews();
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCAResidentialBasicPrepaidBundleCSR();

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();

            AccountDetails accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            subscriberDashboard.doAddSO(so_2010WorldCupSoccerNews.getOfferName());
            ModifyOfferParameters modifyOfferParameters = subscriberDashboard.clickModifyOfferParameters();
            modifyOfferParameters.enterVoiceMailSize("512");
            modifyOfferParameters.checkVoiceMailEnableToNo();
            test.setBugId("CBS00160248");
            ModifyItemOfSubscriber modifyItemOfSubscriber = modifyOfferParameters.clickModify();
            test.setBugId("NoBug");

            ModifyItem modifyItem = modifyItemOfSubscriber.clickConfirm();
            modifyItem.clickOK();
            subscriberDashboard.clickAccountIDFromNavigationPanel();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
            requestsForCustomer.clickToSubscriberDashboard();

            modifyOfferParameters = subscriberDashboard.clickModifyOfferParameters();

            Common.assertTextEquals("512", modifyOfferParameters.getVoiceMailSize());

            test.setResult("pass");

        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            e.printStackTrace();
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
