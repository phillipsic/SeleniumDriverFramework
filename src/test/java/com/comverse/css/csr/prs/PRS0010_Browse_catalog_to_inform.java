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
import com.comverse.css.data.PO.PO_ResidentialBasicPrepaid;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class PRS0010_Browse_catalog_to_inform extends CSSTest {

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
    public void testPRS0010_Browse_catalog_to_inform() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            PO_ResidentialBasicPrepaid po_ResidentialBasicPrepaid = new PO_ResidentialBasicPrepaid();

            WorkSpace workSpace = new WorkSpace(tool, test, user);
            workSpace.clickBrowseCatalog();
            workSpace.selectCustomerType(po_ResidentialBasicPrepaid.getOfferCustomerType());

            Shopping shopping = workSpace.clickSubmit();

            shopping.filterSubscriberBundlePrimaryOfferByName(po_ResidentialBasicPrepaid.getOfferName());
            shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialBasicPrepaid.getOfferName());

            Common.assertTextOnPage(tool, "Total RC:$ 10.00 Weekly");
            Common.assertTextOnPage(tool, "Total NRC:  $ 10.00");
            Common.assertTextOnPage(tool, "Service Category:" + po_ResidentialBasicPrepaid.getOfferNetworkType());
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
