package com.framework.app.common;

import com.framework.common.Platform;
import com.framework.common.Selenium;
import com.framework.common.Main;
import com.framework.common.Application;
import com.framework.common.User;
import com.framework.common.TestDetails;
import org.junit.Before;

import com.company.sec.companyOneSingleSignOn;

public class Test extends Main {

    @Before
    public void setUp() throws Exception {
        PropertyHelper propsHelper = new PropertyHelper();
        tool = new Selenium();
        test = new TestDetails();
        test.setName(this.getClass().getSimpleName());
        test.setDebug(Boolean.valueOf(propsHelper.readInitProperties("DEBUG")));
        System.out.println("DEBUG = " + test.getDebug());
        test.setLOG_FILE();
        tool.platform = new Platform();
        user = new User();
        tool.parseUserAgent(tool, test, tool.instanciateDriver(tool, test));
    }

    public void launchApplication() throws Exception {
        application.setVersion(tool, test);
        tool.get(application.appURL());
        test.writeInLogFile("INFO", "Browser: " + tool.platform.getBrowserFullNameAndVersion() + ", OS: " + tool.platform.getOSFullNameAndVersion());
        test.writeInLogFile("INFO", "Application: " + application.getCommonName() + " " + application.appURL());
        if (!test.getDebug()) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
    }

    public void launchCSSApplicationOnly() throws Exception {
        tool.get(application.appURL());
        Thread.sleep(1000);
    }

    public void launchAnotherCSSApplication(Application application2) throws Exception {
        tool.get(application2.appURL());
        Thread.sleep(1000);
    }

    public void launchCSSApplicationAndSSOLogin() throws Exception {
        tool.get(application.appURL());
        test.writeInLogFile("INFO", "Browser: " + tool.platform.getBrowserFullNameAndVersion() + ", OS: " + tool.platform.getOSFullNameAndVersion());
        test.writeInLogFile("INFO", "Application: " + application.getCommonName() + " " + application.appURL());
        companyOneSingleSignOn ssoLoginPage = new companyOneSingleSignOn(tool, test, user);
        ssoLoginPage.loginSSOUser();
        application.setVersion(tool, test);
        tool.navigateBack();
        if (!test.getDebug()) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
        Common.checkForExistingBasketAndDiscard(tool);
    }

    public void launchOCMApplicationAndGetBuildNumber() throws Exception {
        application.setVersion(tool, test);
        // Launch OCM with Direct URL
        application.setMainURLKey(application.getDirectURLKey());
        tool.get(application.appOCMURL());
        if (!test.getDebug()) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
    }

    public void launchOCMApplication() throws Exception {
        // Launch OCM with Direct URL
        application.setMainURLKey(application.getDirectURLKey());
        tool.get(application.appOCMURL());
    }

    public void launchSecurityApplication() throws Exception {
        application.setVersion(tool, test);
        tool.get(application.appFullURL());
    }

    public void launchOTGApplication() throws Exception {
        tool.get(application.appFullURL());
        Thread.sleep(4000);
    }
}