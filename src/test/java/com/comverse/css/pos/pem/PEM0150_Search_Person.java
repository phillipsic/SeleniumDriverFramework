package com.comverse.css.pos.pem;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.AccountDetails;
import com.comverse.css.pos.IdentifyCustomer;
import com.comverse.css.pos.MyShapeChannel;
import com.comverse.css.pos.WorkSpace;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class PEM0150_Search_Person extends CSSTest {
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
    public void testPEM0150_Search_Person() throws Exception {

        try {
            launchCSSApplication();
            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            // CustomerSearchResult customerSearchResult =
            // manageAccount.searchByAccountLastNameMultiplePersons(workSpace.getAccount()
            // .getBillingLastNameProperty());
            AccountDetails accountDetails = manageAccount.searchByPersonLastNameSinglePerson(Common.getPersonLastName());
            assertEquals("Account Details", tool.getTitle(tool));
            accountDetails.clickHomeMenu();
            manageAccount = workSpace.gotoManageAccount();

            accountDetails = manageAccount.searchByPersonFirstNameSinglePerson(Common.getPersonFirstName());
            assertEquals("Account Details", tool.getTitle(tool));
            accountDetails.clickHomeMenu();
            manageAccount = workSpace.gotoManageAccount();

            manageAccount.clickMoreLinkPerson();

            manageAccount.searchByPersonNatioanlIdMultiplePersons("*");
            Common.assertTextOnPage(tool, "Please select the person matching with entered criteria.");
            accountDetails.clickHomeMenu();
            manageAccount = workSpace.gotoManageAccount();

            manageAccount.clickMoreLinkPerson();

            manageAccount.searchByPersonDOBMultiplePersons("03/13/1975");
            Common.assertTextOnPage(tool, "Please select the person matching with entered criteria.");

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
