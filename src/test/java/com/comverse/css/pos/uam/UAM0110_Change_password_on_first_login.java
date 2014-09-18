package com.comverse.css.pos.uam;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.common.User;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.MyShapeChannel;
import com.comverse.css.pos.SearchRetailer;
import com.comverse.css.pos.ViewHierarchy;
import com.comverse.css.pos.WelcomeToYourWorkspace;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoAdmin;
import com.comverse.data.users.TelcoRetailerAdmin;

public class UAM0110_Change_password_on_first_login extends CSSTest {
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
    public void testUAM0110_Change_password_on_first_login() throws Exception {

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

            String tempPassword = viewHierarchy.addEmployeeTelcoRetailerSubscriber(uniqueCode);

            myShapeChannel = viewHierarchy.clickLogout();
            myShapeChannel.clickHomePage();
            User user2 = new TelcoRetailerAdmin();
            user2.setNewLogin(uniqueCode);
            user2.setNewPassword(tempPassword);
            myShapeChannel.successfulLogin(user2);

            Common.assertTextEquals("You must change your password", myShapeChannel.getChangePasswordOnFirstLoginMessage());
            myShapeChannel.setYourPassword(tempPassword);
            myShapeChannel.setNewPassword("Passw0rd!");
            myShapeChannel.setConfirmNewPassword("Passw0rd!");
            myShapeChannel.setSecretAnswer("Passw0rd!");
            myShapeChannel.clickChange();
            myShapeChannel.clickAgreeTermsAndConditions();

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
