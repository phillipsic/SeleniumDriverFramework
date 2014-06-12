package com.comverse.css.pos.pem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class PEM0500_List_personas extends CSSTest {
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
    public void testPEM0500_List_personas() throws Exception {

        try {
            launchCSSApplication();
            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);
            workSpace.doResitdentialNCAResidentialUltraPostpaidPOS();
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            CustomerSearchResult customerSearchResult = manageAccount.searchByAccountLastNameMultiplePersons(workSpace.getAccount().getBillingLastNameProperty());

            AccountDetails accountDetails = customerSearchResult.clickPersonNameLink(workSpace.getPerson().getPersonLastNameProperty());
            String accountNumber = accountDetails.getAccountNumber();

            accountDetails.clickPersonManagement();
            Person persCOP = workSpace.getPerson();
            Person persCUP = workSpace.getPerson2();

            Common.assertTextOnPage(tool, persCOP.getPersonFirstNameProperty());
            Common.assertTextOnPage(tool, persCOP.getPersonLastNameProperty());
            Common.assertTextOnPage(tool, "Customer Owner Person");
            Common.assertTextOnPage(tool, accountNumber);
            Common.assertTextOnPage(tool, "Active");

            Common.assertTextOnPage(tool, persCUP.getPersonFirstNameProperty());
            Common.assertTextOnPage(tool, persCUP.getPersonLastNameProperty());
            Common.assertTextOnPage(tool, "Customer User: Ordering");
            Common.assertTextOnPage(tool, workSpace.getSubscriber().getSubscriberMSISDNProperty());

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
