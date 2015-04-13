package com.framework.app.common;

import com.framework.common.Platform;
import com.framework.common.Selenium;
import com.framework.common.Main;
import com.framework.common.Application;
import com.framework.common.User;
import com.framework.common.TestDetails;
import org.junit.Before;

public class AppTest extends Main {

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

    public void launchOTGApplication() throws Exception {
        tool.get(application.appFullURL());
        Thread.sleep(4000);
    }
}
