package com.comverse.css.csr.prs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.css.data.PO.PO_ResidentialBasicPrepaid;
import com.comverse.css.data.PO.PO_ResidentialPostpaidwithOptionalEmail;
import com.comverse.css.data.SB.SB_OneVoiceSubscriberBundle;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class PRS0030_Browse_and_select_Primary_Offers_Subscriber_Bundles extends CSSTest {
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
    public void testPRS0030_Browse_and_select_Primary_Offers_Subscriber_Bundles() throws Exception {
        try {
            SB_OneVoiceSubscriberBundle sb_OneVoiceSubscriberBundle = new SB_OneVoiceSubscriberBundle();
            PO_ResidentialPostpaidwithOptionalEmail po_ResidentialPostpaidwithOptionalEmail = new PO_ResidentialPostpaidwithOptionalEmail();
            PO_ResidentialBasicPrepaid po_ResidentialBasicPrepaid = new PO_ResidentialBasicPrepaid();
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            enterIdentificationData.enterDefaultIdentificationData();
            Shopping shopping = enterIdentificationData.clickContinue();

            shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialBasicPrepaid.getOfferName());
            MyBasket myBasket = shopping.clickSelectOfferInPopUpWindow();
            shopping = myBasket.clickContinueShopping();

            shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialPostpaidwithOptionalEmail.getOfferName());

            ConfigureBalance configureBalance = shopping.clickSelectOfferInPopUpWindowExpectingConfigureBalance();

            configureBalance.setSpendingLimit(po_ResidentialPostpaidwithOptionalEmail.getBAL_GPRS_WAP_INTERNET().getBalanceName(), po_ResidentialPostpaidwithOptionalEmail
                    .getBAL_GPRS_WAP_INTERNET().getBalanceValue());
            configureBalance.clickContinueExpectingMyBasket();

            Common.assertTextOnPage(tool, po_ResidentialBasicPrepaid.getOfferName());
            Common.assertTextOnPage(tool, po_ResidentialPostpaidwithOptionalEmail.getOfferName());

            shopping = myBasket.clickContinueShopping();

            shopping.clickSubscriberBundlePrimaryOfferName(sb_OneVoiceSubscriberBundle.getOfferName());
            myBasket = shopping.clickSelectOfferInPopUpWindow();

            Common.assertTextOnPage(tool, po_ResidentialBasicPrepaid.getOfferName());
            Common.assertTextOnPage(tool, po_ResidentialPostpaidwithOptionalEmail.getOfferName());
            Common.assertTextOnPage(tool, sb_OneVoiceSubscriberBundle.getOfferName());

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
