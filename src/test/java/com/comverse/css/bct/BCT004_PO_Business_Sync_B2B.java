package com.comverse.css.bct;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.common.User;
import com.comverse.css.b2b.*;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2B;
import com.comverse.data.users.B2BAdmin;
import com.comverse.data.users.CSRAdmin;

public class BCT004_PO_Business_Sync_B2B extends CSSTest {

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2B();
        user = new CSRAdmin();
    }

    @Test
    public void testBCT004_PO_Business_Sync_B2B() throws Exception {

        launchCSSApplication();
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

        assertTrue(contactInformation.getFirstName().matches("^[\\s\\S]*FN" + uniqueID + "[\\s\\S]*$"));
        assertTrue(contactInformation.getLastName().matches("^[\\s\\S]*LN" + uniqueID + "[\\s\\S]*$"));

        test.setResult("pass");
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
