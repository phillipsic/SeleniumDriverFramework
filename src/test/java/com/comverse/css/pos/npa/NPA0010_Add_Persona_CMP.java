package com.comverse.css.pos.npa;

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

public class NPA0010_Add_Persona_CMP extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @Test
    public void testNPA0010_Add_Persona_CMP() throws Exception {

        try {
            launchCSSApplication();

            String uniqueString = Common.generateTimeStamp();
            String accountLastname = Common.getLastNameOfPostPaidAccount();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastname);

            String accountNumber = accountDetails.getAccountNumber();

            PersonManagement personManagement = accountDetails.clickPersonManagement();

            // CUP with ordering
            personManagement.clickPersonAdd();

            personManagement.selectTitle("Mrs.");
            personManagement.setFirstName("F1N" + uniqueString);
            personManagement.setLastName("L1N" + uniqueString);
            personManagement.setAddressLine1("A1D" + uniqueString);
            personManagement.setPostalCode("COP1postcode");
            personManagement.setCity("COP1city");
            personManagement.selectCountry("United States");
            personManagement.selectRegion("Alaska");

            personManagement.clickAccountManager();
            personManagement.clickAdd();

            String cleanPageSource = Common.returnCleanPageSource(tool);

            Common.assertVerifyTrue(tool, cleanPageSource.matches(".*F1N" + uniqueString + " L1N" + uniqueString + accountNumber + ".*Customer Manager PersonActive.*"));

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
