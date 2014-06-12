package com.comverse.css.otg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.OTG;

public class OTG0040_Bills extends CSSTest {

    private StringBuffer verificationErrors = new StringBuffer();
    Prep preparation;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new OTG();

    }

    @Test
    public void testOTG0040_Bills() throws Exception {

        try {
            launchOTGApplication();
            OTGHome otg = new OTGHome(tool, test, user);

            AccountDashboard act = otg.loginToOTGAsCOP();
            MyBills myBills = act.clickMyBills();
            myBills.verifyMyBills();
            myBills.clickPDFInvoice();
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
