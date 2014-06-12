package com.comverse.css.b2b.epi;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2b.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2B;
import com.comverse.data.users.B2BAdmin;

public class EPI0010_Search_employees extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2B();
        user = new B2BAdmin();
    }

    @Test
    public void testEPI0010_Search_employees() throws Exception {
        try {
            launchCSSApplication();

            MyshapeBusiness loginPage = new MyshapeBusiness(tool, test, user);
            WorkSpace workSpace = loginPage.loginToB2B(user);
            ViewHierarchy viewHierarchy = workSpace.clickUserManagement();
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
            registerLogin.getTempPasswordFromPage();
            viewHierarchy = registerLogin.clickOk();

            viewHierarchy = workSpace.clickUserManagement();

            SearchEmployeePage searchEmployee = viewHierarchy.clickSearchEmployee();
            searchEmployee.searchEmployeeByLastName("LN" + uniqueID);

            ContactInformation contactInformation = searchEmployee.clickEmployeeNameLink("LN" + uniqueID);

            Common.assertTextOnPage(tool, "Last Name: LN" + uniqueID);

            viewHierarchy = contactInformation.clickUserManagement();
            searchEmployee = viewHierarchy.clickSearchEmployee();
            viewHierarchy.clickSearchEmployee();

            searchEmployee.searchEmployeeByLogin(uniqueID);
            Common.assertTextOnPage(tool, "LN" + uniqueID);

            searchEmployee.searchEmployeeByLogin("111");
            Common.assertTextOnPage(tool, "No matching employee found");

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
