package com.comverse.caseui.common;

import org.junit.Before;

import com.comverse.common.*;
import com.comverse.css.common.Common;
import com.comverse.css.common.PropertyHelper;
import com.comverse.data.apps.CSR;

public class CaseUITest extends Main {

    @Before
    public void setUp() throws Exception {
        PropertyHelper propsHelper = new PropertyHelper();
        tool = new Selenium();
        test = new Test();
        test.setName(this.getClass().getSimpleName());
        test.setDebug(Boolean.valueOf(propsHelper.readInitProperties("DEBUG")));
        tool.platform = new Platform();
        user = new User();
        tool.parseUserAgent(tool, test, tool.instanciateDriver(tool, test));
    }

    public void launchCaseUIApplicationWithSSO() throws Exception {
        test.writeInLog(Common.getMethodName());
        application.setVersion(tool, test);
        tool.get(application.appFullURL());
        loginSSOUser();
        if (!test.getDebug()) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
    }

    public void launchCSSApplication() throws Exception {
        test.writeInLog(Common.getMethodName());
        Application CSR = new CSR();
        tool.get(CSR.appURL());
        loginSSOUser();
    }
}
