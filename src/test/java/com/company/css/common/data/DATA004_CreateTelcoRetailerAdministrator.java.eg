package com.company.css.common.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.framework.common.AlreadyRunException;
import com.framework.app.common.AppTest;
import com.framework.app.common.Prep;
import com.company.css.pos.MyShapeChannel;
import com.company.css.pos.SearchRetailer;
import com.company.css.pos.ViewHierarchy;
import com.company.css.pos.WelcomeToYourWorkspace;
import com.company.data.apps.POS;
import com.company.data.users.TelcoAdmin;
import com.company.data.users.TelcoRetailerAdmin;

public class DATA004_CreateTelcoRetailerAdministrator extends AppTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoAdmin();
    }

    @AppTest
    public void testDATA004_CreateTelcoRetailerAdministrator() throws Exception {

        try {
            launchApplication();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            loginPage.clickAdminLogin(application);
            WelcomeToYourWorkspace welcomeToYourWorkspace = loginPage.loginToPOSAsTelcoAdmin(user);
            SearchRetailer searchRetailer = welcomeToYourWorkspace.clickManageRetailer();
            searchRetailer.setDealerName("*");
            searchRetailer.clickSearchDealerName();
            ViewHierarchy viewHierarchy = searchRetailer.clickDealerLink("Dealer 1");

            user = new TelcoRetailerAdmin();
            String futurPassword = user.getPassword();
            String tempPassword = viewHierarchy.addEmployeeTelcoRetailerAdministrator(user.getLogin());
            user.setNewPassword(tempPassword);

            MyShapeChannel myShapeChannel = viewHierarchy.clickLogout();
            myShapeChannel.clickHomePage();

            myShapeChannel.successfulLogin(user);
            myShapeChannel.setYourPassword(user.getPassword());
            user.setNewPassword(futurPassword);
            myShapeChannel.setNewPassword(user.getPassword());
            myShapeChannel.setConfirmNewPassword(user.getPassword());
            myShapeChannel.setSecretAnswer(user.getPassword());
            myShapeChannel.clickChange();
            myShapeChannel.clickContinue();

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
