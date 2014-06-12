package com.comverse.css.b2b.cm;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2b.ListCases;
import com.comverse.css.b2b.MyshapeBusiness;
import com.comverse.css.b2b.ViewCase;
import com.comverse.css.b2b.WorkSpace;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2B;
import com.comverse.data.users.B2BAdmin;

public class CM0025_View_existing_cases_and_details extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2B();
        user = new B2BAdmin();
    }

    @Test
    public void testCM0025_View_existing_cases_and_details() throws Exception {
        try {
            launchCSSApplication();
            MyshapeBusiness loginPage = new MyshapeBusiness(tool, test, user);
            WorkSpace workSpace = loginPage.loginToB2B(user);

            ListCases listCases = workSpace.clickCustomerCare();
            listCases.clickSearch();
            ViewCase viewCase = listCases.clickFirstCase();

            assertTrue(viewCase.getCaseType().matches("^[\\s\\S]*Service Problem[\\s\\S]*$"));
            assertTrue(viewCase.getCaseProblemArea().matches("^[\\s\\S]*Poor Quality - Wired Services[\\s\\S]*$"));
            assertTrue(viewCase.getCaseDescription().matches("^[\\s\\S]*This was created by automated test PBM61_Create_case_b2b.[\\s\\S]*$"));

            viewCase.clickBackExpectingListCases();

            test.setResult("pass");
        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            verificationErrors.append(e.getMessage());
            throw e;
        }

    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
