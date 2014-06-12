package com.comverse.css.csr.uam;

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
            String role = "OCM Publisher";
            WorkSpace workSpace = new WorkSpace(tool, test, user);
            ViewHierarchy viewHierarchy = workSpace.clickManageTelco();

            viewHierarchy.addOCMPublisherEmployee(uniqueCode);

            ContactInformation contactInformation = viewHierarchy.clickEmployeeNameLink("FN" + uniqueCode, "LN" + uniqueCode);
            assertEquals("First Name: FN" + uniqueCode, contactInformation.getFirstName());
            assertEquals("Last Name: LN" + uniqueCode, contactInformation.getLastName());
            LoginInformation loginInformation = contactInformation.clickViewLoginInformationLink();
            assertEquals(role, loginInformation.getCurrentRoleFromPage());

            LockLogin lockLogin = loginInformation.clickLockLogin();
            lockLogin.clickConfirm();
            loginInformation = lockLogin.clickOk();

            loginInformation.clickLogoutExpectingSSO();

            viewHierarchy = workSpace.clickManageTelco();

            contactInformation = viewHierarchy.clickEmployeeNameLink("FN" + uniqueCode, "LN" + uniqueCode);
            loginInformation = contactInformation.clickViewLoginInformationLink();

            UnlockLogin unlockLogin = loginInformation.clickUnLockLogin();
            unlockLogin.clickConfirm();
            // ChangePassword changePassword = unlockDone.clickChangePassword();

            // changePassword.setYourPassword(preparation.readUsersPasswordFromIniFile("TelcoAdmin"));
            // ModifyLoginPassword modifyLoginPassword =
            // changePassword.clickChange();
            // modifyLoginPassword.clickOk();
            // String newPassword = modifyLoginPassword.getNewPassword();
            // myshapeCSRPortal = modifyLoginPassword.clickLogout();

            // myshapeCSRPortal.successfulLogin(uniqueCode, newPassword);

            // test.setResult("pass");

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
