package com.comverse.cls.common;

import org.junit.Before;

import com.comverse.common.*;

public class CLSTest extends Main {

    @Before
    public void setUp() throws Exception {
        tool = new Selenium();
        test = new Test();
        tool.platform = new Platform();
        user = new User();
        tool.parseUserAgent(tool, test, tool.instanciateDriver(tool, test));
    }

    public void launchCLSApplication() throws Exception {
        application.setVersion(tool);
        tool.get(tool, application.appFullURL());
        if (!test.getDebug()) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
    }
}
