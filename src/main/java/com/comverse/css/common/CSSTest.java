package com.comverse.css.common;

import org.junit.Before;

import com.comverse.common.Application;
import com.comverse.common.Main;

public class CSSTest extends Main {

    @Before
    public void setUp() throws Exception {
        parseUserAgent(instanciateDriver());
    }

    public void launchCSSApplication() throws Exception {
        application.setVersion(driver);
        driver.get(application.appURL());
        if (!debug) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
    }

    public void launchAnotherCSSApplication(Application application2) throws Exception {
        driver.get(application2.appURL());
        Thread.sleep(1000);
    }

    public void launchCSSApplicationAndSSOLogin() throws Exception {
        driver.get(application.appURL());
        loginSSOUser();
        application.setVersion(driver);
        driver.navigate().back();
        if (!debug) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
        Common.checkForExistingBasketAndDiscard(driver);
    }

    public void launchOCMApplicationAndGetBuildNumber() throws Exception {
        application.setVersion(driver);
        // Launch OCM with Direct URL
        application.setMainURLKey(application.getDirectURLKey());
        driver.get(application.appOCMURL());
        if (!debug) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
    }

    public void launchOCMApplication() throws Exception {
        // Launch OCM with Direct URL
        application.setMainURLKey(application.getDirectURLKey());
        driver.get(application.appOCMURL());
    }

    public void launchSecurityApplication() throws Exception {
        application.setVersion(driver);
        driver.get(application.appFullURL());
    }

    public void launchOTGApplication() throws Exception {
        driver.get(application.appFullURL());
        Thread.sleep(4000);
    }
}
