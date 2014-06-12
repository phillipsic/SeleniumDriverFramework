package com.comverse.caseui.common;

import org.junit.Before;

import com.comverse.common.*;
import com.comverse.data.apps.CSR;

public class CaseUITest extends Main {

    @Before
    public void setUp() throws Exception {
        tool = new Selenium();
        test = new Test();
        tool.platform = new Platform();
        user = new User();
        tool.parseUserAgent(tool, test, tool.instanciateDriver(tool, test));
    }

    public void launchCaseUIApplicationWithSSO() throws Exception {
        application.setVersion(tool);
        tool.driver.get(application.appFullURL());
        loginSSOUser();
        if (!test.getDebug()) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
    }

    public void launchCSSApplication() throws Exception {
        Application CSR = new CSR();
        tool.driver.get(CSR.appURL());
        loginSSOUser();
    }
}