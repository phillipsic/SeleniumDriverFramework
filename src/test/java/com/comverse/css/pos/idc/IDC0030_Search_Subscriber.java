package com.comverse.css.pos.idc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.IdentifyCustomer;
import com.comverse.css.pos.MyShapeChannel;
import com.comverse.css.pos.WorkSpace;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class IDC0030_Search_Subscriber extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @Test
    public void testIDC0030_Search_Subscriber() throws Exception {

        try {
            launchCSSApplication();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            workSpace.doResitdentialNCAResidentialUltraPostpaidPOS();

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
