package com.comverse.css.csr.idc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.commonpages.ClearTheCurrentBasketCommon;
import com.comverse.css.commonpages.EnterIdentificationDataCommon;
import com.comverse.css.csr.WorkSpace;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class IDC0040_Automatically_search_customer_from_external_CTI_client extends CSSTest {
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
    public void testIDC0040_Automatically_search_customer_from_external_CTI_client() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();

            String External_id = Common.getSubscriberMSISDN();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationDataCommon enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            enterIdentificationData.enterDefaultIdentificationData();
            enterIdentificationData.clickContinue();

            ClearTheCurrentBasketCommon clearTheCurrentBasket = enterIdentificationData.enterCTIURL(application, External_id);
            clearTheCurrentBasket.clickOK();

            Common.assertTextOnPage(tool, External_id);

            test.setResult("pass");

        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            // e.printStackTrace();
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
