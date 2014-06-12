package com.comverse.css.b2b.cm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2b.ListCases;
import com.comverse.css.b2b.MyshapeBusiness;
import com.comverse.css.b2b.WorkSpace;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2B;
import com.comverse.data.users.B2BAdmin;

public class CM0005_List_Cases extends CSSTest {
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
    public void testCM0005_List_Cases() throws Exception {
        try {
            launchCSSApplication();

            MyshapeBusiness loginPage = new MyshapeBusiness(tool, test, user);
            WorkSpace workSpace = loginPage.loginToB2B(user);

            ListCases listCases = workSpace.clickCustomerCare();
            listCases.clickSearch();

            Common.assertTextOnPage(tool, "case(s) found");
            Common.assertTextOnPage(tool, "Reference");
            Common.assertTextOnPage(tool, "Att.");
            Common.assertTextOnPage(tool, "External Id");
            Common.assertTextOnPage(tool, "Creation date");
            Common.assertTextOnPage(tool, "Modification date");
            Common.assertTextOnPage(tool, "Type");
            Common.assertTextOnPage(tool, "Problem Area");
            Common.assertTextOnPage(tool, "Account ID");
            Common.assertTextOnPage(tool, "Subscriber ID");
            Common.assertTextOnPage(tool, "Other item");
            Common.assertTextOnPage(tool, "Description");
            Common.assertTextOnPage(tool, "Status");
            Common.assertTextOnPage(tool, "Justification Status");

            listCases.clickSearch();
            listCases.clickFirstCase();

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
