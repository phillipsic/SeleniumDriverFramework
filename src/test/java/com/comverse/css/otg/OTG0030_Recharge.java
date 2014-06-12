package com.comverse.css.otg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Prep;
import com.comverse.css.data.Person.CUP;
import com.comverse.data.apps.OTG;

public class OTG0030_Recharge extends CSSTest {

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
    public void testOTG0030_Recharge() throws Exception {

        try {
            CUP cup = new CUP();
            int rechargeAmount = 1;

            launchOTGApplication();
            OTGHome otg = new OTGHome(tool, test, user);

            AccountDashboard act = otg.loginToOTGAsCOP();
            SubscriberDashboard sub = act.enterThirdSubscriber(cup.getSubscriber().getSubscriberMSISDNProperty());
            int remainingCredits = sub.getRemainingCredits();
            sub.clickRecharge();
            sub.clickOther();
            sub.setFreeAmount(rechargeAmount);
            sub.clickConfirm();
            sub.verifyNewRemainingCredits(remainingCredits + rechargeAmount);

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
