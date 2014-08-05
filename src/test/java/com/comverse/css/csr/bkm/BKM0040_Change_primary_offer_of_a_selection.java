package com.comverse.css.csr.bkm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.css.data.SB.SB_ResidentialBasicPrepaidBundle;
import com.comverse.css.data.SB.SB_ResidentialUltraPostpaidBundle;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class BKM0040_Change_primary_offer_of_a_selection extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testBKM0040_Change_primary_offer_of_a_selection() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            SB_ResidentialBasicPrepaidBundle sb_ResidentialBasicPrepaidBundle = new SB_ResidentialBasicPrepaidBundle();
            SB_ResidentialUltraPostpaidBundle sb_ResidentialUltraPostpaidBundle = new SB_ResidentialUltraPostpaidBundle();
            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            enterIdentificationData.enterDefaultIdentificationData();
            Shopping shopping = enterIdentificationData.clickContinue();

            shopping.clickSubscriberBundlePrimaryOfferName(sb_ResidentialBasicPrepaidBundle.getOfferName());

            MyBasket myBasket = shopping.clickSelectOfferInPopUpWindow();

            Common.assertTextOnPage(tool, sb_ResidentialBasicPrepaidBundle.getOfferName());

            shopping = myBasket.changePrimaryOffer();
            shopping.filterSubscriberBundlePrimaryOfferByName(sb_ResidentialUltraPostpaidBundle.getOfferName());
            shopping.clickSubscriberBundlePrimaryOfferName(sb_ResidentialUltraPostpaidBundle.getOfferName());

            ConfigureContractDetails configureContractDetails = shopping.clickSelectOfferInPopUpWindowExpectingConfigureContract();
            configureContractDetails.setSpendingLimit(sb_ResidentialUltraPostpaidBundle.getPO_ResidentialUltraPostpaid().getBAL_GPRS_WAP_INTERNET().getBalanceName(),
                    sb_ResidentialUltraPostpaidBundle.getPO_ResidentialUltraPostpaid().getBAL_GPRS_WAP_INTERNET().getBalanceValue());

            
            //@TODO  Need to remove this IF.  We should not have IF's in the code.  Also, the xpath is unreadable.
            if (tool.isElementPresentByXPath("xpath=//*[contains(@id, 'Subscriber DetailsBlock') and contains(@style, 'display: none;')]")) {
                tool.clickUsingCssSelector("img.floatLeft");
            }

            configureContractDetails.setLang("French (Standard)");
            myBasket = configureContractDetails.clickContinue();

            Common.assertTextNotOnPage(tool, sb_ResidentialBasicPrepaidBundle.getOfferName());
            Common.assertTextOnPage(tool, sb_ResidentialUltraPostpaidBundle.getOfferName());

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