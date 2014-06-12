package com.comverse.css.csr.uam;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.ContactInformation;
import com.comverse.css.csr.LoginInformation;
import com.comverse.css.csr.ViewHierarchy;
import com.comverse.css.csr.WelcomeToYourPersonalizedWorkspace;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.TelcoAdmin;

public class UAM0100_Get_forgotten_password extends CSSTest {
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
    public void testUAM0100_Get_forgotten_password() throws Exception {
        try {
            String uniqueCode = Common.generateTimeStamp();

            launchCSSApplicationAndSSOLogin();
            String role = "OCM Publisher";

            WelcomeToYourPersonalizedWorkspace personalizedWorkSpace = new WelcomeToYourPersonalizedWorkspace(tool, test, user);
            ViewHierarchy viewHierarchy = personalizedWorkSpace.clickManageTelco();

            viewHierarchy.addEmployee(uniqueCode, role);

            ContactInformation contactInformation = viewHierarchy.clickEmployeeNameLink("FN" + uniqueCode, "LN" + uniqueCode);
            assertEquals("First Name: FN" + uniqueCode, contactInformation.getFirstName());
            assertEquals("Last Name: LN" + uniqueCode, contactInformation.getLastName());
            LoginInformation loginInformation = contactInformation.clickViewLoginInformationLink();
            assertEquals("Telco CSR Admin", loginInformation.getCurrentRoleFromPage());
            loginInformation.clickLogoutExpectingSSO();

            // myshapeCSRPortal.successfulLogin(uniqueCode, tempPassword);
            //
            // myshapeCSRPortal.setYourPassword(tempPassword);
            // myshapeCSRPortal.setNewPassword("Passw0rd!");
            // myshapeCSRPortal.setConfirmNewPassword("Passw0rd!");
            // myshapeCSRPortal.setSecretAnswer("Passw0rd!");
            // WorkSpace workSpace = myshapeCSRPortal.clickChange();
            // myshapeCSRPortal = workSpace.clickLogout();
            // myshapeCSRPortal.clickHomePage();
            // myshapeCSRPortal.setUserName(uniqueCode);
            // myshapeCSRPortal.clickForgotYourPassword();
            //
            // bugId = "CBS00145964";
            // myshapeCSRPortal.setSecretAnswer("Passw0rd!");
            // bugId = "NoBug";
            // myshapeCSRPortal.clickOk();
            // tempPassword = myshapeCSRPortal.getTempPasswordFromPage();
            // myshapeCSRPortal.successfulLogin(uniqueCode, tempPassword);
            //
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
