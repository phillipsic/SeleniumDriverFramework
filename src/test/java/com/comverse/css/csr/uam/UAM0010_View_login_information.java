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
import com.comverse.data.users.CSRAdmin;

public class UAM0010_View_login_information extends CSSTest {
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
    public void testUAM0010_View_login_information() throws Exception {
        try {
            String businessAccountID = Common.getBusinessAccountID();
            String uniqueCode = Common.generateTimeStamp();

            launchCSSApplicationAndSSOLogin();
            WorkSpace workSpace = new WorkSpace(tool, test, user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountID(businessAccountID);

            ViewHierarchy viewHierarchy = accountDetails.clickCustomerHierarchy();

            AddEmployeeContactInformation addEmployeeContactInformation = viewHierarchy.clickAddB2BEmployee();
            addEmployeeContactInformation.setFirstName("FN" + uniqueCode);
            addEmployeeContactInformation.setLastName("LN" + uniqueCode);
            AddEmployeeRegisterLogin addEmployeeRegisterLogin = addEmployeeContactInformation.clickContinue();
            addEmployeeRegisterLogin.enterLogin(uniqueCode);

            AddEmployeeConfirmation addEmployeeConfirmation = addEmployeeRegisterLogin.clickSubmit();
            RegisterLogin registerLogin = addEmployeeConfirmation.clickOk();
            registerLogin.getTempPasswordFromPage();
            viewHierarchy = registerLogin.clickOk();

            ContactInformation contactInformation = viewHierarchy.clickEmployeeNameLink("FN" + uniqueCode, "LN" + uniqueCode);
            assertEquals("First Name: FN" + uniqueCode, contactInformation.getFirstName());
            assertEquals("Last Name: LN" + uniqueCode, contactInformation.getLastName());
            LoginInformation loginInformation = contactInformation.clickViewLoginInformationLink();

            assertEquals("Business Administrator", loginInformation.getCurrentRoleFromPage());

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
