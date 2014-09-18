package com.comverse.css.csr.uam;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.common.User;
import com.comverse.css.OCM.LoginPage;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.TelcoAdmin;

/**
 * @author mkumar
 */
public class UAM0130_Reactivate_login extends CSSTest {

    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new TelcoAdmin();
    }

    @Test
    public void testUAM0130_Reactivate_login() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String uniqueCode = Common.generateTimeStamp();

            WorkSpace workSpace = new WorkSpace(tool, test, user);
            ViewHierarchy viewHierarchy = workSpace.clickManageTelco();

            User OCMUser = viewHierarchy.addOCMPublisherEmployee(uniqueCode);

            ContactInformation contactInformation = viewHierarchy.clickEmployeeNameLink("FN" + uniqueCode, "LN" + uniqueCode);
            Common.assertTextEquals("First Name: FN" + uniqueCode, contactInformation.getFirstName());
            Common.assertTextEquals("Last Name: LN" + uniqueCode, contactInformation.getLastName());
            LoginInformation loginInformation = contactInformation.clickViewLoginInformationLink();
            Common.assertTextEquals(OCMUser.getRole(), loginInformation.getCurrentRoleFromPage());

            DeactivateLogin deactivateLogin = loginInformation.clickDeactivateLogin();
            deactivateLogin.clickConfirm();

            loginInformation.clickLogoutExpectingSSO();

            launchOCMApplication();
            LoginPage loginPage = new LoginPage(tool, test, OCMUser);
            loginPage.loginToOCMAndFail(OCMUser);

            Common.assertTextOnPage(tool, "User is disabled");

            launchCSSApplicationAndSSOLogin();
            viewHierarchy = workSpace.clickManageTelco();

            contactInformation = viewHierarchy.clickEmployeeNameLink("FN" + uniqueCode, "LN" + uniqueCode);
            loginInformation = contactInformation.clickViewLoginInformationLink();
            ActivateLogin activateLogin = loginInformation.clickActivateLogin();

            LoginActivated loginActivated = activateLogin.clickConfirmExpectingLoginActivated();
            ModifyLoginPassword modifyLoginPassword = loginActivated.clickChangePassword();
            modifyLoginPassword.clickOk();
            OCMUser.setNewPassword(modifyLoginPassword.getNewPassword());

            modifyLoginPassword.clickLogoutExpectingSSO();

            launchOCMApplication();
            loginPage.loginToOCMAndChangePassword(OCMUser);

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
