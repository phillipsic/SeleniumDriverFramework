package com.comverse.css.b2b.bam;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2b.AccountDetails;
import com.comverse.css.b2b.MyshapeBusiness;
import com.comverse.css.b2b.WorkSpace;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2B;
import com.comverse.data.users.B2BAdmin;

public class BAM0010_View_and_manage_account extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2B();
        user = new B2BAdmin();
    }

    @Test
    public void testBAM0010_View_and_manage_account() throws Exception {

        try {
            launchCSSApplication();

            MyshapeBusiness loginPage = new MyshapeBusiness(tool, test, user);
            WorkSpace workSpace = loginPage.loginToB2B(user);

            AccountDetails accountDetails = workSpace.clickAccount();

            Common.assertTextOnPage(tool, "Payment method");
            Common.assertTextOnPage(tool, "Bundle/Offers");
            Common.assertTextOnPage(tool, "Status:");
            Common.assertTextOnPage(tool, "Active Date:");
            Common.assertTextOnPage(tool, "Financial Summary");
            Common.assertTextOnPage(tool, "Billing contact");

            accountDetails.clickNavigate();

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
