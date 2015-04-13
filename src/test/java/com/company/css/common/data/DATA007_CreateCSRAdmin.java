package com.company.css.common.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.framework.common.User;
import com.framework.app.common.Test;
import com.framework.app.common.Prep;
import com.company.data.apps.SEC;
import com.company.data.users.CSRAdmin;
import com.company.data.users.SECAdmin;
import com.company.sec.SecLoginPage;

public class DATA007_CreateCSRAdmin extends Test {

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new SEC();
        user = new SECAdmin();
    }

    @Test
    public void testDATA007_CreateCSRAdmin() throws Exception {
        launchSecurityApplication();
        SecLoginPage loginPage = new SecLoginPage(tool, test, user);
        loginPage.loginSecservAsSecadmin();

        User user2 = new CSRAdmin();
        loginPage.clickIdentity();
        loginPage.clickCSS_CSR();
        loginPage.clickAddUser();
        loginPage.addEmployeeCSRAdmin(user2.getLogin(), user2.getPassword());

        test.setResult("pass");
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
