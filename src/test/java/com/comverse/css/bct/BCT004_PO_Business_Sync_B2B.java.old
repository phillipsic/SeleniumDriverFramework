package com.comverse.css.bct;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2b.*;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2B;
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
        MyshapeBusiness loginPage = new MyshapeBusiness(driver);
        loginPage.clickAdminLogin(application);
        WorkSpace workSpace = loginPage.loginToB2B(user);

        ManageAccount manageAccount = workSpace.clickManageAccount();

        // @TODO - need to update the test to search for business account
        // created with Common.storeBusinessAccountID

        SearchResults searchResults = manageAccount.searchAccountIDWithWildCard();
        ViewHierarchy viewHierarchy = searchResults.clickFirstRefreshLink();
        loginPage = viewHierarchy.clickLogout();
        loginPage.clickHomePage();
        workSpace = loginPage.loginToB2B(user);

        viewHierarchy = workSpace.clickUserManagement();

        AddEmployeeContactInformation addEmployeeContactInformation = viewHierarchy.addNewEmployee();

        String uniqueID = Common.generateTimeStamp();
        addEmployeeContactInformation.enterFirstName("FN" + uniqueID);
        addEmployeeContactInformation.enterLastName("LN" + uniqueID);
        addEmployeeContactInformation.selectCountry("United States");
        addEmployeeContactInformation.selectState("Idaho");

        AddEmployeeRegisterLogin addEmployeeRegisterLogin = addEmployeeContactInformation.clickSubmit();
        addEmployeeRegisterLogin.enterLogin(uniqueID);
        AddEmployeeConfirmation addEmployeeConfirmation = addEmployeeRegisterLogin.clickSubmit();
        RegisterLogin registerLogin = addEmployeeConfirmation.clickSubmit();
        String tempPassword = registerLogin.getTempPasswordFromPage();
        viewHierarchy = registerLogin.clickOk();
        viewHierarchy.clickLogout();

        loginPage.clickHomePage();
        loginPage.enterLoginName(uniqueID);
        loginPage.enterPassword(tempPassword);
        loginPage.clickLoginButtonForFirstTime();
        loginPage.enterOldPassword(tempPassword);
        loginPage.enterNewPassword("passw0rd");
        loginPage.enterNewPasswordVerify("passw0rd");
        loginPage.enterSecretAnswer(uniqueID);
        workSpace = loginPage.clickChangeButton();
        test.setBugId("CBS00157300");
        ContactInformation contactInformation = workSpace.clickUsersName();
        test.setBugId("NoBug");

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
