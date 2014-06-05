package com.comverse.css.b2c.prob;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2C;

public class PROB0103_Create_Case extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testPROB0103_Create_Case() throws Exception {

        try {
            launchCSSApplication();
            String login = Common.getB2CLoginName();
            String password = Common.getB2CPassword();

            HomePage homePage = new HomePage(driver);
            homePage.enterUsername(login);
            homePage.enterPassword(password);
            SubscriberDetail subscriberDetail = homePage.clickLogIn();

            Common.assertTextOnPage(driver, "Welcome");

            ListCases listCases = subscriberDetail.clickSupport();
            AddCase addCase = listCases.clickCreateCase();

            addCase.selectCategory("Service Problem");
            addCase.selectSubCategory("Calls Dropped");
            addCase.enterDescription("Case Description entered by PROB0103 test");
            addCase.selectSubjectRelativeToProblemSubscriber();
            addCase.selectFirstSubscriber();
            AddCaseReview addCaseReview = addCase.clickSubmit();

            AddCaseConfirmation addCaseConfirmation = addCaseReview.clickCreateCase();
            String newCaseID = addCaseConfirmation.getCaseID();
            addCase = addCaseConfirmation.clickOk();

            listCases = addCase.clickListCases();
            listCases.clickOnCaseIDLink(newCaseID);

            assertTrue(Common.isTextOnPageWithRegex(driver, "Reference:\\s*" + newCaseID));
            assertTrue(Common.isTextOnPageWithRegex(driver, "Status:\\s*New"));
            assertTrue(Common.isTextOnPageWithRegex(driver, "Reporting Person:\\s*" + "FN" + login.toLowerCase()));
            assertTrue(Common.isTextOnPageWithRegex(driver, "Affected Person:\\s*" + "FN" + login.toLowerCase()));
            assertTrue(Common.isTextOnPageWithRegex(driver, "Type:\\s*Service Problem"));
            assertTrue(Common.isTextOnPageWithRegex(driver, "Problem area:\\s*Calls Dropped"));
            assertTrue(Common.isTextOnPageWithRegex(driver, "Case Description entered by PROB0103 test"));

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
