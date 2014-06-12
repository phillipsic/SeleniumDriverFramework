package com.comverse.css.csr.uam;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRUser;

public class UAM0200_Add_Login_To_Persona extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRUser();
    }

    @Test
    public void testUAM0200_Add_Login_To_Persona() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();

            String lastNameOfCOP;
            String lastNameOfCUP = Common.getLastNameOfOrderingCUP();
            String lastNameOfNonOrderingCUP = Common.getLastNameOfNonOrderingCUP();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();

            AccountDetails accountDetails = manageAccount.searchByPersonLastNameSinglePerson(lastNameOfNonOrderingCUP);

            String accountNumber = accountDetails.getAccountNumber();
            PersonManagement personManagement = accountDetails.clickPersonManagement();
            AddLogin addLogin = personManagement.clickActionsAddLoginForPerson(lastNameOfNonOrderingCUP);

            addLogin.setLogin(lastNameOfNonOrderingCUP);
            addLogin.setPassword("Passw0rd!");
            addLogin.setConfirmPassword("Passw0rd!");

            personManagement = addLogin.clickContinue();

            String cleanPageSource = Common.returnCleanPageSource(tool);

            assertTrue(cleanPageSource.matches(".*" + lastNameOfNonOrderingCUP + accountNumber + ".*Customer User: .*" + lastNameOfNonOrderingCUP.toLowerCase() + "Active.*"));

            Common.storeNonOrderingCUPLoginAndPassword(lastNameOfNonOrderingCUP.toLowerCase(), "Passw0rd!", "Created by UAM0200_Add_Login_To_Persona");

            personManagement.clickHome();
            workSpace.gotoManageAccount();
            accountDetails = manageAccount.searchByPersonLastNameSinglePerson(lastNameOfCUP);

            accountNumber = accountDetails.getAccountNumber();
            accountDetails.clickPersonManagement();
            personManagement.clickActionsAddLoginForPerson(lastNameOfCUP);

            addLogin.setLogin(lastNameOfCUP);
            addLogin.setPassword("Passw0rd!");
            addLogin.setConfirmPassword("Passw0rd!");

            personManagement = addLogin.clickContinue();

            cleanPageSource = Common.returnCleanPageSource(tool);

            assertTrue(cleanPageSource.matches(".*" + lastNameOfCUP + accountNumber + ".*Customer User: .*" + lastNameOfCUP.toLowerCase() + "Active.*"));

            lastNameOfCOP = personManagement.getLastNameOfCOP();
            addLogin = personManagement.clickActionsAddLoginForPerson(lastNameOfCOP);

            addLogin.setLogin(lastNameOfCOP);
            addLogin.setPassword("Passw0rd!");
            addLogin.setConfirmPassword("Passw0rd!");

            personManagement = addLogin.clickContinue();

            cleanPageSource = Common.returnCleanPageSource(tool);

            assertTrue(cleanPageSource.matches(".*" + lastNameOfCOP + accountNumber + ".*Customer Owner .*" + lastNameOfCOP.toLowerCase() + "Active.*"));

            Common.storeCUPLoginAndPassword(lastNameOfCUP.toLowerCase(), "Passw0rd!", "Created by UAM0200_Add_Login_To_Persona");
            Common.storeCOPLoginAndPassword(lastNameOfCOP.toLowerCase(), "Passw0rd!", "Created by UAM0200_Add_Login_To_Persona");

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
