package com.comverse.css.csr.prs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.Shopping;
import com.comverse.css.csr.WorkSpace;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class PRS0020_Get_account_pre_requisite_criteria extends CSSTest {
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
    public void testPRS0020_Get_account_pre_requisite_criteria() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.clickBrowseCatalog();
            Common.assertTextOnPage(tool, "Please enter the following attributes");
            Common.assertTextOnPage(tool, "Customer Context");
            Common.assertTextOnPage(tool, "Customer prerequisite information");
            workSpace.selectCustomerType("TestAccount");
            Shopping shopping = workSpace.clickSubmit();
            Common.assertTextOnPage(tool, "Subscriber Bundles/Primary Offers");
            shopping.filterSubscriberBundlePrimaryOfferByName(po_ResidentialUltraPostpaid.getOfferName());
            Common.assertTextOnPage(tool, "No records found.");

            workSpace.clickHome();

            workSpace.clickBrowseCatalog();
            Common.assertTextOnPage(tool, "Please enter the following attributes");
            Common.assertTextOnPage(tool, "Customer Context");
            Common.assertTextOnPage(tool, "Customer prerequisite information");
            workSpace.selectCustomerType(po_ResidentialUltraPostpaid.getOfferCustomerType());
            shopping = workSpace.clickSubmit();
            Common.assertTextOnPage(tool, "Subscriber Bundles/Primary Offers");
            shopping.filterSubscriberBundlePrimaryOfferByName(po_ResidentialUltraPostpaid.getOfferName());
            Common.assertTextOnPage(tool, po_ResidentialUltraPostpaid.getOfferName());
            shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialUltraPostpaid.getOfferName());
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
