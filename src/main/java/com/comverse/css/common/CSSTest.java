package com.comverse.css.common;

import org.junit.Before;

import com.comverse.common.*;

public class CSSTest extends Main {

    @Before
    public void setUp() throws Exception {
        PropertyHelper propsHelper = new PropertyHelper();
        tool = new Selenium();
        test = new Test();
        test.setDebug(Boolean.valueOf(propsHelper.readInitProperties("DEBUG")));
        System.out.println("DEBUG = " + test.getDebug());
        tool.platform = new Platform();
        user = new User();
        tool.parseUserAgent(tool, test, tool.instanciateDriver(tool, test));
    }

    public void launchCSSApplication() throws Exception {
        application.setVersion(tool);
        tool.get(tool, application.appURL());
        if (!test.getDebug()) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
    }

    public void launchAnotherCSSApplication(Application application2) throws Exception {
        tool.get(tool, application2.appURL());
        Thread.sleep(1000);
    }

    public void launchCSSApplicationAndSSOLogin() throws Exception {
        tool.get(tool, application.appURL());
        loginSSOUser();
        application.setVersion(tool);
        tool.navigateBack(tool);
        if (!test.getDebug()) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
        Common.checkForExistingBasketAndDiscard(tool);
    }

    public void launchOCMApplicationAndGetBuildNumber() throws Exception {
        application.setVersion(tool);
        // Launch OCM with Direct URL
        application.setMainURLKey(application.getDirectURLKey());
        tool.get(tool, application.appOCMURL());
        if (!test.getDebug()) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
    }

    public void launchOCMApplication() throws Exception {
        // Launch OCM with Direct URL
        application.setMainURLKey(application.getDirectURLKey());
        tool.get(tool, application.appOCMURL());
    }

    public void launchSecurityApplication() throws Exception {
        application.setVersion(tool);
        tool.get(tool, application.appFullURL());
    }

    public void launchOTGApplication() throws Exception {
        tool.get(tool, application.appFullURL());
        Thread.sleep(4000);
    }
}
