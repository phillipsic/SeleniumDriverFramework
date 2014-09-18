/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class UAM0130_Reactivate_login extends CSSTest {
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
    public void testUAM0130_Reactivate_login() throws Exception {

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

            String tempPassword = viewHierarchy.addEmployeeTelcoRetailerSubscriber(uniqueCode);

            ContactInformation contactInformation = viewHierarchy.clickEmployeeNameLink("FN" + uniqueCode, "LN" + uniqueCode);
            Common.assertTextEquals("First Name: FN" + uniqueCode, contactInformation.getFirstName());
            Common.assertTextEquals("Last Name: LN" + uniqueCode, contactInformation.getLastName());
            LoginInformation loginInformation = contactInformation.clickViewLoginInformationLink();
            Common.assertTextEquals("Telco Retailer Subscriber", loginInformation.getCurrentRoleFromPage());

            DeactivateLogin deactivateLogin = loginInformation.clickDeactivateLogin();
            deactivateLogin.clickConfirm();

            myShapeChannel = loginInformation.clickLogout();
            myShapeChannel.clickHomePage();
            User user2 = new TelcoRetailerAdmin();
            user2.setNewLogin(uniqueCode);
            user2.setNewPassword(tempPassword);
            myShapeChannel.unsuccessfulLogin(user2);

            Common.assertTextEquals("Your login has been deactivated", myShapeChannel.getMessage());

            myShapeChannel.clickAdminLogin(application);
            myShapeChannel.loginToPOSAsTelcoAdmin(user);
            searchRetailer = welcomeToYourWorkspace.clickManageRetailer();
            searchRetailer.setDealerName("*");
            searchRetailer.clickSearchDealerName();
            viewHierarchy = searchRetailer.clickDealerLink("Dealer 1");

            contactInformation = viewHierarchy.clickEmployeeNameLink("FN" + uniqueCode, "LN" + uniqueCode);
            loginInformation = contactInformation.clickViewLoginInformationLink();

            ActivateLogin activateLogin = loginInformation.clickActivateLogin();
            ModifyLoginPassword modifyLoginPassword = activateLogin.clickConfirm();

            EnableLogin enableLogin = modifyLoginPassword.clickOkToEnableLogin();

            String newPassword = enableLogin.getNewPassword();
            user2.setNewPassword(newPassword);

            loginInformation = enableLogin.clickOk();
            loginInformation.clickLogout();
            myShapeChannel.clickHomePage();
            myShapeChannel.successfulLogin(user2);

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
