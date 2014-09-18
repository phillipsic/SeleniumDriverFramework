package com.comverse.css.csr.uam;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.common.Application;
import com.comverse.common.User;
import com.comverse.css.b2b.MyshapeBusiness;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.B2B;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.B2BAdmin;
import com.comverse.data.users.CSRAdmin;

public class UAM0040_Reset_password_of_another_user extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testUAM0040_Reset_password_of_another_user() throws Exception {
        try {
            String businessAccountID = Common.getBusinessAccountID();
            String uniqueCode = Common.generateTimeStamp();

            launchCSSApplicationAndSSOLogin();
            WorkSpace workSpace = new com.comverse.css.csr.WorkSpace(tool, test, user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountID(businessAccountID);
            ViewHierarchy viewHierarchy = accountDetails.clickCustomerHierarchy();

            String tempPassword = viewHierarchy.addBusinessAdminEmployee(uniqueCode);

            ContactInformation contactInformation = viewHierarchy.clickEmployeeNameLink("FN" + uniqueCode, "LN" + uniqueCode);
            Common.assertTextEquals("First Name: FN" + uniqueCode, contactInformation.getFirstName());
            Common.assertTextEquals("Last Name: LN" + uniqueCode, contactInformation.getLastName());
            LoginInformation loginInformation = contactInformation.clickViewLoginInformationLink();
            Common.assertTextEquals("Business Administrator", loginInformation.getCurrentRoleFromPage());

            ModifyLoginPassword modifyLoginPassword = loginInformation.clickChangePasswordOfAnotherUser();

            modifyLoginPassword.clickOk();
            tempPassword = modifyLoginPassword.getNewPassword();

            loginInformation.clickLogoutExpectingSSO();

            Application application2 = new B2B();
            launchAnotherCSSApplication(application2);

            MyshapeBusiness myShapeBusiness = new MyshapeBusiness(tool, test, user);

            User user2 = new B2BAdmin();
            user2.setNewLogin(uniqueCode);
            user2.setNewPassword(tempPassword);
            myShapeBusiness.successfulLogin(user2);

            myShapeBusiness.setYourPassword(tempPassword);
            myShapeBusiness.setNewPassword("Passw0rd!");
            myShapeBusiness.setConfirmNewPassword("Passw0rd!");
            myShapeBusiness.setSecretAnswer("Passw0rd!");
            myShapeBusiness.clickChangeButton();

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
