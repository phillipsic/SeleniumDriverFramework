package com.comverse.upm.common;

import org.junit.Before;

import com.comverse.common.*;
import com.comverse.css.common.PropertyHelper;

public class UPMTest extends Main {

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

    public void launchUPMApplication() throws Exception {
        application.setVersion(tool);
        tool.get(application.appFullURL());
        if (!test.getDebug()) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
    }

}
