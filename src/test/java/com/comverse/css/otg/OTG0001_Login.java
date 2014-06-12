package com.comverse.css.otg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Prep;
import com.comverse.css.data.Person.CMP;
import com.comverse.data.apps.OTG;

public class OTG0001_Login extends CSSTest {

    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new OTG();

    }

    @Test
    public void testOTG0001_Login() throws Exception {

        try {
            CMP cmp = new CMP();

            launchOTGApplication();
            OTGHome otg = new OTGHome(tool, test, user);

            AccountDashboard act = otg.loginToOTGAsCOP();
            act.verifyPageWelcome();
            otg.clickLogout();

            SubscriberDashboard sub = otg.loginToOTGAsCUP(cmp.getSubscriber().getSubscriberMSISDNProperty());
            sub.verifyPageMobileNumber(cmp.getSubscriber().getSubscriberMSISDNProperty());
            otg.clickLogout();

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
