package com.comverse.sfa.common;

import org.junit.After;
import org.junit.Before;

import com.comverse.common.*;
import com.comverse.css.common.Common;
import com.comverse.css.common.PropertyHelper;
import com.comverse.data.apps.SFA;
import com.comverse.sec.ComverseOneSingleSignOn;

public class SFATest extends Main {

    @Before
    public void setUp() throws Exception {
        PropertyHelper propsHelper = new PropertyHelper();
        tool = new Selenium();
        test = new Test();
        test.setName(this.getClass().getSimpleName());
        test.setDebug(Boolean.valueOf(propsHelper.readInitProperties("DEBUG")));
        test.setLOG_FILE();
        tool.platform = new Platform();
        user = new User();
        tool.parseUserAgent(tool, test, tool.instanciateDriver(tool, test));
    }

    public void launchSFAApplication() throws Exception {
        application.setVersion(tool, test);
        tool.get(application.appFullURL());
        if (!test.getDebug()) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
    }

    public void launchSFAApplicationWithSSO() throws Exception {
        application.setVersion(tool, test);
        tool.get(application.appFullURL());
        ComverseOneSingleSignOn ssoLoginPage = new ComverseOneSingleSignOn(tool, test, user);
        ssoLoginPage.loginSSOUser();
        if (!test.getDebug()) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
    }

    public void launchSFAApplicationWithExistingSSOSession() throws Exception {
        Application application2 = new SFA();
        tool.get(application2.appFullURL());
        Common.sleepForNumberOfSeconds(3);
    }

    public void launchAdminUIWithSSO() throws Exception {
        application.setVersion(tool, test);
        tool.get(application.appFullURL());
        ComverseOneSingleSignOn ssoLoginPage = new ComverseOneSingleSignOn(tool, test, user);
        ssoLoginPage.loginSSOUser();
        if (!test.getDebug()) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
    }

    public void uploadLeadFileToCrmManaged(String leadFile) throws Exception {
        PropertyHelper propsHelper = new PropertyHelper();
        String crmManaged = propsHelper.getPasswordProperties("CRMMANAGED.IP");
        String sftpUser = propsHelper.getPasswordProperties("CRMMANAGED.SFTPUSER");
        String sftpPassword = propsHelper.getPasswordProperties("CRMMANAGED.SFTPPASSWD");
        String targetLeadDirectory = propsHelper.getPasswordProperties("CRMMANAGED.LEADDIR");

        Common.sftpFile(crmManaged, sftpUser, sftpPassword, leadFile, targetLeadDirectory);
    }

    @Override
    @After
    public void tearDown() throws Exception {
        PropertyHelper propsHelper = new PropertyHelper();
        String URL_SSO_LOGOUT = propsHelper.getInitProperties("ssologout_url");

        tool.get(URL_SSO_LOGOUT);
        super.tearDown();
    }
}
