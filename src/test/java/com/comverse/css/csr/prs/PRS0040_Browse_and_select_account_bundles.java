package com.comverse.css.csr.prs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.EnterIdentificationData;
import com.comverse.css.csr.SelectOffersForYourSubscriber;
import com.comverse.css.csr.Shopping;
import com.comverse.css.csr.WorkSpace;
import com.comverse.css.data.AB.AB_DIYeExtendedInteractionTVSuperPack;
import com.comverse.css.data.AO.AO_DIYeExtendedInteractivityYourAccount;
import com.comverse.css.data.SO.SO_DIYeSportsCoupons;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class PRS0040_Browse_and_select_account_bundles extends CSSTest {
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
    public void testPRS0040_Browse_and_select_account_bundles() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            AB_DIYeExtendedInteractionTVSuperPack ab_DIYeExtendedInteractionTVSuperPack = new AB_DIYeExtendedInteractionTVSuperPack();
            AO_DIYeExtendedInteractivityYourAccount ao_DIYeExtendedInteractivityYourAccount = new AO_DIYeExtendedInteractivityYourAccount();
            SO_DIYeSportsCoupons so_DIYeSportsCoupons = new SO_DIYeSportsCoupons();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            enterIdentificationData.enterDefaultIdentificationData();
            Shopping shopping = enterIdentificationData.clickContinue();

            shopping.clickAccountBundlesTab();

            SelectOffersForYourSubscriber selectOffersForYourSubscriber = shopping.subscribeToAccountBundlelSubscriberSelectiveOfferByNameExpectingSelectOffersForSubscriber(
                    ab_DIYeExtendedInteractionTVSuperPack.getOfferName(), ao_DIYeExtendedInteractivityYourAccount.getOfferName(), ab_DIYeExtendedInteractionTVSuperPack
                            .getSB_DIYeExtendedInteractionTVSuperBundle().getOfferName());
            selectOffersForYourSubscriber.selectOffersForSubscriber(so_DIYeSportsCoupons.getOfferName());

            selectOffersForYourSubscriber.clickContinueExpectingMyBasket();

            Common.assertTextOnPage(tool, ab_DIYeExtendedInteractionTVSuperPack.getOfferName());

            Common.assertTextOnPage(tool, ao_DIYeExtendedInteractivityYourAccount.getOfferName());

            Common.assertTextOnPage(tool, ab_DIYeExtendedInteractionTVSuperPack.getSB_DIYeExtendedInteractionTVSuperBundle().getOfferName());
            Common.assertTextOnPage(tool, so_DIYeSportsCoupons.getOfferName());

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
