package com.comverse.css.csr.uam;

import com.comverse.common.User;
import com.comverse.css.OCM.LoginPage;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.TelcoAdmin;
import com.comverse.sec.ComverseOneSingleSignOn;

public class UAM0070_Unlock_login extends CSSTest {

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
    public void testUAM0070_Unlock_login() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String uniqueCode = Common.generateTimeStamp();

            WorkSpace workSpace = new WorkSpace(tool, test, user);
            ViewHierarchy viewHierarchy = workSpace.clickManageTelco();

            User OCMUser = viewHierarchy.addOCMPublisherEmployee(uniqueCode);

            ContactInformation contactInformation = viewHierarchy.clickEmployeeNameLink("FN" + uniqueCode, "LN" + uniqueCode);
            assertEquals("First Name: FN" + uniqueCode, contactInformation.getFirstName());
            assertEquals("Last Name: LN" + uniqueCode, contactInformation.getLastName());
            LoginInformation loginInformation = contactInformation.clickViewLoginInformationLink();
            assertEquals(OCMUser.getRole(), loginInformation.getCurrentRoleFromPage());

            LockLogin lockLogin = loginInformation.clickLockLogin();
            lockLogin.clickConfirm();
            loginInformation = lockLogin.clickOk();

            ComverseOneSingleSignOn comverseOneSingleSignOn = loginInformation.clickLogoutExpectingSSO();

            launchOCMApplication();
            LoginPage loginPage = new LoginPage(tool, test, OCMUser);
            loginPage.loginToOCMAndFail(OCMUser);

            Common.assertTextOnPage(tool, "User account is locked");

            launchCSSApplicationAndSSOLogin();
            viewHierarchy = workSpace.clickManageTelco();

            contactInformation = viewHierarchy.clickEmployeeNameLink("FN" + uniqueCode, "LN" + uniqueCode);
            loginInformation = contactInformation.clickViewLoginInformationLink();

            UnlockLogin unlockLogin = loginInformation.clickUnLockLogin();
            UnlockDone unlockDone = unlockLogin.clickConfirm();

            ModifyLoginPassword modifyLoginPassword = unlockDone.clickChangePassword();
            unlockLogin = modifyLoginPassword.clickOkToModifyPassword();

            OCMUser.setNewPassword(unlockLogin.getNewPassword());
            loginInformation = unlockLogin.clickOK();
            loginInformation.clickLogoutExpectingSSO();

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
