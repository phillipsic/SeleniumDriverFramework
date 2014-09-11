package com.comverse.css.csr.uam;

import com.comverse.common.Application;
import com.comverse.css.b2c.ConfirmModifyProfileInformation;
import com.comverse.css.b2c.CustomerProfile;
import com.comverse.css.b2c.HomePage;
import com.comverse.css.b2c.ModifyProfileInformation;
import com.comverse.css.b2c.SearchMember;
import com.comverse.css.b2c.SubscriberDetail;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.B2C;
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

            // Now login with accounts so we don't have to change paswords in other tests.
            String cup_login = Common.getCUPB2CLogin();
            String cup_password = Common.getCUPB2CPassword(cup_login);
            String cup_newPassword = "Pa$$w0rd";
            String cop_newPassword = "Pa$$w0rd";
            String cop_login = Common.getCOPB2CLogin();
            String cop_password = Common.getCOPB2CPassword(cop_login);

            Application B2Capplication = new B2C();
            launchAnotherCSSApplication(B2Capplication);

            HomePage homePage = new HomePage(tool, test, user);

            homePage.enterUsername(cop_login);
            homePage.enterPassword(cop_password);

            homePage.clickLogInExpectingChangePassword();
            homePage.enterOldPassword(cop_password);
            homePage.enterNewPassword(cop_newPassword);
            homePage.enterNewConfirmPassword(cop_newPassword);
            homePage.enterChangePasswordSecretAnswer(cop_newPassword);
            SubscriberDetail subscriberDetail = homePage.clickChangeExpectingSubscriberDetail();

            Common.assertTextOnPage(tool, "Welcome");

            SearchMember searchMember = subscriberDetail.clickMyInformationTab();

            CustomerProfile customerProfile = searchMember.clickChangeProfile();
            ModifyProfileInformation modifyProfileInformation = customerProfile.clickModify();

            modifyProfileInformation.selectApprovalSequencing("Yes");
            ConfirmModifyProfileInformation confirmModifyProfileInformation = modifyProfileInformation.clickOK();

            confirmModifyProfileInformation.clickOK();

            confirmModifyProfileInformation.clickLogout();

            homePage.clickHomePage();
            homePage.enterUsername(cup_login);
            homePage.enterPassword(cup_password);

            System.out.print(cup_login + "/" + cup_password);
            homePage.clickLogInExpectingChangePassword();
            homePage.enterOldPassword(cup_password);
            homePage.enterNewPassword(cup_newPassword);
            homePage.enterNewConfirmPassword(cup_newPassword);
            homePage.enterChangePasswordSecretAnswer(cup_newPassword);
            homePage.clickChange();

            Common.storeCUPLoginAndPassword(lastNameOfCUP.toLowerCase(), cop_newPassword, "Created by UAM0200_Add_Login_To_Persona");
            Common.storeCOPLoginAndPassword(lastNameOfCOP.toLowerCase(), cup_newPassword, "Created by UAM0200_Add_Login_To_Persona");

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
