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

public class UAM0030_Change_password extends CSSTest {
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
    public void testUAM0030_Change_password() throws Exception {
        try {
            String uniqueCode = Common.generateTimeStamp();
            String firstPassword = "Passw0rd!";
            String secondPassword = "Sonora01!";

            launchCSSApplication();

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            myShapeChannel.clickAdminLogin(application);
            WelcomeToYourWorkspace welcomeToYourWorkspace = myShapeChannel.loginToPOSAsTelcoAdmin(user);

            SearchRetailer searchRetailer = welcomeToYourWorkspace.clickManageRetailer();
            searchRetailer.setDealerName("*");
            searchRetailer.clickSearchDealerName();
            ViewHierarchy viewHierarchy = searchRetailer.clickDealerLink("Dealer 1");

            String tempPassword = viewHierarchy.addEmployeeTelcoRetailerSubscriber(uniqueCode);

            myShapeChannel = viewHierarchy.clickLogout();
            myShapeChannel.clickHomePage();
            User user2 = new TelcoRetailerAdmin();
            user2.setNewLogin(uniqueCode);
            user2.setNewPassword(tempPassword);

            myShapeChannel.successfulLogin(user2);

            myShapeChannel.setYourPassword(tempPassword);
            myShapeChannel.setNewPassword(firstPassword);
            myShapeChannel.setConfirmNewPassword(firstPassword);
            myShapeChannel.setSecretAnswer(firstPassword);
            myShapeChannel.clickChange();

            WorkSpace workSpace = myShapeChannel.clickAgreeTermsAndConditions();
            ContactInformation contactInformation = workSpace.clickUserInformation();
            LoginInformation loginInformation = contactInformation.clickViewLoginInformationLink();
            ChangePassword changePassword = loginInformation.clickChangePassword();

            changePassword.setYourPassword(firstPassword);
            changePassword.setNewPassword(secondPassword);
            changePassword.setConfirmNewPassword(secondPassword);
            ModifyLoginPassword modifyLoginPassword = changePassword.clickChange();
            modifyLoginPassword.clickOk();
            myShapeChannel = modifyLoginPassword.clickLogout();
            myShapeChannel.clickHomePage();

            myShapeChannel.setUserName(uniqueCode);
            myShapeChannel.setPassword(secondPassword);
            myShapeChannel.clickLogin();
            workSpace = myShapeChannel.clickAgreeTermsAndConditions();

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
