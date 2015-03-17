package com.comverse.css.common.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.framework.common.AlreadyRunException;
import com.framework.app.common.CSSTest;
import com.framework.app.common.Prep;
import com.comverse.css.pos.MyShapeChannel;
import com.comverse.css.pos.SearchRetailer;
import com.comverse.css.pos.ViewHierarchy;
import com.comverse.css.pos.WelcomeToYourWorkspace;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoAdmin;
import com.comverse.data.users.TelcoRetailerUser;

public class DATA005_CreateTelcoRetailerSubscriber extends CSSTest {
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
    public void testDATA005_CreateTelcoRetailerSubscriber() throws Exception {

        try {
            launchCSSApplication();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            loginPage.clickAdminLogin(application);
            WelcomeToYourWorkspace welcomeToYourWorkspace = loginPage.loginToPOSAsTelcoAdmin(user);
            SearchRetailer searchRetailer = welcomeToYourWorkspace.clickManageRetailer();
            searchRetailer.setDealerName("*");
            searchRetailer.clickSearchDealerName();
            ViewHierarchy viewHierarchy = searchRetailer.clickDealerLink("Dealer 1");

            user = new TelcoRetailerUser();
            String futurPassword = user.getPassword();
            String tempPassword = viewHierarchy.addEmployeeTelcoRetailerSubscriber(user.getLogin());
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
