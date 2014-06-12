package com.comverse.css.csr.uam;

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

public class UAM0080_Register_login extends CSSTest {
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
    public void testUAM0080_Register_login() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String uniqueCode = Common.generateTimeStamp();
            // String role = "OCM Publisher";

            WelcomeToYourPersonalizedWorkspace personalizedWorkSpace = new WelcomeToYourPersonalizedWorkspace(tool, test, user);
            ViewHierarchy viewHierarchy = personalizedWorkSpace.clickManageTelco();

            // NewMemberLegalAddress newMemberLegalAddress = viewHierarchy.();

            // newMemberLegalAddress.setFirstName("FN" + uniqueCode);
            // newMemberLegalAddress.setLastName("LN" + uniqueCode);
            // Login login = newMemberLegalAddress.clickContinue();
            // AddMemberConfirmation addMemberConfirmation =
            // login.clickCreateLoginLater();
            // AddMember addMember = addMemberConfirmation.clickOk();
            // viewHierarchy = addMember.clickOk();
            ContactInformation contactInformation = viewHierarchy.clickEmployeeNameLink("FN" + uniqueCode, "LN" + uniqueCode);
            LoginInformation loginInformation = contactInformation.clickViewLoginInformationLink();

            RegisterLogin registerLogin = loginInformation.clickSetLogin();
            registerLogin.setLogin(uniqueCode);
            registerLogin.clickRadioButtonOCMUser();

            registerLogin = registerLogin.clickRegisterLoginContinue();

            loginInformation = registerLogin.clickConfirm();

            loginInformation.getTempPasswordFromPage();
            loginInformation.clickLogout();
            // myshapeCSRPortal.successfulLogin(uniqueCode, password);

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
