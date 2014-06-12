package com.comverse.css.pos.prs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.MyShapeChannel;
import com.comverse.css.pos.Shopping;
import com.comverse.css.pos.WorkSpace;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class PRS0010_Browse_catalog_to_inform extends CSSTest {
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
    public void testPRS0010_Browse_catalog_to_inform() throws Exception {

        try {
            launchCSSApplication();
            String PRIMARY_OFFER = "Residential - Basic Prepaid";

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);
            workSpace.clickBrowseCatalog();
            workSpace.selectCustomerType("Residential");

            Shopping shopping = workSpace.clickSubmit();

            shopping.filterSubscriberBundlePrimaryOfferByName(PRIMARY_OFFER);
            shopping.clickSubscriberBundlePrimaryOfferName(PRIMARY_OFFER);

            Common.assertTextOnPage(tool, "Total RC:$ 10.00 Weekly");
            Common.assertTextOnPage(tool, "Total NRC:  $ 10.00");
            Common.assertTextOnPage(tool, "Service Category:GSM Mobile");
            Common.assertTextOnPage(tool, "Engagement Duration:None");

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