package com.comverse.css.common.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.common.User;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.SEC;
import com.comverse.data.users.CSRAdmin;
import com.comverse.data.users.SECAdmin;
import com.comverse.sec.SecLoginPage;

public class SEC0003_CreateCSRUser extends CSSTest {

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new SEC();
        user = new SECAdmin();
    }

    @Test
    public void testSEC0003_CreateCSRUser() throws Exception {
        launchSecurityApplication();
        SecLoginPage loginPage = new SecLoginPage(tool, test, user);
        loginPage.loginSecservAsSecadmin();

        User user2 = new CSRAdmin();
        loginPage.clickIdentity();
        loginPage.clickCSS_CSR();
        loginPage.clickAddUser();
        loginPage.addEmployeeCSRUser(user2.getLogin(), user2.getPassword());

        test.setResult("pass");
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
