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

public class PRS0020_Get_account_pre_requisite_criteria extends CSSTest {
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
    public void testPRS0020_Get_account_pre_requisite_criteria() throws Exception {
        try {
            launchCSSApplication();
            String PRIMARY_OFFER = "Residential - Ultra Postpaid";

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            workSpace.clickBrowseCatalog();
            Common.assertTextOnPage(tool, "Please enter the following attributes");
            Common.assertTextOnPage(tool, "Customer Context");
            Common.assertTextOnPage(tool, "Customer prerequisite information");
            workSpace.selectCustomerType("TestAccount");
            Shopping shopping = workSpace.clickSubmit();
            Common.assertTextOnPage(tool, "Subscriber Bundles/Primary Offers");
            shopping.filterSubscriberBundlePrimaryOfferByName(PRIMARY_OFFER);
            Common.assertTextOnPage(tool, "No records found.");

            workSpace.clickHome();

            workSpace.clickBrowseCatalog();
            Common.assertTextOnPage(tool, "Please enter the following attributes");
            Common.assertTextOnPage(tool, "Customer Context");
            Common.assertTextOnPage(tool, "Customer prerequisite information");
            workSpace.selectCustomerType("Residential");
            shopping = workSpace.clickSubmit();
            Common.assertTextOnPage(tool, "Subscriber Bundles/Primary Offers");
            shopping.filterSubscriberBundlePrimaryOfferByName(PRIMARY_OFFER);
            Common.assertTextOnPage(tool, PRIMARY_OFFER);
            shopping.clickSubscriberBundlePrimaryOfferName(PRIMARY_OFFER);
            Common.assertTextOnPage(tool, "Primary Offer Details");

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