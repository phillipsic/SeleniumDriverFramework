package com.comverse.css.pos.pem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class PEM0430_Merge_persons extends CSSTest {
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
    public void testPEM0430_Merge_persons() throws Exception {

        try {
            launchCSSApplication();
            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.searchByPersonLastNameSinglePerson(Common.getPersonLastName());

            PersonManagement personManagement = accountDetails.clickPersonManagement();

            personManagement.addCMP();
            personManagement.clickActions(Common.getPersonFirstName());
            PersonMerge personMerge = personManagement.clickPersonMerge();
            personMerge.setLastName(personManagement.person3.getPersonLastNameProperty());
            personMerge.clickPersonSearch();
            personMerge.clickSelect();

            personMerge.clickOKFromMerge();
            Common.assertTextOnPage(tool, "inactive");

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
