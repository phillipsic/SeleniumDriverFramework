package com.company.css.common.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.framework.common.User;
import com.framework.app.common.AppTest;
import com.framework.app.common.Prep;
import com.company.data.apps.SEC;
import com.company.data.users.BOGAdmin;
import com.company.data.users.SECAdmin;
import com.company.sec.SecLoginPage;

public class DATA006_CreateBOGAdmin extends AppTest {

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new SEC();
        user = new SECAdmin();
    }

    @AppTest
    public void testDATA006_CreateBOGAdmin() throws Exception {
        launchSecurityApplication();
        SecLoginPage loginPage = new SecLoginPage(tool, test, user);
        loginPage.loginSecservAsSecadmin();

        User user2 = new BOGAdmin();
        loginPage.clickIdentity();
        loginPage.clickCSS_CSR();
        loginPage.clickAddUser();
        loginPage.addEmployeeBOGAdmin(user2.getLogin(), user2.getPassword());

        test.setResult("pass");
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
