package com.comverse.css.otg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.data.Person.CMP;
import com.comverse.css.data.Person.COP;
import com.comverse.css.data.Person.CUP;
import com.comverse.data.apps.OTG;

public class OTG0010_AccountDashboard extends CSSTest {

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
    public void testOTG0010_AccountDashboard() throws Exception {

        try {
            COP cop = new COP();
            CMP cmp = new CMP();
            CUP cup = new CUP();

            launchOTGApplication();
            OTGHome otg = new OTGHome(tool, test, user);

            AccountDashboard act = otg.loginToOTGAsCOP();
            act.verifyPageWelcome();
            Common.assertTextOnPage(tool, cop.getPersonLastNameProperty());
            System.out.println("Person LN: " + cop.getPersonLastNameProperty());
            Common.assertTextOnPage(tool, cop.getPersonFirstNameProperty());
            System.out.println("Person FN: " + cop.getPersonFirstNameProperty());
            Common.assertTextOnPage(tool, cop.getAccount().getBillingAccountIDProperty());
            System.out.println("Account ID: " + cop.getAccount().getBillingAccountIDProperty());

            act.clickSecondSubscriber();
            Common.assertTextOnPage(tool, cmp.getOffer().getOfferName());
            Common.assertTextOnPage(tool, cmp.getOffer().getOfferDescription());
            Common.assertTextOnPage(tool, cmp.getSubscriber().getSubscriberMSISDNProperty());

            act.clickThirdSubscriber();
            Common.assertTextOnPage(tool, cup.getOffer().getOfferName());
            Common.assertTextOnPage(tool, cup.getOffer().getOfferDescription());
            Common.assertTextOnPage(tool, cup.getSubscriber().getSubscriberMSISDNProperty());

            act.clickFirstSubscriber();
            Common.assertTextOnPage(tool, cop.getOffer().getOfferName());
            Common.assertTextOnPage(tool, cop.getOffer().getOfferDescription());
            Common.assertTextOnPage(tool, cop.getSubscriber().getSubscriberMSISDNProperty());

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
