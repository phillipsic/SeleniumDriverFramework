package com.comverse.css.pos.uam;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.common.User;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoAdmin;
import com.comverse.data.users.TelcoRetailerAdmin;

public class UAM0080_Register_login extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoAdmin();
    }

    @Test
    public void testUAM0080_Register_login() throws Exception {

        try {
            launchCSSApplication();
            String uniqueCode = Common.generateTimeStamp();

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            myShapeChannel.clickAdminLogin(application);
            WelcomeToYourWorkspace welcomeToYourWorkspace = myShapeChannel.loginToPOSAsTelcoAdmin(user);

            SearchRetailer searchRetailer = welcomeToYourWorkspace.clickManageRetailer();
            searchRetailer.setDealerName("*");
            searchRetailer.clickSearchDealerName();
            ViewHierarchy viewHierarchy = searchRetailer.clickDealerLink("Dealer 1");
            AddEmployeeContactInformation addEmployeeContactInformation = viewHierarchy.clickAddEmployee();

            addEmployeeContactInformation.setFirstName("FN" + uniqueCode);
            addEmployeeContactInformation.setLastName("LN" + uniqueCode);
            addEmployeeContactInformation.enterHomeState("Kentucky");
            AddEmployeeRegisterLogin addEmployeeRegisterLogin = addEmployeeContactInformation.clickContinue();
            AddEmployeeConfirmation addEmployeeConfirmation = addEmployeeRegisterLogin.clickCreateLoginLater();
            RegisterLogin registerLogin = addEmployeeConfirmation.clickOkForRegisterLater();
            viewHierarchy = registerLogin.clickOk();
            ContactInformation contactInformation = viewHierarchy.clickEmployeeNameLink("FN" + uniqueCode, "LN" + uniqueCode);
            LoginInformation loginInformation = contactInformation.clickViewLoginInformationLink();

            registerLogin = loginInformation.clickSetLogin();
            registerLogin.setLogin(uniqueCode);
            registerLogin.clickRadioButtonTelcoRetailerUser();

            registerLogin = registerLogin.clickRegisterLoginContinue();
            registerLogin.clickConfirm();
            String password = registerLogin.getTempPasswordFromPage();
            registerLogin.clickLogout();
            myShapeChannel.clickHomePage();
            User user2 = new TelcoRetailerAdmin();
            user2.setNewLogin(uniqueCode);
            user2.setNewPassword(password);
            myShapeChannel.successfulLogin(user2);

            myShapeChannel.setYourPassword(password);
            myShapeChannel.setNewPassword("Passw0rd!");
            myShapeChannel.setConfirmNewPassword("Passw0rd!");
            myShapeChannel.setSecretAnswer("Passw0rd!");
            myShapeChannel.clickChange();

            myShapeChannel.clickAgreeTermsAndConditions();

            Common.assertTextOnPage(tool, "Welcome to Your Workspace");

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
