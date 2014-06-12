package com.comverse.css.csr.idc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.IdentifyCustomer;
import com.comverse.css.csr.WorkSpace;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class IDC0030_Search_Subscriber extends CSSTest {
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
    public void testIDC0030_Search_Subscriber() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCAResidentialUltraPostpaidCSR();

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();

            // Search by MSISDN
            identifyCustomer.searchBySubscriberMSISDNMultiplePersons(workSpace.getSubscriber().getSubscriberMSISDNProperty());
            Common.assertTextOnPage(tool, workSpace.getSubscriber().getSubscriberMSISDNProperty());
            identifyCustomer.clickHome();
            identifyCustomer.gotoManageAccount();

            // Search by MSISDN + Shadow only + Include inactive
            identifyCustomer.clickMoreSubscriberSearchFields();
            identifyCustomer.selectShadowOnly();
            identifyCustomer.checkIncludeInactiveSubscriberID();
            identifyCustomer.searchBySubscriberMSISDNMultiplePersons(workSpace.getSubscriber().getSubscriberMSISDNProperty());
            Common.assertTextOnPage(tool, "No matching subscriber found");

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
