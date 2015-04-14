package com.company.css.bct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.framework.common.User;
import com.company.css.b2b.*;
import com.framework.app.common.AppTest;
import com.framework.app.common.Common;
import com.framework.app.common.Prep;
import com.company.data.apps.B2B;
import com.company.data.users.B2BAdmin;
import com.company.data.users.CSRAdmin;

public class BCT004_PO_Business_Sync_B2B extends AppTest {

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2B();
        user = new CSRAdmin();
    }

    @AppTest
    public void testBCT004_PO_Business_Sync_B2B() throws Exception {

        launchApplication();
        MyshapeBusiness loginPage = new MyshapeBusiness(tool, test, user);
        loginPage.clickAdminLogin(application);
        WorkSpace workSpace = loginPage.loginToB2B(user);

        ManageAccount manageAccount = workSpace.clickManageAccount();

        // @TODO - need to update the test to search for business account
        // created with Common.storeBusinessAccountID

        SearchResults searchResults = manageAccount.searchAccountIDWithWildCard();
        ViewHierarchy viewHierarchy = searchResults.clickFirstRefreshLink();
        loginPage = viewHierarchy.clickLogout();
        loginPage.clickHomePage();
        User user2 = new B2BAdmin();
        workSpace = loginPage.loginToB2B(user2);

        viewHierarchy = workSpace.clickUserManagement();

        AddEmployeeContactInformation addEmployeeContactInformation = viewHierarchy.addNewEmployee();

        String uniqueID = Common.generateTimeStamp();
        addEmployeeContactInformation.enterFirstName("FN" + uniqueID);
        addEmployeeContactInformation.enterLastName("LN" + uniqueID);
        addEmployeeContactInformation.selectCountry("United States");
        addEmployeeContactInformation.selectState("Idaho");

        AddEmployeeRegisterLogin addEmployeeRegisterLogin = addEmployeeContactInformation.clickSubmit();
        User user3 = new B2BAdmin();
        addEmployeeRegisterLogin.enterLogin(uniqueID);
        user3.setNewLogin(uniqueID);
        AddEmployeeConfirmation addEmployeeConfirmation = addEmployeeRegisterLogin.clickSubmit();
        RegisterLogin registerLogin = addEmployeeConfirmation.clickSubmit();
        user3.setNewPassword(registerLogin.getTempPasswordFromPage());
        viewHierarchy = registerLogin.clickOk();
        viewHierarchy.clickLogout();

        loginPage.clickHomePage();
        loginPage.loginWithChangeOfPassword(user3.getLogin(), user3.getPassword());
        loginPage.enterOldPassword(user3.getPassword());
        loginPage.enterNewPassword("passw0rd");
        loginPage.enterNewPasswordVerify("passw0rd");
        loginPage.enterSecretAnswer(uniqueID);
        workSpace = loginPage.clickChangeButton();
        ContactInformation contactInformation = workSpace.clickUsersName();

        Common.assertVerifyTrue(tool, contactInformation.getFirstName().matches("^[\\s\\S]*FN" + uniqueID + "[\\s\\S]*$"));
        Common.assertVerifyTrue(tool, contactInformation.getLastName().matches("^[\\s\\S]*LN" + uniqueID + "[\\s\\S]*$"));

        test.setResult("pass");
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
