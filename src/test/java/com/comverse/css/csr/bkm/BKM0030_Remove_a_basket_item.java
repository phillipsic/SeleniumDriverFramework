package com.comverse.css.csr.bkm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.css.data.PO.PO_ResidentialBasicPrepaid;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class BKM0030_Remove_a_basket_item extends CSSTest {
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
    public void testBKM0030_Remove_a_basket_item() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();
            PO_ResidentialBasicPrepaid po_ResidentialBasicPrepaid = new PO_ResidentialBasicPrepaid();
            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            enterIdentificationData.enterDefaultIdentificationData();
            Shopping shopping = enterIdentificationData.clickContinue();

            shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialUltraPostpaid.getOfferName());
            ConfigureBalance configureBalance = shopping.clickSelectOfferInPopUpWindowExpectingConfigureBalance();
            configureBalance.setSpendingLimit(po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET().getBalanceName(), po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET()
                    .getBalanceValue());
            MyBasket myBasket = configureBalance.clickContinueExpectingMyBasket();

            Common.assertTextOnPage(tool, po_ResidentialUltraPostpaid.getOfferName());
            Common.assertTextNotOnPage(tool, po_ResidentialBasicPrepaid.getOfferName());

            myBasket.clickContinueShopping();
            shopping.filterSubscriberBundlePrimaryOfferByName(po_ResidentialBasicPrepaid.getOfferName());
            shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialBasicPrepaid.getOfferName());
            myBasket = shopping.clickSelectOfferInPopUpWindow();

            Common.assertTextOnPage(tool, po_ResidentialUltraPostpaid.getOfferName());
            Common.assertTextOnPage(tool, po_ResidentialBasicPrepaid.getOfferName());

            RemoveSelection removeSelection = myBasket.removeSecondItemFromBasket();
            myBasket = removeSelection.clickYes();

            Common.assertTextOnPage(tool, po_ResidentialUltraPostpaid.getOfferName());
            Common.assertTextNotOnPage(tool, po_ResidentialBasicPrepaid.getOfferName());

            removeSelection = myBasket.removeFirstItemFromBasket();
            myBasket = removeSelection.clickYes();

            Common.assertTextOnPage(tool, "Your basket is empty");

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
