package com.comverse.css.pos.sum;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class SUM0155_Modify_subscriber_offers extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @Test
    public void testSUM0155_Modify_subscriber_offers() throws Exception {

        try {
            String SUPPLEMENTARY_OFFER = "2010 World Cup Soccer News";
            launchCSSApplication();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            workSpace.doResitdentialNCAResidentialBasicPrepaidBundlePOS();

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();

            AccountDetails accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            subscriberDashboard.doAddSO(SUPPLEMENTARY_OFFER);
            ModifyOfferParameters modifyOfferParameters = subscriberDashboard.clickModifyOfferParameters();
            modifyOfferParameters.enterVoiceMailSize("512");
            modifyOfferParameters.checkVoiceMailEnableToNo();
            ModifyItemOfSubscriber modifyItemOfSubscriber = modifyOfferParameters.clickModify();
            ModifyItem modifyItem = modifyItemOfSubscriber.clickConfirm();
            modifyItem.clickOK();
            subscriberDashboard.clickAccountIDFromNavigationPanel();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
            requestsForCustomer.clickToSubscriberDashboard();

            modifyOfferParameters = subscriberDashboard.clickModifyOfferParameters();

            assertEquals("512", modifyOfferParameters.getVoiceMailSize());

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