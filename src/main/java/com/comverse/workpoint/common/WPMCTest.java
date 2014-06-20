package com.comverse.workpoint.common;

import org.junit.Before;

import com.comverse.common.*;

public class WPMCTest extends Main {

    public String baseUrl;
    public String baseCSRUrl;

    @Before
    public void setUp() throws Exception {
        tool = new Selenium();
        test = new Test();
        tool.platform = new Platform();
        user = new User();
        tool.parseUserAgent(tool, test, tool.instanciateDriver(tool, test));
    }

    public void launchWPMCApplication() throws Exception {
        application.setVersion(tool);
        tool.get(application.appFullURL());
        if (!test.getDebug()) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
    }

}
