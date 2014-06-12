package com.comverse.css.pos.uam;

import static org.junit.Assert.assertEquals;

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

public class UAM0040_Reset_password_of_another_user extends CSSTest {
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
    public void testUAM0040_Reset_password_of_another_user() throws Exception {

        try {
            String uniqueCode = Common.generateTimeStamp();

            launchCSSApplication();

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            myShapeChannel.clickAdminLogin(application);
            WelcomeToYourWorkspace welcomeToYourWorkspace = myShapeChannel.loginToPOSAsTelcoAdmin(user);

            SearchRetailer searchRetailer = welcomeToYourWorkspace.clickManageRetailer();
            searchRetailer.setDealerName("*");
            searchRetailer.clickSearchDealerName();
            ViewHierarchy viewHierarchy = searchRetailer.clickDealerLink("Dealer 1");
            viewHierarchy.addEmployeeTelcoRetailerAdministrator(uniqueCode);

            ContactInformation contactInformation = viewHierarchy.clickEmployeeNameLink("FN" + uniqueCode, "LN" + uniqueCode);
            assertEquals("First Name: FN" + uniqueCode, contactInformation.getFirstName());
            assertEquals("Last Name: LN" + uniqueCode, contactInformation.getLastName());
            LoginInformation loginInformation = contactInformation.clickViewLoginInformationLink();
            assertEquals("Telco Retailer Administrator", loginInformation.getCurrentRoleFromPage());

            ModifyLoginPassword modifyLoginPassword = loginInformation.clickChangePasswordOfAnotherUser();

            modifyLoginPassword.clickOk();
            String newPassword = modifyLoginPassword.getNewPassword();

            myShapeChannel = modifyLoginPassword.clickLogout();

            myShapeChannel.clickHomePage();
            User user2 = new TelcoRetailerAdmin();
            user2.setNewLogin(uniqueCode);
            user2.setNewPassword(newPassword);
            myShapeChannel.successfulLogin(user2);

            myShapeChannel.setYourPassword(newPassword);
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
