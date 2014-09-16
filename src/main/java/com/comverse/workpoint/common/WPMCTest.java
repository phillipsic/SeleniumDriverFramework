package com.comverse.workpoint.common;

import org.junit.Before;

import com.comverse.common.*;
import com.comverse.css.common.PropertyHelper;

public class WPMCTest extends Main {

    public String baseUrl;
    public String baseCSRUrl;

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

    public void launchWPMCApplication() throws Exception {
        application.setVersion(tool, test);
        tool.get(application.appFullURL());
        if (!test.getDebug()) {
            this.checkForPassAndAbort(this.getClass().getSimpleName());
        }
    }

}
