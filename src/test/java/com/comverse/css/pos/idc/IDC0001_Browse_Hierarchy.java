package com.comverse.css.pos.idc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerUser;

public class IDC0001_Browse_Hierarchy extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerUser();
    }

    @Test
    public void testIDC0001_Browse_Hierarchy() throws Exception {

        try {
            launchCSSApplication();
            String accountLastName = Common.getLastNameOfPostPaidAccount();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);
            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();
            AccountDetails accountDetails = identifyCustomer.gotoAccountDashboardUsingAccountLastName("*" + accountLastName);

            Common.assertTextOnPage(tool, accountLastName);

            SubscriberDetails subscriberDetails = accountDetails.clickSubscriberIDFromNavigationPanel();
            subscriberDetails.clickAccountIDFromNavigationPanel();

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
